package com.vangbacdaquy.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.opensymphony.xwork2.Action;

/**
 * @author cuongdev
 *
 */
public class TrackingTweetAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private String TweetId;
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
	}
	
	@Override
	public String execute() throws Exception {
		return Action.SUCCESS;
	}
	
	public String viewTrend(){
		result.put("error", true);
		return "json";
	}

	public String getTweetId() {
		return TweetId;
	}

	public void setTweetId(String tweetId) {
		TweetId = tweetId;
	}

	
	
	
}
