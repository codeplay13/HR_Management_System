package com.lti.hrmanagementsystem.service;

import java.util.List;

import com.lti.hrmanagementsystem.bean.TimesheetBean;

public interface TimesheetService {
	
	public TimesheetBean addEntry(TimesheetBean timesheetBean,String psno);
	public List<TimesheetBean> displayEntry();
	public String updateTimesheetStatus(String timesheetId,int status);
}
