package com.applepieme.controller;

import com.applepieme.pojo.Fan;
import com.applepieme.response.AjaxResult;
import com.applepieme.response.ResponseUtil;
import com.applepieme.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 风扇 controller
 *
 * @author applepieme
 * @date 2021/6/16 15:10
 */
@RestController
@RequestMapping("/fan")
public class FanController {
    private FanService fanService;

    @Autowired
    public void setFanService(FanService fanService) {
        this.fanService = fanService;
    }

    @RequestMapping("/info")
    public AjaxResult<Object> findFanById(String fanId) {
        Fan fan = fanService.findFanById(fanId);
        if (fan != null) {
            return ResponseUtil.success(fan);
        }
        return ResponseUtil.failed();
    }
}
