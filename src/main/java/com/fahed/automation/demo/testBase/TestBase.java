package com.fahed.automation.demo.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;

	public Properties OR = new Properties();

	public WebDriver getDriver() {
		return driver;
	}

	//loading data from config file
	public void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java//com\\fahed\\automation\\demo\\config\\config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);

	}

	public void init() throws IOException {
		loadData();
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		System.out.println(OR.getProperty("browser"));
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
	}

	public void selectBrowser(String browser) {
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				// driver = new EventFiringWebDriver(dr);
				// eventListener = new WebEventListener();
				// driver.register(eventListener);
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				// System.setProperty("webdriver.gecko.driver",
				// System.getProperty("user.dir") +
				// "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();

			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();
				// driver = new EventFiringWebDriver(dr);
				// eventListener = new WebEventListener();
				// driver.register(eventListener);
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.firefox.marionette",
						System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();

			}
		}
	}

	public void getUrl(String url) {
		log.info("navigating to :-" + url);
		driver.get(url);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void waitForElement(WebDriver driver, WebElement element,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
