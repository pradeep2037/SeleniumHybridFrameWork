package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class UtilKit extends BaseTest{

	static FileInputStream fis1 = null;

	public static HashMap<String, String> getTestDataFromExcel(String TestCase) {

		XSSFWorkbook workBook = null;
		try {
			fis1 = new FileInputStream("src\\test\\resources\\testdata\\excels\\TestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			workBook = new XSSFWorkbook(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFSheet workSheet = workBook.getSheet("Sheet1");

		ArrayList<Row> testCaseRows = getTestCaseRows(workSheet, TestCase);

		HashMap<String, String> testDataMap = new HashMap<String, String>();
		
		for (int i = 0; i < testCaseRows.size(); i++) {
			short TotalCells = testCaseRows.get(i).getLastCellNum();
			for (int j = 1; j < TotalCells; j++) {
				testDataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(),
						testCaseRows.get(1).getCell(j).getStringCellValue());
			}
		}
		return testDataMap;
	}

	private static ArrayList<Row> getTestCaseRows(XSSFSheet workSheet, String testCase) {

		ArrayList<Row> allRows = new ArrayList<Row>();

		for (int i = 0; i <= workSheet.getLastRowNum(); i++) {
			if (workSheet.getRow(i) != null) {
				allRows.add(workSheet.getRow(i));
			}
		}

		ArrayList<Row> testCaseRows = new ArrayList<Row>();

		for (int i = 0; i < allRows.size(); i++) {
			if (allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCase)) {
				testCaseRows.add(allRows.get(i));
			}
		}
		return testCaseRows;
	}
	
	
	public static String getScreenShot() {
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String date = simpleDateFormat.format(new Date());
		//System.out.println(date);
		date=date.replace(":", "-");
		System.out.println(date);
		
		String screenshotFilePath = System.getProperty("user.dir")+"\\screenshots\\"+date+".png";
		
		File screenshotFile=new File(screenshotFilePath);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screenshotFilePath;	
	}
}
