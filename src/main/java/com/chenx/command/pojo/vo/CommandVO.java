package com.chenx.command.pojo.vo;

import com.chenx.command.pojo.dto.CommandArgDTO;
import com.chenx.command.pojo.dto.CommandGroupDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName CommandVO
 * @Description 命令VO
 * @Author chenxiaowei
 * @Date 2022/11/30 09:56
 **/
@ApiModel(description = "命令VO")
@Data
public class CommandVO {
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
     * 命令分组信息
     */
    @ApiModelProperty(value = "命令分组信息", required = true)
    private CommandGroupDTO commandGroupDTO;

    /**
     * 命令参数列表
     */
    @ApiModelProperty(value = "命令参数列表", required = true)
    private List<CommandArgDTO> commandArgList;
}
