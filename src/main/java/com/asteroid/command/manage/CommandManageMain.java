package com.asteroid.command.manage;

import com.asteroid.command.manage.bean.Command;
import com.asteroid.command.manage.bean.CommandArg;
import com.asteroid.command.manage.dto.CommandDTO;

import java.util.ArrayList;
import java.util.List;

public class CommandManageMain {
    public static void main(String[] args) {

        Command command = new Command();
        command.setId("1");
        command.setName("mv");
        command.setDescription("移动");

        // getCommondId by Args
        List<CommandArg> commandArgs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CommandArg commandArg = new CommandArg();
            commandArg.setId(String.valueOf(i));
            commandArg.setCommandId(command.getId());
            commandArg.setSortName("R");
            commandArg.setSortName("Return");
            commandArg.setDescription("移动");
        }



        // 主命令
        // 参数
        // 参数类型
        // 参数数值
        // 参数的描述
        // 命令的描述
        // 命令的版本
        // 参数的顺序


        // 主命令描述
        // 参数描述


        // 命令的分组

        // 命令的解析
    }
}
