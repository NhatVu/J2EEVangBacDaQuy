package com.vangbacdaquy.action;

import java.io.IOException;

import com.opensymphony.xwork2.ActionContext;

public class StreamingClassificationAction extends AbstractAction{
	private static final long serialVersionUID = 696269514180793042L;
	
	private String logConsole;
	private static Thread thread;
	private String classifierStatus;
	private String statusBackground = "label-danger";

	public String getStatusBackground() {
		return statusBackground;
	}

	public void setStatusBackground(String statusBackground) {
		this.statusBackground = statusBackground;
	}

	public String getClassifierStatus() {
		return classifierStatus;
	}

	public void setClassifierStatus(String classifierStatus) {
		this.classifierStatus = classifierStatus;
	}

	public String getLogConsole() {
		return logConsole;
	}

	public void setLogConsole(String logConsole) {
		this.logConsole = logConsole;
	}
	public String goStreamingClassification(){
		return "success";
	}
	@Override
	public void prepare() throws Exception {
		super.prepare();
	}
	
	@Override
	public String execute() {
		return "success";
	}
	public String startPredictor() throws ClassNotFoundException, IOException{
		String modelPath = (String)ActionContext.getContext().getSession().get("modelFilePath");
		return "success";
	}
	
	public String stopPredictor() throws InterruptedException{
		System.out.println("Stopping predictor");
		return "success";
	}
}
