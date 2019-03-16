package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class ViewOpenTaskPage 
{
	
	SeleniumLib slib;
	
	@FindBy(how=How.CSS,using="input[value='Delete This Task']")
	private WebElement deleteTask;
	
    @FindBy(how=How.CSS,using="input[value='Delete Task']")
    private WebElement deleteTaskBtn;
    
    
    public ViewOpenTaskPage(WebDriver driver)
    {
    	slib=new SeleniumLib(driver);
    	PageFactory.initElements(driver, this);
     }
    
    
    public void clickOnDeleteTask()
    {
    	slib.clickElement(deleteTask);
    	slib.clickElement(deleteTaskBtn);
    }
    
    
}
