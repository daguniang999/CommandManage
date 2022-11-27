package com.chenx.command.facade;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.chenx.command.pojo.dto.CommandAddDTO;
import com.chenx.command.pojo.dto.CommandDTO;
import com.chenx.command.pojo.dto.CommandGroupRelationDTO;
import com.chenx.command.pojo.request.CommandRequest;
import com.chenx.command.service.CommandArgService;
import com.chenx.command.service.CommandGroupRelationService;
import com.chenx.command.service.CommandGroupService;
import com.chenx.command.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

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
    public Boolean add(CommandAddDTO addDTO) {

        Long commandId = IdWorker.getId();

        // 插入命令
        addDTO.setCommandId(commandId);
        Boolean ok = commandService.add(addDTO);

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
}
