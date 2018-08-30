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

import com.lti.hrmanagementsystem.bean.TimesheetBean;
import com.lti.hrmanagementsystem.service.TimesheetService;

@Controller
public class TimesheetController {

	@Autowired
	TimesheetService timesheetService;

	@RequestMapping(value = "timesheet.html", method = RequestMethod.GET)
	public String getTimesheet() {
		try {
			return "timesheet";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}

	@RequestMapping(value = "timesheet.html", method = RequestMethod.POST)
	public ModelAndView addtimesheet(@ModelAttribute TimesheetBean timesheetBean, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			// LoginBean bean = new LoginBean();
			System.out.println(timesheetBean);
			// timesheetBean.setPsno((String)httpSession.getAttribute("userName"));
			String psno = (String) httpSession.getAttribute("psNo");
			System.out.println("sesionpsno" + psno);
			String convertDate = timesheetBean.getEntryDate().substring(8, 10) + 
					timesheetBean.getEntryDate().substring(4, 8) + 
					timesheetBean.getEntryDate().substring(0, 4);
			System.out.println(convertDate);
			timesheetBean.setEntryDate(convertDate);
			timesheetService.addEntry(timesheetBean, psno);
			modelAndView.setViewName("timesheet");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "displaytimesheethr.html", method = RequestMethod.GET)
	public ModelAndView displaytimesheethr(@ModelAttribute TimesheetBean timesheetBean) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<TimesheetBean> list = timesheetService.displayEntry();
			modelAndView.addObject("list", list);
			modelAndView.setViewName("displaytimesheethr");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "displaytimesheethr.html", method = RequestMethod.POST)
	public ModelAndView displaytimesheethr() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<TimesheetBean> list = timesheetService.displayEntry();
			modelAndView.addObject("list", list);
			modelAndView.setViewName("displaytimesheethr");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "displayTimesheetEmp.html", method = RequestMethod.GET)
	public ModelAndView displayTimesheetEmp(@ModelAttribute TimesheetBean timesheetBean, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<TimesheetBean> list = timesheetService.displayEntry();
			String emp_psno = (String) httpSession.getAttribute("psNo");
			modelAndView.addObject("list", list);
			modelAndView.addObject("emp_psno", emp_psno);
			modelAndView.setViewName("displayTimesheetEmp");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "approveTimesheet.html", method = RequestMethod.GET)
	public ModelAndView approveTimesheet(@RequestParam("id") String id,
			@RequestParam("approvalStatus") String approvalStatus) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			System.out.println("Approve Id:" + id);
			System.out.println("Approval Status:" + approvalStatus);
			String timesheetStatus = null;
			if ("a".equals(approvalStatus)) {
				timesheetStatus = timesheetService.updateTimesheetStatus(id, 1);
			} else if ("d".equals(approvalStatus)) {
				timesheetStatus = timesheetService.updateTimesheetStatus(id, 2);
			} else {
				timesheetStatus = timesheetService.updateTimesheetStatus(id, 0);
			}
			System.out.println(timesheetStatus);
			List<TimesheetBean> list = timesheetService.displayEntry();
			modelAndView.addObject("list", list);
			modelAndView.setViewName("displaytimesheethr");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
}
