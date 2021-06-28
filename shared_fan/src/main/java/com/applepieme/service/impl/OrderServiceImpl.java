package com.applepieme.service.impl;

import com.applepieme.mapper.OrderMapper;
import com.applepieme.mapper.UserMapper;
import com.applepieme.pojo.Order;
import com.applepieme.service.OrderService;
import com.applepieme.service.UserService;
import com.applepieme.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单 service 实现类
 *
 * @author applepieme
 * @date 2021/6/16 15:42
 */
@Service
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;
    private UserService userService;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Integer addOrder(Order order) {
        order.setOrderId(IdUtil.getId());
        if (userService.updateAssets(order.getUserId(), order.getSum()) > 0) {
            return orderMapper.addOrder(order);
        }
        return 0;
    }

    @Override
    public List<Order> findOrderByUserId(String userId) {
        return orderMapper.findOrderByUserId(userId);
    }
}
