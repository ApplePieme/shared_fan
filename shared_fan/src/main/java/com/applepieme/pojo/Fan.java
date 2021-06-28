package com.applepieme.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 风扇
 *
 * @author applepieme
 * @date 2021/6/16 12:46
 */
public class Fan implements Serializable {
    /**
     * 风扇 id
     * 对应 fan 表中的 fan_id
     */
    private String fanId;
    /**
     * 风扇位置
     * 对应 fan 表中的 location
     */
    private String location;
    /**
     * 风扇价格/每小时
     * 对应 fan 表中的 price
     */
    private Double price;
    /**
     * 创建时间
     * 对应 fan 表中的 create_time
     */
    private Date createTime;
    /**
     * 更新时间
     * 对应 fan 表中的 update_time
     */
    private Date updateTime;

    public Fan() {
    }

    public Fan(String fanId, String location, Double price, Date createTime, Date updateTime) {
        this.fanId = fanId;
        this.location = location;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getFanId() {
        return fanId;
    }

    public void setFanId(String fanId) {
        this.fanId = fanId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Fan{" +
                "fanId='" + fanId + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
