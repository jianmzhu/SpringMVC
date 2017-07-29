package com.alex.springmvc.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PathVariableExampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(PathVariableExampleController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//项目下的路径访问，都会跳转到该controller统一处理，返回pathvariable关键字，并且model中带有pathvariablevalue属性值（详细可以参照图片/SpringMVC/specification/mvc-run introduction.png）
	/**
	 * http://localhost:8080/SpringMVC/pathvariable/site/ch_zh/document/10/test
	 * 
	 *  /SpringMVC——context path
	 *  /pathvariable/site/ch_zh/document/10/test——URI
	 *  /pathvariable/{sitePrefix}/{language}/document/{id}/{naturalText}——URI template
	 *  {sitePrefix}、{language}、{id}、{naturalText}——URI template variable（path variable）
	 * 
	 * @param model
	 * @param sitePrefix
	 * @param language
	 * @param id
	 * @param naturalText
	 * @return
	 */
	@RequestMapping("/pathvariable/{sitePrefix}/{language}/document/{id}/{naturalText}")
	public String home(Model model,
			@PathVariable(value = "sitePrefix")String sitePrefix,
			@PathVariable(value = "language")String language,
			@PathVariable(value = "id")Long id,
			@PathVariable(value = "naturalText")String naturalText
			) {
		
		model.addAttribute("sitePrefix", sitePrefix);
        model.addAttribute("language", language);
        model.addAttribute("id", id);
        model.addAttribute("naturalText", naturalText);
        
		logger.info("sitePrefix vlaue:"+sitePrefix+" language vlaue:"+language+" id vlaue:"+id+" naturalText vlaue:"+naturalText);
		if(id==81){
			model.addAttribute("pathvariablevalue", id);
		}else{
			model.addAttribute("pathvariablevalue", 0);
		}
		
		return "pathvariable";
	}
	
}
