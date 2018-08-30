package com.lti.hrmanagementsystem.dao;

import java.util.List;

import com.lti.hrmanagementsystem.bean.AnnouncementBean;

public interface AnnouncementDAO {
	
	public String addAnnouncement(AnnouncementBean announcementBean);
	public List<AnnouncementBean> displayAnnouncements();
	public List<AnnouncementBean> displayAnnouncementByHrName(String hrName);
}
