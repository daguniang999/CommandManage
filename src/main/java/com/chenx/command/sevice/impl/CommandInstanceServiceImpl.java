package com.chenx.command.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandInstanceMapper;
import com.chenx.command.pojo.entity.CommandInstance;
import com.chenx.command.sevice.CommandInstanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CommandInstanceServiceImpl
 * @Description 命令实例Service实现
 * @Author daguniang
 * @Date 2022/11/26 16:40
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandInstanceServiceImpl extends ServiceImpl<CommandInstanceMapper, CommandInstance>
    implements CommandInstanceService {
}
