package com.fahed.automation.demo.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fahed.automation.demo.testBase.TestBase;

public class HomePage extends TestBase {
	
	
	
	@FindBy(xpath="//*[@id='container']/div/header/div[3]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[1]/a/span[1]")
	public WebElement homePageDisplayMsg;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//to check whether home page message displayed
	public String isHomePageMessageDsplayed()
	{
	String actualTitle=driver.getTitle();
	return actualTitle;
		
		
		
	}

}
