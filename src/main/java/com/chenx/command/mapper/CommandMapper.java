package com.chenx.command.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenx.command.pojo.entity.Command;
import com.chenx.command.pojo.request.CommandRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CommandMapper
 * @Description 命令Mapper
 * @Author daguniang
 * @Date 2022/11/6 15:04
 **/
@Mapper
public interface CommandMapper extends BaseMapper<Command> {

    /**
     * 根据条件获取命令ID集合
     * @param request 筛选条件
     * @return 命令ID集合
     */
    List<Long> getCommandId(@Param("request") CommandRequest request);
}
