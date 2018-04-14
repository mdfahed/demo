package com.fahed.automation.demo.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fahed.automation.demo.testBase.TestBase;
import com.fahed.automation.demo.uiActions.HomePage;

public class TC002_VerifyHomePageUsingParemetersFromJenkins extends TestBase {
	

	public static final Logger log = Logger.getLogger(TC001_VerifyHomePage.class.getName());
	public HomePage homePage;
		

	@BeforeClass
	public void setUp() throws IOException {
		//u can add these below url,browser,environment in your TestBase.java
		String browser=System.getProperty("browser");
		System.out.println("-------"+browser);
		String url=System.getProperty("url");
		System.out.println("-------"+url);
		String environment=System.getProperty("environment");
		System.out.println("-------"+environment);
		
		selectBrowser(browser);
		getUrl(url);
	}

	@Test
	public void verifyHomePageOpened() {
		try {
			String expectedTitle="Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More";
			log.info("=======started verifyHomePageOpened Test===========");
					homePage = new HomePage(driver);
					
			Assert.assertEquals(homePage.isHomePageMessageDsplayed(),expectedTitle );
			log.info("=======finished verifyHomePageOpened Test===========");
			
		} catch (AssertionError e) {
			
			Assert.assertTrue(false, "verifyRegistration");
		} catch (Exception e) {
			log.info(e.fillInStackTrace().toString());
			
			Assert.assertTrue(false, "verifyRegistration");
		}
	}

	@AfterClass
	public void endTest(){
	driver.close();
	}

}
