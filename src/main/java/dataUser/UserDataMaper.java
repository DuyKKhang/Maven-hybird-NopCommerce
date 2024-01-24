package dataUser;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMaper {
	public static UserDataMaper getUserDataMaper() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File("D:\\Test Automation\\01-Project-Maven-Hybird-NopCommer\\src\\main\\java\\dataUser\\dataAccount.json"), UserDataMaper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@JsonProperty("name")
	private String name;
	public String getName() {
		return name;
	}
	
	@JsonProperty("Customer")
	private Customer curtomer; 
	
	static class Customer{
		@JsonProperty("firstname")
		private String firstname;
		
		@JsonProperty("lastname")
		private String lastname;
		
		@JsonProperty("email")
		private String email;
		
		@JsonProperty("companyName")
		private String companyName;
		
	}
	public String getCurtomerFirstName() {
		return curtomer.firstname;
	}
	
	public void setCurtomer(String firstname) {
		this.curtomer.firstname = firstname;
	}
	
	public String getCurtomerLastName() {
		return curtomer.lastname;
	}
	
	public String getCurtomerEmail() {
		return curtomer.email;
	}
	
	public String getCurtomerCompany() {
		return curtomer.companyName;
	}
	
	@JsonProperty("Address")
	private Address address; 
	
	static class Address{
		@JsonProperty("firstnam")
		private String firstnam;
		
		@JsonProperty("lastname")
		private String lastname;
		
		@JsonProperty("email")
		private String email;
		
		@JsonProperty("companyName")
		private String companyName;
		
		@JsonProperty("country")
		private String country;
		
		@JsonProperty("state")
		private String state;
		
		@JsonProperty("city")
		private String city;
		
		@JsonProperty("address_1")
		private String address_1;
		
		@JsonProperty("address_2")
		private String address_2;
		
		@JsonProperty("zip")
		private String zip;
		
		@JsonProperty("phone")
		private String phone;
		
		@JsonProperty("faxNumber")
		private String faxNumber;
		
	}
	
	public String getAddressFirstName() {
		return address.firstnam;
	}
	
	public String getAddressLastName() {
		return address.lastname;
	}
	
	public String getAddressEmail() {
		return address.email;
	}
	
	public String getAddressCompanyName() {
		return address.companyName;
	}
	
	public String getAddressCountry() {
		return address.country;
	}
	
	public String getAddressState() {
		return address.state;
	}
	
	public String getAddressCity() {
		return address.city;
	}
	
	public String getAddress_1() {
		return address.address_1;
	}
	
	public String getAddress_2() {
		return address.address_2;
	}
	
	public String getAddressZip() {
		return address.zip;
	}
	
	public String getAddressPhone() {
		return address.phone;
	}
	
	public String getAddressFaxNumber() {
		return address.faxNumber;
	}

	public void setAddress(String firstname) {
		this.address.firstnam = firstname;
	}
	
}
