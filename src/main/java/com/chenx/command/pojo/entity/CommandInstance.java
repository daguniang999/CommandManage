package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName CommandInstance
 * @Description 命令实例
 * @Author daguniang
 * @Date 2022/11/26 15:57
 **/
@Data
@TableName(value = "command_instance")
public class CommandInstance {

    /**
     * 命令实例Id
     */
    @TableId(value = "instance_id", type = IdType.ASSIGN_ID)
    private Long instanceId;

    /**
     * 命令ID
     */
    private Long commandId;

    /**
     * 命令实例描述
     */
    private String description;
}
