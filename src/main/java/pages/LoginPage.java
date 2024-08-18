package pages;

import java.util.Properties;

import com.microsoft.playwright.Page;


public class LoginPage {
	
	private Page page;
	Properties prop;
	private String username = "//input[@id='login_field']";
	private String password= "//input[@type='password']";
	private String submitBtn= "//input[@type='submit']";
	
	public LoginPage(Page page, Properties prop) {
		this.page = page;
		this.prop= prop;
	}
	
	public Dashboard doLogin() throws InterruptedException {
		
		String email = prop.getProperty("email");
		String gitPassword = prop.getProperty("password");
//		System.out.println(email);
		page.locator(username).fill(email);
		System.out.println("entered email");
		
		page.locator(password).fill(gitPassword);
		System.out.println("entered password");
		
		page.locator(submitBtn).click();
		System.out.println("Clicked on login button");
		
		Thread.sleep(3000);
		
		return new Dashboard(page);
	}
	
	
}
