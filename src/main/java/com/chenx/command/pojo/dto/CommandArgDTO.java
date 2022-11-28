package com.chenx.command.pojo.dto;

import lombok.Data;

/**
 * @ClassName CommandArgDTO
 * @Description 命令参数DTO
 * @Author daguniang
 * @Date 2022/11/27 09:27
 **/
@Data
public class CommandArgDTO {

    /**
     * 命令参数ID
     */
    private Long commandArgId;

    /**
     * 命令ID
     */
    private Long commandId;

    /**
     * 参数名
     */
    private String name;

    /**
     * 参数类型
     */
    private Integer type;

    /**
     * 分隔符
     */
    private Integer symbol;

    /**
     * 顺序
     */
    private Integer sequence;

    /**
     * 描述
     */
    private String description;
}
