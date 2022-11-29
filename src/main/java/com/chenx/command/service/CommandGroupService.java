package com.chenx.command.service;


import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenx.command.pojo.dto.CommandGroupDTO;
import com.chenx.command.pojo.dto.CommandGroupTree;
import com.chenx.command.pojo.entity.CommandGroup;

import java.util.List;

/**
 * @ClassName CommandGroupService
 * @Description 命令分组Service
 * @Author daguniang
 * @Date 2022/11/26 16:27
 **/
public interface CommandGroupService extends IService<CommandGroup> {

    /**
     * 添加命令分组
     *
     * @param addList 添加DTO
     * @return {@link Boolean}
     */
    Boolean addGroup(List<CommandGroupDTO> addList);

    /**
     * 获取分组树
     *
     * @return {@link List}<{@link CommandGroupTree}>
     */
    List<Tree<String>> getGroupTree();

    /**
     * 删除根据id
     *
     * @param ids id
     * @return {@link Boolean}
     */
    Boolean deleteById(List<Long> ids);
}
