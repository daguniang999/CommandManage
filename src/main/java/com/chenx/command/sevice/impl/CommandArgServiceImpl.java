package com.chenx.command.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandArgMapper;
import com.chenx.command.pojo.entity.CommandArg;
import com.chenx.command.sevice.CommandArgService;
import org.springframework.stereotype.Service;

/**
 * @ClassName CommandArgServiceImpl
 * @Description TODO
 * @Author daguniang
 * @Date 2022/11/6 15:40
 **/
@Service
public class CommandArgServiceImpl extends ServiceImpl<CommandArgMapper, CommandArg> implements CommandArgService {
    @Override
    public String test(Integer num, String name) {
        return null;
    }
}
