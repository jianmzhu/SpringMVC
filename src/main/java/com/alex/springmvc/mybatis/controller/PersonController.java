package com.alex.springmvc.mybatis.controller;
import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
  



import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  

import com.alex.springmvc.mybatis.entity.Person;
import com.alex.springmvc.mybatis.service.IPersonService;
import com.alibaba.fastjson.JSON;
  
@Controller  
@RequestMapping("/mybatis")  
public class PersonController {  
    @Resource  
    private IPersonService personService;  
      
    @RequestMapping("/showPerson")  
    public String toIndex(HttpServletRequest request,Model model){  
        int personId = Integer.parseInt(request.getParameter("id"));  
      	Person person = personService.getPersonById(personId);
        model.addAttribute("person", person);
        model.addAttribute("massage", JSON.toJSONString(person));
        return "mybatis/showMyBatisPerson";  
    }  
}  