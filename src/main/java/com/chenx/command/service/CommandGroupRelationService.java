package com.chenx.command.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.chenx.command.pojo.dto.CommandGroupRelationDTO;
import com.chenx.command.pojo.entity.CommandGroupRelation;

import java.util.List;

/**
 * @ClassName CommandGroupRelationService
 * @Description 命令分组关联Service
 * @Author daguniang
 * @Date 2022/11/26 16:28
 **/
public interface CommandGroupRelationService extends IService<CommandGroupRelation> {

    /**
     * 添加命令分组关联
     *
     * @param list 列表
     * @return {@link Boolean}
     */
    Boolean addRelation(List<CommandGroupRelationDTO> list);

    /**
     * 按命令id删除
     *
     * @param commandIds 命令id
     * @return {@link Boolean}
     */
    Boolean deleteByCommandId(List<Long> commandIds);

    /**
     * 按组id删除
     *
     * @param groupIds 组id
     * @return {@link Boolean}
     */
    Boolean deleteByGroupId(List<Long> groupIds);

    /**
     * 获取dto根据命令id
     *
     * @param commandIds 命令id
     * @return {@link List}<{@link CommandGroupRelationDTO}>
     */
    List<CommandGroupRelationDTO> getDTOByCommandId(List<Long> commandIds);

    /**
     * 获取dto根据分组id
     *
     * @param groupIds 分组id
     * @return {@link List}<{@link CommandGroupRelationDTO}>
     */
    List<CommandGroupRelationDTO> getDTOByGroupId(List<Long> groupIds);
}
