package com.chenx.command.controller;

import com.chenx.command.sevice.CommandArgService;
import com.chenx.command.sevice.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CommandController
 * @Description TODO
 * @Author daguniang
 * @Date 2022/11/6 10:56
 **/
@RestController
@RequestMapping("/command")
public class CommandController {

    @Autowired
    private CommandService commandService;

    @Autowired
    private CommandArgService commandArgService;

}
