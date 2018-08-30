package com.lti.hrmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.hrmanagementsystem.bean.AnnouncementBean;

@Repository("announcementDAO")
public class AnnouncementDAOImpl implements AnnouncementDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String addAnnouncement(AnnouncementBean announcementBean) {
		sessionFactory.getCurrentSession().save(announcementBean);
		return "Announcement added successfully";
	}

	@Override
	public List<AnnouncementBean> displayAnnouncements() {
		Session session = sessionFactory.getCurrentSession();
		List<AnnouncementBean> list = new ArrayList<AnnouncementBean>();
		for (Object object : session.createQuery("from announcement order by entryDate desc").getResultList()) {
			list.add((AnnouncementBean) object);
		}
		return list;
	}

	@Override
	public List<AnnouncementBean> displayAnnouncementByHrName(String hrName) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from announcement where hrName=:hrName order by entryDate";
		@SuppressWarnings("unchecked")
		Query<AnnouncementBean> result = session.createQuery(hql);
		result.setParameter("hrName", hrName);
		try {
			List<AnnouncementBean> list = result.getResultList();
			return list;
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}
}
