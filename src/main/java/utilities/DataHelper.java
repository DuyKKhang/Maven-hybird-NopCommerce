package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private static Locale locales = new Locale("en");
	private static Faker fakes = new com.github.javafaker.Faker(locales);
	
	public static DataHelper getDataHelper() {
		return new DataHelper();
	}
	
	public static String getFirstName() {
		return fakes.name().firstName();
	}
	public static String getLastName() {
		return fakes.name().lastName();
	}
	
	public static String getEmailAddress() {
		return fakes.internet().emailAddress();
	}
	
	public static String getCityName() {
		return fakes.address().city();
	}

	public static String getPhoneNumber() {
		return fakes.phoneNumber().phoneNumber();
	}
	
	public static String getAddress() {
		return fakes.address().streetAddress();
	}
	
	public static String getPassWord() {
		return fakes.internet().password(9, 12, true, true);
	}
}
