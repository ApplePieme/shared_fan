package com.applepieme.response;

/**
 * 响应工具类
 *
 * @author applepieme
 * @date 2021/6/16 12:34
 */
public class ResponseUtil {
    private ResponseUtil() {}

    /**
     * 请求成功并返回数据
     *
     * @param obj 数据对象
     * @return AjaxResult
     */
    public static AjaxResult<Object> success(Object obj) {
        return new AjaxResult<>(obj);
    }

    /**
     * 请求成功但不返回数据
     *
     * @return AjaxResult
     */
    public static AjaxResult<Object> success() {
        return new AjaxResult<>(MessageType.SUCCESS.getCode(), MessageType.SUCCESS.getMessage());
    }

    /**
     * 请求失败
     *
     * @return AjaxResult
     */
    public static AjaxResult<Object> failed() {
        return new AjaxResult<>(MessageType.FAILED.getCode(), MessageType.FAILED.getMessage());
    }
}
