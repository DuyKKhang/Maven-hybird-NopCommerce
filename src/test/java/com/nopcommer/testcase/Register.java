package com.nopcommer.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataUser.UserData;
import utilities.DataHelper;


public class Register extends BaseTest{
	
	private WebDriver driver;
	
	@Parameters({"evnName", "serverName", "browser"})
	@BeforeClass
	public void beforeClass(String evnName,String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);
		
	}
	
	@Test
	public void TC_01_Register_With_Empty_Data(){
		String df = UserData.LoginAdmin.EMAIL;
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
