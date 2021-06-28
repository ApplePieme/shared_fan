package com.applepieme.service;

import com.applepieme.pojo.User;

import java.util.Map;

/**
 * 用户 service 接口
 *
 * @author applepieme
 * @date 2021/6/16 12:59
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param user 用户
     * @return Integer
     */
    Integer userRegistered(User user);

    /**
     * 用户登录
     * 如果用户名和密码正确，返回该用户信息和 token
     * 如果不正确，返回一个空的用户
     *
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    Map<String, Object> userLogin(String username, String password);

    /**
     * 账户充值
     *
     * @param userId 用户 id
     * @param value 充值数值
     * @return Integer
     */
    Integer addAssets(String userId, Double value);

    /**
     * 根据 id 查询用户
     *
     * @param userId 用户 id
     * @return User
     */
    User findUser(String userId);

    /**
     * 更新账户余额
     *
     * @param userId 用户 id
     * @param value 订单用掉的余额
     * @return Integer
     */
    Integer updateAssets(String userId, Double value);
}
