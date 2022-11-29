package com.chenx.command.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.common.Constant;
import com.chenx.command.mapper.CommandMapper;
import com.chenx.command.pojo.dto.CommandDTO;
import com.chenx.command.pojo.entity.Command;
import com.chenx.command.pojo.request.CommandRequest;
import com.chenx.command.service.CommandArgService;
import com.chenx.command.service.CommandGroupRelationService;
import com.chenx.command.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName CommandServiceImpl
 * @Description 命令Service实现
 * @Author daguniang
 * @Date 2022/11/6 15:06
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandServiceImpl extends ServiceImpl<CommandMapper, Command> implements CommandService {

    private CommandArgService commandArgService;

    private CommandGroupRelationService commandGroupRelationService;

    /**
     * 获取dtolist
     *
     * @param request 筛选条件
     * @return {@link List}<{@link CommandDTO}>
     */
    @Override
    public List<CommandDTO> getDTOList(CommandRequest request) {
        // 根据request获取命令ID集合
        List<Long> commandIds = getBaseMapper().getCommandId(request);
        return getList(commandIds);
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
     * 按组id删除
     *
     * @param groupIds 组id
     * @return {@link Boolean}
     */
    @Override
    public Boolean deleteByGroupId(List<Long> groupIds) {
        // TODO 根据分组删除命令
        return true;
    }

    /**
     * 获取对象根据ID
     *
     * @param id id
     * @return {@link CommandDTO}
     */
    @Override
    public CommandDTO getDTOById(Long id) {
        if (id == null) {
            return null;
        }
        List<CommandDTO> list = getList(Collections.singletonList(id));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 获取列表
     *
     * @param ids id
     * @return {@link List}<{@link CommandDTO}>
     */
    private List<CommandDTO> getList(List<Long> ids) {
        List<CommandDTO> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(ids)) { return result; }

        // 批量获取命令列表数据
        List<Command> commands = getBaseMapper().selectBatchIds(ids);

        // 填充参数
        for (Command item : commands) {
            CommandDTO newItem = new CommandDTO();
            convertDO2DTO(item, newItem);
            result.add(newItem);
        }
        return result;
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

        // 删除命令
        getBaseMapper().deleteBatchIds(ids);

        // 删除命令参数
        commandArgService.deleteByCommandId(ids);

        // 删除命令和分组关联
        commandGroupRelationService.deleteByCommandId(ids);
        return true;
    }

    @Autowired
    public void setCommandArgService(CommandArgService commandArgService) {
        this.commandArgService = commandArgService;
    }

    @Autowired
    public void setCommandGroupRelationService(CommandGroupRelationService commandGroupRelationService) {
        this.commandGroupRelationService = commandGroupRelationService;
    }

    /**
     * DO 2 DTO
     * DO 2 DTO
     *
     * @param source 源对象
     * @param target 目标对象
     * @return {@link CommandDTO}
     */
    private CommandDTO convertDO2DTO(Command source, CommandDTO target) {
        if (source == null || target == null) {
            return target;
        }
        target.setCommandId(source.getCommandId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }

    /**
     * DTO 2 DO
     * DTO 2 DO
     *
     * @param source 源对象
     * @param target 目标对象
     * @return {@link Command}
     */
    private Command convertDTO2DO(CommandDTO source, Command target) {
        if (source == null || target == null) {
            return target;
        }
        target.setCommandId(source.getCommandId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }
}
