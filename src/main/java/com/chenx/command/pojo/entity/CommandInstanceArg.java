package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName CommandInstanceArg
 * @Description 命令实例参数
 * @Author daguniang
 * @Date 2022/11/26 15:56
 **/
@Data
@TableName(value = "command_instance_arg")
public class CommandInstanceArg {

    /**
     * 命令实例参数ID
     */
    @TableId(value = "instance_arg_id", type = IdType.ASSIGN_ID)
    private Long instanceArgId;

    /**
     * 命令参数ID
     */
    private Long commandArgId;

    /**
     * 参数值
     */
    private String value;

    /**
     * 参数默认值
     */
    private String defaultValue;
}
