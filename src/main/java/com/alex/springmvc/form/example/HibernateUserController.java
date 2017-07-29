package com.alex.springmvc.form.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HibernateUserController {
	@Autowired
	private HibernateUser hibernateUser;
	
	@RequestMapping(value="/addHibernateUser",method=RequestMethod.GET)
	public ModelAndView user(){
		return new ModelAndView("form/addHibernateUser","command",hibernateUser);
	}
	
	@ModelAttribute("hibernateUser")
	public HibernateUser createHibernateUserModel(){
		return hibernateUser;
	}
	
	@RequestMapping(value="/addHibernateUser",method=RequestMethod.POST)
	public String addHibernateUser(@ModelAttribute("hibernateUser")@Validated HibernateUser hibernateUser,BindingResult bindingResult,Model model){
		if (bindingResult.hasErrors()) {
			return "form/addHibernateUser";
		}
		model.addAttribute("name", hibernateUser.getName());
		model.addAttribute("age", hibernateUser.getAge());
		model.addAttribute("id", hibernateUser.getId());
		
		return "form/addHibernateUserResult";
	}
}
