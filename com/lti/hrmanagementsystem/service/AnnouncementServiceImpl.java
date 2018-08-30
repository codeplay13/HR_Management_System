package com.lti.hrmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.hrmanagementsystem.bean.AnnouncementBean;
import com.lti.hrmanagementsystem.dao.AnnouncementDAO;

@Service("announcementService")
@Transactional(propagation = Propagation.REQUIRED)
public class AnnouncementServiceImpl implements AnnouncementService {
	
	@Autowired
	AnnouncementDAO announcementDAO;

	@Override
	public String addAnnouncement(AnnouncementBean announcementBean) {
		// TODO Auto-generated method stub
		return announcementDAO.addAnnouncement(announcementBean);
	}

	@Override
	public List<AnnouncementBean> displayAnnouncements() {
		// TODO Auto-generated method stub
		return announcementDAO.displayAnnouncements();
	}

	@Override
	public List<AnnouncementBean> displayAnnouncementByHrName(String hrName) {
		// TODO Auto-generated method stub
		return announcementDAO.displayAnnouncementByHrName(hrName);
	}

}
