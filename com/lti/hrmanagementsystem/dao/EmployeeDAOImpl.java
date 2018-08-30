package com.lti.hrmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.bean.LoginBean;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String addEmployee(EmployeeBean bean) {
		Session session = sessionFactory.getCurrentSession();
		LoginBean loginBean = new LoginBean();
		session.save(bean);
		loginBean.setPsno(bean.getPsno());
		loginBean.setPassword(bean.getPassword());
		loginBean.setUserType("user");
		loginBean.setUserstatus(0);
		session.save(loginBean);
		return bean.getFirstName() + " " + bean.getMiddleName() + " " + bean.getLastName();
	}

	@Override
	public EmployeeBean getEmployeeById(String psno) {
		return sessionFactory.getCurrentSession().get(EmployeeBean.class, psno);
	}

	@Override
	public List<EmployeeBean> getEmployees() {
		Session session = sessionFactory.getCurrentSession();
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		for (Object oneObject : session.createQuery("from Employee").getResultList()) {
			list.add((EmployeeBean) oneObject);
		}
		//List<EmployeeBean> list = (List<EmployeeBean>)session.createQuery("from Employee").list();
		return list;
	}

	@Override
	public String deleteEmployee(String psno) {
		Session session = sessionFactory.getCurrentSession();
		EmployeeBean bean = session.byId(EmployeeBean.class).load(psno);
		if(bean == null) {
			return "No employee found";
		}
		LoginBean bean2 = session.byId(LoginBean.class).load(psno);
		session.delete(bean);
		session.delete(bean2);
		return "Deleted";
	}

}
