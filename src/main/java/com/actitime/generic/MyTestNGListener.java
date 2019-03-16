package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.actitime.scripts.BaseTest;
import com.google.common.io.Files;

public  class MyTestNGListener implements ITestListener
{
	
public static int executionCount,passCount,failcount,skipCount=0;

public void onTestStart(ITestResult result)
{
	executionCount++;
	Reporter.log(result.getName()+" script execution starts"+ new Date(),true);
	
}

public void onTestSuccess(ITestResult result) 
{
	
	passCount++;
	Reporter.log(result.getName()+" script is passed"+ new Date(),true);
}

public void onTestFailure(ITestResult result) 
{
	failcount++;
	Reporter.log(result.getName()+" script is failed"+ new Date(),true);
	TakesScreenshot ts=(TakesScreenshot)BaseTest.driver;
	File srcFile = ts.getScreenshotAs(OutputType.FILE);
	File destfile = new File("./Screenshots/"+result.getName()+".png");
	try
	{
		Files.copy(srcFile, destfile);
	}
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	Reporter.log("Screenshot is been taken",true);
}

public void onTestSkipped(ITestResult result) 
{
  skipCount++;	
  Reporter.log(result.getName()+" script is skipped"+ new Date(),true);
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result)
{
	            
	
}

public void onStart(ITestContext context)
{
	Reporter.log("Suite execution starts"+ new Date(),true);
	
}

public void onFinish(ITestContext context) 
{
	Reporter.log("Suite execution Ends"+ new Date(),true);
	Reporter.log("total scripts executed:"+executionCount,true);
	Reporter.log("Total scripts Passed:"+ passCount,true);
	Reporter.log("Total scripts failes:"+ failcount,true);
	Reporter.log("Total scripts skipped:"+ skipCount,true);

	
}
	
}
