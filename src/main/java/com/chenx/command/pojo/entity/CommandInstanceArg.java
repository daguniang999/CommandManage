package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CommandInstanceArg
 * @Description 命令实例参数
 * @Author daguniang
 * @Date 2022/11/26 15:56
 **/
@ApiModel(description = "命令实例参数DO")
@Data
@TableName(value = "command_instance_arg")
public class CommandInstanceArg {

    /**
     * 命令实例参数ID
     */
    @ApiModelProperty(value = "命令实例参数ID", required = true)
    @TableId(value = "instance_arg_id", type = IdType.ASSIGN_ID)
    private Long instanceArgId;

    /**
     * 实例id
     */
    @ApiModelProperty(value = "实例id", required = true)
    private Long instanceId;

    /**
     * 命令参数ID
     */
    @ApiModelProperty(value = "命令参数ID", required = true)
    private Long commandArgId;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = true)
    private Integer type;

    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序", required = true)
    private Integer sequence;

    /**
     * 参数值
     */
    @ApiModelProperty(value = "参数值", required = true)
    private String value;

    /**
     * 参数默认值
     */
    @ApiModelProperty(value = "参数默认值", required = true)
    private String defaultValue;
}
