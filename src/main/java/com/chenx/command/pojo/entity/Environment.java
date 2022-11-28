package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName Environment
 * @Description 环境配置
 * @Author daguniang
 * @Date 2022/11/26 15:57
 **/
@ApiModel(description = "环境DO")
@Data
@TableName(value = "environment")
public class Environment {

    /**
     * 环境ID
     */
    @ApiModelProperty(value = "环境ID", required = true)
    @TableId(value = "env_id", type = IdType.ASSIGN_ID)
    private Long envId;

    /**
     * 环境名称
     */
    @ApiModelProperty(value = "环境名称", required = true)
    private String name;

    /**
     * 环境描述
     */
    @ApiModelProperty(value = "环境描述", required = true)
    private String description;
}
