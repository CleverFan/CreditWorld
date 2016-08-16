package com.credit.service;

import com.credit.domain.ComBase;

public interface ComBaseService {
	public void saveComBase(ComBase comBase);
	public ComBase findComBaseById(String id);
}
