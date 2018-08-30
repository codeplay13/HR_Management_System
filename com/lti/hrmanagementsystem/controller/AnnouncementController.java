package com.lti.hrmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lti.hrmanagementsystem.bean.AnnouncementBean;
import com.lti.hrmanagementsystem.service.AnnouncementService;

@Controller
public class AnnouncementController {
	
	@Autowired
	AnnouncementService announcementService;
	
	@RequestMapping(value = "addAnnouncement.html", method = RequestMethod.GET)
	public String getAnnouncementPage() {
		try {
			return "addAnnouncement";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}
	
	@RequestMapping(value = "announcements.html", method = RequestMethod.GET)
	public String getAnnouncementsPage() {
		try {
			return "announcements";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}
	
	@RequestMapping(value = "addAnnouncement.html", method = RequestMethod.POST)
	public ModelAndView getAddAnnouncementPage(@ModelAttribute AnnouncementBean announcementBean) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String result = announcementService.addAnnouncement(announcementBean);
			System.out.println(result);
			modelAndView.setViewName("addAnnouncement");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "allAnnouncements.html", method = RequestMethod.GET)
	public ModelAndView getAllAnnouncementsPage() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<AnnouncementBean> list = announcementService.displayAnnouncements();
			modelAndView.addObject("announcements", list);
			modelAndView.setViewName("allAnnouncements");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "allAnnouncementsHr.html", method = RequestMethod.GET)
	public ModelAndView getAllAnnouncementsHrPage() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<AnnouncementBean> list = announcementService.displayAnnouncements();
			modelAndView.addObject("announcements", list);
			modelAndView.setViewName("allAnnouncementsHr");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "getAnnouncementsByHr.html", method = RequestMethod.GET)
	public String getAnnouncementsByHrPage() {
		try {
			return "getAnnouncementsByHr";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}
	
	@RequestMapping(value = "getAnnouncementsByHrHr.html", method = RequestMethod.GET)
	public String getAnnouncementsByHrHrPage() {
		try {
			return "getAnnouncementsByHrHr";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}
	
	@RequestMapping(value = "getAnnouncementsByHr.html", method = RequestMethod.POST)
	public ModelAndView getAddAnnouncementPage(@RequestParam("hrName") String hrName) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<AnnouncementBean> list = announcementService.displayAnnouncementByHrName(hrName);
			modelAndView.addObject("announcements", list);
			modelAndView.setViewName("getAnnouncementsByHr");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "getAnnouncementsByHrHr.html", method = RequestMethod.POST)
	public ModelAndView getAddAnnouncementHrPage(@RequestParam("hrName") String hrName) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<AnnouncementBean> list = announcementService.displayAnnouncementByHrName(hrName);
			modelAndView.addObject("announcements", list);
			modelAndView.setViewName("getAnnouncementsByHrHr");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
}
