package com.credit.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.credit.domain.ComBase;
import com.credit.domain.ComDet;
import com.credit.domain.Company;
import com.credit.domain.UserDet;
import com.credit.service.ComBaseService;
import com.credit.service.CompanyDetService;
import com.credit.service.CompanyService;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport implements ServletResponseAware{

	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	
	private String result;
	
	private CompanyService companyService;
	private CompanyDetService companyDetService;
	private ComBaseService comBaseService;;
	
	
	private Company company;
	private ComBase comBase;
	private ComDet comDet;

	public String companyGet(){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			//UserDet u = userDetService.findUserDet(String.valueOf(userService.findUserByLoginName(user.getLoginName()).getId()));
			ComBase c = comBaseService.findComBaseById(companyService.findCompany(company.getLoginName()).getId());
			ComDet d = companyDetService.findComdetById(companyService.findCompany(company.getLoginName()).getId());
			m.put("flag", "true");
			if(c != null){
				m.put("comBase", c);
				m.put("comDet", d);
				result = JSONObject.fromObject(m).toString();
				System.out.println(result);
			}else{
				m.put("flag", "false");
				result = JSONObject.fromObject(m).toString();
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("flag", "false");
			result = JSONObject.fromObject(m).toString();
		}
		return SUCCESS;
	}
	
	public String companyRegist() {
		response.setHeader("Access-Control-Allow-Origin", "*");
		//result = callback+"({\"flag\":\"successfuly\"})";//返回必须是json字符串;
		Map<String, String> m = new HashMap<String, String>();
		try {
			companyService.saveCompany(company);
			m.put("flag", "true");
			m.put("loginName", company.getLoginName());
			result = JSONObject.fromObject(m).toString();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			m.put("flag", "false");
			result = JSONObject.fromObject(m).toString();
		}
		return SUCCESS;
	}
	public String companyLogin(){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, String> m = new HashMap<String, String>();
		try {
			System.out.println(company.getLoginName());
			String password = companyService.findCompany(company.getLoginName()).getCpassword();
			m.put("flag", "true");
			if(password != null && password.equals(company.getCpassword())){
				m.put("loginName", company.getLoginName());
				result = JSONObject.fromObject(m).toString();
				System.out.println(result);
			}else{
				m.put("flag", "false");
				result = JSONObject.fromObject(m).toString();
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("flag", "false");
			result = JSONObject.fromObject(m).toString();
		}
		return SUCCESS;
	}
	
	public String companyBase(){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, String> m = new HashMap<String, String>();
		try {
			System.out.println(company.getLoginName());
			comBase.setId(companyService.findCompany(company.getLoginName()).getId());
			comBaseService.saveComBase(comBase);
			m.put("flag", "true");
			result = JSONObject.fromObject(m).toString();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			m.put("flag", "false");
			result = JSONObject.fromObject(m).toString();
		}
		return SUCCESS;
	}
	
	public String companyDet(){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, String> m = new HashMap<String, String>();
		try {
			System.out.println(company.getLoginName());
			companyDetService.saveComDet(comDet, companyService.findCompany(company.getLoginName()).getId());
			m.put("flag", "true");
			result = JSONObject.fromObject(m).toString();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			m.put("flag", "false");
			result = JSONObject.fromObject(m).toString();
		}
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
		
	}
	public CompanyDetService getCompanyDetService() {
		return companyDetService;
	}
	public void setCompanyDetService(CompanyDetService companyDetService) {
		this.companyDetService = companyDetService;
	}
	public ComBaseService getComBaseService() {
		return comBaseService;
	}
	public void setComBaseService(ComBaseService comBaseService) {
		this.comBaseService = comBaseService;
	}
	public ComBase getComBase() {
		return comBase;
	}
	public void setComBase(ComBase comBase) {
		this.comBase = comBase;
	}
	public ComDet getComDet() {
		return comDet;
	}
	public void setComDet(ComDet comDet) {
		this.comDet = comDet;
	}
	
	
}
