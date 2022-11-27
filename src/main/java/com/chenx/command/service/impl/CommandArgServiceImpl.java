package com.chenx.command.service.impl;

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

/**
 * @ClassName CommandArgServiceImpl
 * @Description 命令参数Service实现
 * @Author daguniang
 * @Date 2022/11/6 15:40
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandArgServiceImpl extends ServiceImpl<CommandArgMapper, CommandArg> implements CommandArgService {

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
