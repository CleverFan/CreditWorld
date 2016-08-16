package com.credit.service;

import com.credit.domain.User;

public interface UserService {
	public User findUserByLoginName(String loginNmae);
	
	public User fineUserByPhone(String phone);
	
	public void saveUser(User user);
}
