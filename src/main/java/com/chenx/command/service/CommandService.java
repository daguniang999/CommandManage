package com.chenx.command.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenx.command.pojo.dto.CommandAddDTO;
import com.chenx.command.pojo.dto.CommandDTO;
import com.chenx.command.pojo.entity.Command;
import com.chenx.command.pojo.request.CommandRequest;

import java.util.List;

/**
 * @ClassName CommandService
 * @Description 命令Service
 * @Author daguniang
 * @Date 2022/11/6 15:05
 **/
public interface CommandService extends IService<Command> {

    /**
     * 获取命令DTO列表
     * @param request
     * @return
     */
    List<CommandDTO> getDTOList(CommandRequest request);

    /**
     * 添加命令
     * @param addDTO
     * @return
     */
    Boolean add(CommandAddDTO addDTO);
}
