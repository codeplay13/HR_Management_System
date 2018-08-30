package com.lti.hrmanagementsystem.service;

import java.util.List;

import com.lti.hrmanagementsystem.bean.EmployeeBean;

public interface EmployeeService {
	public String addEmployee(EmployeeBean bean);

	public EmployeeBean getEmployeeById(String psno);

	public List<EmployeeBean> getEmployees();

	public String deleteEmployee(String psno);
}
