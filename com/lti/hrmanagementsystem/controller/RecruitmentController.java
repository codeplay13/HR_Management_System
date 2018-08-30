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
import com.lti.hrmanagementsystem.bean.RecruitmentBean;
import com.lti.hrmanagementsystem.service.RecruitmentService;

@Controller
public class RecruitmentController {

	@Autowired
	RecruitmentService recruitmentService;
	
	@RequestMapping(value = "recruitment.html", method = RequestMethod.GET)
	public String getRecruitmentPage() {
		try {
			return "recruitment";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}
	
	@RequestMapping(value = "recruitment.html", method = RequestMethod.POST)
	public ModelAndView addRecruitment(@ModelAttribute RecruitmentBean recruitmentBean) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String result = recruitmentService.addProject(recruitmentBean);
			System.out.println(result);
			modelAndView.setViewName("displayRecruitment");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "displayRecruitment.html", method = RequestMethod.GET)
	public String getDisplayRecruitmentPage() {
		try {
			return "displayRecruitment";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}
	
	@RequestMapping(value = "allRecruitments.html", method = RequestMethod.GET)
	public ModelAndView getDisplayAllRecruitmentsPage() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<RecruitmentBean> list = recruitmentService.viewProjects();
			modelAndView.addObject("recruitments", list);
			modelAndView.setViewName("allRecruitments");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "recruitmentById.html", method = RequestMethod.GET)
	public String getRecruitmentByIdPage() {
		try {
			return "recruitmentById";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}
	
	@RequestMapping(value = "recruitmentById.html", method = RequestMethod.POST)
	public ModelAndView getRecruitmentByIdPage(@RequestParam("projectId") String id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			RecruitmentBean recruitmentBean = recruitmentService.viewProjectById(id);
			modelAndView.addObject("recruitment", recruitmentBean);
			modelAndView.setViewName("recruitmentById");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "recruitedList.html", method = RequestMethod.POST)
	public ModelAndView getRecruitedListPage() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<EmployeeBean> list = recruitmentService.getEmployeesWithNoProject();
			modelAndView.addObject("employees", list);
			modelAndView.setViewName("recruitedList");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "assignProject.html", method = RequestMethod.POST)
	public ModelAndView projectAssignment(@RequestParam("psno") String psno, @RequestParam("projectId") String projectId) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String result = recruitmentService.updateProjectId(psno, projectId);
			System.out.println(result);
			modelAndView = getRecruitedListPage();
			modelAndView.addObject("result", result);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
}
