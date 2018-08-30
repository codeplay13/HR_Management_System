package com.lti.hrmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.hrmanagementsystem.bean.ComplaintBean;
import com.lti.hrmanagementsystem.dao.ComplaintDAO;


@Service("complaintService")
@Transactional(propagation = Propagation.REQUIRED)
public class ComplaintServiceImpl implements ComplaintService {
	@Autowired
	ComplaintDAO complaintDAO;
	@Override
	public String addComplaint(ComplaintBean complaintBean) {
		return complaintDAO.addComplaint(complaintBean);
	}

	@Override
	public List<ComplaintBean> getAllComplaints() {
		// TODO Auto-generated method stub
		return complaintDAO.getAllComplaints();
	}

	@Override
	public List<ComplaintBean> getComplaintByPsno(String psno) {
		// TODO Auto-generated method stub
		return complaintDAO.getComplaintByPsno(psno);
	}

}
