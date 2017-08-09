package com.alex.springmvc.mybatis.service;

import com.alex.springmvc.mybatis.entity.User;

public interface IUserService {
	public User getUserById(int userId);
}
