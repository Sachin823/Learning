package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class EditCustInfo 
{
	SeleniumLib slib;
	@FindBy(how=How.CSS,using="input[value='Delete This Customer']")
	private WebElement deleteCust;
	
	@FindBy(how=How.ID,using="deleteButton")
	private WebElement deleteCustBtn;
	@FindBy(how=How.CLASS_NAME,using="successmsg")
	private WebElement successMsg;
	
	public EditCustInfo(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void createCustDelBtn()
	{
		slib.clickElement(deleteCust);
		slib.clickElement(deleteCustBtn);
	}
	
	 
    //stepDefinition
//    public void verifyDelCustMsg()
//    {
//   	 String expMsg="Customer has been successfully deleted.";
//   	 String actMsg = successMsg.getText();
//   	 slib.validateString(expMsg, actMsg, actMsg);
//    }

}
