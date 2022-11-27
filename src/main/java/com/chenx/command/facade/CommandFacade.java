package com.chenx.command.facade;

import com.chenx.command.common.ResponseInfo;
import com.chenx.command.pojo.dto.CommandDTO;
import com.chenx.command.pojo.request.CommandRequest;
import com.chenx.command.sevice.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Autowired
    public void setCommandService(CommandService commandService) {
        this.commandService = commandService;
    }

    /**
     * 根据条件获取命令列表
     * @param request
     * @return
     */
    public List<CommandDTO> getList(CommandRequest request) {
        //  根据Request获取命令列表
        List<CommandDTO> dtoList = commandService.getDTOList(request);
        return dtoList;
    }
}
