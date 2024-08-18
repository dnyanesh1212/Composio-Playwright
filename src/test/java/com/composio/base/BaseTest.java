package com.composio.base;

import java.util.Properties;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import factory.PlaywrightFactory;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	Properties prop;
	protected HomePage homepage;
	protected LoginPage loginpage;
	
	@BeforeTest
	public void setup() {
		pf= new PlaywrightFactory();
		prop = pf.init_prop();
		page= pf.initBrowser(prop);
		
		homepage = new HomePage(page,prop);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
		System.out.println("browser closed");
	}

}
