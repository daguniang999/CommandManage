package com.chenx.command.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.chenx.command.pojo.dto.CommandGroupRelationDTO;
import com.chenx.command.pojo.entity.CommandGroupRelation;

import java.util.List;

/**
 * @ClassName CommandGroupRelationService
 * @Description 命令分组关联Service
 * @Author daguniang
 * @Date 2022/11/26 16:28
 **/
public interface CommandGroupRelationService extends IService<CommandGroupRelation> {

    /**
     * 添加命令分组关联
     *
     * @param list 列表
     * @return {@link Boolean}
     */
    Boolean addRelation(List<CommandGroupRelationDTO> list);
}
