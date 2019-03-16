package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.ExcelUtilities;
import com.actitime.generic.SeleniumLib;
import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewUserPage;
import com.actitime.pageobjects.EditUserSettingsPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.UserListPage;

public class UsersTest extends BaseTest
{
    SeleniumLib slib;
    
    @Test()
    public void CreateNewUser()
    {

  	  String filepath="./testdata/testdata.xlsx";
  		String username = ExcelUtilities.readData(filepath, "Sheet1", 9, 1);
  		String password = ExcelUtilities.readData(filepath, "Sheet1", 9, 2);
  		
  		
  		LoginPage lp=new LoginPage(driver);
  		lp.login(username, password);
    	lp.clickOnUsers();
    	
    	UserListPage ulp=new UserListPage(driver);
    	ulp.clickOnCreateNewUser();
    	
    	String un = ExcelUtilities.readData(filepath, "Sheet1", 9, 3);
    	String pwd = ExcelUtilities.readData(filepath, "Sheet1", 9, 4);
    	String fname = ExcelUtilities.readData(filepath, "Sheet1", 9, 5);
    	String lname = ExcelUtilities.readData(filepath, "Sheet1", 9, 6);
    	String mail = ExcelUtilities.readData(filepath, "Sheet1", 9, 7);
    	
    	
    	CreateNewUserPage cnup=new CreateNewUserPage(driver);
    	cnup.userName(un);
    	cnup.passWord(pwd);
    	cnup.reEnterPassword(pwd);
    	cnup.firstName(fname);
    	cnup.lastName(lname);
    	cnup.email(mail);
    	cnup.clickOnCreateUserBtn();
    	
    	
    	ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
    	apcp.verifyCreateUserMsg();
    	apcp.clickOnLogout();
    	
    }
    
    
    @Test(dependsOnMethods="CreateNewUser")
    public void verifyNewUser()
    {
    	 String filepath="./testdata/testdata.xlsx";
   		String username = ExcelUtilities.readData(filepath, "Sheet1", 10, 1);
   		String password = ExcelUtilities.readData(filepath, "Sheet1", 10, 2);
   		
   		
   		LoginPage lp=new LoginPage(driver);
   		lp.login(username, password);
     	
     	
     	EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
     	ettp.verifyEnterTimeTrack();
     	ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
     	apcp.clickOnLogout();
    }
    
    
    @Test(dependsOnMethods="verifyNewUser")
    public void deleteUser()
    {
    	 String filepath="./testdata/testdata.xlsx";
   		String username = ExcelUtilities.readData(filepath, "Sheet1", 9, 1);
   		String password = ExcelUtilities.readData(filepath, "Sheet1", 9, 2);
   		
   		
   		LoginPage lp=new LoginPage(driver);
   		lp.login(username, password);
   		lp.clickOnUsers();
   		
   		UserListPage ulp=new UserListPage(driver);
   		ulp.clickOnUserLink();
   		
   		EditUserSettingsPage eusp=new EditUserSettingsPage(driver);
   		eusp.deleteUserBtn();
   		
   		ulp.verifyDeleteUser();
    }
     	
    }
    