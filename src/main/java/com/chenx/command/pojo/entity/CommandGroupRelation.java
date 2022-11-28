package com.chenx.command.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName CommandGroupRelationService
 * @Description 命令分组关联
 * @Author daguniang
 * @Date 2022/11/26 15:56
 **/
@Data
@TableName(value = "command_group_relation")
public class CommandGroupRelation {

    /**
     * 命令分组关联ID
     */
    @TableId(value = "group_relation_id", type = IdType.ASSIGN_ID)
    private Long groupRelationId;

    /**
     * 命令ID
     */
    private Long commandId;

    /**
     * 分组ID
     */
    private Long groupId;

}
