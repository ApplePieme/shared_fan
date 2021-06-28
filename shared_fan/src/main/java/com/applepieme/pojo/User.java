package com.applepieme.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author applepieme
 * @date 2021/6/16 12:41
 */
public class User implements Serializable {
    /**
     * 用户 id
     * 对应 user 表中的 user_id
     */
    private String userId;
    /**
     * 用户名
     * 对应 user 表中的 username
     */
    private String username;
    /**
     * 登录密码
     * 对应 user 表中的 password
     */
    private String password;
    /**
     * 手机号码
     * 对应 user 表中的 phone
     */
    private String phone;
    /**
     * 账户余额
     * 对应 user 表中的 assets
     */
    private Double assets;
    /**
     * 注册时间
     * 对应 user 表中的 create_time
     */
    private Date createTime;
    /**
     * 更新时间
     * 对应 user 表中的 update_time
     */
    private Date updateTime;

    public User() {
    }

    public User(String userId, String username, String password, String phone, Double assets,
                Date createTime, Date updateTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.assets = assets;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getAssets() {
        return assets;
    }

    public void setAssets(Double assets) {
        this.assets = assets;
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
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", assets=" + assets +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
