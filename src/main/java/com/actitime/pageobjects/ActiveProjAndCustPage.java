package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class ActiveProjAndCustPage extends BasePage
{
	SeleniumLib slib;
	
	@FindBy(how=How.CSS,using="input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(how=How.CLASS_NAME,using="successmsg")
	private WebElement successMsg;
	@FindBy(how=How.NAME,using="selectedCustomer")
	private WebElement customerDrpdwn;
	@FindBy(how=How.CSS,using="input[value*='Show']")
	private WebElement showBtn;
	@FindBy(how=How.XPATH,using="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private WebElement customerLink;
	@FindBy(how=How.CSS,using="input[value='Create New Project']")
	private WebElement createNewProjectBtn;
	@FindBy(how=How.XPATH,using="(//td[@valign='middle']/a)[3]")
	private WebElement Projectlink;
	
	public ActiveProjAndCustPage(WebDriver driver)
	{
		super(driver);
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	//step definition
     public void clickOncreateNewCustBtn()
    {
	
    	 slib.clickElement(createNewCustBtn);
     }
     
     //stepDefinition
     public void verifyCreateCustMsg(String customerName)
     {
    	 String expMsg="Customer \""+customerName+"\" has been successfully created.";
    	 String actMsg = successMsg.getText();
    	 slib.validateString(expMsg, actMsg, actMsg);
     }
     
     
     public void showcustomer(String customerName)
     {
    	 slib.selectOptionByText(customerDrpdwn, customerName);
    	 slib.clickElement(showBtn);
    	 slib.clickElement(customerLink);
     }
     
     public void verifyDelCustMsg()
     {
    	 String expMsg="Customer has been successfully deleted.";
    	 String actMsg = successMsg.getText();
    	 slib.validateString(expMsg, actMsg, actMsg);
     }
     public void createNewprojectBtn()
     {
    	 slib.clickElement(createNewProjectBtn);
     }
     
     public void verifyCreateprojMsg(String projName)
     {
    	 String expMsg="Project \""+projName+"\" has been successfully created.";
    	 String actMsg = successMsg.getText();
    	 slib.validateString(expMsg, actMsg, actMsg);
     }
     
     public void clickOnProject()
     {
    	 slib.clickElement(Projectlink);
     }
     
     public void verifyDeleteprojMsg()
     {
    	 String expMsg="Project has been successfully deleted.";
    	 String actMsg = successMsg.getText();
    	 slib.validateString(expMsg, actMsg, actMsg);
     }
     
     
     
     
     
     public void verifyCreateTaskMsg(String customername,String projName)
     {
    	 String expMsg="1 new task was added to the customer \""+customername+"\", project \""+projName+"\".";
    	 String actMsg = successMsg.getText();
    	 slib.validateString(expMsg, actMsg, actMsg);
     }
     
     
     public void verifyDeleteTaskMsg()
     {
    	 String expMsg="Task has been successfully deleted.";
    	 String actMsg = successMsg.getText();
    	 slib.validateString(expMsg, actMsg, actMsg);
     }
     
     
     public void verifyCreateUserMsg()
     {
    	 String expMsg="User account has been successfully created.";
    	 String actMsg = successMsg.getText();
    	 slib.validateString(expMsg, actMsg, actMsg);
     }
     
     
     
     
    
     
     
     
     
     

}
