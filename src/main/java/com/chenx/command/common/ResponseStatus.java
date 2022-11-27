package com.chenx.command.common;

/**
 * @ClassName ResponseCode
 * @Description 接口返回状态
 * @Author daguniang
 * @Date 2022/11/27 11:17
 **/
public enum ResponseStatus {

    SUCCESS(0, "成功"),
    FAIL(1, "失败");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResponseStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseStatus getEnumByCode(Integer code) {
        for (ResponseStatus item : ResponseStatus.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
}
