package com.lti.hrmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lti.hrmanagementsystem.bean.ComplaintBean;
import com.lti.hrmanagementsystem.service.ComplaintService;

@Controller
public class ComplaintController {

	@Autowired
	ComplaintService complaintService;

	@RequestMapping(value = "complaint.html", method = RequestMethod.GET)
	public String getComplaint() {
		try {
			return "complaint";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}

	@RequestMapping(value = "complaint.html", method = RequestMethod.POST)
	public ModelAndView complaint(@ModelAttribute ComplaintBean complaintBean) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String result = complaintService.addComplaint(complaintBean);
			System.out.println(result);
			modelAndView.setViewName("complaintSent");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "allComplaint.html", method = RequestMethod.GET)
	public ModelAndView getAllComplaints() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<ComplaintBean> list = complaintService.getAllComplaints();
			modelAndView.addObject("complaints", list);
			modelAndView.setViewName("allComplaint");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "getComplaintByPsno.html", method = RequestMethod.GET)
	public String getComplaintByPsnoPage() {
		try {
			return "getComplaintByPsno";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}

	@RequestMapping(value = "getComplaintByPsno.html", method = RequestMethod.POST)
	public ModelAndView getComplaintByPsnoPage(@RequestParam("psno") String psno) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<ComplaintBean> list = complaintService.getComplaintByPsno(psno);
			modelAndView.addObject("complaint", list);
			modelAndView.setViewName("getComplaintByPsno");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("getComplaintByPsno");
			return modelAndView;
		}
	}
}
