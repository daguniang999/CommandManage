package com.chenx.command.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CommandArgDTO
 * @Description 命令参数DTO
 * @Author daguniang
 * @Date 2022/11/27 09:27
 **/
@ApiModel(description = "命令参数对象")
@Data
public class CommandArgDTO {

    /**
     * 命令参数ID
     */
    @ApiModelProperty(value = "命令参数ID", required = true)
    private Long commandArgId;

    /**
     * 命令ID
     */
    @ApiModelProperty(value = "命令ID", required = true)
    private Long commandId;

    /**
     * 参数名
     */
    @ApiModelProperty(value = "参数名", required = true)
    private String name;

    /**
     * 参数类型
     */
    @ApiModelProperty(value = "参数类型", required = true)
    private Integer type;

    /**
     * 分隔符
     */
    @ApiModelProperty(value = "分隔符", required = true)
    private Integer symbol;

    /**
     * 顺序
     */
    @ApiModelProperty(value = "顺序", required = true)
    private Integer sequence;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", required = true)
    private String description;
}
