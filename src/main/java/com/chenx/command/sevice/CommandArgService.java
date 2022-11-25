package com.chenx.command.sevice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenx.command.pojo.entity.CommandArg;

/**
 * @ClassName CommandArgService
 * @Description TODO
 * @Author daguniang
 * @Date 2022/11/6 15:40
 **/
public interface CommandArgService extends IService<CommandArg> {

    /**
     * 测试方法
     * @param num 数量
     * @param name 名称
     * @return 测试返回
     */
    public String test(Integer num, String name);
}
