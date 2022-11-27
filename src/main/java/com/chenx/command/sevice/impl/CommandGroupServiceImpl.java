package com.chenx.command.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandGroupMapper;
import com.chenx.command.pojo.entity.CommandGroup;
import com.chenx.command.sevice.CommandGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CommandGroupServiceImpl
 * @Description 命令分组Service实现
 * @Author daguniang
 * @Date 2022/11/26 16:38
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandGroupServiceImpl extends ServiceImpl<CommandGroupMapper, CommandGroup>
    implements CommandGroupService {
}
