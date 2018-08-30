package com.lti.hrmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.bean.RecruitmentBean;
import com.lti.hrmanagementsystem.dao.RecruitmentDAO;

@Service("recruitmentService")
@Transactional(propagation = Propagation.REQUIRED)
public class RecruitmentServiceImpl implements RecruitmentService{
	
	@Autowired
	RecruitmentDAO recruitmentDAO;

	@Override
	public String addProject(RecruitmentBean recruitmentBean) {
		// TODO Auto-generated method stub
		return recruitmentDAO.addProject(recruitmentBean);
	}

	@Override
	public RecruitmentBean viewProjectById(String projectId) {
		// TODO Auto-generated method stub
		return recruitmentDAO.viewProjectById(projectId);
	}

	@Override
	public List<RecruitmentBean> viewProjects() {
		// TODO Auto-generated method stub
		return recruitmentDAO.viewProjects();
	}

	@Override
	public List<EmployeeBean> getEmployeesWithNoProject() {
		// TODO Auto-generated method stub
		return recruitmentDAO.getEmployeesWithNoProject();
	}

	@Override
	public String updateProjectId(String psno, String projectId) {
		// TODO Auto-generated method stub
		return recruitmentDAO.updateProjectId(psno, projectId);
	}
	
}
