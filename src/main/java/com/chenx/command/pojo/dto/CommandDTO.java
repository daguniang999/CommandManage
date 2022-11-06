package com.chenx.command.pojo.dto;

import com.chenx.command.pojo.entity.CommandArg;
import lombok.Data;

import java.util.List;

/**
 * @ClassName CommandDTO
 * @Description 命令DTO
 * @Author daguniang
 * @Date 2022/11/6 10:53
 **/
@Data
public class CommandDTO {

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
