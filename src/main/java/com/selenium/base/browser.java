package com.selenium.base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface browser {
	/*
	 * Add method description here
	 */
	public WebDriver startApp(String url);
	public WebDriver startApp(String browser, String url);
	public WebElement locateElement(String locatorType,String value);
	public List<WebElement> locateElements(String LocatorType, String value);
	public void switchToWindow(int index);
	public void enterText(WebElement ele, String data);
	
	
	
}
