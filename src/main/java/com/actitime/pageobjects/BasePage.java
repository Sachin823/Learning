package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public abstract class BasePage 
{
	SeleniumLib slib;
	
	@FindBy(how=How.XPATH,using="//div[text()='Tasks']")
	private WebElement tasks;
	@FindBy(how=How.ID,using="logoutLink")
	private WebElement logout;
	
	public BasePage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}

	//step definition
	public void clickonTasks()
	{
		slib.clickElement(tasks);
	}
	
	public void clickOnLogout()
	{
		slib.clickElement(logout);
	}
}
