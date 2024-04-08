package commons;


import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstants {
	private static GlobalConstants globalInstance;
	
	private GlobalConstants() {
	}
	
	public static synchronized GlobalConstants getGlobalConstants() {
		if(globalInstance == null) {
			globalInstance = new GlobalConstants();
		}
		return globalInstance;
	}

	private final String project_path = System.getProperty("user.dir");
	private final String javaVersion = System.getProperty("java.version");
	private final String uploadFile = project_path + File.separator + "uploadFiles" + File.separator;
	private final String browserUserName = "duyduy_71AVuY";
	private final String browserAutomateKey = "iQghAAsv1tn7SCo2yUxh";
	private final String browserStackUrl = "https://"+browserUserName+":"+browserAutomateKey+"@hub-cloud.browserstack.com/wd/hub";
	public String getbrowserStackUrl() {
		return browserStackUrl;
	}

	private final long shortTimeOut = 5;
	private final long longTimeOut = 30;

	public long getShortTimeOut() {
		return shortTimeOut;
	}
	public long getLongTimeOut() {
		return longTimeOut;
	}
	public String getProject_path() {
		return project_path;
	}
	public String getJavaVersion() {
		return javaVersion;
	}
}
