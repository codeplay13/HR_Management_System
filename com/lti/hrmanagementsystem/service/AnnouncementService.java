package com.lti.hrmanagementsystem.service;

import java.util.List;

import com.lti.hrmanagementsystem.bean.AnnouncementBean;

public interface AnnouncementService {
	public String addAnnouncement(AnnouncementBean announcementBean);
	public List<AnnouncementBean> displayAnnouncements();
	public List<AnnouncementBean> displayAnnouncementByHrName(String hrName);
}
