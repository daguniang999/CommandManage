package com.chenx.command.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

/**
 * 命令dto
 *
 * @ClassName CommandDTO
 * @Description 命令DTO
 * @Author daguniang
 * @Date 2022/11/6 10:53
 **/
@ApiModel(description = "命令对象")
@Data
public class CommandDTO {

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
     * 命令参数列表
     */
    @ApiModelProperty(value = "命令参数列表", required = true)
    private List<CommandArgDTO> commandArgList;

    /**
     * 分组信息
     */
    @ApiModelProperty(value = "分组信息", required = true)
    private CommandGroupDTO commandGroupDTO;

}
