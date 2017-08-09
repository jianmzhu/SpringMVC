package com.alex.springmvc.mybatis.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alex.springmvc.mybatis.dao.UserMapper;
import com.alex.springmvc.mybatis.entity.User;
import com.alex.springmvc.mybatis.service.IUserService;

@Service("userMybatisService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}

}
