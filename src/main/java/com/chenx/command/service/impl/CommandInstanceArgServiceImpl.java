package com.chenx.command.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandInstanceArgMapper;
import com.chenx.command.pojo.entity.CommandInstanceArg;
import com.chenx.command.service.CommandInstanceArgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CommandInstanceArgServiceImpl
 * @Description 命令实例参数Service实现
 * @Author daguniang
 * @Date 2022/11/26 16:41
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandInstanceArgServiceImpl extends ServiceImpl<CommandInstanceArgMapper, CommandInstanceArg>
    implements CommandInstanceArgService {
}
