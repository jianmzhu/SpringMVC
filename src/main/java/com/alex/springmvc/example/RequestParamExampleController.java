package com.alex.springmvc.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RequestParamExampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestParamExampleController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//项目下的路径访问，都会跳转到该controller统一处理，返回requestparam关键字
	/**
	 * 访问http://localhost:8080/SpringMVC/requestparam?name=admin会将admin带入到@RequestParam中处理出name值，相当于HttpRequestServlet.getParameter方法
	 * 
	 * @param model
	 * @param name(读取页面带入的name值，无值时，使用defaultValue)
	 * @return
	 */
	@RequestMapping(value = "/requestparam")
	public String requsetParamExample(Model model,@RequestParam(value="name",defaultValue="Guest")String name) {
		logger.info("name value: "+name);
		model.addAttribute("name", name);
		if("admin".equals(name)){
			model.addAttribute("email", "alex_ever@126.com");
		}else{
			model.addAttribute("email", "guest,no email");
		}
		return "requestparam";
	}
	
}
