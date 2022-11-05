package com.asteroid.command.manage.dto;

import com.asteroid.command.manage.bean.Command;
import com.asteroid.command.manage.bean.CommandArg;
import java.util.List;

/**
 * 命令DTO
 */
public class CommandDTO extends Command {

    /**
     * 命令参数列表
     */
    private List<CommandArg> commandArgList;


    public List<CommandArg> getCommandArgList() {
        return commandArgList;
    }

    public void setCommandArgList(List<CommandArg> commandArgList) {
        this.commandArgList = commandArgList;
    }
}
