package com.chenx.command.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandMapper;
import com.chenx.command.pojo.entity.Command;
import com.chenx.command.sevice.CommandService;
import org.springframework.stereotype.Service;

/**
 * @ClassName CommandServiceImpl
 * @Description TODO
 * @Author daguniang
 * @Date 2022/11/6 15:06
 **/
@Service
public class CommandServiceImpl extends ServiceImpl<CommandMapper, Command> implements CommandService {

}
