package com.vangbacdaquy.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;
import com.vangbacdaquy.constant.FilePathConstant;

public class UploadFileAction extends AbstractAction {
	private static final long serialVersionUID = 554305743193040011L;

	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;
	private String destPath;
	private String actionName;
	private String logConsole;
	private String dataTypeSubmit;
		
	public String getDataTypeSubmit() {
		return dataTypeSubmit;
	}

	public void setDataTypeSubmit(String dataTypeSubmit) {
		this.dataTypeSubmit = dataTypeSubmit;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public String getLogConsole() {
		return logConsole;
	}

	public void setLogConsole(String logConsole) {
		this.logConsole = logConsole;
	}


	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String execute() throws IOException {
		String returnString = ERROR;
		File destFile = null;
		/* Upload file to a specfied directory*/
		if (actionName != null && actionName.equalsIgnoreCase("CrawlTweet")) {
			destPath = FilePathConstant.KEYWORD_FOLDER;
			destFile = new File(destPath, uploadFileFileName);			
			returnString = "CrawlTweet";
		}		
		if (actionName != null && actionName.equalsIgnoreCase("PreprocessData_DataFile")) {
		    FileUtils.cleanDirectory(new File(FilePathConstant.INPUT_TRAINING_DATA_FOLDER));
		    FileUtils.cleanDirectory(new File(FilePathConstant.INPUT_TESTING_DATA_FOLDER));
			if (dataTypeSubmit.equals("Training")){
				destPath = FilePathConstant.INPUT_TRAINING_DATA_FOLDER;				
			}
			if (dataTypeSubmit.equals("Testing")){
				destPath = FilePathConstant.INPUT_TESTING_DATA_FOLDER;				
			}
			destFile = new File(destPath, uploadFileFileName);
			returnString = "PreprocessData";
		}
		if (actionName != null && actionName.equalsIgnoreCase("PreprocessData_DictionaryFile")) {//disregard uploaded file name, use own format
			destPath = FilePathConstant.DICTIONARY_ZIP_FILE;
			destFile = new File(destPath);
			returnString = "PreprocessData";
		}
		if (actionName != null && actionName.equalsIgnoreCase("PreprocessData_StopwordFile")) {
			destPath = FilePathConstant.STOPWORD_FILE;
			destFile = new File(destPath);
			returnString = "PreprocessData";
		}		
		if (actionName != null && actionName.equalsIgnoreCase("TrainModel")) {
			destPath = FilePathConstant.TFIDF_TRAINING_DATA_FILE;
			destFile = new File(destPath);
			returnString = "TrainModel";
		}		
		if (actionName != null && actionName.equalsIgnoreCase("PredictHotNews_ModelFile")) {//disregard uploaded file name, use own format
			destPath = FilePathConstant.MODEL_FOLDER;
			Map<String, Object> sessionMap = ActionContext.getContext().getSession();
			String modelFilePath = destPath + (String) sessionMap.get("userNameLogged") + "_ML.model";
			sessionMap.put("modelFilePath", modelFilePath);
			destFile = new File(modelFilePath);
			returnString = "PredictHotNews";
		}
		if (actionName != null && actionName.equalsIgnoreCase("PredictHotNews_LabelValuesFile")) {//disregard uploaded file name, use own format
			destPath = FilePathConstant.MODEL_FOLDER;
			Map<String, Object> sessionMap = ActionContext.getContext().getSession();
			String labelValuesFilePath = destPath + (String) sessionMap.get("userNameLogged") + "_labelValues.txt";
			sessionMap.put("labelValuesFilePath", labelValuesFilePath);
			destFile = new File(labelValuesFilePath);
			returnString = "PredictHotNews";
		}
		if (actionName != null && actionName.equalsIgnoreCase("PredictHotNews_DataFile")) {
			destPath = FilePathConstant.TFIDF_TESTING_DATA_FILE;
			destFile = new File(destPath);
			returnString = "PredictHotNews";
		}
		if (actionName != null && actionName.equalsIgnoreCase("StreamingClassification")) {//disregard uploaded file name, use own format
			destPath = FilePathConstant.MODEL_FOLDER;
			Map<String, Object> sessionMap = ActionContext.getContext().getSession();
			String modelFilePath = destPath + (String) sessionMap.get("userNameLogged") + "_ML.model";
			sessionMap.put("modelFilePath", modelFilePath);
			destFile = new File(modelFilePath);
			returnString = "StreamingClassification";
		}
		logConsole += "\nUploaded: " + uploadFileFileName;
		try {

			FileUtils.copyFile(uploadFile, destFile);

		} catch (IOException e) {
			e.printStackTrace();
			logConsole += "\nError uploading file";
			return ERROR;
		}

		return returnString;
	}

}
