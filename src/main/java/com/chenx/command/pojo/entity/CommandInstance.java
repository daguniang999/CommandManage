package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CommandInstance
 * @Description 命令实例
 * @Author daguniang
 * @Date 2022/11/26 15:57
 **/
@ApiModel(description = "命令实例DO")
@Data
@TableName(value = "command_instance")
public class CommandInstance {

    /**
     * 命令实例Id
     */
    @ApiModelProperty(value = "命令实例Id", required = true)
    @TableId(value = "instance_id", type = IdType.ASSIGN_ID)
    private Long instanceId;

    /**
     * 命令ID
     */
    @ApiModelProperty(value = "命令ID", required = true)
    private Long commandId;

    /**
     * 命令实例描述
     */
    @ApiModelProperty(value = "命令实例描述", required = true)
    private String description;
}
