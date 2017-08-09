package com.alex.springmvc.mybatis.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alex.springmvc.mybatis.entity.Person;
import com.alex.springmvc.mybatis.entity.User;
import com.alex.springmvc.mybatis.service.IPersonService;
import com.alex.springmvc.mybatis.service.IUserService;
import com.alibaba.fastjson.JSON;

/**
 * SpringMVC的Controller，通过项目路径http://localhost:8080/SpringMVC/mybatis/showPerson?id=*来进行访问
 * 通过id不同来获取Person
 * 最后跳转到/WEB-INF/views/mybatis/showMyBatisPerson.jsp进行展示
 * 
 * @author xiaoming
 *
 */
@Controller
@RequestMapping("/mybatis")
public class PersonController {
	@Resource
	private IPersonService personService;
	
	@Resource
	private IUserService userMybatisService;

	@RequestMapping("/showPerson")
	public String toIndex(HttpServletRequest request, Model model) {
		int personId = Integer.parseInt(request.getParameter("id"));
		User user =  userMybatisService.getUserById(personId);
		Person person = personService.getPersonById(personId);
		model.addAttribute("person", person);
		model.addAttribute("user", user);
		model.addAttribute("massage", JSON.toJSONString(person));
		model.addAttribute("massage1", JSON.toJSONString(user));
		return "mybatis/showMyBatisPerson";
	}
}