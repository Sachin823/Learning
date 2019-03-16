package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class EditProjInfoPage 
{
	SeleniumLib slib;
	
	@FindBy(how=How.XPATH,using="//input[@value='Delete This Project']")
	private WebElement deleteprojectBtn;
	
	@FindBy(how=How.ID,using="deleteButton")
	private WebElement confirmDelete;
	
	
	public EditProjInfoPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void deleteproject()
	{
		slib.clickElement(deleteprojectBtn);
		slib.clickElement(confirmDelete);
	}

}
