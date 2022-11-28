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
     * 命令参数ID
     */
    @ApiModelProperty(value = "命令参数ID", required = true)
    private Long commandArgId;

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
