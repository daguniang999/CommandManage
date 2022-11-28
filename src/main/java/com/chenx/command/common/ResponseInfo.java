package com.chenx.command.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ResponseInfo
 * @Description 接口返回结构
 * @Author daguniang
 * @Date 2022/11/27 11:15
 **/
@ApiModel(description = "返回结构")
@Data
public class ResponseInfo<T> implements Serializable {

    /**
     * 编码
     */
    @ApiModelProperty(value = "编码", required = true)
    private Integer code;

    /**
     * 消息
     */
    @ApiModelProperty(value = "消息", required = true)
    private String msg;

    /**
     * 数据
     */
    @ApiModelProperty(value = "数据", required = true)
    private T data;

    private ResponseInfo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResponseInfo(ResponseStatus status, T data) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
    }

    public static <T> ResponseInfo success(T data) {
        return new ResponseInfo(ResponseStatus.SUCCESS, data);
    }

    public static <T> ResponseInfo fail(T data) {
        return new ResponseInfo(ResponseStatus.FAIL, data);
    }

    public static ResponseInfo success() {
        return new ResponseInfo(ResponseStatus.SUCCESS, null);
    }

    public static ResponseInfo fail() {
        return new ResponseInfo(ResponseStatus.FAIL, null);
    }
}
