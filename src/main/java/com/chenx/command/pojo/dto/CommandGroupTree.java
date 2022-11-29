package com.chenx.command.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName CommandGroupTree
 * @Description 命令分组树
 * @Author chenxiaowei
 * @Date 2022/11/29 13:38
 **/
@Data
@ApiModel(description = "命令分组树")
public class CommandGroupTree {

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

    /**
     * 分组子节点
     */
    @ApiModelProperty(value = "分组子节点")
    private List<CommandGroupTree> children;

}
