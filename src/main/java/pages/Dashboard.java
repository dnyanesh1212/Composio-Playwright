package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Dashboard {
	
	private Page page;
	
	private String toolscatalogue = "//span[.='Tools catalogue']";
	private String githubCard = "(//div[.='Github'])[1]";
	private String connectGithub = "//div[@class='w-[320px] max-w-[320px]']";
	private String saveBtn = "//button[.='Save']";
	
	private String connectToGitHubBtn = "//button[contains(text(),'Connect to ')]";
	
	private String close = "//div[@class='hover:bg-red absolute right-[20px] top-[24px] h-6 w-6 cursor-pointer rounded-[8px]']";
	private String connectedAccount= "(//span[.='Connected accounts'])[1]";
	private String openBtn = "(//button/div[.='Open'])[1]";
	private String exeAction = "//button[.='actions']";
	private String actionToBeExecuted = "(//button/div[.='Run'])[1]";
	private String runAction = "//div/button[.='Run action']";
	
	
	public Dashboard(Page page) {
		this.page=page;
	}
	
	public void connectGitHub() throws InterruptedException {
		page.locator(toolscatalogue).click();
		System.out.println("clicked on tools catalouge");
		page.locator(githubCard).click();
		page.locator(connectGithub).click();
		page.locator(saveBtn).click();
		page.locator(connectToGitHubBtn).click();
		page.locator(close).click();
//		page.locator(connectedAccount);
		page.locator(connectedAccount).click(new Locator.ClickOptions().setForce(true));
		System.out.println("clicked on Connected account");
		page.locator(openBtn).click();
		page.locator(exeAction).click();
		System.out.println("Action started");
		page.locator(actionToBeExecuted).click();
		page.click(runAction);
		Thread.sleep(5000);
		System.out.println("Action completd");
		
	}

}
