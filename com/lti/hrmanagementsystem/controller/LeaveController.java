package com.lti.hrmanagementsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lti.hrmanagementsystem.bean.LeaveBean;
import com.lti.hrmanagementsystem.service.LeaveService;

@Controller
public class LeaveController {

	@Autowired
	LeaveService leaveService;

	// Display Page

	@RequestMapping(value = "leave.html", method = RequestMethod.GET)
	public String getleavePage() {
		try {
			return "leave";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}

	// Add Timesheet Entry
	@RequestMapping(value = "leave.html", method = RequestMethod.POST)
	public ModelAndView addleave(@ModelAttribute LeaveBean leaveBean, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String psno = (String) httpSession.getAttribute("psNo");
			String res = leaveService.addLeave(leaveBean, psno);
			System.out.println(res);
			modelAndView.setViewName("appliedForLeave");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "displayLeave.html", method = RequestMethod.GET)
	public ModelAndView displayLeave(@ModelAttribute LeaveBean leaveBean, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<LeaveBean> list = leaveService.getLeaves();
			System.out.println("Controller" + list);
			modelAndView.addObject("list", list);
			modelAndView.setViewName("displayLeave");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}

	}

	@RequestMapping(value = "approveLeave.html", method = RequestMethod.GET)
	public ModelAndView approveLeave(@RequestParam("id") String id, @RequestParam("approvalStatus") String approvalStatus) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			System.out.println("Approve Id:" + id);
			System.out.println("Approval Status:" + approvalStatus);
			String leaveStatus = null;
			if ("a".equals(approvalStatus)) {
				leaveStatus = leaveService.updateLeaveStatus(id, 1);
			} else if ("d".equals(approvalStatus)) {
				leaveStatus = leaveService.updateLeaveStatus(id, 2);
			} else {
				leaveStatus = leaveService.updateLeaveStatus(id, 0);
			}
			System.out.println(leaveStatus);
			List<LeaveBean> list = leaveService.getLeaves();
			modelAndView.addObject("list", list);
			modelAndView.setViewName("displayLeave");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "displayLeaveEmp.html", method = RequestMethod.GET)
	public ModelAndView displayLeaveEmp(@ModelAttribute LeaveBean leaveBean, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<LeaveBean> list = leaveService.getLeaves();
			String emp_psno = (String) httpSession.getAttribute("psNo");
			modelAndView.addObject("list", list);
			modelAndView.addObject("emp_psno", emp_psno);
			modelAndView.setViewName("displayLeaveEmp");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
}
