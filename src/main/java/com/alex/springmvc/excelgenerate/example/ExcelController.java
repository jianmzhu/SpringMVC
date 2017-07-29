package com.alex.springmvc.excelgenerate.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.alex.springmvc.contentnegotiatingviewresolver.example.Pizza;

/**
 * xml配置参照<beans:bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
 * 
 * 访问http://localhost:8080/SpringMVC/PDFGenerator/PDF即可跳转到该controller中进行处理
 * 
 * @author xiaoming
 *
 */
@Controller(value="excelController")
public class ExcelController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// user data
		Pizza pizza = new  Pizza("pizza1");
		//将数据传输到试图的类userPDFView中加载userData
		return new ModelAndView("userExcelView", "pizza", pizza);
	}

}
