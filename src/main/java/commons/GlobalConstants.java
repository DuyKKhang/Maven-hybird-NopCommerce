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
	


	private final String uploadFile = project_path + File.separator + "uploadFiles" + File.separator;
	
	private final long shortTimeOut = 5;
	private final long longTimeOut = 10;

	
	public long getShortTimeOut() {
		return shortTimeOut;
	}

	public long getLongTimeOut() {
		return longTimeOut;
	}
	
	public String getProject_path() {
		return project_path;
	}
}
