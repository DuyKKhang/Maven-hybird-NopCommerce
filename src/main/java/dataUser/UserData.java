package dataUser;

import utilities.DataHelper;

public class UserData {
	
	private static DataHelper data = new DataHelper().getDataHelper(); 
	private static String email =  data.getEmailAddress();
	private static String passWord =  data.getPassWord();
	
	public static class Register{
		public static final String FIRSTNAME = data.getFirstName();
		public static final String LASTNAME =  data.getLastName();
		public static final String EMAIL =  email;
		public static final String CITY =  data.getCityName();
		public static final String PASSWORD =  passWord;
	}
	
	public static class LoginUser {
		public static final String EMAIL =  email;
		public static final String PASSWORD =  passWord;
	}
	
	public static class LoginAdmin{
		public static final String EMAIL =  "admin@yourstore.com";
		public static final String PASSWORD =  "admin";
	}
}
