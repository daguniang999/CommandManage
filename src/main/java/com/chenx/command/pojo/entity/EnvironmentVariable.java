package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName EnvironmentVariable
 * @Description 环境变量配置
 * @Author daguniang
 * @Date 2022/11/26 15:57
 **/
@ApiModel(description = "环境变量DO")
@Data
@TableName(value = "environment_variable")
public class EnvironmentVariable {

    /**
     * 环境变量ID
     */
    @ApiModelProperty(value = "环境变量ID", required = true)
    @TableId(value = "env_variable_id", type = IdType.ASSIGN_ID)
    private Long envVariableId;

    /**
     * 环境ID
     */
    @ApiModelProperty(value = "环境ID", required = true)
    private Long envId;

    /**
     * 变量名称
     */
    @ApiModelProperty(value = "变量名称", required = true)
    private String name;

    /**
     * 变量值
     */
    @ApiModelProperty(value = "变量值", required = true)
    private String value;
}
