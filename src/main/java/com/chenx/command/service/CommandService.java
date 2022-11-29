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
     * 获取对象List
     *
     * @param request 筛选条件
     * @return {@link List}<{@link CommandDTO}>
     */
    List<CommandDTO> getDTOList(CommandRequest request);

    /**
     * 根据ID获取dto
     *
     * @param id id
     * @return {@link CommandDTO}
     */
    CommandDTO getDTOById(Long id);

    /**
     * 删除通过id
     *
     * @param ids id
     * @return {@link Boolean}
     */
    Boolean deleteById(List<Long> ids);

    /**
     * 按组id删除
     *
     * @param groupIds 组id
     * @return {@link Boolean}
     */
    Boolean deleteByGroupId(List<Long> groupIds);
}
