package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class CreateNewUserPage
{
	SeleniumLib slib;
	@FindBy(how=How.NAME,using="username")
	private WebElement userNameTxtBx;
	@FindBy(how=How.NAME,using="passwordText")
	private WebElement pwdTxtbx;
	@FindBy(how=How.NAME,using="passwordTextRetype")
	private WebElement pwdReTxtBx;
	@FindBy(how=How.NAME,using="firstName")
	private WebElement fstnametxtBx;
	@FindBy(how=How.NAME,using="lastName")
	private WebElement lstNameTxtBx;
	@FindBy(how=How.NAME,using="email")
	private WebElement emailTxtBx;
	
	@FindBy(how=How.CSS,using="input[value*='Create User']")
	private WebElement createUserBtn;

	public CreateNewUserPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void userName(String username)
	{
		slib.enterData(userNameTxtBx, username);
	}
	
	public void passWord(String pwd)
	{
		slib.enterData(pwdTxtbx,pwd );
	}
	
	public void reEnterPassword(String rePwd)
	{
		slib.enterData(pwdReTxtBx, rePwd);
	}
	
	public void firstName(String fname)
	{
		slib.enterData(fstnametxtBx, fname);
	}
	
	public void lastName(String lname)
	{
		slib.enterData(lstNameTxtBx, lname);
	}
	
	public void email(String mail)
	{
		slib.enterData(emailTxtBx, mail);
	}
	
	public void clickOnCreateUserBtn()
	{
		slib.clickElement(createUserBtn);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
