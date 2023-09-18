package com.selenium.test;

import org.testng.annotations.Test;

import com.testng.base.ProjectSpecifiedMethods;
import com.ui.pages.LoginPage;

public class TC001_Login extends ProjectSpecifiedMethods{

	@Test
	public void createLeaf() {
		new LoginPage(driver).enterUsername("demosalesmanager").enterPwd("crmsfa").clickLogin();
	}
}
