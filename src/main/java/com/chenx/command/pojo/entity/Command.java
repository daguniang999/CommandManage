package com.chenx.command.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Command
 * @Description 命令
 * @Author daguniang
 * @Date 2022/11/6 10:53
 **/
@Data
public class Command {

    /**
     * 命令ID
     */
    private Long commandId;

    /**
     * 命令名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}