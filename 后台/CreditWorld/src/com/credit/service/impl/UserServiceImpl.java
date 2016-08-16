package com.credit.service.impl;

import com.credit.dao.UserDao;
import com.credit.domain.User;
import com.credit.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	@Override
	public User findUserByLoginName(String loginName) {
		return userDao.selectUserByLoginName(loginName);
	}

	@Override
	public User fineUserByPhone(String phone) {
		return null;
	}

	@Override
	public void saveUser(User user) {
		userDao.insertUser(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
