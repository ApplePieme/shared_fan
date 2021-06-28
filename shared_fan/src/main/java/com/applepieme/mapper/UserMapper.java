package com.applepieme.mapper;

import com.applepieme.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户 mapper 接口
 *
 * @author applepieme
 * @date 2021/6/16 13:35
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 用户注册
     *
     * @param user 用户
     * @return Integer
     */
    Integer userRegistered(User user);

    /**
     * 用户登录
     * 如果用户名和密码正确，返回该用户信息
     * 如果不正确，返回一个空的用户
     *
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    User userLogin(@Param("username") String username,@Param("password") String password);

    /**
     * 账户充值
     *
     * @param userId 用户 id
     * @param value 充值数值
     * @return Integer
     */
    Integer addAssets(@Param("userId") String userId, @Param("value") Double value);

    /**
     * 根据 id 查询用户
     *
     * @param userId 用户 id
     * @return User
     */
    User findUser(@Param("userId") String userId);

    /**
     * 更新账户余额
     *
     * @param userId 用户 id
     * @param value 订单用掉的余额
     * @return Integer
     */
    Integer updateAssets(@Param("userId") String userId,@Param("value") Double value);
}
