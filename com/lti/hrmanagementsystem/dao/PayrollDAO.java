package com.lti.hrmanagementsystem.dao;

import com.lti.hrmanagementsystem.bean.PayrollBean;

public interface PayrollDAO {
	public PayrollBean generatePayroll(String psno);
}
