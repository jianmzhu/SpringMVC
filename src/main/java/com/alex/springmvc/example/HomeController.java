package com.alex.springmvc.example;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//项目下的路径访问，都会跳转到该controller统一处理，返回home关键字，并且model中带有serverTime属性值（详细可以参照图片/SpringMVC/specification/mvc-run introduction.png）
	/**
	 * 
	 * 带有locale和model
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping("/hello")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		if(!model.containsAttribute("serverTime")){
			model.addAttribute("serverTime", formattedDate );
		}
		return "home";
	}
	
}
