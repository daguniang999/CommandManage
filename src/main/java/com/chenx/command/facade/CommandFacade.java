package com.chenx.command.facade;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.chenx.command.pojo.dto.CommandArgDTO;
import com.chenx.command.pojo.dto.CommandDTO;
import com.chenx.command.pojo.dto.CommandGroupRelationDTO;
import com.chenx.command.pojo.entity.Command;
import com.chenx.command.pojo.request.CommandRequest;
import com.chenx.command.service.CommandArgService;
import com.chenx.command.service.CommandGroupRelationService;
import com.chenx.command.service.CommandGroupService;
import com.chenx.command.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName CommandFacade
 * @Description 命令Facade
 * @Author daguniang
 * @Date 2022/11/27 09:09
 **/
@Component
public class CommandFacade {

    private CommandService commandService;

    private CommandArgService commandArgService;

    private CommandGroupService commandGroupService;

    private CommandGroupRelationService commandGroupRelationService;

    @Autowired
    public void setCommandGroupRelationService(CommandGroupRelationService commandGroupRelationService) {
        this.commandGroupRelationService = commandGroupRelationService;
    }

    @Autowired
    public void setCommandGroupService(CommandGroupService commandGroupService) {
        this.commandGroupService = commandGroupService;
    }

    @Autowired
    public void setCommandArgService(CommandArgService commandArgService) {
        this.commandArgService = commandArgService;
    }

    @Autowired
    public void setCommandService(CommandService commandService) {
        this.commandService = commandService;
    }

    /**
     * 获取列表
     *
     * @param request 筛选条件
     * @return {@link List}<{@link CommandDTO}>
     */
    public List<CommandDTO> getList(CommandRequest request) {
        //  根据Request获取命令列表
        List<CommandDTO> dtoList = commandService.getDTOList(request);
        return dtoList;
    }


    /**
     * 添加
     *
     * @param addDTO 添加DTO
     * @return {@link Boolean}
     */
    public Boolean add(CommandDTO addDTO) {

        Long commandId = IdWorker.getId();

        // 插入命令
        addDTO.setCommandId(commandId);
        Command command = new Command();
        convertDO2DTO(addDTO, command);
        Boolean ok = commandService.save(command);

        // 插入命令参数
        commandArgService.addBatch(addDTO.getCommandArgList());

        // 插入命令分组关联
        Long groupId = addDTO.getGroupId();
        if (groupId != null) {
            CommandGroupRelationDTO relationDTO = new CommandGroupRelationDTO();
            relationDTO.setCommandId(commandId);
            relationDTO.setGroupId(groupId);
            commandGroupRelationService.addRelation(Collections.singletonList(relationDTO));
        }
        return ok;
    }

    public Boolean edit(CommandDTO editDTO) {
        Long commandId = editDTO.getCommandId();
        List<Long> commandIds = Collections.singletonList(commandId);

        // 新命令参数
        List<CommandArgDTO> argList = Optional.ofNullable(editDTO.getCommandArgList()).orElse(Collections.emptyList());
        List<Long> argIds = argList.stream().map(CommandArgDTO::getCommandArgId).collect(Collectors.toList());
        // 获取历史命令
        CommandDTO oldCommandDTO = commandService.getDTOById(commandId);
        List<CommandArgDTO> oldArgList = Optional.ofNullable(oldCommandDTO.getCommandArgList())
            .orElse(Collections.emptyList());

        // 需要删除的参数ID
        List<Long> deleteArgIds = oldArgList.stream().map(CommandArgDTO::getCommandArgId).collect(Collectors.toList());
        deleteArgIds.removeAll(argIds);

        // 需要更新的参数
        List<CommandArgDTO> updateArgList = argList.stream().filter(item -> item.getCommandArgId() != null)
            .collect(Collectors.toList());

        // 需要新增的参数
        List<CommandArgDTO> addArgList = argList.stream().filter(item -> item.getCommandArgId() == null)
            .collect(Collectors.toList());

        // 更新命令
        Command command = new Command();
        convertDO2DTO(editDTO, command);
        commandService.updateById(command);

        // 更新命令参数
        commandArgService.updateBatch(updateArgList);

        // 新增命令参数
        commandArgService.addBatch(addArgList);

        // 删除命令参数
        commandArgService.deleteById(deleteArgIds);

        return true;
    }

    /**
     * 删除
     *
     * @param id id
     * @return {@link Boolean}
     */
    public Boolean delete(Long id) {
        return commandService.deleteById(Collections.singletonList(id));
    }

    /**
     * DO 2 DTO
     *
     * @param source 源对象
     * @param target 目标对象
     * @return {@link Command}
     */
    private Command convertDO2DTO(CommandDTO source, Command target) {
        if (source == null || target == null) {
            return target;
        }
        target.setCommandId(source.getCommandId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }
}
