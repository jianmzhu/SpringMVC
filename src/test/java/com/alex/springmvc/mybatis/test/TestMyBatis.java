package com.alex.springmvc.mybatis.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alex.springmvc.angularjs.example.UserService;
import com.alex.springmvc.mybatis.entity.Person;
import com.alex.springmvc.mybatis.service.IPersonService;
import com.alex.springmvc.mybatis.service.IUserService;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:mybatis-context.xml" })
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	// private ApplicationContext ac = null;
	@Resource
	private IPersonService personService = null;
	
	@Resource
	private IUserService userService = null;

	// @Before
	// public void before() {
	// ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// userService = (IUserService) ac.getBean("userService");
	// }

	@Test
	public void test1() {
//		Person person = personService.getPersonById(1);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
//		logger.info(JSON.toJSONString(person));
		logger.info(JSON.toJSONString(userService.getUserById(1)));
	}
}