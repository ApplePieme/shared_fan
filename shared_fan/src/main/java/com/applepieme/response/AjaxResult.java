package com.applepieme.response;

import java.io.Serializable;

/**
 * 返回结果工具类
 *
 * @author applepieme
 * @date 2021/6/16 12:16
 */
public class AjaxResult<T> implements Serializable {
    /**
     * 返回数据
     */
    private T data;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;

    public AjaxResult() {}

    public AjaxResult(T data) {
        this.code = MessageType.SUCCESS.getCode();
        this.message = MessageType.SUCCESS.getMessage();
        this.data = data;
    }

    public AjaxResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "AjaxResult{" +
                "data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
