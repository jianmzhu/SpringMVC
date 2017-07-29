package com.alex.springmvc.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RedirectExampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(RedirectExampleController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//项目下的路径访问，都会跳转到该controller统一处理，返回redirect:/hello关键字，并且model中带有serverTime属性值（详细可以参照图片/SpringMVC/specification/mvc-run introduction.png）
	/**
	 * 最后跳转到HomeController里面
	 * 
	 * 只带上model
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/redirect",method = RequestMethod.GET)
	public String requsetResponseExample(Model model) {
		logger.info("use redirect! The response redirect to /hello");
		model.addAttribute("serverTime", "this is redirect request" );//会在重定向中用get的方式返回这个字符串
		return "redirect:/hello";
	}
	
}
