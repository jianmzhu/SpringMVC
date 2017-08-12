package com.alex.springmvc.mybatis.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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
	
	private static Logger _log = Logger.getLogger(PersonController.class);

	/**
	 * 通过项目路径http://localhost:8080/SpringMVC/mybatis/showPerson?id=1来进行访问
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
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
	
	/**
	 * 通过项目路径http://localhost:8080/SpringMVC/mybatis/showPersonJoinPost?id=1来进行访问
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showPersonJoinPost")
	public String showPersonJoinPost(HttpServletRequest request, Model model) {
		int personId = Integer.parseInt(request.getParameter("id"));
		Person person = personService.getPersonJoinPost(personId);
		model.addAttribute("person", person);
		model.addAttribute("massage", JSON.toJSONString(person));
		return "mybatis/showMyBatisPersonExample";
	}
	
	/**
	 * 通过项目路径http://localhost:8080/SpringMVC/mybatis/showPersonByIf?id=1&name=yiibai&website=来进行访问
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showPersonByIf")
	public String showPersonByIf(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String website = request.getParameter("website");
		Person person = personService.getPersonByIf(id, name, website);
		model.addAttribute("person", person);
		model.addAttribute("massage", JSON.toJSONString(person));
		return "mybatis/showMyBatisPersonExample";
	}
	
	/**
	 * 通过项目路径http://localhost:8080/SpringMVC/mybatis/showPersonByWhere?id=1&name=yiibai&website=来进行访问
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showPersonByWhere")
	public String showPersonByWhere(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String website = request.getParameter("website");
		Person person = personService.getPersonByWhere(id, name, website);
		model.addAttribute("person", person);
		model.addAttribute("massage", JSON.toJSONString(person));
		return "mybatis/showMyBatisPersonExample";
	}
	
	/**
	 * 通过项目路径http://localhost:8080/SpringMVC/mybatis/showPersonByWhereWrong?id=1&name=yiibai&website=来进行访问
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showPersonByWhereWrong")
	public String showPersonByWhereWrong(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String website = request.getParameter("website");
		Person person = personService.getPersonByWhereWrong(id, name, website);
		model.addAttribute("person", person);
		model.addAttribute("massage", JSON.toJSONString(person));
		return "mybatis/showMyBatisPersonExample";
	}
	
	/**
	 * 通过项目路径http://localhost:8080/SpringMVC/mybatis/updatePersonBySetIf?id=1&name=yiibai1&website=11来进行访问
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatePersonBySetIf")
	public String updatePersonBySetIf(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String website = request.getParameter("website");
		Person person = personService.getPersonById(id);//加载数据库Person对象
//		person.setId(id);
		person.setName(name);
		person.setWebsite(website);
		_log.info("更新Person对象的值为："+JSON.toJSONString(person));
//		model.addAttribute("person", person);
		model.addAttribute("massage", "已更新"+personService.updateByPrimaryKeySelective(person)+"条");
		person = personService.getPersonById(person.getId());//重新加载数据库Person对象
		_log.info("更新后Person对象的值为："+JSON.toJSONString(person));
		model.addAttribute("person", person);
		return "mybatis/showMyBatisPersonExample";
	}
	
	/**
	 * 通过项目路径http://localhost:8080/SpringMVC/mybatis/showPersonByChoose?id=1&name=yiibai&website=来进行访问
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showPersonByChoose")
	public String showPersonByChoose(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String website = request.getParameter("website");
		Person person = personService.getPersonByChoose(id, name, website);
		model.addAttribute("person", person);
		model.addAttribute("massage", JSON.toJSONString(person));
		return "mybatis/showMyBatisPersonExample";
	}
}