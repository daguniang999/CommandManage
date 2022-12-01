package com.chenx.command.pojo.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName CommandForm
 * @Description 命令表单
 * @Author chenxiaowei
 * @Date 2022/11/30 09:59
 **/
@ApiModel(description = "命令表单")
@Data
public class CommandForm {

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
     * 分组ID
     */
    @ApiModelProperty(value = "分组ID", required = true)
    private Long groupId;

    /**
     * 命令参数列表
     */
    @ApiModelProperty(value = "命令参数列表", required = true)
    private List<CommandArgForm> commandArgList;
}
