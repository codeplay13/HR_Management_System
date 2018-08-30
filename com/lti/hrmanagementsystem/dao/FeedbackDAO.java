package com.lti.hrmanagementsystem.dao;

import java.util.List;

import com.lti.hrmanagementsystem.bean.FeedbackBean;

public interface FeedbackDAO {
	public String addFeedback(FeedbackBean feedbackBean);
	public List<FeedbackBean> getAllFeedback();
	public List<FeedbackBean> getFeedbackBypsnoPage(String psno);
}
