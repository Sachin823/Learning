package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities 
{
	
	public static Workbook getworkbook(String filepath,FileInputStream fis) throws IOException
	{
		Workbook wb=null;
		if(filepath.contains(".xlsx"))
	{
		wb=new XSSFWorkbook(fis);
			
	}
		else if(filepath.contains(".xls"))
	{
			wb=new HSSFWorkbook(fis);
	}
		return wb;
	}
	

	public static String readData(String filepath,String sheet,int row,int cell)
	{
		String value=null;
		try
		{

			
			
			FileInputStream fis=new FileInputStream(new File(filepath));
			Workbook wb= getworkbook(filepath, fis);
			Cell cl = wb.getSheet(sheet).getRow(row).getCell(cell);
			
			switch (cl.getCellType())
			{
			case STRING:
				value=cl.getStringCellValue();
				
				break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cl))
				{
					Date date=cl.getDateCellValue();
					SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
					value=sdf.format(date);
				}
				else
				{
					int num=(int) cl.getNumericCellValue();
					value=Integer.toString(num);
				}
				
				break;
			case BOOLEAN:
				value=Boolean.toString(cl.getBooleanCellValue());
				
				break;

			default:
				System.out.println("Cell Format no Matching");
				break;
			}//end of switch
		}
			catch (IOException e) 
			{
				System.out.println(e.getClass().getSimpleName());
	
	}
		return value;
	}
	
	
	
	
	
}
