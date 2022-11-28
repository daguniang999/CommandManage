package com.chenx.command.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandGroupRelationMapper;
import com.chenx.command.pojo.dto.CommandGroupRelationDTO;
import com.chenx.command.pojo.entity.CommandGroupRelation;
import com.chenx.command.service.CommandGroupRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName CommandGroupRelationServiceImpl
 * @Description 命令分组关联Service实现
 * @Author daguniang
 * @Date 2022/11/26 16:34
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandGroupRelationServiceImpl extends ServiceImpl<CommandGroupRelationMapper, CommandGroupRelation>
        implements CommandGroupRelationService {

    @Override
    public Boolean addRelation(List<CommandGroupRelationDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return true;
        }

        List<CommandGroupRelation> list = new ArrayList<>();
        // 参数填充
        for (CommandGroupRelationDTO item : dtoList) {
            CommandGroupRelation newItem = new CommandGroupRelation();
            convertDTO2DO(item, newItem);
            list.add(newItem);
        }

        // 批量添加
        Boolean ok = saveBatch(list);
        return ok;
    }

    /**
     * 按命令id删除
     *
     * @param commandIds 命令id
     * @return {@link Boolean}
     */
    @Override
    public Boolean deleteByCommandId(List<Long> commandIds) {
        if (CollectionUtils.isEmpty(commandIds)) {
            return true;
        }

        LambdaQueryWrapper<CommandGroupRelation> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(CommandGroupRelation::getCommandId, commandIds)
                .select(CommandGroupRelation::getGroupRelationId);
        List<CommandGroupRelation> relationList = getBaseMapper().selectList(wrapper);
        List<Long> ids = relationList.stream().map(CommandGroupRelation::getGroupRelationId).collect(Collectors.toList());
        return delete(ids);
    }

    /**
     * 按组id删除
     *
     * @param groupIds 组id
     * @return {@link Boolean}
     */
    @Override
    public Boolean deleteByGroupId(List<Long> groupIds) {
        if (CollectionUtils.isEmpty(groupIds)) {
            return true;
        }
        LambdaQueryWrapper<CommandGroupRelation> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(CommandGroupRelation::getGroupId, groupIds)
                .select(CommandGroupRelation::getGroupRelationId);
        List<CommandGroupRelation> relationList = getBaseMapper().selectList(wrapper);
        List<Long> ids = relationList.stream().map(CommandGroupRelation::getGroupRelationId)
                .collect(Collectors.toList());

        return delete(ids);
    }

    /**
     * 删除
     *
     * @param ids id
     * @return {@link Boolean}
     */
    private Boolean delete(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return true;
        }

        getBaseMapper().deleteBatchIds(ids);
        return true;
    }

    /**
     * DTO 2 DO
     *
     * @param source 源对象
     * @param target 目标对象
     * @return {@link CommandGroupRelation}
     */
    private CommandGroupRelation convertDTO2DO(CommandGroupRelationDTO source, CommandGroupRelation target) {
        if (source == null || target == null) {
            return target;
        }
        target.setGroupRelationId(source.getGroupRelationId());
        target.setCommandId(source.getCommandId());
        target.setGroupId(source.getGroupId());
        return target;
    }
}
