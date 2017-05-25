package com.vangbacdaquy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DownloadFileAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private InputStream fileInputStream;
	private String filePath;
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public String execute() throws Exception {
		try {
			File file = new File(filePath);
			fileInputStream = new FileInputStream(file);
			fileName = file.getName();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	    return SUCCESS;
	}
}
