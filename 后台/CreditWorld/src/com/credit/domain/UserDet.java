package com.credit.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userDet")
public class UserDet {
	@Id
	private String userid;
	private String house;
	private String liveTime;
	private String occupation;
	private String workTime;
	private String credit;
	private String backCount;
	private String debt;
	private String selectTime;
	private String creditTime;
	private String outCount;
	private String creditUse;
	private String creditBreak;
	private String mask;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getLiveTime() {
		return liveTime;
	}
	public void setLiveTime(String liveTime) {
		this.liveTime = liveTime;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getBackCount() {
		return backCount;
	}
	public void setBackCount(String backCount) {
		this.backCount = backCount;
	}
	public String getDebt() {
		return debt;
	}
	public void setDebt(String debt) {
		this.debt = debt;
	}
	public String getSelectTime() {
		return selectTime;
	}
	public void setSelectTime(String selectTime) {
		this.selectTime = selectTime;
	}
	public String getCreditTime() {
		return creditTime;
	}
	public void setCreditTime(String creditTime) {
		this.creditTime = creditTime;
	}
	public String getOutCount() {
		return outCount;
	}
	public void setOutCount(String outCount) {
		this.outCount = outCount;
	}
	public String getCreditUse() {
		return creditUse;
	}
	public void setCreditUse(String creditUse) {
		this.creditUse = creditUse;
	}
	public String getCreditBreak() {
		return creditBreak;
	}
	public void setCreditBreak(String creditBreak) {
		this.creditBreak = creditBreak;
	}
	
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public UserDet() {
		super();
	}
	
	
}
