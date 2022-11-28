package com.chenx.command.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName CommandAddDTO
 * @Description 命令添加DTO
 * @Author daguniang
 * @Date 2022/11/27 17:58
 **/
@ApiModel(description = "命令添加对象")
@Data
public class CommandAddDTO {

    /**
     * 命令ID
     */
    @ApiModelProperty(value = "命令ID", required = true)
    private Long commandId;

    /**
     * 命令名称
     */
    @ApiModelProperty(value = "命令名称", required = true)
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", required = true)
    private String description;

    /**
     * 命令组ID
     */
    @ApiModelProperty(value = "命令组ID", required = true)
    private Long groupId;

    /**
     * 命令参数列表
     */
    @ApiModelProperty(value = "命令参数列表", required = true)
    private List<CommandArgDTO> commandArgList;

}
