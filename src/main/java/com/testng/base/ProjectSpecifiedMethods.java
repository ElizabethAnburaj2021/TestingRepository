package com.testng.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.selenium.base.SeleniumBase;

public class ProjectSpecifiedMethods extends SeleniumBase{
	
	@BeforeMethod
	public void beforeMethod() {
		driver = startApp("http://leaftaps.com/opentaps");
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
