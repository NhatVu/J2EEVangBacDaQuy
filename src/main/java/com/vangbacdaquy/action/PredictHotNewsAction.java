package com.vangbacdaquy.action;

import com.opensymphony.xwork2.ActionContext;
import com.vangbacdaquy.constant.FilePathConstant;
import com.vangbacdaquy.utility.WekaML;

public class PredictHotNewsAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String logConsole;
	private String downloadFileName;
	private String downloadFilePath;
	
	public String getLogConsole() {
		return logConsole;
	}

	public void setLogConsole(String logConsole) {
		this.logConsole = logConsole;
	}
	
	public String getDownloadFileName() {
		return downloadFileName;
	}
	
	public String getDownloadFilePath() {
		return downloadFilePath;
	}

	public void setDownloadFilePath(String downloadFilePath) {
		this.downloadFilePath = downloadFilePath;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String goPredictHotNews() {
		return "admin";
	}

	@Override
	public String execute() throws Exception {
		WekaML wekaML = new WekaML(FilePathConstant.TFIDF_TRAINING_DATA_FILE);
		// choose model
		wekaML.loadClassifierModel((String)ActionContext.getContext().getSession().get("modelFilePath"));
		// choose unlabeled data
		wekaML.classifyNewInstances(FilePathConstant.TFIDF_TESTING_DATA_FILE,
				FilePathConstant.CLASSIFICATION_RESULT_FILE, (String)ActionContext.getContext().getSession().get("labelValuesFilePath"));
		
		// 
		logConsole += "\nDone";
		downloadFilePath = FilePathConstant.CLASSIFICATION_RESULT_FILE;
		downloadFileName = "classificationResult.csv";
		return "admin";
	}
}
