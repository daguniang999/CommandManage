package com.chenx.command.controller;

import com.chenx.command.common.ResponseInfo;
import com.chenx.command.facade.CommandFacade;
import com.chenx.command.pojo.dto.CommandDTO;
import com.chenx.command.pojo.request.CommandRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CommandController
 * @Description 命令Controller
 * @Author daguniang
 * @Date 2022/11/6 10:56
 **/
@RestController
@RequestMapping("/command")
@Slf4j
public class CommandController {

    CommandFacade commandFacade;

    @Autowired
    public void setCommandFacade(CommandFacade commandFacade) {
        this.commandFacade = commandFacade;
    }

    /**
     * 根据条件获取命令列表
     * @param request
     * @return
     */
    @GetMapping
    public ResponseInfo<List<CommandDTO>> getList(CommandRequest request) {
        //  根据Request获取命令列表
        List<CommandDTO> dtoList = commandFacade.getList(request);
        return ResponseInfo.success(dtoList);
    }

    @GetMapping("/test")
    public ResponseInfo getTest() {
        return ResponseInfo.success();
    }

}
