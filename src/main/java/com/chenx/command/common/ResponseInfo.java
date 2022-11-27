package com.chenx.command.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ResponseInfo
 * @Description 接口返回结构
 * @Author daguniang
 * @Date 2022/11/27 11:15
 **/
@Data
public class ResponseInfo<T> implements Serializable {

    private Integer code;

    private String msg;

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
