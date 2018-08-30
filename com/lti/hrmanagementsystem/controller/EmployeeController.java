package com.lti.hrmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "registration.html", method = RequestMethod.GET)
	public String getRegistrationPage() {
		try {
			return "registration";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}

	@RequestMapping(value = "registration.html", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute EmployeeBean bean ) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (employeeService.addEmployee(bean) != null) {
				System.out.println("Success");
			} else {
				System.out.println("Failed to register");
			}
			modelAndView.setViewName("registration");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "getEmployees.html", method = RequestMethod.GET)
	public ModelAndView getEmployeesPage() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<EmployeeBean> list = employeeService.getEmployees();
			modelAndView.addObject("employees", list);
			modelAndView.setViewName("getEmployees");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "getEmployeeById.html", method = RequestMethod.GET)
	public String getEmployeeByIdPage() {
		try {
			return "getEmployeeById";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}
	
	@RequestMapping(value = "getEmployeeById.html", method = RequestMethod.POST)
	public ModelAndView getEmployeeById(@RequestParam("psno") String psno) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			EmployeeBean employeeBean = employeeService.getEmployeeById(psno);
			modelAndView.addObject("employee", employeeBean);
			modelAndView.setViewName("getEmployeeById");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "deleteEmployee.html", method = RequestMethod.GET)
	public String getDeleteEmployeePage() {
		try {
			return "deleteEmployee";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}
	
	@RequestMapping(value = "deleteEmployee.html", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(@RequestParam("psno") String psno) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String result = employeeService.deleteEmployee(psno);
			System.out.println(result);
			modelAndView.addObject("result", result);
			modelAndView.setViewName("deleteEmployee");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	//Profile
	@RequestMapping(value="profile.html",method=RequestMethod.GET)
	public String getProfile() {
		try {
			return "profile";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}
}
