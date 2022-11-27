package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName EnvironmentVariable
 * @Description 环境变量配置
 * @Author daguniang
 * @Date 2022/11/26 15:57
 **/
@Data
@TableName(value = "environment_variable")
public class EnvironmentVariable {

    /**
     * 环境变量ID
     */
    @TableId(value = "env_variable_id", type = IdType.ASSIGN_ID)
    private Long envVariableId;

    /**
     * 环境ID
     */
    private Long envId;

    /**
     * 变量名称
     */
    private String name;

    /**
     * 变量值
     */
    private String value;
}
