package com.applepieme.controller;

import com.applepieme.pojo.Order;
import com.applepieme.response.AjaxResult;
import com.applepieme.response.ResponseUtil;
import com.applepieme.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 订单 controller
 *
 * @author applepieme
 * @date 2021/6/16 15:44
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/add")
    public AjaxResult<Object> addOrder(String userId, String fanId, Double sum, String beginTime, String endTime) {
        Order order = new Order();
        order.setUserId(userId);
        order.setFanId(fanId);
        order.setSum(sum);
        order.setBeginTime(new Date(Long.parseLong(beginTime)));
        order.setEndTime(new Date(Long.parseLong(endTime)));
        if (orderService.addOrder(order) > 0) {
            return ResponseUtil.success();
        }
        return ResponseUtil.failed();
    }

    @RequestMapping("/list")
    public AjaxResult<Object> findOrderByUserId(String userId) {
        List<Order> orderList = orderService.findOrderByUserId(userId);
        if (!orderList.isEmpty()) {
            return ResponseUtil.success(orderList);
        }
        return ResponseUtil.failed();
    }
}
