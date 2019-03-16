package com.actitime.scripts;


import org.testng.annotations.Test;

import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjectPage;
import com.actitime.pageobjects.CreateNewTaskPage;
import com.actitime.pageobjects.EditCustInfo;
import com.actitime.pageobjects.EditProjInfoPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTasksPage;
import com.actitime.pageobjects.ViewOpenTaskPage;


public class TaskTest extends BaseTest
{
/**
 * @author Sachin
 * created on 12th Feb 2019 at 3:30pm
 * 
 */
	@Test(description="Create New  Customer")
	public void createNewCustomer()
	{
		/**
		 * @author Ranjha
		 */
		String filepath="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filepath, "Sheet1", 3, 1);
		String password = ExcelUtilities.readData(filepath, "Sheet1", 3, 2);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickonTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickonprojNcustLink();
		
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.clickOncreateNewCustBtn();
		
		
		String customerName = ExcelUtilities.readData(filepath, "Sheet1", 3, 3);
		CreateNewCustPage cncp=new CreateNewCustPage(driver);
		cncp.createcustSubmitbtn(customerName);
		
		apcp.verifyCreateCustMsg(customerName);
		
		apcp.clickOnLogout();
		
	}
	
	@Test(dependsOnMethods="deleteProject")
	public void deletecustomer()
	{
		String filepath="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(filepath, "Sheet1", 4, 1);
		String password = ExcelUtilities.readData(filepath, "Sheet1", 4, 2);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickonTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickonprojNcustLink();
		
		
		String customerName=ExcelUtilities.readData(filepath, "Sheet1", 4, 3);
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.showcustomer(customerName);
		
		EditCustInfo eci=new EditCustInfo(driver);
		eci.createCustDelBtn();
		
		
		apcp.verifyDelCustMsg();
		apcp.clickOnLogout();
		
	}
	

	@Test(dependsOnMethods="createNewCustomer")
      public void createproject()
      {
    	  String filepath="./testdata/testdata.xlsx";
  		String username = ExcelUtilities.readData(filepath, "Sheet1", 5, 1);
  		String password = ExcelUtilities.readData(filepath, "Sheet1", 5, 2);
  		
  		
  		LoginPage lp=new LoginPage(driver);
  		lp.login(username, password);
  		
  		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
  		ettp.clickonTasks();
  		
  		OpenTasksPage otp=new OpenTasksPage(driver);
  		otp.clickonprojNcustLink();
  		
  		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
  		apcp.createNewprojectBtn();
  		
  		
  		String customerName = ExcelUtilities.readData(filepath, "Sheet1", 5, 3);
  		String projName = ExcelUtilities.readData(filepath, "Sheet1", 5, 4);
  		CreateNewProjectPage cnpp=new CreateNewProjectPage(driver);
  		cnpp.selectCustomer(customerName);
  		cnpp.createNewProjectBtn(projName);
  		cnpp.clickonCreateproj();
  		apcp.verifyCreateprojMsg(projName);
  		
  		apcp.clickOnLogout();
      }
		
      @Test(dependsOnMethods="deleteTask")
      public void deleteProject()
      {
    	  String filepath="./testdata/testdata.xlsx";
    		String username = ExcelUtilities.readData(filepath, "Sheet1", 5, 1);
    		String password = ExcelUtilities.readData(filepath, "Sheet1", 5, 2);
    		
    		
    		LoginPage lp=new LoginPage(driver);
    		lp.login(username, password);
    		
    		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
    		ettp.clickonTasks();
    		
    		OpenTasksPage otp=new OpenTasksPage(driver);
    		otp.clickonprojNcustLink();
    		
    		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
    		apcp.clickOnProject();
    		
    		EditProjInfoPage epif=new EditProjInfoPage(driver);
    		epif.deleteproject();
    		apcp.verifyDeleteprojMsg();
    		
    		apcp.clickOnLogout();
      }
      
      
      @Test(dependsOnMethods="createproject")
      public void createNewTask()
      {
    	  
    	  
    	  String filepath="./testdata/testdata.xlsx";
  		String username = ExcelUtilities.readData(filepath, "Sheet1", 5, 1);
  		String password = ExcelUtilities.readData(filepath, "Sheet1", 5, 2);
  		
  		
  		LoginPage lp=new LoginPage(driver);
  		lp.login(username, password);
  		
  		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
  		ettp.clickonTasks();
  		
    	OpenTasksPage otp=new OpenTasksPage(driver);
    	otp.clickOnTaskBtn();
    	
    	
    	String customername = ExcelUtilities.readData(filepath, "Sheet1", 7, 3);
    	String projName = ExcelUtilities.readData(filepath, "Sheet1", 7, 4);
    	String taskname = ExcelUtilities.readData(filepath, "Sheet1", 7, 5);
    	String deadline = ExcelUtilities.readData(filepath, "Sheet1", 7, 6);
    	String billtype = ExcelUtilities.readData(filepath, "Sheet1", 7, 7);
    	
    	
    	
    	CreateNewTaskPage cntp=new CreateNewTaskPage(driver);
    	cntp.selectCustomer(customername);
    	cntp.selectProject(projName);
    	cntp.createNewTaskBx(taskname);
    	cntp.createDeadlineTaskBx(deadline);
    	cntp.selectBillTypeBx(billtype);
    	cntp.selectMyTimeTrack();
    	cntp.clickOnCreateTaskBtn();
    	
    	ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
    	
    	apcp.verifyCreateTaskMsg(customername, projName);
    	apcp.clickOnLogout();
    	  
      }

      
      @Test(dependsOnMethods="createNewTask")
      public void deleteTask()
      {
    	  String filepath="./testdata/testdata.xlsx";
    		String username = ExcelUtilities.readData(filepath, "Sheet1", 5, 1);
    		String password = ExcelUtilities.readData(filepath, "Sheet1", 5, 2);
    		
    		
    		LoginPage lp=new LoginPage(driver);
    		lp.login(username, password);
    		
    		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
    		ettp.clickonTasks();
    		
      	OpenTasksPage otp=new OpenTasksPage(driver);
      	
      	
      	otp.clickOnTaskLink();
      	
      	ViewOpenTaskPage votp=new ViewOpenTaskPage(driver);
      	votp.clickOnDeleteTask();
      	
      	ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
      	apcp.verifyDeleteTaskMsg();
      	apcp.clickOnLogout();
      	
      	
      	
      	
      	
      	
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
