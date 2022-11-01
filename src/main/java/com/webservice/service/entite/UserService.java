package com.webservice.service.entite;


public class UserService {
	
	private String username;
	private String password;
	private String companyCode;
	
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
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	@Override
	public String toString() {
		return "[username=" + username + ", password=" + password + ", companyCode=" + companyCode + "]";
	}
	
	
}
