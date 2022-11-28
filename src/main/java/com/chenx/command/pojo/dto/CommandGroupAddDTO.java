package com.chenx.command.pojo.dto;

import lombok.Data;

/**
 * @ClassName CommandGroupAddDTO
 * @Description 命令分组添加DTO
 * @Author daguniang
 * @Date 2022/11/27 23:20
 **/
@Data
public class CommandGroupAddDTO {

    /**
     * 命令分组ID
     */
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
