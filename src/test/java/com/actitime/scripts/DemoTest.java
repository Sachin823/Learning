package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.ExcelUtilities;

public class DemoTest extends BaseTest
{

	@Test
	public void demoTest()
	{
		System.out.println("Demo Test");
		String filepath = "./testdata/new.xlsx";
		String value = ExcelUtilities.readData(filepath, "Sheet1", 0, 0);
		System.out.println(value);
	}
}
