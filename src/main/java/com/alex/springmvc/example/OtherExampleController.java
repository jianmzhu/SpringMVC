package com.alex.springmvc.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OtherExampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(OtherExampleController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//项目下的路径访问，都会跳转到该controller统一处理，返回testRequestToResponse关键字，并且model中带有testCode属性值（详细可以参照图片/SpringMVC/specification/mvc-run introduction.png）
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/testRequestToResponse")
	//该处理类中会带有HttpServletRequest和HttpServletResopnse和Model
	public String requsetResponseExample(HttpServletRequest request,HttpServletResponse response,Model model) {
		logger.info("use testRequestToResponse! The response model is {}.", model);
		model.addAttribute("testCode", "testRequestToResponse" );
		return "testRequestToResponse";
	}
	
}
