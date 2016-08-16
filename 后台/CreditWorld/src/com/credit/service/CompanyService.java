package com.credit.service;

import com.credit.domain.Company;

public interface CompanyService {
	public void saveCompany(Company company);
	
	public Company findCompany(String loginName);
}
