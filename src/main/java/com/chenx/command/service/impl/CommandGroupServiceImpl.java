package com.chenx.command.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandGroupMapper;
import com.chenx.command.pojo.dto.CommandAddDTO;
import com.chenx.command.pojo.dto.CommandGroupAddDTO;
import com.chenx.command.pojo.entity.CommandGroup;
import com.chenx.command.service.CommandGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommandGroupServiceImpl
 * @Description 命令分组Service实现
 * @Author daguniang
 * @Date 2022/11/26 16:38
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandGroupServiceImpl extends ServiceImpl<CommandGroupMapper, CommandGroup>
    implements CommandGroupService {

    @Override
    public Boolean addGroup(List<CommandGroupAddDTO> addList) {
        if (CollectionUtils.isEmpty(addList)) {
            return true;
        }

        List<CommandGroup> list = new ArrayList<>();
        // 参数转换
        for (CommandGroupAddDTO item : addList) {
            CommandGroup newItem = new CommandGroup();
            convertAddDTO2DO(item, newItem);
            list.add(newItem);
        }

        // 添加命令分组
        Boolean ok = saveBatch(list);
        return ok;
    }

    /**
     * AddDTO 2 DO
     *
     * @param source 源对象
     * @param target 目标对象
     * @return {@link CommandGroup}
     */
    private CommandGroup convertAddDTO2DO(CommandGroupAddDTO source, CommandGroup target) {
        if (source == null || target == null) {
            return target;
        }
        target.setCommandGroupId(source.getCommandGroupId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }
}
