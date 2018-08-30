package com.lti.hrmanagementsystem.service;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.bean.LoginBean;

public interface LoginService {

	public LoginBean validateUser(LoginBean bean);

	public String updateUser(String userId, int status);

	public int getuserStatus(String userId);

	public String getUserType(String userId);

	public EmployeeBean resetPassword(String psno, String answer, String pass);
	
	public String updatePassword(String psno, String pass);
}
