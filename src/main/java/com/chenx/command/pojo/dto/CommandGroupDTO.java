package com.chenx.command.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CommandGroupAddDTO
 * @Description 命令分组添加DTO
 * @Author daguniang
 * @Date 2022/11/27 23:20
 **/
@ApiModel(description = "命令分组对象")
@Data
public class CommandGroupDTO {

    /**
     * 命令分组ID
     */
    @ApiModelProperty(value = "命令分组ID", required = true)
    private Long groupId;

    /**
     * 命令分组父ID
     */
    @ApiModelProperty(value = "命令分组父ID", required = true)
    private Long parentGroupId;

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
