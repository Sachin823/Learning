package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class ActiTimeLoginPage
{
	
	SeleniumLib slib;
	@FindBy(how=How.XPATH,using="(//span[@class='errormsg'])[1]")
	private WebElement pageTitle;
	
	public ActiTimeLoginPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	// loginPageverification feature
	public void verifyLogin()
	{
		String Expected="Username or Password is invalid. Please try again.";
		 String Actual = pageTitle.getText();
		 slib.validateString(Expected, Actual, "login page(ActiTime login)is displayed");
		 
		 String expTitle="actiTIME - Login";
		 slib.validatePageTitle(expTitle, "Login Page(actiTIME - Login)title is verified");
	}

}
