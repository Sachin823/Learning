package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class CreateNewProjectPage 
{
	SeleniumLib slib;
	
	@FindBy(how=How.NAME,using="customerId")
	private WebElement selectcust;
	@FindBy(how=How.NAME,using="name")
	private WebElement projName;
	@FindBy(how=How.NAME,using="createProjectSubmit")
	private WebElement createprojBtn;
	
	public CreateNewProjectPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
		
	}
	
      public void selectCustomer(String customername)
      {
    	  slib.selectOptionByText(selectcust, customername);
    	  slib.clickElement(selectcust);
      }
	
	public void createNewProjectBtn(String projectName)
	{
		slib.enterData(projName,projectName);
	}
	
	
	
	 public void clickonCreateproj()
	 {
		 slib.clickElement(createprojBtn);
	 }
}
