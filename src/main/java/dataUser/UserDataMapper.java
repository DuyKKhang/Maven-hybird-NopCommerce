package dataUser;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {
	public static UserDataMapper getUserDataMapper() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.getGlobalConstants().getProject_path() + "\\src\\main\\java\\dataUser\\dataAccount.json"), UserDataMapper.class);
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
	public String getCurtomerLastname() {
		return curtomer.lastname;
	}
	public String getCurtomerEmail() {
		return curtomer.email;
	}
	public String getCurtomerCompanyName() {
		return curtomer.companyName;
	}

	@JsonProperty("Address")
	private Address address;
	static class Address{
		@JsonProperty("firstName")
		private String firstName;
		@JsonProperty("lastName")
		private String lastName;
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
		@JsonProperty("cardNumber")
		private String cardNumber;
		@JsonProperty("cardCode")
		private String cardCode;
		@JsonProperty("expDate_day")
		private String expDate_day;
		@JsonProperty("expDate_year")
		private String expDate_year;
	}

	public String getAddressFirstName(){
		return address.firstName;
	}
	public String getAddressLastName(){
		return address.lastName;
	}
	public String getAddressEmail(){
		return address.email;
	}
	public String getAddressCompanyName(){
		return address.companyName;
	}
	public String getAddressCountry(){
		return address.country;
	}
	public String getAddressState(){
		return address.state;
	}
	public String getAddressCity(){
		return address.city;
	}
	public String getAddressAddress_1(){
		return address.address_1;
	}
	public String getAddressAddress_2(){
		return address.address_2;
	}
	public String getAddressZip(){
		return address.zip;
	}
	public String getAddressPhone(){
		return address.phone;
	}
	public String getCardNumber(){
		return address.cardNumber;
	}
	public String getCarCode(){
		return address.cardCode;
	}
	public String getExpDate_day(){
		return address.expDate_day;
	}
	public String getExpDate_year(){
		return address.expDate_year;
	}
	public String getAddressFaxNumber(){
		return address.faxNumber;
	}

}
