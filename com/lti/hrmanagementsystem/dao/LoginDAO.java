package com.lti.hrmanagementsystem.dao;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.bean.LoginBean;

public interface LoginDAO {

	public LoginBean validateUser(LoginBean loginBean);

	public String updateUser(String userId, int status);

	public int getuserStatus(String userId);

	public String getUserType(String userId);

	public EmployeeBean resetPassword(String psno, String answer, String pass);
	
	public String updatePassword(String psno, String pass);
}
