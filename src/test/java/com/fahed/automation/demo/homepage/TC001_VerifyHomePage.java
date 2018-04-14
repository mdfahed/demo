package com.fahed.automation.demo.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fahed.automation.demo.testBase.TestBase;
import com.fahed.automation.demo.uiActions.HomePage;


public class TC001_VerifyHomePage extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC001_VerifyHomePage.class.getName());
	public HomePage homePage;
		

	@BeforeClass
	public void setUp() throws IOException {
		init();
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
