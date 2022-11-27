package com.chenx.command.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandArgMapper;
import com.chenx.command.pojo.entity.CommandArg;
import com.chenx.command.sevice.CommandArgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CommandArgServiceImpl
 * @Description 命令参数Service实现
 * @Author daguniang
 * @Date 2022/11/6 15:40
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandArgServiceImpl extends ServiceImpl<CommandArgMapper, CommandArg> implements CommandArgService {
}
