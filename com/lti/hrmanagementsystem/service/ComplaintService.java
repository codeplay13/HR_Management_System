package com.lti.hrmanagementsystem.service;

import java.util.List;

import com.lti.hrmanagementsystem.bean.ComplaintBean;


public interface ComplaintService {
	public String addComplaint(ComplaintBean complaintBean);

	public List<ComplaintBean> getAllComplaints();

	public List<ComplaintBean> getComplaintByPsno(String psno);


}
