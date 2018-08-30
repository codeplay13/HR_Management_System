package com.lti.hrmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.hrmanagementsystem.bean.LeaveBean;

@Repository("leaveDAO")
public class LeaveDAOImpl implements LeaveDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String addLeave(LeaveBean leaveBean, String psno) {
		leaveBean.setPsno(psno);
		sessionFactory.getCurrentSession().save(leaveBean);
		return "success";
	}

	@Override
	public List<LeaveBean> getLeaves() {
		Session session = sessionFactory.getCurrentSession();
		List<LeaveBean> list = new ArrayList<LeaveBean>();
		for (Object object : session.createQuery("from leave order by applyDate, leaveStatus desc").getResultList()) {
			list.add((LeaveBean) object);
		}
		return list;
	}

	@Override
	public String updateLeaveStatus(String leaveId, int status) {
		Session session = sessionFactory.getCurrentSession();
		LeaveBean leaveBean = session.get(LeaveBean.class, leaveId);
		System.out.println("upLeave"+status);
		System.out.println(leaveId);
		leaveBean.setLeaveStatus(status);
		session.update(leaveBean);
		return "Status Updated";
	}

}
