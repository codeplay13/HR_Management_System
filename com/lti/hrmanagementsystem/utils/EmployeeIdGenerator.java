package com.lti.hrmanagementsystem.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.lti.hrmanagementsystem.bean.EmployeeBean;

public class EmployeeIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object emp) throws HibernateException {
		String query = "select seq.nextval as emp_seq from dual";
		Connection connection = session.connection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String res = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				res = resultSet.getString("emp_seq");
			}
			EmployeeBean bean = (EmployeeBean) emp;
			res = bean.getFirstName().substring(0, 2) + res;
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
