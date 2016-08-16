package com.credit.service.impl;

import com.credit.dao.CompanyBaseDao;
import com.credit.domain.ComBase;
import com.credit.service.ComBaseService;

public class ComBaseServiceImpl implements ComBaseService {

	private CompanyBaseDao companyBaseDao;
	
	@Override
	public ComBase findComBaseById(String id) {
		return companyBaseDao.selectInfo(id);
	}
	
	@Override
	public void saveComBase(ComBase comBase) {
		companyBaseDao.insertInfo(comBase);
	}

	public CompanyBaseDao getCompanyBaseDao() {
		return companyBaseDao;
	}

	public void setCompanyBaseDao(CompanyBaseDao companyBaseDao) {
		this.companyBaseDao = companyBaseDao;
	}

	
}
