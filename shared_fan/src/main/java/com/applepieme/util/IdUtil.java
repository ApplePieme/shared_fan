package com.applepieme.util;

import java.util.UUID;

/**
 * id 工具类
 *
 * @author applepieme
 * @date 2021/6/16 11:52
 */
public class IdUtil {
    private IdUtil() {}

    /**
     * 生成 id
     * 返回根据时间戳生成的唯一 id
     *
     * @return String
     */
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
