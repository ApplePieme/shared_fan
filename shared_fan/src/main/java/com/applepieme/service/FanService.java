package com.applepieme.service;

import com.applepieme.pojo.Fan;

/**
 * 风扇 service 接口
 *
 * @author applepieme
 * @date 2021/6/16 15:01
 */
public interface FanService {
    /**
     * 根据 id 查找风扇
     *
     * @param fanId 风扇 id
     * @return Fan
     */
    Fan findFanById(String fanId);

    /**
     * 添加风扇
     *
     * @param fan 风扇
     * @return Integer
     */
    Integer addFan(Fan fan);
}
