package com.alex.springmvc.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ResponseBodyController {
	
	private static final Logger logger = LoggerFactory.getLogger(ResponseBodyController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//项目下的路径访问，都会跳转到该controller统一处理，返回responsebody关键字，方法自动返回对象给页面responsebody.jsp
	@RequestMapping(value = "/responsebody")
	@ResponseBody
	public String responsebodyMethod(Model model) {
		logger.info("handler /responsebody request,and  model.addAttribute return responsebodyMethod returnvalue");
		return "responsebody";
	}
	
}
