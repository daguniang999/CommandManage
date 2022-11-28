package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CommandArg
 * @Description 命令参数
 * @Author daguniang
 * @Date 2022/11/6 10:53
 **/
@ApiModel(description = "命令参数DO")
@Data
@TableName(value = "command_arg")
public class CommandArg {

    /**
     * 命令参数ID
     */
    @ApiModelProperty(value = "命令参数ID", required = true)
    @TableId(value = "command_arg_id", type = IdType.ASSIGN_ID)
    private Long commandArgId;

    /**
     * 命令ID
     */
    @ApiModelProperty(value = "命令ID", required = true)
    private Long commandId;

    /**
     * 参数名
     */
    @ApiModelProperty(value = "参数名", required = true)
    private String name;

    /**
     * 参数类型
     */
    @ApiModelProperty(value = "参数类型", required = true)
    private Integer type;

    /**
     * 分隔符
     */
    @ApiModelProperty(value = "分隔符", required = true)
    private Integer symbol;

    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序", required = true)
    private Integer sequence;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", required = true)
    private String description;

}
