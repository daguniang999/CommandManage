package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CommandGroupRelationService
 * @Description 命令分组关联
 * @Author daguniang
 * @Date 2022/11/26 15:56
 **/
@ApiModel(description = "命令分组关联DO")
@Data
@TableName(value = "command_group_relation")
public class CommandGroupRelation {

    /**
     * 命令分组关联ID
     */
    @ApiModelProperty(value = "命令分组关联ID", required = true)
    @TableId(value = "group_relation_id", type = IdType.ASSIGN_ID)
    private Long groupRelationId;

    /**
     * 命令ID
     */
    @ApiModelProperty(value = "命令ID", required = true)
    private Long commandId;

    /**
     * 分组ID
     */
    @ApiModelProperty(value = "分组ID", required = true)
    private Long groupId;

}
