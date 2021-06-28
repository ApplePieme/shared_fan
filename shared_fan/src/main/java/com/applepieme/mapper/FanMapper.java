package com.applepieme.mapper;

import com.applepieme.pojo.Fan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 风扇 mapper 接口
 *
 * @author applepieme
 * @date 2021/6/16 14:50
 */
@Mapper
@Repository
public interface FanMapper {
    /**
     * 根据 id 查找风扇
     *
     * @param fanId 风扇 id
     * @return Fan
     */
    Fan findFanById(@Param("fanId") String fanId);

    /**
     * 添加风扇
     *
     * @param fan 风扇
     * @return Integer
     */
    Integer addFan(Fan fan);
}
