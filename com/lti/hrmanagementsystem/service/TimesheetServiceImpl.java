package com.lti.hrmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.hrmanagementsystem.bean.TimesheetBean;
import com.lti.hrmanagementsystem.dao.TimesheetDAO;

@Service("timesheetService")
@Transactional(propagation=Propagation.REQUIRED)
public class TimesheetServiceImpl implements TimesheetService{

	@Autowired
	TimesheetDAO timesheetDAO;
	
	@Override
	public TimesheetBean addEntry(TimesheetBean timesheetBean, String psno) {
		// TODO Auto-generated method stub
		return timesheetDAO.addEntry(timesheetBean, psno);
	}

	@Override
	public List<TimesheetBean> displayEntry() {
		// TODO Auto-generated method stub
		return timesheetDAO.displayEntry();
	}


	@Override
	public String updateTimesheetStatus(String timesheetId, int status) {
		// TODO Auto-generated method stub
		return timesheetDAO.updateTimesheetStatus(timesheetId, status);
	}


	

}
