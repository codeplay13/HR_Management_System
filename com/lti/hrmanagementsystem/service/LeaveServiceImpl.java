package com.lti.hrmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.hrmanagementsystem.bean.LeaveBean;
import com.lti.hrmanagementsystem.dao.LeaveDAO;

@Service("leaveService")
@Transactional(propagation = Propagation.REQUIRED)
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	LeaveDAO leaveDAO;
	
	@Override
	public String addLeave(LeaveBean leaveBean, String psno) {
		// TODO Auto-generated method stub
		return leaveDAO.addLeave(leaveBean, psno);
	}

	@Override
	public List<LeaveBean> getLeaves() {
		// TODO Auto-generated method stub
		return leaveDAO.getLeaves();
	}

	@Override
	public String updateLeaveStatus(String leaveId, int status) {
		// TODO Auto-generated method stub
		return leaveDAO.updateLeaveStatus(leaveId, status);
	}

}
