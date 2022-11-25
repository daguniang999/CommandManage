package com.chenx.command.controller;

import com.chenx.command.sevice.CommandArgService;
import com.chenx.command.sevice.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CommandController
 * @Description 命令Controller
 * @Author daguniang
 * @Date 2022/11/6 10:56
 **/
@RestController
@RequestMapping("/command")
public class CommandController {

    private CommandService commandService;

    private CommandArgService commandArgService;

    @Autowired
    public void setCommandService(CommandService commandService) {
        this.commandService = commandService;
    }

    @Autowired
    public void setCommandArgService(CommandArgService commandArgService) {
        this.commandArgService = commandArgService;
    }
}
