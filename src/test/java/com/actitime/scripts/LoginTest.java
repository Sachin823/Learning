package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.ActiTimeLoginPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;

public class LoginTest extends BaseTest
{
	@Test()
	public void validLogin()
	{
		String filepath="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filepath, "Sheet1", 1, 1);
		String password = ExcelUtilities.readData(filepath, "Sheet1", 1, 2);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.verifyEnterTimeTrack();
	}
	
	@Test(dependsOnMethods="validLogin")
	public void invalidLogin()
	{
		String filepath = "./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filepath, "Sheet1", 2, 1);
		String password = ExcelUtilities.readData(filepath, "Sheet1", 2, 2);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
	      
	      ActiTimeLoginPage atlp=new ActiTimeLoginPage(driver);
	      atlp.verifyLogin();
	}

}
