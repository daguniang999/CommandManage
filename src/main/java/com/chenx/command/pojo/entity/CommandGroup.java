package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CommandGroupService
 * @Description 命令分组
 * @Author daguniang
 * @Date 2022/11/26 15:56
 **/
@ApiModel(description = "命令分组DO")
@Data
@TableName("command_group")
public class CommandGroup {

    /**
     * 命令分组ID
     */
    @ApiModelProperty(value = "命令分组ID", required = true)
    @TableId(value = "command_group_id", type = IdType.ASSIGN_ID)
    private Long commandGroupId;

    /**
     * 分组名称
     */
    @ApiModelProperty(value = "分组名称", required = true)
    private String name;

    /**
     * 分组描述
     */
    @ApiModelProperty(value = "分组描述", required = true)
    private String description;
}
