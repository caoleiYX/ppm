package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * Demo PO
 *
 * @author fenglin
 * @since 2023-01-11 20:14:53
 */
@Data
@TableName("demo")
public class Demo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    /**
    * id
    */
    @ApiModelProperty(name="id")
    private String id;

    /**
    * 项目id
    */
    @ApiModelProperty(name="object_id")
    private String objectId;

    /**
    * 对象classname
    */
    @ApiModelProperty(name="object_classname")
    private String objectClassname;

    /**
    * 用户id
    */
    @ApiModelProperty(name="user_id")
    private String userId;

    /**
    * 序号
    */
    @ApiModelProperty(name="sort")
    private int sort;

    /**
    * 角色id
    */
    @ApiModelProperty(name="role_key")
    private String roleKey;

    /**
    * 状态
    */
    @ApiModelProperty(name="state")
    private int state;

    /**
    * 投入百分比
    */
    @ApiModelProperty(name="percentage")
    private Double percentage;

    /**
    * 备注
    */
    @ApiModelProperty(name="remark")
    private String remark;

    /**
    * 投入时间
    */
    @ApiModelProperty(name="join_time")
    private Date joinTime;

    /**
    * 释放时间
    */
    @ApiModelProperty(name="release_time")
    private Date releaseTime;

    /**
    * 状态流中当前处理人标识(是：1 ； 否 ： 0)
    */
    @ApiModelProperty(name="active")
    private String active;

    /**
    * 是为核心成员(1:核心代表；2:拓展代表；3：工程师
    */
    @ApiModelProperty(name="is_key_member")
    private String isKeyMember;

    /**
    * 领域
    */
    @ApiModelProperty(name="ext_domain")
    private String extDomain;

}