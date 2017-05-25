package com.vangbacdaquy.dto;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.vangbacdaquy.constant.UserType;

/**
 *
 * @author HNTIN
 */
public class UserDTO {
	
	private int id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String phone;
    private int userTypeID;
    private UserType userType;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@RequiredStringValidator(message = "Username is not empty")
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserTypeID() {
		return userTypeID;
	}
	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}
	public UserType getUserType() {
		return UserType.parseValue(getUserTypeID());
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
}
