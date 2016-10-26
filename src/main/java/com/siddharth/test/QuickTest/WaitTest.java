package com.siddharth.test.QuickTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTest {
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		driver = new FirefoxDriver();
		driver.get("https://www.makemytrip.com/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='chf_header']")));
		System.out.println("page loaded.");

		String price = driver.findElement(By.xpath("")).getText().replace("$", "");
		double price1 = Double.parseDouble(price);
		driver.close();
		
		File excel = new File ("C:\\Users\\Siddhartha\\Desktop\\expense.xlx");
		FileInputStream fis = new FileInputStream(excel);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet ws = wb.getSheet("input");
		
		int rowNum = ws.getLastRowNum() +1;
		int colNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];
		
		for (int i=0;i < rowNum;i++)
		{
			HSSFRow row = ws.getRow(i);
			for (int j=0;j <colNum ;j++)
			{
				HSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				data [i][j] = value;
			}
		}
		
		
	}

	private static String cellToString(HSSFCell cell) {
		int type;
		Object result;
		type = cell.getCellType();
		
		switch (type)
		{
		case 0:
		result = cell.getNumericCellValue();
		break;
		
		case 1:
		result = cell.getStringCellValue();
		break;
		default:
			throw new RuntimeException("Not supported.");
		}
		return result.toString();
	}

	
	
}
