package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class LoginPage 
{
	SeleniumLib slib;
	
	@FindBy(how=How.NAME,using="username")
	private WebElement unTxtBx;
	@FindBy(how=How.NAME,using="pwd")
	private WebElement pwdtxtbx;
	
	@FindBy(how=How.ID,using="loginButton")
	private WebElement loginbtn;
     
	@FindBy(how=How.XPATH,using="//div[text()='Users']")
	private WebElement users;
	
	public LoginPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}

//	loginFeatures
	public void login(String username,String password)
	{
		slib.enterData(unTxtBx, username);
		slib.enterData(pwdtxtbx, password);
		slib.clickElement(loginbtn);
	}
	
	public void clickOnUsers()
	{
		slib.clickElement(users);
	}

}
