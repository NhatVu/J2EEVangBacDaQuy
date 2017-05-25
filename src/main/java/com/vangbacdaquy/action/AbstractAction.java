package com.vangbacdaquy.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class AbstractAction  extends ActionSupport implements Preparable, ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The session. */
	protected HttpSession session;

	/** The request. */
	protected HttpServletRequest request;
	
	/** The response. */
	protected HttpServletResponse response;

	// Thông tin kết quả trả về ajax
	/** The result. */
	protected Map<String, Object> result;
	
	@Override
	public void prepare() throws Exception {
		request = ServletActionContext.getRequest();		
		response = ServletActionContext.getResponse();
		session = this.request.getSession(true);
		
		result = new HashMap<String, Object>();
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	public HttpServletRequest getServletRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
}
