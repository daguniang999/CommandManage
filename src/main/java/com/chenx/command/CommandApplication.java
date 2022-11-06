package com.chenx.command;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName CommandApplication
 * @Description 启动类
 * @Author daguniang
 * @Date 2022/11/6 10:53
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.chenx.command.mapper"})
public class CommandApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }
}
