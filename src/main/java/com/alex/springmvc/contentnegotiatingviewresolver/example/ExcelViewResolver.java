package com.alex.springmvc.contentnegotiatingviewresolver.example;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
@Deprecated
public class ExcelViewResolver implements ViewResolver{

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		ExcelView view = new ExcelView();
		return view;
      }
	
}