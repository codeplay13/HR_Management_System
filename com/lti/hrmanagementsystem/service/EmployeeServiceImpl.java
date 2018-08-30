package com.lti.hrmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.dao.EmployeeDAO;

@Service("employeeService")
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public String addEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(bean);
	}

	@Override
	public EmployeeBean getEmployeeById(String psno) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeById(psno);
	}

	@Override
	public List<EmployeeBean> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}

	@Override
	public String deleteEmployee(String psno) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmployee(psno);
	}

}
