package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName Environment
 * @Description 环境配置
 * @Author daguniang
 * @Date 2022/11/26 15:57
 **/
@Data
@TableName(value = "environment")
public class Environment {

    /**
     * 环境ID
     */
    @TableId(value = "env_id", type = IdType.ASSIGN_ID)
    private Long envId;

    /**
     * 环境名称
     */
    private String name;

    /**
     * 环境描述
     */
    private String description;
}
