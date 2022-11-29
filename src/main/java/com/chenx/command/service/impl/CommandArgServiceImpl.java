package com.chenx.command.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandArgMapper;
import com.chenx.command.pojo.dto.CommandArgDTO;
import com.chenx.command.pojo.entity.CommandArg;
import com.chenx.command.service.CommandArgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName CommandArgServiceImpl
 * @Description 命令参数Service实现
 * @Author daguniang
 * @Date 2022/11/6 15:40
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandArgServiceImpl extends ServiceImpl<CommandArgMapper, CommandArg> implements CommandArgService {

    /**
     * 批量添加
     *
     * @param argList 参数列表
     * @return {@link Boolean}
     */
    @Override
    public Boolean addBatch(List<CommandArgDTO> argList) {
        if (CollectionUtils.isEmpty(argList)) {
            return true;
        }

        List<CommandArg> list = new ArrayList<>();

        // 参数转换
        for (CommandArgDTO item : argList) {
            CommandArg newItem = new CommandArg();
            convertDTO2DO(item, newItem);
            list.add(newItem);
        }

        // 批量插入
        Boolean ok = saveBatch(list);
        return ok;
    }


    /**
     * 删除通过id
     *
     * @param ids id
     * @return {@link Boolean}
     */
    @Override
    public Boolean deleteById(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return true;
        }
        return delete(ids);
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
        LambdaQueryWrapper<CommandArg> wrapper = new LambdaQueryWrapper<CommandArg>()
                .in(CommandArg::getCommandId, commandIds)
                .select(CommandArg::getCommandArgId);
        List<CommandArg> commandArgs = getBaseMapper().selectList(wrapper);
        List<Long> ids = commandArgs.stream().map(CommandArg::getCommandArgId).collect(Collectors.toList());
        return delete(ids);
    }


    /**
     * 批处理更新
     *
     * @param argList 参数列表
     * @return {@link Boolean}
     */
    @Override
    public Boolean updateBatch(List<CommandArgDTO> argList) {
        if (CollectionUtils.isEmpty(argList)) {
            return true;
        }

        List<CommandArg> list = new ArrayList<>();
        for (CommandArgDTO item : argList) {
            CommandArg newItem = new CommandArg();
            convertDTO2DO(item, newItem);
            list.add(newItem);
        }
        return updateBatchById(list);
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
     * DTO 2 DO
     *
     * @param source 源对象
     * @param target 目标对象
     * @return {@link CommandArg}
     */
    private CommandArg convertDTO2DO(CommandArgDTO source, CommandArg target) {
        if (source == null || target == null) {
            return target;
        }

        target.setCommandArgId(source.getCommandArgId());
        target.setCommandId(source.getCommandId());
        target.setName(source.getName());
        target.setType(source.getType());
        target.setSymbol(source.getSymbol());
        target.setSequence(source.getSequence());
        target.setDescription(source.getDescription());
        return target;
    }
}
