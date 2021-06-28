package com.applepieme.service.impl;

import com.applepieme.mapper.UserMapper;
import com.applepieme.pojo.User;
import com.applepieme.service.UserService;
import com.applepieme.util.IdUtil;
import com.applepieme.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户 service 实现类
 *
 * @author applepieme
 * @date 2021/6/16 13:42
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Integer userRegistered(User user) {
        user.setUserId(IdUtil.getId());
        user.setPassword(Md5Util.md5(user.getPassword()));
        return userMapper.userRegistered(user);
    }

    @Override
    public User userLogin(String username, String password) {
        return userMapper.userLogin(username, Md5Util.md5(password));
    }

    @Override
    public Integer addAssets(String userId, Double value) {
        return userMapper.addAssets(userId, value);
    }

    @Override
    public User findUser(String userId) {
        return userMapper.findUser(userId);
    }

    @Override
    public Integer updateAssets(String userId, Double value) {
        User user = findUser(userId);
        if (user.getAssets() < value) {
            return 0;
        }
        return userMapper.updateAssets(userId, value);
    }
}
