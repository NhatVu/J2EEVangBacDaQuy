package com.vangbacdaquy.action;

import java.io.File;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.vangbacdaquy.constant.FilePathConstant;
import com.vangbacdaquy.utility.WekaML;
import com.vangbacdaquy.utility.ZipUtility;

public class TrainModelAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	private String chosenAlgorithm;
	private String logConsole;
	private String downloadFileName;
	private String downloadFilePath;
	
	public String getDownloadFileName() {
		return downloadFileName;
	}
	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}
	public String getDownloadFilePath() {
		return downloadFilePath;
	}
	public void setDownloadFilePath(String downloadFilePath) {
		this.downloadFilePath = downloadFilePath;
	}
	public String getLogConsole() {
		return logConsole;
	}
	public void setLogConsole(String logConsole) {
		this.logConsole = logConsole;
	}
	public String goTrainModel(){
		return "admin";
	}
	public String getChosenAlgorithm() {
		return chosenAlgorithm;
	}
	public void setChosenAlgorithm(String chosenAlgorithm) {
		this.chosenAlgorithm = chosenAlgorithm;
	}
	
	@Override
	public String execute() throws Exception {
		WekaML wekaML = new WekaML(FilePathConstant.TFIDF_TRAINING_DATA_FILE);
		String evalString = null;
		if (!chosenAlgorithm.equalsIgnoreCase("None")){
			Map<String, Object> sessionMap = ActionContext.getContext().getSession();
			String userPath = FilePathConstant.MODEL_FOLDER + (String) sessionMap.get("userNameLogged") + File.separator;
			
			File newFolder = new File(userPath);
			if (!newFolder.exists()){	
				newFolder.mkdirs();
			}	
			
			wekaML.trainClassifier(chosenAlgorithm, userPath + chosenAlgorithm + ".model", userPath + "labelValues.txt");	
//			evalString = wekaML.crossValidateModel(10);
			
			String zipPath = ZipUtility.zipDirectory(userPath);
			downloadFilePath = zipPath;
			downloadFileName = new File(zipPath).getName();
			
			logConsole += "\n" + "Done!";
		} else {
			logConsole += "\nPlease choose an algorithm";
		}
		return "admin";
	}
}
