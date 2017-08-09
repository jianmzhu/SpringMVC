package com.alex.springmvc.mybatis.service;

import com.alex.springmvc.mybatis.entity.Person;
  
/**
 * 服务接口，提供外面调用的接口声明
 * 
 * @author xiaoming
 *
 */
public interface IPersonService {  
    public Person getPersonById(int userId);  
}  