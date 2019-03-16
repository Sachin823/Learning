package com.actitime.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.actitime.generic.DriverFactory;

public abstract class BaseTest 
{
	
	public static WebDriver driver;
	@BeforeMethod
	@Parameters({"browser","baseurl"})
	public void preConditions(String browserName,String url)
	{
		driver=DriverFactory.launch(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(url);
		Reporter.log(url+" url navigated",true);
	}
@AfterMethod
public void postconditions()
{
	driver.close();
	Reporter.log(driver.getClass().getSimpleName()+"browser closed",true);
}
}
