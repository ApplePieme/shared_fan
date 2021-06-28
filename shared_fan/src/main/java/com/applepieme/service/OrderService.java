package com.applepieme.service;

import com.applepieme.pojo.Order;

import java.util.List;

/**
 * 订单 service 接口
 *
 * @author applepieme
 * @date 2021/6/16 15:41
 */
public interface OrderService {
    /**
     * 添加订单
     *
     * @param order 订单
     * @return Integer
     */
    Integer addOrder(Order order);

    /**
     * 根据用户 id 查找订单列表
     *
     * @param userId 用户 id
     * @return List
     */
    List<Order> findOrderByUserId(String userId);
}
