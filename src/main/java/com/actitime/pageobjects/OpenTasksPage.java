package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class OpenTasksPage 
{
	SeleniumLib slib;
	@FindBy(how=How.LINK_TEXT,using="Projects & Customers")
	private WebElement projNcustLink;
	
	@FindBy(how=How.CSS,using="input[value='Create New Tasks']")
    private WebElement createNewTaskBtn;
	
	@FindBy(how=How.CSS,using="a[href*='taskId']")
	private WebElement tasklLink;
	
	public OpenTasksPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickonprojNcustLink()
	{
		slib.clickElement(projNcustLink);
	}
	
	public void clickOnTaskBtn()
	{
		slib.clickElement(createNewTaskBtn);
	}
	
	public void clickOnTaskLink()
	{
		slib.clickElement(tasklLink);
	}
}
