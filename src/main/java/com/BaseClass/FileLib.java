package com.BaseClass;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author hp
 *
 */
public class FileLib {
	
	public static String readExcelData(String path, String sheetName, int rowNo, int cellNo) throws Throwable {
		
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		Workbook wb = WorkbookFactory.create(fis);
		String excelValue = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).toString();
		return excelValue;
				
	}
	
	public static void	writeExcelData(String path, String sheetName, int rowNo, int cellNo, String data) throws Throwable {
		
		FileInputStream fis = new FileInputStream(path);
		Workbook wbf = WorkbookFactory.create(fis);
		wbf.getSheet(sheetName).getRow(rowNo).createCell(cellNo).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(path);
		wbf.write(fos);
		
	}
	
	public static int getRowCount(String path, String sheetName) throws Throwable {
		
		FileInputStream fis = new FileInputStream(path);
		Workbook wbf = WorkbookFactory.create(fis);
		int rowCount = wbf.getSheet(sheetName).getLastRowNum();
		return rowCount;
		
		

		
	}
	
	public static String readProprertyData(String proPath, String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(proPath);
		Properties prop = new Properties();
		prop.load(fis);
		String propValue = prop.getProperty(key, "Incorrect key");
		return propValue;
	}
	

}
