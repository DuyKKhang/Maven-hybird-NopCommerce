package utilities;

import java.util.Locale;

import net.datafaker.Faker;

public class DataHelper {
	private Locale locales = new Locale("en");
	private Faker fakes = new Faker(locales);
	
	public static DataHelper getDataHelper() {
		return new DataHelper();
	}
	
	public String getFirstName() {
		return fakes.name().firstName();
	}
	public String getLastName() {
		return fakes.name().lastName();
	}
	
	public String getEmailAddress() {
		return fakes.internet().emailAddress();
	}
	
	public String getCityName() {
		return fakes.address().city();
	}

	public String getPhoneNumber() {
		return fakes.phoneNumber().phoneNumber();
	}
	
	public String getAddress() {
		return fakes.address().streetAddress();
	}
	
	public String getPassWord() {
		return fakes.internet().password(9, 12, true, true);
	}
}
