package com.chenx.command.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CommandGroupRelationDTO
 * @Description 命令分组关联DTO
 * @Author daguniang
 * @Date 2022/11/27 23:27
 **/
@ApiModel(description = "命令分组关联对象")
@Data
public class CommandGroupRelationDTO {

    /**
     * 命令分组关联ID
     */
    @ApiModelProperty(value = "命令分组关联ID", required = true)
    private Long groupRelationId;

    /**
     * 命令ID
     */
    @ApiModelProperty(value = "命令ID", required = true)
    private Long commandId;

    /**
     * 分组ID
     */
    @ApiModelProperty(value = "分组ID", required = true)
    private Long groupId;

    /**
     * 命令分组对象
     */
    @ApiModelProperty(value = "命令分组对象", required = true)
    private CommandGroupDTO commandGroupDTO;
}
