package com.lti.hrmanagementsystem.service;

import java.util.List;

import com.lti.hrmanagementsystem.bean.FeedbackBean;

public interface FeedbackService {
	public String addFeedback(FeedbackBean feedbackBean);

	public List<FeedbackBean> getAllFeedback();

	public List<FeedbackBean> getFeedbackBypsnoPage(String psno);

}
