package com.selenium.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBase implements browser, element {

	public WebDriver driver;
	public WebElement ele;

	@Override
	public WebDriver startApp(String url) {

		return startApp("chrome", url);
	}

	@Override
	public WebDriver startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
			return driver;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public WebElement locateElement(String locatorType, String value) {
		try {
			switch (locatorType.toUpperCase()) {
			case "ID":
				  ele = driver.findElement(By.id(value));
				 return ele;
			case "NAME":
				  ele = driver.findElement(By.name(value));
				 return ele;
			case "CLASS":
				  ele = driver.findElement(By.className(value));
					 return ele;
			case "XPATH":
				  ele = driver.findElement(By.xpath(value));
					 return ele;
			}
			return null;
		}catch(Exception e) {
			throw new RuntimeException("No such Element found Exception");
		}
	}

	@Override
	public List<WebElement> locateElements(String LocatorType, String value) {
		try {
			switch (LocatorType.toUpperCase()) {
			case "ID":
				return driver.findElements(By.id(value));
			case "NAME":
				return driver.findElements(By.name(value));
			case "CLASS":
				return driver.findElements(By.className(value));
			case "XPATH":
				return driver.findElements(By.xpath(value));
			}
			return null;
		}catch(Exception e) {
			throw new RuntimeException("No Such Element Exception");
		}
	}
	

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<String>(windowHandles);
			String windowId = allHandles.get(index);
			driver.switchTo().window(windowId);
		}catch(Exception e) {
			throw new RuntimeException("No such Window Exception");
		}
	}

	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
		}catch(Exception e) {
			throw new RuntimeException("Element Intercept Exception");
		}
		
	}

	@Override
	public String getElementText(WebElement ele) {
		try {
			ele.getText();
		}catch(Exception e) {
			throw new RuntimeException("No such Element Exception");
		}
		return null;
	}

	@Override
	public void enterText(WebElement ele, String data) {
		ele.sendKeys(data);
	}

}
