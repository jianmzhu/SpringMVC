package com.alex.springmvc.mybatis.service.impl;
import javax.annotation.Resource;  
  



import org.springframework.stereotype.Service;  

import com.alex.springmvc.mybatis.dao.IPersonDao;
import com.alex.springmvc.mybatis.entity.Person;
import com.alex.springmvc.mybatis.service.IPersonService;
  
  
@Service("personService")  
public class PersonServiceImpl implements IPersonService {  
    @Resource  
    private IPersonDao personDao;  
	@Override
	public Person getPersonById(int userId) {
		// TODO Auto-generated method stub
		return this.personDao.selectByPrimaryKey(1);
	}  
  
}  