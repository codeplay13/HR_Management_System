package com.lti.hrmanagementsystem.dao;

import java.util.List;

import com.lti.hrmanagementsystem.bean.ComplaintBean;

public interface ComplaintDAO {
	public String addComplaint(ComplaintBean complaintBean);
	public List<ComplaintBean> getAllComplaints();
	public List<ComplaintBean> getComplaintByPsno(String psno);

}
