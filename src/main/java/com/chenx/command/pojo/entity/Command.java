package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.util.Date;

/**
 * @ClassName Command
 * @Description 命令
 * @Author daguniang
 * @Date 2022/11/6 10:53
 **/
@ApiModel(description = "命令DO")
@Data
@TableName(value = "command")
public class Command {

    /**
     * 命令ID
     */
    @ApiModelProperty(value = "命令ID", required = true)
    @TableId(value = "command_id", type = IdType.ASSIGN_ID)
    private Long commandId;

    /**
     * 命令名称
     */
    @ApiModelProperty(value = "命令名称", required = true)
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", required = true)
    private String description;
}