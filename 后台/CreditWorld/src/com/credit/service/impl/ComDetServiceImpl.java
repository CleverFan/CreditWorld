package com.credit.service.impl;

import java.lang.reflect.Field;

import com.credit.dao.CompanyDetDao;
import com.credit.domain.ComDet;
import com.credit.service.CompanyDetService;
import com.credit.util.UserUtil;

public class ComDetServiceImpl implements CompanyDetService {

	private CompanyDetDao companyDetDao;
	@Override
	public void saveComDet(ComDet comDet,String id) {
		comDet = setMask(comDet);
		comDet.setId(id);
		companyDetDao.insertInfo(comDet);
	}

	@Override
	public ComDet findComdetById(String id) {
		return companyDetDao.selectInfo(id);
	}
	
	private ComDet setMask(ComDet comDet) {
		double mask = 0;
		Field[] fields = comDet.getClass().getDeclaredFields();  
		for(int i=0; i<fields.length; i++){  
            Field f = fields[i];  
            f.setAccessible(true);  
            try {
				//System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(userDet));
				String value = (String)(f.get(comDet));
				if(value != null){	
					f.set(comDet, UserUtil.divideStr(value));
					mask += UserUtil.divideStrForMask(value);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}  
        } 
		comDet.setMask(mask+"");
		return comDet;
	}

	public CompanyDetDao getCompanyDetDao() {
		return companyDetDao;
	}

	public void setCompanyDetDao(CompanyDetDao companyDetDao) {
		this.companyDetDao = companyDetDao;
	}
}
