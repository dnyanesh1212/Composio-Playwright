package pages;

import java.util.Properties;

import com.microsoft.playwright.Page;


public class HomePage {
	
	private Page page;
	Properties prop;
	protected LoginPage loginpage;
	private String loginWithGithubButton = "(//button[@title='Get Magic Link'])[1]";

	public HomePage(Page page, Properties prop) {
		this.page=page;
		this.prop=prop;
		
	}

	public LoginPage clickContinueWithGoogle() {
		page.locator(loginWithGithubButton).click();
		System.out.println("landed on homepage");
		return new LoginPage(page,prop);
	}

}
