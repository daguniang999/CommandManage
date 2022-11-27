package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName CommandArg
 * @Description 命令参数
 * @Author daguniang
 * @Date 2022/11/6 10:53
 **/
@Data
@TableName(value = "command_arg")
public class CommandArg {

    /**
     * 命令参数ID
     */
    @TableId(value = "command_arg_id", type = IdType.ASSIGN_ID)
    private Long commandArgId;

    /**
     * 命令ID
     */
    private Long commandId;

    /**
     * 参数名
     */
    private String name;

    /**
     * 参数类型
     */
    private Integer type;

    /**
     * 分隔符
     */
    private Integer symbol;

    /**
     * 顺序
     */
    private Integer sequence;

    /**
     * 描述
     */
    private String description;

}
