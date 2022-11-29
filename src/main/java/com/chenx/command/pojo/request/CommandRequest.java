package com.chenx.command.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CommandRequest
 * @Description 命令查询条件
 * @Author daguniang
 * @Date 2022/11/27 09:14
 **/
@ApiModel(description = "命令筛选")
@Data
public class CommandRequest {

    /**
     * 分组ID
     */
    @ApiModelProperty(value = "分组ID", name = "", required = false)
    private Long groupId;

}
