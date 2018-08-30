package com.lti.hrmanagementsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lti.hrmanagementsystem.bean.EmployeeBean;
import com.lti.hrmanagementsystem.bean.LoginBean;
import com.lti.hrmanagementsystem.service.EmployeeService;
import com.lti.hrmanagementsystem.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = { "home.html", "/" }, method = RequestMethod.GET)
	public String getHomePage() {
		try {
			return "home";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}

	@RequestMapping(value = "validateUser.html", method = RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute LoginBean bean, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			LoginBean loginBean = loginService.validateUser(bean);
			if (loginBean != null) {
				String res = loginService.getUserType(loginBean.getPsno());
				int res2 = loginService.getuserStatus(loginBean.getPsno());
				String res3 = loginService.updateUser(loginBean.getPsno(), 1);
				System.out.println(res + " " + res2 + " " + res3);
				EmployeeBean employeeBean = employeeService.getEmployeeById(loginBean.getPsno());
				//httpSession.setAttribute("employee", loginBean);
				// modelAndView.setViewName("success");
				if ("hr".equals(res)) {
					httpSession.setAttribute("psno", loginBean.getPsno());
					modelAndView.setViewName("hr_dashboard");
				} else if ("user".equals(res)) {
					httpSession.setAttribute("psNo", employeeBean.getPsno());
					httpSession.setAttribute("userName", employeeBean.getFirstName() + " "
							+ employeeBean.getMiddleName() + " " + employeeBean.getLastName());
					httpSession.setAttribute("dob", employeeBean.getDob());
					httpSession.setAttribute("doj", employeeBean.getDoj());
					httpSession.setAttribute("address", employeeBean.getAddress());
					httpSession.setAttribute("emp_projectName", employeeBean.getProjectId());
					httpSession.setAttribute("skill", employeeBean.getSkills());
					modelAndView.setViewName("emp_dashboard");
				}
			} else {
				modelAndView.setViewName("notFound");
			}
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "forgotPassword.html", method = RequestMethod.GET)
	public String getResetPasswordPage() {
		try {
			return "forgotPassword";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}

	@RequestMapping(value = "forgotPassword.html", method = RequestMethod.POST)
	public ModelAndView getResetPasswordPage(@RequestParam("psno") String psno, @RequestParam("ans") String answer,
			@RequestParam("npass") String npass) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (loginService.resetPassword(psno, answer, npass) != null) {
				String result = loginService.updatePassword(psno, npass);
				System.out.println(result);
				modelAndView.setViewName("home");
			} else {
				modelAndView.setViewName("notFound");
			}
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "logout.html", method = RequestMethod.GET)
	public String getHomeAfterLogoutPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession httpSession = null;
			httpSession = request.getSession(false);
			String userName = (String) httpSession.getAttribute("userName");
			System.out.println(userName);
			httpSession.invalidate();
			return "home";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}

	// DashBoards

	@RequestMapping(value = "hr_dashboard", method = RequestMethod.GET)
	public String getHrDashboard() {
		return "hr_dashboard";

	}

	@RequestMapping(value = "emp_dashboard", method = RequestMethod.GET)
	public String getEmpDashboard() {
		return "emp_dashboard";

	}

}