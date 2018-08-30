package com.lti.hrmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.hrmanagementsystem.bean.PayrollBean;
import com.lti.hrmanagementsystem.dao.PayrollDAO;

@Service("payrollService")
@Transactional(propagation=Propagation.REQUIRED)
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	PayrollDAO payrollDAO;
	
	@Override
	public PayrollBean generatePayroll(String psno) {
		// TODO Auto-generated method stub
		return payrollDAO.generatePayroll(psno);
	}

}
