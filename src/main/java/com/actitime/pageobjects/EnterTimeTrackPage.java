package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class EnterTimeTrackPage extends BasePage
{
	SeleniumLib slib;
	@FindBy(how=How.XPATH,using="(//td[@class='pagetitle'])[2]")
	private WebElement pageTitle;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//home page verification featureE
	public void verifyEnterTimeTrack() 
	{
		String Expected="Enter Time-Track";
		 String Actual = pageTitle.getText();
		 slib.validateString(Expected, Actual, "Home page(Enter Time Track)is displayed");
//		 
		 String expTitle="actiTIME - Enter Time-Track";
		 slib.validatePageTitle(expTitle, "Home Page(Enter Time Track)title is verified");
	}

}
