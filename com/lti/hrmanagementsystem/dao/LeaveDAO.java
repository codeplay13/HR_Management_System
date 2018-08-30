package com.lti.hrmanagementsystem.dao;

import java.util.List;

import com.lti.hrmanagementsystem.bean.LeaveBean;

public interface LeaveDAO {

	public String addLeave(LeaveBean leaveBean, String psno);

	public List<LeaveBean> getLeaves();
	
	public String updateLeaveStatus(String leaveId, int status);
}
