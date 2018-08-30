package com.lti.hrmanagementsystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "login")
@Table(name = "login")
public class LoginBean {
	@Id
	private String psno;
	private String password;
	private String userType;
	private int userstatus;

	public String getPsno() {
		return psno;
	}

	public void setPsno(String psno) {
		this.psno = psno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}

}
