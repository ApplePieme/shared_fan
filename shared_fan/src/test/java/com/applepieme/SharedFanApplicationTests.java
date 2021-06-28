package com.applepieme;

import com.applepieme.mapper.UserMapper;
import com.applepieme.pojo.Fan;
import com.applepieme.pojo.Order;
import com.applepieme.pojo.User;
import com.applepieme.service.FanService;
import com.applepieme.service.OrderService;
import com.applepieme.service.UserService;
import com.applepieme.util.IdUtil;
import com.applepieme.util.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class SharedFanApplicationTests {
	@Autowired
	UserService userService;
	@Autowired
	FanService fanService;
	@Autowired
	OrderService orderService;
	@Autowired
	UserMapper userMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void myTest() {
		User user = new User();
		user.setUserId("123678");
		user.setAssets(12.00);
		user.setUsername("hh");
		user.setPassword("dhd");
		user.setPhone("12345");
		System.out.println(userService.userRegistered(user));
	}

	@Test
	void addFan() {
		Fan fan = new Fan();
		fan.setFanId(IdUtil.getId());
		fan.setLocation("广东省珠海市金湾区吉林大学珠海学院音乐厅");
		fan.setPrice(0.35);
		System.out.println(fanService.addFan(fan));
	}

	@Test
	void addOrder() {
		Order order = new Order();
		order.setOrderId(IdUtil.getId());
		order.setFanId("40ca032613d148f9b0d09f1e56bb787a");
		order.setUserId("2a1136c7e8134bf8a45641cafb508403");
		order.setLocation("广东省珠海市金湾区吉林大学珠海学院第3教学楼");
		order.setBeginTime(new Timestamp(System.currentTimeMillis()));
		order.setEndTime(new Timestamp(System.currentTimeMillis()));
		order.setSum(95.23);
		System.out.println(orderService.addOrder(order));
	}

	@Test
	void addUser() {
		User user = new User();
		user.setUserId(IdUtil.getId());
		user.setUsername("admin");
		user.setPassword("123");
		user.setPhone("12345678910");
		user.setAssets(998.23);
		userService.userRegistered(user);
	}

	@Test
	void addAssets(){
		System.out.println(userMapper.addAssets("815e07a0df854361b03648af8a9cf3be", 12.0));
	}

}
