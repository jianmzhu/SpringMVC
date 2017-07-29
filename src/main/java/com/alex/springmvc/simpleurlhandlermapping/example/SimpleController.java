package com.alex.springmvc.simpleurlhandlermapping.example;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Handles requests.
 */
public class SimpleController extends AbstractController{
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(SimpleController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("home");
		Date date = new Date();
		modelAndView.addObject("serverTime", date);
		return modelAndView;
	}
	
	
}
