package com.lti.hrmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.hrmanagementsystem.bean.FeedbackBean;

@Repository("feedbackDAO")
public class FeedbackDAOImpl implements FeedbackDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String addFeedback(FeedbackBean feedbackBean) {
		sessionFactory.getCurrentSession().save(feedbackBean);
		return "Feedback sent successfully";
	}

	@Override
	public List<FeedbackBean> getAllFeedback() {
		Session session = sessionFactory.getCurrentSession();
		List<FeedbackBean> list = new ArrayList<FeedbackBean>();
		for (Object object : session.createQuery("from feedback").getResultList()) {
			list.add((FeedbackBean) object);
		}
		return list;
	}

	@Override
	public List<FeedbackBean> getFeedbackBypsnoPage(String psno) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from feedback where psno=:psno order by feedbackDate";
		@SuppressWarnings("unchecked")
		Query<FeedbackBean> result = session.createQuery(hql);
		result.setParameter("psno", psno);
		try {
			List<FeedbackBean> list = result.getResultList();
			return list;
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	}
}
