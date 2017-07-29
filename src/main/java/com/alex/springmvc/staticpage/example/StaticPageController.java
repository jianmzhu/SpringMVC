package com.alex.springmvc.staticpage.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticPageController {
	/**
	 * 首页指引，http://localhost:8080/SpringMVC/staticpages/index转移到staticpage/index.jsp中
	 * 
	 * @return
	 */
	@RequestMapping(value = "/staticpages/index",method = RequestMethod.GET)
	public String indexPage(){
		return "staticpage/index";
	}
	
	/**
	 * redirect指向到静态页面，/html/为resources配置的html路径
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/staticpages/staticpage",method = RequestMethod.GET)
	public String redirectStaticPage(Model model){
		return "redirect:/html/staticPage.html";
	}
}
