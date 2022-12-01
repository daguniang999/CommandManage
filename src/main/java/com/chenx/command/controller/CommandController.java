package com.chenx.command.controller;

import com.chenx.command.common.ResponseInfo;
import com.chenx.command.facade.CommandFacade;
import com.chenx.command.pojo.dto.CommandDTO;
import com.chenx.command.pojo.form.CommandForm;
import com.chenx.command.pojo.request.CommandRequest;
import com.chenx.command.pojo.vo.CommandVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CommandController
 * @Description 命令Controller
 * @Author daguniang
 * @Date 2022/11/6 10:56
 **/
@Api(value = "/command")
@RestController
@RequestMapping("/command")
@Slf4j
public class CommandController {

    CommandFacade commandFacade;

    @Autowired
    public void setCommandFacade(CommandFacade commandFacade) {
        this.commandFacade = commandFacade;
    }

    /**
     * 获取列表
     *
     * @param request 筛选条件
     * @return {@link ResponseInfo}<{@link List}<{@link CommandDTO}>>
     */
    @ApiOperation(value = "获取列表", notes = "", tags = {}, httpMethod = "GET")
    @GetMapping
    public ResponseInfo<List<CommandVO>> getList(CommandRequest request) {
        //  根据Request获取命令列表
        List<CommandVO> voList = commandFacade.getList(request);
        return ResponseInfo.success(voList);
    }

    /**
     * 添加
     *
     * @param form 添加DTO
     * @return {@link ResponseInfo}
     */
    @ApiImplicitParam(name = "addDTO", value = "添加DTO")
    @ApiOperation(value = "添加", notes = "", tags = {}, httpMethod = "POST")
    @PostMapping
    public ResponseInfo add(@RequestBody CommandForm form) {
        Boolean ok = commandFacade.add(form);
        return ok ? ResponseInfo.success() : ResponseInfo.fail();
    }

    /**
     * 编辑
     *
     * @param form 编辑DTO
     * @return {@link ResponseInfo}
     */
    @ApiImplicitParam(name = "editDTO", value = "编辑DTO")
    @ApiOperation(value = "编辑", notes = "", tags = {}, httpMethod = "PUT")
    @PutMapping
    public ResponseInfo edit(@RequestBody CommandForm form) {
        Boolean ok = commandFacade.edit(form);
        return ok ? ResponseInfo.success() : ResponseInfo.fail();
    }

    /**
     * 删除
     *
     * @param id id
     * @return {@link ResponseInfo}
     */
    @ApiImplicitParam(name = "id", value = "id")
    @ApiOperation(value = "删除", notes = "", tags = {}, httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseInfo delete(@PathVariable("id") Long id) {
        Boolean ok = commandFacade.delete(id);
        return ok ? ResponseInfo.success() : ResponseInfo.fail();
    }
}
