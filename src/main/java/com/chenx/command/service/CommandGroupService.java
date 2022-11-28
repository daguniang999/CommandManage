package com.chenx.command.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.chenx.command.pojo.dto.CommandGroupAddDTO;
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
    Boolean addGroup(List<CommandGroupAddDTO> addList);
}
