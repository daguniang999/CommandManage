package com.chenx.command.pojo.dto;

import lombok.Data;

/**
 * @ClassName CommandGroupRelationDTO
 * @Description 命令分组关联DTO
 * @Author daguniang
 * @Date 2022/11/27 23:27
 **/
@Data
public class CommandGroupRelationDTO {

    /**
     * 命令分组关联ID
     */
    private Long groupRelationId;

    /**
     * 命令ID
     */
    private Long commandId;

    /**
     * 分组ID
     */
    private Long groupId;
}
