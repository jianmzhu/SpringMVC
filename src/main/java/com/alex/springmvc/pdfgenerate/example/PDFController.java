package com.alex.springmvc.pdfgenerate.example;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * xml配置参照<beans:bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
 * 
 * 访问http://localhost:8080/SpringMVC/PDFGenerator/PDF即可跳转到该controller中进行处理
 * 
 * @author xiaoming
 *
 */
@Controller(value="pdfController")
public class PDFController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// user data
		Map<String, String> userData = new HashMap<String, String>();
		userData.put("100", "Xiao.Lu");
		userData.put("102", "User 102");
		userData.put("301", "User 301");
		userData.put("400", "User 400");
		//将数据传输到试图的类userPDFView中加载userData
		return new ModelAndView("userPDFView", "userData", userData);
	}

}
