package com.credit.service.impl;

import com.credit.dao.CompanyDao;
import com.credit.domain.Company;
import com.credit.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

	private CompanyDao companyDao;
	@Override
	public void saveCompany(Company company) {
		// TODO Auto-generated method stub
		companyDao.insertCompany(company);

	}

	@Override
	public Company findCompany(String loginName) {
		// TODO Auto-generated method stub
		return companyDao.selectInfoByLoginName(loginName);
	}

	public CompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	
}
