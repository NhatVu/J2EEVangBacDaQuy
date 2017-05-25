package com.vangbacdaquy.action;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.vangbacdaquy.bo.UserBO;
import com.vangbacdaquy.constant.UserType;
import com.vangbacdaquy.dto.UserDTO;

public class LoginAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String msg;
	private boolean isAdmin;
	private Map<String, Object> sessionMap;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LoginAction() {
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}
	
	public String execute() throws Exception {
		String page = null;
		sessionMap = ActionContext.getContext().getSession();
		if (sessionMap != null) {
			if (sessionMap.get("isLogged") != null
					&& ((boolean) sessionMap.get("isLogged") == true)) {
				String userTypeCode = (String) sessionMap.get("role");
				if (userTypeCode.equals(UserType.ADMIN.toString())) {
					page = "admin";
				} else {
					page = "editor";
				}
				return page;
			}
		}
		page = "fail";
		return page;
	}

	public String login() throws Exception{
		String page = null;
		
		UserBO userBO = new UserBO();
		UserDTO userDTO = userBO.getUserDTO(username, password);
		if (userDTO != null) {
			if (userDTO.getUsername() == null
					|| userDTO.getUsername().equals("")) {
				page = "fail";
				msg = "UserName and password is not valid!";
				addActionError("Username and password is not valid!");
			} else {
				sessionMap = ActionContext.getContext().getSession();
				sessionMap.put("isLogged", true);
				sessionMap.put("userNameLogged", username);
				sessionMap.put("role", userDTO.getUserType().toString());
				sessionMap.put("loggedTime", new Date());
				setAdmin(false);
				if(userDTO.getUserType().getValue().equals(UserType.ADMIN.getValue())) {
					setAdmin(true);
				}

				if (UserType.ADMIN.getValue().equals(userDTO.getUserTypeID())) {
					page = "admin";
				} else {
					page = "editor";
				}
			}
		} else {
			page = "fail";
			msg = "Login Fail";
			addActionError("Username and password is not valid!");
		}
		
		return page;
	}
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
