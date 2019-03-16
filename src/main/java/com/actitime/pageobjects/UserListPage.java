package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class UserListPage
{

	SeleniumLib slib;
	@FindBy(how=How.XPATH,using="//span[text()='Create New User']")
	private WebElement createnewUserBtn;
	@FindBy(how=How.XPATH,using="(//td[contains(@class,'userNameTableCell ')]/a)[1]")
	private WebElement userLink;
	@FindBy(how=How.CSS,using="span[class='successmsg']")
	private WebElement deleteMsg;
	
	public UserListPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCreateNewUser()
	{
		slib.clickElement(createnewUserBtn);
	}
	
	public void clickOnUserLink()
	{
		slib.clickElement(userLink);
	}
	
	
	public void verifyDeleteUser()
	{
		String expMsg = "User account has been successfully deleted.";
		String actMsg = deleteMsg.getText();
		slib.validateString(expMsg, actMsg, expMsg);
	}
	
	
	
	
	
	
	
	
	
	
}
