package com.applepieme.controller;

import com.applepieme.pojo.User;
import com.applepieme.response.AjaxResult;
import com.applepieme.response.ResponseUtil;
import com.applepieme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 controller
 *
 * @author applepieme
 * @date 2021/6/16 14:32
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/register")
    public AjaxResult<Object> userRegistered(User user) {
        if (userService.userRegistered(user) > 0) {
            return ResponseUtil.success();
        }
        return ResponseUtil.failed();
    }

    @RequestMapping("/login")
    public AjaxResult<Object> userLogin(String username, String password) {
        User user = userService.userLogin(username, password);
        if (user != null) {
            return ResponseUtil.success(user);
        }
        return ResponseUtil.failed();
    }

    @RequestMapping("/add-assets")
    public AjaxResult<Object> addAssets(String userId, Double value) {
        if (userService.addAssets(userId, value) > 0) {
            User user = userService.findUser(userId);
            return ResponseUtil.success(user);
        }
        return ResponseUtil.failed();
    }

    @RequestMapping("/info")
    public AjaxResult<Object> findUser(String userId) {
        User user = userService.findUser(userId);
        if (user != null) {
            return ResponseUtil.success(user);
        }
        return ResponseUtil.failed();
    }
}
