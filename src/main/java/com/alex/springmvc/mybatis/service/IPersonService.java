package com.alex.springmvc.mybatis.service;

import com.alex.springmvc.mybatis.entity.Person;
  
public interface IPersonService {  
    public Person getPersonById(int userId);  
}  