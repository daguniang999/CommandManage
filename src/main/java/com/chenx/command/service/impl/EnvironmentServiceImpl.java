package com.chenx.command.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.EnvironmentMapper;
import com.chenx.command.pojo.entity.Environment;
import com.chenx.command.service.EnvironmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName EnvironmentServiceImpl
 * @Description 环境Service实现
 * @Author daguniang
 * @Date 2022/11/26 16:42
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class EnvironmentServiceImpl extends ServiceImpl<EnvironmentMapper, Environment>
    implements EnvironmentService {
}
