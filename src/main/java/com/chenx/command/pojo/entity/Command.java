package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.util.Date;

/**
 * @ClassName Command
 * @Description 命令
 * @Author daguniang
 * @Date 2022/11/6 10:53
 **/
@Data
@TableName(value = "command")
public class Command {

    /**
     * 命令ID
     */
    @TableId(value = "command_id", type = IdType.ASSIGN_ID)
    private Long commandId;

    /**
     * 命令名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;
}