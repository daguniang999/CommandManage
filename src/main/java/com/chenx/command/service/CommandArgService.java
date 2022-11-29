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

    /**
     * 批处理更新
     *
     * @param argList 参数列表
     * @return {@link Boolean}
     */
    Boolean updateBatch(List<CommandArgDTO> argList);

    /**
     * 删除通过id
     *
     * @param ids id
     * @return {@link Boolean}
     */
    Boolean deleteById(List<Long> ids);

    /**
     * 按命令id删除
     *
     * @param commandIds 命令id
     * @return {@link Boolean}
     */
    Boolean deleteByCommandId(List<Long> commandIds);
}
