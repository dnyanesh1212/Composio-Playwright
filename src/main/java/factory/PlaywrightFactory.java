package factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	String path= "./src/test/resources/config/config.properties";

	
	public Page initBrowser(Properties prop) {
		
		String browserName= prop.getProperty("browser").trim();
		System.out.println(browserName + "browser started");
		playwright = Playwright.create();

		switch (browserName) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
			break;
		case "firefoc":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(100));
			break;

		default:
			break;

		}
		
		browserContext = browser.newContext();
		page = browserContext.newPage();
		String url = prop.getProperty("url").trim();
		page.navigate(url);
		return page;

	}
	
	public Properties init_prop() {
		try {
			FileInputStream fis = new FileInputStream(path);
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}
	

}
