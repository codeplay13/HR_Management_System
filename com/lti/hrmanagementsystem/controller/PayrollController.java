package com.lti.hrmanagementsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lti.hrmanagementsystem.bean.PayrollBean;
import com.lti.hrmanagementsystem.service.PayrollService;

@Controller
public class PayrollController {

	@Autowired
	PayrollService payrollService;
	
//	@RequestMapping(value="payrollStatus.html", method=RequestMethod.GET)
//	public String getPayrollStatus() {
//		try {
//			return "payrollStatus";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "notFound";
//		}
//	}

	@RequestMapping(value = "payrollStatus.html", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String psno = (String) httpSession.getAttribute("psNo");
			PayrollBean payrollBean = payrollService.generatePayroll(psno);
			modelAndView.addObject("payrollBean", payrollBean);
			modelAndView.setViewName("payrollStatus");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
}
