package com.alex.springmvc.mybatis.service;

import org.apache.ibatis.annotations.Param;

import com.alex.springmvc.mybatis.entity.Person;
  
/**
 * 服务接口，提供外面调用的接口声明
 * 
 * @author xiaoming
 *
 */
public interface IPersonService {  
    public Person getPersonById(int personId);
    public Person getPersonJoinPost(int personId);  
    
    public Person getPersonByIf(int id,String name,String website);
    public Person getPersonByWhereWrong(int id,String name,String website);
    public Person getPersonByWhere(int id,String name,String website);

    /**
     * 更新方法（带有set、if的更新方法）
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Person record);
}  