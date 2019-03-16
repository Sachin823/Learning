package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class CreateNewCustPage 
{
	SeleniumLib slib;
	
	@FindBy(how=How.NAME,using="name")
	private WebElement custNameTxtBx;
	
	@FindBy(how=How.NAME,using="createCustomerSubmit")
	private WebElement createcustSubmitbtn;
	
	public CreateNewCustPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}

	public void createcustSubmitbtn(String customerName)
	{
		slib.enterData(custNameTxtBx, customerName);
		slib.clickElement(createcustSubmitbtn);
	}
}
