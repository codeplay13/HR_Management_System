package com.lti.hrmanagementsystem.dao;

import java.util.List;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.hrmanagementsystem.bean.PayrollBean;

@Repository("payrollDAO")
public class PayrollDAOImpl implements PayrollDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public PayrollBean generatePayroll(String psno) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from timesheet where to_char(to_date(entryDate, 'DD-MM-YYYY'), 'MM') in (to_char(trunc(sysdate), 'MM')-1) and psno=:psno and timesheetStatus = 1";
		Query<Long> result = session.createQuery(hql);
		result.setParameter("psno", psno);
		long days = result.getSingleResult();
		System.out.println(days);
		List list = session.createNativeQuery("select TO_CHAR(sysdate-to_char(sysdate,'dd')+level,'DD-Mon-YYYY')\"DATE\", to_char(sysdate-to_char(sysdate,'dd')+level,'fmDay')\"DAY\" from dual\r\n" + 
				"where to_char(sysdate-to_char(sysdate,'dd')+level,'fmDAY')=upper('SUNDAY') connect by level<=to_char(last_day(sysdate),'dd')").list();
		int sundays = list.size();
		System.out.println(sundays);
		days += sundays;
		double basic = days*1666.67;
		PayrollBean payrollBean = new PayrollBean();
		payrollBean.setPsno(psno);
		payrollBean.setBasic(basic);
		payrollBean.setGratuity(basic);
		payrollBean.setPf(basic);
		payrollBean.setTax(basic);
		payrollBean.setTotal(basic, payrollBean.getPf(), payrollBean.getGratuity(), payrollBean.getTax());
		return payrollBean;
	}

}
