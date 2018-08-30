package com.lti.hrmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.bean.LoginBean;
import com.lti.hrmanagementsystem.dao.LoginDAO;

@Service("loginService")
@Transactional(propagation = Propagation.REQUIRED)
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAO loginDAO;

	@Override
	public LoginBean validateUser(LoginBean loginBean) {
		// TODO Auto-generated method stub
		return loginDAO.validateUser(loginBean);
	}

	@Override
	public String updateUser(String userId, int status) {
		// TODO Auto-generated method stub
		return loginDAO.updateUser(userId, status);
	}

	@Override
	public int getuserStatus(String userId) {
		// TODO Auto-generated method stub
		return loginDAO.getuserStatus(userId);
	}

	@Override
	public String getUserType(String userId) {
		// TODO Auto-generated method stub
		return loginDAO.getUserType(userId);
	}

	@Override
	public EmployeeBean resetPassword(String psno, String answer, String pass) {
		// TODO Auto-generated method stub
		return loginDAO.resetPassword(psno, answer, pass);
	}

	@Override
	public String updatePassword(String psno, String pass) {
		// TODO Auto-generated method stub
		return loginDAO.updatePassword(psno, pass);
	}
	
	
}
