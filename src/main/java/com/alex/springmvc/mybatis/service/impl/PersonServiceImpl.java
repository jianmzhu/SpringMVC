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
	public Person getPersonById(int personId) {
		// TODO Auto-generated method stub
		return this.personDao.selectByPrimaryKey(personId);
	}
	@Override
	public Person getPersonJoinPost(int personId) {
		// TODO Auto-generated method stub
		return this.personDao.getPersonJoinPost(personId);
	}
	@Override
	public Person getPersonByIf(int id, String name, String website) {
		// TODO Auto-generated method stub
		return this.personDao.getPersonByIf(id, name, website);
	}
	@Override
	public Person getPersonByWhereWrong(int id, String name, String website) {
		// TODO Auto-generated method stub
		return this.personDao.getPersonByWhereWrong(id, name, website);
	}
	@Override
	public Person getPersonByWhere(int id, String name, String website) {
		// TODO Auto-generated method stub
		return this.personDao.getPersonByWhere(id, name, website);
	}  
	
	@Override
	public int updateByPrimaryKeySelective(Person record) {
		// TODO Auto-generated method stub
		return this.personDao.updateByPrimaryKeySelective(record);
	}
  
	@Override
	public Person getPersonByChoose(int id, String name, String website) {
		// TODO Auto-generated method stub
		return this.personDao.getPersonByChoose(id, name, website);
	}
}  