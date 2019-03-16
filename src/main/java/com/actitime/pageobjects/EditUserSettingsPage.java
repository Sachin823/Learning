package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class EditUserSettingsPage 
{
	SeleniumLib slib;
	@FindBy(how=How.CSS,using="input[value='Delete This User']")
	private WebElement deleteUser;
	
	public EditUserSettingsPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}

	
	
	public void deleteUserBtn()
	{
		slib.clickElement(deleteUser);
		slib.acceptPopUp();
	}
}
