package com.lti.hrmanagementsystem.service;

import java.util.List;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.bean.RecruitmentBean;

public interface RecruitmentService {
	public String addProject(RecruitmentBean recruitmentBean);
	public RecruitmentBean viewProjectById(String projectId);
	public List<RecruitmentBean> viewProjects();
	public List<EmployeeBean> getEmployeesWithNoProject();
	public String updateProjectId(String psno, String projectId);
}
