package com.lti.hrmanagementsystem.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.bean.LoginBean;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public LoginBean validateUser(LoginBean loginBean) {
		Session session= sessionFactory.getCurrentSession();
		String hql = "from login where psno=:psno and password=:password";
		@SuppressWarnings("unchecked")
		Query<LoginBean> result = session.createQuery(hql);
		result.setParameter("psno", loginBean.getPsno());
		result.setParameter("password", loginBean.getPassword());
		try {
			LoginBean bean = result.getSingleResult();
			return bean;
		} catch(NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String updateUser(String userId, int status) {
		Session session = sessionFactory.getCurrentSession();
		LoginBean loginBean = session.byId(LoginBean.class).load(userId);
		loginBean.setUserstatus(status);
		session.update(loginBean);
		return "Success";
	}

	@Override
	public int getuserStatus(String userId) {
		Session session = sessionFactory.getCurrentSession();
		LoginBean loginBean = session.byId(LoginBean.class).load(userId);
		return loginBean.getUserstatus();
	}

	@Override
	public String getUserType(String userId) {
		Session session = sessionFactory.getCurrentSession();
		LoginBean loginBean = session.byId(LoginBean.class).load(userId);
		return loginBean.getUserType();
	}

	@Override
	public EmployeeBean resetPassword(String psno, String answer, String pass) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Employee where psno=:psno and answer=:answer";
		@SuppressWarnings("unchecked")
		Query<EmployeeBean> result = session.createQuery(hql);
		result.setParameter("psno", psno);
		result.setParameter("answer", answer);
		try {
			EmployeeBean bean = result.getSingleResult();
			return bean;
		} catch(NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String updatePassword(String psno, String pass) {
		Session session = sessionFactory.getCurrentSession();
		LoginBean loginBean = session.byId(LoginBean.class).load(psno);
		EmployeeBean employeeBean = session.byId(EmployeeBean.class).load(psno);
		loginBean.setPassword(pass);
		employeeBean.setPassword(pass);
		session.update(loginBean);
		session.update(employeeBean);
		return "Successfully Updated!";
	}
}
