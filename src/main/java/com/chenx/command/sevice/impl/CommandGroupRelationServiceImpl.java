package com.chenx.command.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.mapper.CommandGroupRelationMapper;
import com.chenx.command.pojo.entity.CommandGroupRelation;
import com.chenx.command.sevice.CommandGroupRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CommandGroupRelationServiceImpl
 * @Description 命令分组关联Service实现
 * @Author daguniang
 * @Date 2022/11/26 16:34
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandGroupRelationServiceImpl extends ServiceImpl<CommandGroupRelationMapper, CommandGroupRelation>
        implements CommandGroupRelationService {
}
