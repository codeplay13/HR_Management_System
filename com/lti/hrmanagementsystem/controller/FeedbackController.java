package com.lti.hrmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lti.hrmanagementsystem.bean.FeedbackBean;
import com.lti.hrmanagementsystem.service.FeedbackService;

@Controller
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;

	@RequestMapping(value = "feedback.html", method = RequestMethod.GET)
	public String getFeedback() {
		try {
			return "feedback";
		} catch(Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}

	@RequestMapping(value = "feedback.html", method = RequestMethod.POST)
	public ModelAndView feedback(@ModelAttribute FeedbackBean feedbackBean) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String result = feedbackService.addFeedback(feedbackBean);
			System.out.println(result);
			modelAndView.setViewName("feedbackSent");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}

	@RequestMapping(value = "allFeedback.html", method = RequestMethod.GET)
	public ModelAndView getAllFeedback() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<FeedbackBean> list = feedbackService.getAllFeedback();
			modelAndView.addObject("feedbacks", list);
			modelAndView.setViewName("allFeedback");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}

	}

	@RequestMapping(value = "getFeedbackByPsno.html", method = RequestMethod.GET)
	public String getFeedbackBypsnoPage() {
		try {
			return "getFeedbackByPsno";
		} catch (Exception e) {
			e.printStackTrace();
			return "notFound";
		}
	}

	@RequestMapping(value = "getFeedbackByPsno.html", method = RequestMethod.POST)
	public ModelAndView getFeedbackBypsnoPage(@RequestParam("psno") String psno) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<FeedbackBean> list = feedbackService.getFeedbackBypsnoPage(psno);
			modelAndView.addObject("feedback", list);
			modelAndView.setViewName("getFeedbackByPsno");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.setViewName("notFound");
			return modelAndView;
		}
	}
}
