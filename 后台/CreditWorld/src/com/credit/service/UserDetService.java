package com.credit.service;

import com.credit.domain.UserDet;

public interface UserDetService {
	public void saveUserDet(UserDet userDet, int userId);
	
	public UserDet findUserDet(String userid);
}
