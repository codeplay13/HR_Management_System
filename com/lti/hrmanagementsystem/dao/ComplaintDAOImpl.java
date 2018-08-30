package com.lti.hrmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.hrmanagementsystem.bean.ComplaintBean;

@Service
public class ComplaintDAOImpl implements ComplaintDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String addComplaint(ComplaintBean complaintBean) {
		sessionFactory.getCurrentSession().save(complaintBean);
		return "Complaint sent successfully";
	}

	@Override
	public List<ComplaintBean> getAllComplaints() {
		Session session = sessionFactory.getCurrentSession();
		List<ComplaintBean> list = new ArrayList<ComplaintBean>();
		for (Object object : session.createQuery("from complaint").getResultList()) {
			list.add((ComplaintBean) object);
		}
		return list;
	}

	@Override
	public List<ComplaintBean> getComplaintByPsno(String psno) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from complaint where psno=:psno order by complaintDate";
		@SuppressWarnings("unchecked")
		Query<ComplaintBean> result = session.createQuery(hql);
		result.setParameter("psno", psno);
		try {
			List<ComplaintBean> list = result.getResultList();
			return list;
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

}
