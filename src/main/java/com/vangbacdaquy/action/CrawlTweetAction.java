package com.vangbacdaquy.action;


public class CrawlTweetAction extends AbstractAction{
	private String logConsole;
	private static final long serialVersionUID = 1L;
	
	public String getLogConsole() {
		return logConsole;
	}

	public void setLogConsole(String logConsole) {
		this.logConsole = logConsole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		return "admin";
	}
	
	public String goCrawlTweet() throws Exception {
		return "admin";
	}
}