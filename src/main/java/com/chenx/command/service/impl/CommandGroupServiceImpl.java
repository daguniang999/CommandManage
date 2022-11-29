package com.chenx.command.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandGroupMapper;
import com.chenx.command.pojo.dto.CommandGroupDTO;
import com.chenx.command.pojo.dto.CommandGroupTree;
import com.chenx.command.pojo.entity.CommandGroup;
import com.chenx.command.service.CommandGroupRelationService;
import com.chenx.command.service.CommandGroupService;
import com.chenx.command.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
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

    private CommandGroupRelationService commandGroupRelationService;

    private CommandService commandService;

    /**
     * 获取分组树
     *
     * @return {@link List}<{@link CommandGroupTree}>
     */
    @Override
    public List<Tree<String>> getGroupTree() {
        List<CommandGroup> allGroup = getBaseMapper().selectList(new LambdaQueryWrapper<>());
        return buildTree(allGroup);
    }

    /**
     * 添加分组
     *
     * @param addList 添加列表
     * @return {@link Boolean}
     */
    @Override
    public Boolean addGroup(List<CommandGroupDTO> addList) {
        if (CollectionUtils.isEmpty(addList)) {
            return true;
        }

        List<CommandGroup> list = new ArrayList<>();
        // 参数转换
        for (CommandGroupDTO item : addList) {
            CommandGroup newItem = new CommandGroup();
            convertDTO2DO(item, newItem);
            list.add(newItem);
        }

        // 添加命令分组
        Boolean ok = saveBatch(list);
        return ok;
    }

    /**
     * 删除根据id
     *
     * @param ids id
     * @return {@link Boolean}
     */
    @Override
    public Boolean deleteById(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return true;
        }

        // 删除分组
        getBaseMapper().deleteBatchIds(ids);

        // 删除分组下的命令
        commandService.deleteByGroupId(ids);

        // 删除分组关联关系
        commandGroupRelationService.deleteByGroupId(ids);
        return true;
    }

    @Autowired
    public void setCommandGroupRelationService(CommandGroupRelationService commandGroupRelationService) {
        this.commandGroupRelationService = commandGroupRelationService;
    }

    @Autowired
    public void setCommandService(CommandService commandService) {
        this.commandService = commandService;
    }

    /**
     * DTO 2 DO
     *
     * @param source 源对象
     * @param target 目标对象
     * @return {@link CommandGroup}
     */
    private CommandGroup convertDTO2DO(CommandGroupDTO source, CommandGroup target) {
        if (source == null || target == null) {
            return target;
        }
        target.setGroupId(source.getGroupId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }

    /**
     * 构建树
     *
     * @param list 列表
     * @return {@link List}<{@link CommandGroupTree}>
     */
    private List<Tree<String>> buildTree(List<CommandGroup> list) {
        TreeNodeConfig config = new TreeNodeConfig();
        config.setIdKey("groupId");
        config.setChildrenKey("children");
        config.setParentIdKey("parentGroupId");

        List<Tree<String>> build = TreeUtil.build(list, "0", config,
            (treeNode, tree) -> {
                tree.setId(treeNode.getGroupId().toString());
                tree.setParentId(treeNode.getParentGroupId().toString());
                tree.setName(treeNode.getName());
            });
        if (build == null) {
            return Collections.emptyList();
        }
        return build;
    }
}
