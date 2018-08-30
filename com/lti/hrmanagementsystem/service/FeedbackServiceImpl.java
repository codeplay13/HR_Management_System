package com.lti.hrmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import com.lti.hrmanagementsystem.bean.FeedbackBean;
import com.lti.hrmanagementsystem.dao.FeedbackDAO;

@Service("feedbackService")
@Transactional(propagation = Propagation.REQUIRED)
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	FeedbackDAO feedbackDAO;

	@Override
	public String addFeedback(FeedbackBean feedbackBean) {
		// TODO Auto-generated method stub
		return feedbackDAO.addFeedback(feedbackBean);
	}

	@Override
	public List<FeedbackBean> getAllFeedback() {
		// TODO Auto-generated method stub
		return feedbackDAO.getAllFeedback();
	}

	@Override
	public List<FeedbackBean> getFeedbackBypsnoPage(String psno) {
		// TODO Auto-generated method stub
		return feedbackDAO.getFeedbackBypsnoPage(psno);
	}

}
