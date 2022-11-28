package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName CommandGroupService
 * @Description 命令分组
 * @Author daguniang
 * @Date 2022/11/26 15:56
 **/
@Data
@TableName("command_group")
public class CommandGroup {

    /**
     * 命令分组ID
     */
    @TableId(value = "command_group_id", type = IdType.ASSIGN_ID)
    private Long commandGroupId;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组描述
     */
    private String description;
}
