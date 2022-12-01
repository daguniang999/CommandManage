package com.chenx.command.controller;

import cn.hutool.core.lang.tree.Tree;
import com.chenx.command.common.ResponseInfo;
import com.chenx.command.facade.CommandGroupFacade;
import com.chenx.command.pojo.dto.CommandGroupDTO;
import com.chenx.command.pojo.dto.CommandGroupTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CommandGroupController
 * @Description 命令分组Controller
 * @Author chenxiaowei
 * @Date 2022/11/29 09:14
 **/
@Api(value = "/group")
@RestController
@RequestMapping("/group")
public class CommandGroupController {

    private CommandGroupFacade commandGroupFacade;

    /**
     * 获取分组树
     *
     * @return {@link ResponseInfo}<{@link CommandGroupTree}>
     */
    @ApiOperation(value = "获取分组树", notes = "")
    @GetMapping("/tree")
    public ResponseInfo<List<Tree<String>>> tree() {
        List<Tree<String>> groupTree = commandGroupFacade.getGroupTree();
        return ResponseInfo.success(groupTree);
    }

    /**
     * 添加
     *
     * @param addDTO 添加dto
     * @return {@link ResponseInfo}
     */
    @ApiImplicitParam(name = "addDTO", value = "添加dto")
    @ApiOperation(value = "添加", notes = "")
    @PostMapping
    public ResponseInfo add(@RequestBody CommandGroupDTO addDTO) {
        Boolean ok = commandGroupFacade.add(addDTO);
        return ok ? ResponseInfo.success() : ResponseInfo.fail();
    }

    /**
     * 编辑
     *
     * @param editDTO 编辑对象
     * @return {@link ResponseInfo}
     */
    @ApiImplicitParam(name = "editDTO", value = "编辑对象")
    @ApiOperation(value = "编辑", notes = "")
    public ResponseInfo edit(@RequestBody CommandGroupDTO editDTO) {
        Boolean ok = commandGroupFacade.edit(editDTO);
        return ok ? ResponseInfo.success() : ResponseInfo.fail();
    }

    /**
     * 删除
     */
    @ApiImplicitParam(name = "id", value = "")
    @ApiOperation(value = "删除", notes = "")
    @DeleteMapping("/{id}")
    public ResponseInfo delete(@PathVariable("id") Long id) {
        Boolean ok = commandGroupFacade.delete(id);
        return ok ? ResponseInfo.success() : ResponseInfo.fail();
    }

    @Autowired
    public void setCommandGroupFacade(CommandGroupFacade commandGroupFacade) {
        this.commandGroupFacade = commandGroupFacade;
    }
}
