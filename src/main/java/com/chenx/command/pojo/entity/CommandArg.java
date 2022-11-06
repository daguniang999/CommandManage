package com.chenx.command.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName CommandArg
 * @Description 命令参数
 * @Author daguniang
 * @Date 2022/11/6 10:53
 **/
@Data
public class CommandArg {

    /**
     * 命令参数ID
     */
    private Long argId;

    /**
     * 命令ID
     */
    private Long commandId;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 全称
     */
    private String fullName;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

}
