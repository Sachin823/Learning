package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class CreateNewTaskPage
{
	SeleniumLib slib;
	
	@FindBy(how=How.NAME,using="customerId")
	private WebElement customerTxtBox;
	@FindBy(how=How.NAME,using="projectId")
	private WebElement projectTxtBox;
    @FindBy(how=How.NAME,using="task[0].name")
    private WebElement taskTxtBox;
    @FindBy(how=How.NAME,using="task[0].deadline")
    private WebElement deadlineTxtBox;
    @FindBy(how=How.NAME,using="task[0].billingType")
    private WebElement billTypeTxtBox;
    @FindBy(how=How.NAME,using="task[0].markedToBeAddedToUserTasks")
    private WebElement addToMyTask;
    @FindBy(how=How.CSS,using="input[value='Create Tasks']")
    private WebElement createTaskBtn;
    
    
    
    public CreateNewTaskPage(WebDriver driver)
    {
    	slib=new SeleniumLib(driver);
    	PageFactory.initElements(driver, this);
    }
    
    public void selectCustomer(String customername)
    {
    	slib.selectOptionByText(customerTxtBox, customername);
    	
    }
    
    public void selectProject(String projName)
    {
    	slib.selectOptionByText(projectTxtBox, projName);
    }
    
    public void createNewTaskBx(String taskname)
    {
    	slib.enterData(taskTxtBox, taskname);
     }
    
    public void createDeadlineTaskBx(String deadline)
    {
    	slib.enterData(deadlineTxtBox, deadline);
    }
    
    public void selectBillTypeBx(String billtype)
    {
    	slib.selectOptionByText(billTypeTxtBox, billtype);
    }
    
    public void selectMyTimeTrack()
    {
    	slib.clickElement(addToMyTask);
    }
    
    public void clickOnCreateTaskBtn()
    {
    	slib.clickElement(createTaskBtn);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
