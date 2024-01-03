package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import erd.cloud.core.controller.BaseController;
import erd.cloud.core.result.CommonResponse;
import com.example.demo.entity.Demo;
import com.example.demo.dto.DemoDTO;
import com.example.demo.service.DemoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Demo服务API接口
 *
 * @author fenglin
 * @since 2023-01-11 20:14:53
 */
@RestController
@RequestMapping("/demo/v1")
@Api(value = "Demo API")
public class DemoController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private DemoService demoService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResponse selectOne(@PathVariable Serializable id) {
        return CommonResponse.success(this.demoService.getById(id));
    }

    /**
     * 新增数据
     * @return 新增结果
     */
    @PostMapping
    public CommonResponse insert(@RequestBody Demo demo) {
        return CommonResponse.success(this.demoService.save(demo));
    }

    /**
     * 修改数据
     * @return 修改结果
     */
    @PutMapping
    public CommonResponse update(@RequestBody Demo demo) {
        return CommonResponse.success(this.demoService.updateById(demo));
    }

    /**
     * 删除数据
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public CommonResponse delete(@RequestParam("idList") List<Long> idList) {
        return CommonResponse.success(this.demoService.removeByIds(idList));
    }
}

