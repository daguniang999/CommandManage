package com.chenx.command.facade;

import cn.hutool.core.lang.tree.Tree;
import com.chenx.command.pojo.dto.CommandGroupDTO;
import com.chenx.command.pojo.dto.CommandGroupTree;
import com.chenx.command.pojo.entity.CommandGroup;
import com.chenx.command.service.CommandGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName CommandGroupFacade
 * @Description 命令分组Facade
 * @Author daguniang
 * @Date 2022/11/27 09:11
 **/
@Component
public class CommandGroupFacade {

    private CommandGroupService commandGroupService;

    /**
     * 获取分组根据树
     *
     * @return {@link List}<{@link CommandGroupTree}>
     */
    public List<Tree<String>> getGroupTree() {
        List<Tree<String>> trees = commandGroupService.getGroupTree();
        return trees;
    }

    /**
     * 添加
     *
     * @param addDTO 添加dto
     * @return {@link Boolean}
     */
    public Boolean add(CommandGroupDTO addDTO) {
        CommandGroup commandGroup = new CommandGroup();
        convertDTO2DO(addDTO, commandGroup);
        return commandGroupService.save(commandGroup);
    }

    /**
     * 编辑
     *
     * @param editDTO 编辑dto
     * @return {@link Boolean}
     */
    public Boolean edit(CommandGroupDTO editDTO) {
        CommandGroup commandGroup = new CommandGroup();
        convertDTO2DO(editDTO, commandGroup);
        return commandGroupService.updateById(commandGroup);
    }

    /**
     * 删除
     *
     * @param id id
     * @return {@link Boolean}
     */
    public Boolean delete(Long id) {
        if (id == null) {
            return true;
        }
        return commandGroupService.deleteById(Collections.singletonList(id));
    }

    /**
     * 设置命令组服务
     *
     * @param commandGroupService 命令组服务
     */
    @Autowired
    public void setCommandGroupService(CommandGroupService commandGroupService) {
        this.commandGroupService = commandGroupService;
    }

    private Boolean delete(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return true;
        }

        // 删除分组
        return commandGroupService.deleteById(ids);
    }

    private CommandGroup convertDTO2DO(CommandGroupDTO source, CommandGroup target) {
        if (source == null || target == null) {
            return target;
        }
        target.setGroupId(source.getGroupId());
        target.setName(source.getName());
        target.setParentGroupId(source.getParentGroupId());
        target.setDescription(source.getDescription());
        return target;
    }
}
