package com.lti.hrmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.hrmanagementsystem.bean.TimesheetBean;

@Repository("timesheetDAO")
public class TimesheetDAOImpl implements TimesheetDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public TimesheetBean addEntry(TimesheetBean timesheetBean, String psno) {
		Session session = sessionFactory.getCurrentSession();
		timesheetBean.setPsno(psno);
		System.out.println(timesheetBean.getPsno());
		session.save(timesheetBean);
		return timesheetBean;
	}

	@Override
	public String updateTimesheetStatus(String timesheetId, int status) {
		Session session = sessionFactory.getCurrentSession();
		TimesheetBean timesheetBean = session.get(TimesheetBean.class, timesheetId);
		if (timesheetBean == null) {
			return "#";
		}
		System.out.println("PSDAO" + timesheetId);
		System.out.println("statusDAO" + status);
		timesheetBean.setTimesheetStatus(status);
		System.out.println(timesheetBean.getTimesheetStatus());
		session.update(timesheetBean);
		return "Status Updated";
	}

	@Override
	public List<TimesheetBean> displayEntry() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<TimesheetBean> list = new ArrayList<TimesheetBean>();
		for (Object object : session.createQuery("from timesheet").getResultList()) {
			list.add((TimesheetBean) object);
		}
		System.out.println(list);
		return list;
	}

}
