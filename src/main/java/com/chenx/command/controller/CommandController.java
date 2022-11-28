package com.chenx.command.controller;

import com.chenx.command.common.ResponseInfo;
import com.chenx.command.facade.CommandFacade;
import com.chenx.command.pojo.dto.CommandDTO;
import com.chenx.command.pojo.request.CommandRequest;
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
@Api(value = "/command", tags = {""})
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
    @ApiImplicitParam(name = "request", value = "筛选条件")
    @ApiOperation(value = "获取列表", notes = "", tags = {}, httpMethod = "GET")
    @GetMapping
    public ResponseInfo<List<CommandDTO>> getList(CommandRequest request) {
        //  根据Request获取命令列表
        List<CommandDTO> dtoList = commandFacade.getList(request);
        return ResponseInfo.success(dtoList);
    }

    /**
     * 添加
     *
     * @param addDTO 添加DTO
     * @return {@link ResponseInfo}
     */
    @ApiImplicitParam(name = "addDTO", value = "添加DTO")
    @ApiOperation(value = "添加", notes = "", tags = {}, httpMethod = "POST")
    @PostMapping
    public ResponseInfo add(@RequestBody CommandDTO addDTO) {
        Boolean ok = commandFacade.add(addDTO);
        return ok ? ResponseInfo.success() : ResponseInfo.fail();
    }

    /**
     * 编辑
     *
     * @param editDTO 编辑DTO
     * @return {@link ResponseInfo}
     */
    @ApiImplicitParam(name = "editDTO", value = "编辑DTO")
    @ApiOperation(value = "编辑", notes = "", tags = {}, httpMethod = "PUT")
    @PutMapping
    public ResponseInfo edit(@RequestBody CommandDTO editDTO) {
        Boolean ok = commandFacade.edit(editDTO);
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
