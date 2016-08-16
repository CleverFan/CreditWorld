package com.credit.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comBase")
public class ComBase {
	@Id
	private String id;
	private String cname;
	private String ename;
	private String raddress;
	private String maddress;
	private String marea;
	private String csxz;
	private String phone;
	private String cz;
	private String yb;
	private String wadd;
	private String ctype;
	private String zch;
	private String zctime;
	private String dkk;
	private String zzjgdm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMarea() {
		return marea;
	}
	public void setMarea(String marea) {
		this.marea = marea;
	}
	public String getCsxz() {
		return csxz;
	}
	public void setCsxz(String csxz) {
		this.csxz = csxz;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getYb() {
		return yb;
	}
	public void setYb(String yb) {
		this.yb = yb;
	}
	public String getWadd() {
		return wadd;
	}
	public void setWadd(String wadd) {
		this.wadd = wadd;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getZch() {
		return zch;
	}
	public void setZch(String zch) {
		this.zch = zch;
	}
	public String getZctime() {
		return zctime;
	}
	public void setZctime(String zctime) {
		this.zctime = zctime;
	}
	public String getDkk() {
		return dkk;
	}
	public void setDkk(String dkk) {
		this.dkk = dkk;
	}
	public String getZzjgdm() {
		return zzjgdm;
	}
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	public ComBase() {
		super();
	}
	
	
}
