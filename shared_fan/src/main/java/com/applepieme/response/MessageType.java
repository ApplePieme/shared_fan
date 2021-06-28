package com.applepieme.response;

/**
 * 封装消息类型
 *
 * @author applepieme
 * @date 2021/6/16 12:21
 */
public enum MessageType {
    SUCCESS(1000, "SUCCESS"),
    FAILED(2000, "FAILURE");

    private Integer code;
    private String message;

    MessageType() {}

    MessageType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
