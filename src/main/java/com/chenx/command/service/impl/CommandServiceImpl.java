package com.chenx.command.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenx.command.common.Constant;
import com.chenx.command.mapper.CommandMapper;
import com.chenx.command.pojo.dto.CommandAddDTO;
import com.chenx.command.pojo.dto.CommandDTO;
import com.chenx.command.pojo.entity.Command;
import com.chenx.command.pojo.request.CommandRequest;
import com.chenx.command.service.CommandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommandServiceImpl
 * @Description 命令Service实现
 * @Author daguniang
 * @Date 2022/11/6 15:06
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommandServiceImpl extends ServiceImpl<CommandMapper, Command> implements CommandService {

    @Override
    public List<CommandDTO> getDTOList(CommandRequest request) {
        // 根据request获取命令ID集合
        List<Long> commandIds = getBaseMapper().getCommandId(request);
        return getList(commandIds);
    }

    @Override
    public Boolean add(CommandAddDTO addDTO) {
        Command command = new Command();
        convertAddDTO2DO(addDTO, command);
        // 添加命令
        int count = getBaseMapper().insert(command);
        return count == Constant.INTEGER_ONE ? true : false;
    }

    private List<CommandDTO> getList(List<Long> ids) {
        List<CommandDTO> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(ids)) { return result; }

        // 批量获取命令列表数据
        List<Command> commands = getBaseMapper().selectBatchIds(ids);

        // 填充参数
        for (Command item : commands) {
            CommandDTO newItem = new CommandDTO();
            convertDO2DTO(item, newItem);
            result.add(newItem);
        }
        return result;
    }

    /**
     * DO 2 DTO
     * @param source 源对象
     * @param target 目标对象
     */
    private CommandDTO convertDO2DTO(Command source, CommandDTO target) {
        if (source == null || target == null) {
            return target;
        }
        target.setCommandId(source.getCommandId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }

    /**
     * AddDTO 2 DO
     * @param source
     * @param target
     * @return
     */
    private Command convertAddDTO2DO(CommandAddDTO source, Command target) {
        if (source == null || target == null) {
            return target;
        }
        target.setCommandId(source.getCommandId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }
}
