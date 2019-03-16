package com.actitime.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumLib 
{
	WebDriver driver;
	/*********************************constructor*************************/
	public SeleniumLib(WebDriver driver)
	{
		this.driver=driver;
	}
	/*************************************enterData*********************/
	public void enterData(WebElement txtBx,String input)
	{
		if(txtBx.getAttribute("value")!=null)
		{
			txtBx.clear();
			txtBx.sendKeys(input);
		}
		else
		{
			txtBx.sendKeys(input);
		}
	}
	
	/***************************************clickElement*************************/

	public void clickElement(WebElement element )
	{
		if (element.getTagName().equalsIgnoreCase("input")|| element.getTagName().equalsIgnoreCase("button")) 
		{
			if (element.getAttribute("type").equalsIgnoreCase("button"))
			{
				element.click();
			}
			else if(element.getAttribute("type").equalsIgnoreCase("Submit"))
			{
				element.submit();
			}
				else if(element.getAttribute("type").equalsIgnoreCase("checkbox"))
				{
					if (element.isSelected())
					{
						
					}
					else 
					{
						element.click();
					}
					
				}
				else if(element.getAttribute("type").contains("radiop"))
				{
					element.click();
				}
			}
		
		else if(element.getTagName().equals("a"))
		{
			element.click();
		}
		else if(element.getTagName().equals("img"))
		{
			element.click();
		}
		else if(element.getTagName().equals("span"))
		{
			element.click();
		}
		else if(element.getTagName().equals("div"))
		{
			element.click();
		}
	}
	/*****************************************************mouseOver*************************************************************/
	public void mouseOver(WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/*******************************************************selectOptionByText****************************************************/
	public void selectOptionByText(WebElement drpdwn,String optionText)
	{
		Select sel=new Select(drpdwn);
		sel.selectByVisibleText(optionText);
	}
	/*********************************************************iSleep**************************************************************/
	public void iSleep(int seconds)
	{
		try
		{
			Thread.sleep(seconds*1000);
			
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	/********************************************************ewaitForvisible****************************************************/
	public  WebElement eWaitforVisible(int seconds,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		WebElement wb=wait.until(ExpectedConditions.visibilityOf(element));
		return wb;
	}
	/*******************************************************ewaitForPresent******************************************************/
	public WebElement ewaitForPresent(int seconds,By locator)
	{
	WebDriverWait wait=new WebDriverWait(driver, seconds);
		WebElement wb=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return wb;
	}
	/****************************************************validateString**********************************************************/
	public void validateString(String expMsg,String actMsg,String message)
	{
	 Assert.assertEquals(actMsg, expMsg);
	 Reporter.log(message,true);
	 
	}
	/***************************************************validateBoolean*********************************************************/
	public void validateBoolean(WebElement element,String message)
	{
		Assert.assertTrue(element.isDisplayed());
		Reporter.log(message,true);
		
	}
	/***************************************************validateBoolean**********************************************************/
	public void validateBoolean(WebElement element,String ExpMsg,String message)
	{
		Assert.assertTrue(element.getText().contains(ExpMsg));
		Reporter.log(message,true);
	}
	
	/**************************************************validatePageTitle*******************************************************/
	public void validatePageTitle(String expMsg,String message)
	{
		String actMsg = driver.getTitle();
		validateString(expMsg, actMsg, message);
	}
	/*************************************************acceptPopUp******************************************/
	
	public void acceptPopUp()
	{
		driver.switchTo().alert().accept();
	}
	
}
