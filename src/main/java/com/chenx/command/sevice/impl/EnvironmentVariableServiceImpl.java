package com.chenx.command.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.EnvironmentVariableMapper;
import com.chenx.command.pojo.entity.EnvironmentVariable;
import com.chenx.command.sevice.EnvironmentVariableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName EnvironmentVariableServiceImpl
 * @Description 环境变量Service实现
 * @Author daguniang
 * @Date 2022/11/26 16:44
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class EnvironmentVariableServiceImpl extends ServiceImpl<EnvironmentVariableMapper, EnvironmentVariable>
    implements EnvironmentVariableService {
}
