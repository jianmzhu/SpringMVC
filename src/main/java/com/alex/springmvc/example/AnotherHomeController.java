package com.alex.springmvc.example;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
//这样子分开写就是代表http://localhost:8080/SpringMVC/AnotherHello的访问都会进入到这个控制器，Get方法进入到home中
@RequestMapping("/AnotherHello")
public class AnotherHomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnotherHomeController.class);
	
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
	@RequestMapping(method=RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome another home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		if(!model.containsAttribute("serverTime")){
			model.addAttribute("serverTime", formattedDate );
		}
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String home1(Locale locale, Model model) {
		return home(locale,model);
	}
	
}
