package com.example.demo.feign;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import erd.cloud.core.result.CommonResponse;
import com.example.demo.config.FeignOAuth2RequestInterceptor;
import erd.cloud.project.dto.EtProjectMemberModifyDto;
import erd.cloud.project.dto.EtProjectRoleAddDto;
import erd.cloud.project.vo.EtProjectVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 项目服务API接口客户端
 *
 * @author fenglin
 * @since 2023-01-11 20:14:53
 */
@FeignClient(value = "erdcloud-project-app",path = "/proj/v1", configuration = FeignOAuth2RequestInterceptor.class)
public interface ProjectFeign  {
    @GetMapping({"/members"})
    JSONArray getMemberByName(@ApiParam("查询条件") @RequestParam(required = true,value = "condition") @NotNull(message = "10001") String condition) throws JSONException;
    @GetMapping(
            value = {"/projects/all/template"},
            produces = {"application/json;charset=UTF-8"}
    )
    CommonResponse getAllProjectTemplateList(
            @ApiParam("项目ID") @RequestParam(required = false,value = "projectId") String projectId,
            @ApiParam("类型") @RequestParam(required = false,value = "type") String type);
    @ApiOperation("查询当前项目下所有成员和角色")
    @GetMapping({"/project/{projectId}/member/list"})
    @Valid CommonResponse selectProjectRoleMembers(@ApiParam("项目Id") @PathVariable("projectId") @NotNull(
            message = "10001"
    ) String projectId);

    @ApiOperation("新增项目角色")
    @PostMapping(value = {"/project/role"},consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Valid CommonResponse addProjectRole(@ApiParam("项目成员") EtProjectRoleAddDto projectMember) throws Exception;

    @ApiOperation("新增项目角色成员")
    @PutMapping({"/project/{projectId}/role/members"})
    @Valid CommonResponse addProjectRoleMember(@ApiParam("项目成员列表") @RequestBody List<EtProjectRoleAddDto> projectMembers, @ApiParam(required = true,value = "项目ID") @PathVariable(required = true,value = "projectId") @NotNull(
            message = "10001"
    ) String projectId);
}
