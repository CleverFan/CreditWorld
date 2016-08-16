package com.credit.service;

import com.credit.domain.ComDet;

public interface CompanyDetService {
	public void saveComDet(ComDet comDet,String id);
	public ComDet findComdetById(String id);
}
