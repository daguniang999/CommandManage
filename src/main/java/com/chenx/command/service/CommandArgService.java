package com.chenx.command.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenx.command.pojo.dto.CommandArgDTO;
import com.chenx.command.pojo.entity.CommandArg;

import java.util.List;

/**
 * @ClassName CommandArgService
 * @Description 命令参数Service
 * @Author daguniang
 * @Date 2022/11/6 15:40
 **/
public interface CommandArgService extends IService<CommandArg> {

    /**
     * 批量添加
     *
     * @param argList 参数列表
     * @return {@link Boolean}
     */
    Boolean addBatch(List<CommandArgDTO> argList);
}
