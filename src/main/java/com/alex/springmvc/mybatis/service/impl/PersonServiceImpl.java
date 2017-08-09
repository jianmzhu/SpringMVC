package com.alex.springmvc.mybatis.service.impl;
import javax.annotation.Resource;  
  



import org.springframework.stereotype.Service;  

import com.alex.springmvc.mybatis.dao.IPersonDao;
import com.alex.springmvc.mybatis.entity.Person;
import com.alex.springmvc.mybatis.service.IPersonService;
  
  
/**
 * 服务实现类，最后执行的地方 通过/src/main/resources/mybatis-context.xml的
 * <context:component-scan base-package="com.alex.springmvc.mybatis" />  
 * 进行类加载
 * 
 * @author xiaoming
 *
 */
//该类调用名字为personService
@Service("personService")  
public class PersonServiceImpl implements IPersonService {  
    //装载同名的personDao对象，该对象由xml中扫描得出
	@Resource  
    private IPersonDao personDao;  
	@Override
	public Person getPersonById(int userId) {
		// TODO Auto-generated method stub
		return this.personDao.selectByPrimaryKey(1);
	}  
  
}  