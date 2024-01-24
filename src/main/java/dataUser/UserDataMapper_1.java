package dataUser;

import java.io.File;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;
import dataUser.UserDataMaper.Customer;

public class UserDataMapper_1 {
	
	public static UserDataMapper_1 getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.getGlobalConstants().getProject_path() + "\\src\\main\\java\\dataUser\\dataAccount.json"), UserDataMapper_1.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@JsonProperty("Customer")
	private Customer curtomer; 
	
	static class Customer{
		@JsonProperty("firstname")
		private String firstname;
	}
	public String getCurtomerFirstName() {
		return curtomer.firstname;
	}
	
	
	
	@JsonProperty("Login")
	private Login login;
	
	static class Login {
		@JsonProperty("username")
		private String username;
		
		@JsonProperty("password")
		private String password;
	}
	public String getLoginUsername() {
		return login.username;
	}
	
	public void setLoginUsername(String username) {
		this.login.username = username;
	}
	
	public String getLoginPassword() {
		return login.password;
	}
	
	public void setLoginPassword(String password) {
		this.login.password = password;
	}
	
	
	
}
