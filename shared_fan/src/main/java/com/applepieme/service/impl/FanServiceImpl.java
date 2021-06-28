package com.applepieme.service.impl;

import com.applepieme.mapper.FanMapper;
import com.applepieme.pojo.Fan;
import com.applepieme.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 风扇 service 实现类
 *
 * @author applepieme
 * @date 2021/6/16 15:04
 */
@Service
public class FanServiceImpl implements FanService {
    private FanMapper fanMapper;

    @Autowired
    public void setFanMapper(FanMapper fanMapper) {
        this.fanMapper = fanMapper;
    }

    @Override
    public Fan findFanById(String fanId) {
        return fanMapper.findFanById(fanId);
    }

    @Override
    public Integer addFan(Fan fan) {
        return fanMapper.addFan(fan);
    }
}
