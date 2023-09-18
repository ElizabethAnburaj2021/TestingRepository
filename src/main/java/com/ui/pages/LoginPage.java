 package com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.base.SeleniumBase;
import com.testng.base.ProjectSpecifiedMethods;

public class LoginPage extends ProjectSpecifiedMethods{

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage enterUsername(String data) {
		enterText(locateElement("id", "username"), data);
		return this;
		
	}
	public LoginPage enterPwd(String data) {
		enterText(locateElement("id", "password"), data);
		return this;
		
	}
	public HomePage clickLogin() {
		click(locateElement("class", "decorativeSubmit"));
		
		return new HomePage(driver);
		
	}
}
