package com.alex.springmvc.redirect.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {
	
	/**
	 * 访问http://localhost:8080/SpringMVC/redirectTest/index 进入该控制器，跳转到/views/redirect/index.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value="/redirectTest/index",method=RequestMethod.GET)
	public String index(){
		return "redirect/index";
	}
	
	/**
	 * 点击页面的按钮访问http://localhost:8080/SpringMVC/redirectTest/redirect 进入该控制器，
	 * 跳转到http://localhost:8080/SpringMVC/redirectTest/finalPage
	 * 
	 * @return
	 */
	@RequestMapping(value="/redirectTest/redirect",method=RequestMethod.GET)
	public String redirect(){
		return "redirect:finalPage";
	}
	
	/**
	 * 上面的redirect方法进入到该方法，跳转到/views/redirect/final.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value="/redirectTest/finalPage",method=RequestMethod.GET)
	public String finalPage(){
		return "redirect/final";
	}
	
}
