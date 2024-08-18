package com.compsio.test;

import org.testng.annotations.Test;

import com.composio.base.BaseTest;

import pages.Dashboard;
import pages.LoginPage;

public class HomePageTest extends BaseTest {
	
	@Test
	public void homepageTest() throws InterruptedException {
		LoginPage loginpage = homepage.clickContinueWithGoogle();
		Thread.sleep(2000);
		Dashboard dashboard = loginpage.doLogin();
		dashboard.connectGitHub();
		
	}
	
	
}

