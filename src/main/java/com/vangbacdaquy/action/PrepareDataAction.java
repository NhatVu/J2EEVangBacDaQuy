package com.vangbacdaquy.action;


public class PrepareDataAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String dataSource;
	private String fromDate;
	private String toDate;
	private String logConsole;
	private String downloadFilePath;
	private String downloadFileName;
		
	public String getDownloadFilePath() {
		return downloadFilePath;
	}

	public void setDownloadFilePath(String downloadFilePath) {
		this.downloadFilePath = downloadFilePath;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getLogConsole() {
		return logConsole;
	}

	public void setLogConsole(String logConsole) {
		this.logConsole = logConsole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String goPrepareData(){
		return "admin";
	}
	
	@Override
	public String execute() throws Exception {
		return "admin";
	}
}
