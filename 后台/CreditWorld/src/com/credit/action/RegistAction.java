package com.credit.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.credit.domain.User;
import com.credit.domain.UserDet;
import com.credit.service.UserDetService;
import com.credit.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport implements ServletResponseAware{

	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	
	private String result;
	private String repassword;
	
	private UserService userService;
	private UserDetService userDetService;
	
	private User user;
	private UserDet userDet;

	public String userRegist() {
		response.setHeader("Access-Control-Allow-Origin", "*");
		//result = callback+"({\"flag\":\"successfuly\"})";//返回必须是json字符串;
		Map<String, String> m = new HashMap<String, String>();
		try {
			userService.saveUser(user);
			m.put("flag", "true");
			m.put("loginName", user.getLoginName());
			result = JSONObject.fromObject(m).toString();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			m.put("flag", "false");
			result = JSONObject.fromObject(m).toString();
		}
		return SUCCESS;
	}
	
	public String userDet(){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, String> m = new HashMap<String, String>();
		try {
			System.out.println(user.getLoginName());
			userDetService.saveUserDet(userDet,userService.findUserByLoginName(user.getLoginName()).getId());
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
	
	public String userLogin(){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, String> m = new HashMap<String, String>();
		try {
			System.out.println(user.getLoginName());
			String password = userService.findUserByLoginName(user.getLoginName()).getPassword();
			m.put("flag", "true");
			if(password != null && password.equals(user.getPassword())){
				m.put("loginName", user.getLoginName());
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
	
	public String userGet(){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDet u = userDetService.findUserDet(String.valueOf(userService.findUserByLoginName(user.getLoginName()).getId()));
			m.put("flag", "true");
			if(u != null){
				m.put("userDet", u);
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserDet getUserDet() {
		return userDet;
	}

	public void setUserDet(UserDet userDet) {
		this.userDet = userDet;
	}

	public UserDetService getUserDetService() {
		return userDetService;
	}

	public void setUserDetService(UserDetService userDetService) {
		this.userDetService = userDetService;
	}

}
