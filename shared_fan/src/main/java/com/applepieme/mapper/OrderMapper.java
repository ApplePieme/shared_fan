package com.applepieme.mapper;

import com.applepieme.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单 mapper 接口
 *
 * @author applepieme
 * @date 2021/6/16 15:20
 */
@Mapper
@Repository
public interface OrderMapper {
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
