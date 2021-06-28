package com.applepieme.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 *
 * @author applepieme
 * @date 2021/6/16 12:50
 */
public class Order implements Serializable {
    /**
     * 订单 id
     * 对应 order 表中的 order_id
     */
    private String orderId;
    /**
     * 风扇 id
     * 对应 order 表中的 fan_id
     */
    private String fanId;
    /**
     * 用户 id
     * 对应 order 表中的 user_id
     */
    private String userId;
    /**
     * 订单开始时间
     * 对应 order 表中的 begin_time
     */
    private Date beginTime;
    /**
     * 订单结束时间
     * 对应 order 表中的 end_time
     */
    private Date endTime;
    /**
     * 订单总额
     * 对应 order 表中的 sum
     */
    private Double sum;
    /**
     * 订单创建时间
     * 对应 order 表中的 create_time
     */
    private Date createTime;
    /**
     * 位置
     * 订单的位置
     */
    private String location;

    public Order() {
    }

    public Order(String orderId, String fanId, String userId, Date beginTime, Date endTime, Double sum,
                 Date createTime, String location) {
        this.orderId = orderId;
        this.fanId = fanId;
        this.userId = userId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sum = sum;
        this.createTime = createTime;
        this.location = location;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFanId() {
        return fanId;
    }

    public void setFanId(String fanId) {
        this.fanId = fanId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", fanId='" + fanId + '\'' +
                ", userId='" + userId + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", sum=" + sum +
                ", createTime=" + createTime +
                ", location='" + location + '\'' +
                '}';
    }
}
