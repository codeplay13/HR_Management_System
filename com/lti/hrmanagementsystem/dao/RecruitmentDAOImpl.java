package com.lti.hrmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.bean.RecruitmentBean;

@Repository("recruitmentDAO")
public class RecruitmentDAOImpl implements RecruitmentDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String addProject(RecruitmentBean recruitmentBean) {
		Session session = sessionFactory.getCurrentSession();
		session.save(recruitmentBean);
		return "Success";
	}

	@Override
	public RecruitmentBean viewProjectById(String projectId) {
		return sessionFactory.getCurrentSession().get(RecruitmentBean.class, projectId);
	}

	@Override
	public List<RecruitmentBean> viewProjects() {
		Session session = sessionFactory.getCurrentSession();
		List<RecruitmentBean> list = new ArrayList<>();
		for (Object oneObject : session.createQuery("from Recruitment").getResultList()) {
			list.add((RecruitmentBean) oneObject);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeBean> getEmployeesWithNoProject(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Employee where projectId = null").getResultList();
	}
	
	@Override
	public String updateProjectId(String psno, String projectId) {
		Session session = sessionFactory.getCurrentSession();
		RecruitmentBean recruitmentBean = session.get(RecruitmentBean.class, projectId);
		if(recruitmentBean == null) {
			return "#";
		}
		EmployeeBean employeeBean = session.get(EmployeeBean.class, psno);
		employeeBean.setProjectId(projectId);
		session.update(employeeBean);
		return "Project ID updated!";
	}
}
