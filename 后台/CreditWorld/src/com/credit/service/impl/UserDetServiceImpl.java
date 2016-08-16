package com.credit.service.impl;

import java.lang.reflect.Field;

import com.credit.dao.UserDetDao;
import com.credit.domain.UserDet;
import com.credit.service.UserDetService;
import com.credit.util.UserUtil;

public class UserDetServiceImpl implements UserDetService {

	private UserDetDao userDetDao;
	@Override
	public void saveUserDet(UserDet userDet,int userId) {
		userDet = setMask(userDet);
		userDet.setUserid(String.valueOf(userId));
		userDetDao.insertInfo(userDet);
	}

	private UserDet setMask(UserDet userDet) {
		int mask = 0;
		Field[] fields = userDet.getClass().getDeclaredFields();  
		for(int i=0; i<fields.length; i++){  
            Field f = fields[i];  
            f.setAccessible(true);  
            try {
				//System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(userDet));
				String value = (String)(f.get(userDet));
				if(value != null){	
					f.set(userDet, UserUtil.divideStr(value));
					mask += UserUtil.divideStrForMask(value);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}  
        } 
		userDet.setMask(mask+"");
		return userDet;
	}
	

	@Override
	public UserDet findUserDet(String userid) {
		return userDetDao.selectInfo(userid);
	}

	public UserDetDao getUserDetDao() {
		return userDetDao;
	}

	public void setUserDetDao(UserDetDao userDetDao) {
		this.userDetDao = userDetDao;
	}
	
}
