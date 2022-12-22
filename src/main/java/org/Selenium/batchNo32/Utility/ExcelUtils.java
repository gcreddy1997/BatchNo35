package org.Selenium.batchNo32.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.Selenium.batchNo32.Reports.Reports;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import jdk.internal.org.jline.utils.Log;

public class ExcelUtils {

	public static FileInputStream fis;
	public static XSSFWorkbook rwb;
	public static XSSFCell cell;
	public static XSSFSheet sheet;
	public static XSSFCell cell1;
	public static FileOutputStream fout;

	/**
	 * 
	 * @param FilePath
	 * @author GcReddy
	 * @throws IOException 
	 * @This methid is involing the Provided excel sheet and verify wheter the
	 *       provided file is excel file or not...
	 */
	public static void invokeExcel(String FilePath) throws IOException {

/*		try {
			fis = new FileInputStream(FilePath);
			//Reports.startTest("ExcelUtilsExecution", "Excel utils execution checking");
			Reports.info("Excel Invocation", "Excel Invoked Successfully");
			Log.info("Excel" + FilePath + " Invoked successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // console
			Log.error(e.fillInStackTrace().toString()); // Log file
			Reports.fail("Invocation Excel", e.toString(), "");
		}

		try {
			rwb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  */ 
	     FileInputStream fis = new FileInputStream(FilePath);
		 rwb = new XSSFWorkbook(fis);

	}

	// ---------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param rowNum
	 * @param colNum
	 * @return String
	 * @author GcReddy @ This method is picking the value either String type of
	 * non-string using DataFormatter and stores into value as String type @ it will
	 * return String value....
	 */
	public static String getSepcifiecCellValue(int rowNum, int colNum) {
		String value = null;

		try {
			cell = sheet.getRow(rowNum).getCell(colNum);
			value = cell.getStringCellValue();
		} catch (Exception e) {
			cell = sheet.getRow(rowNum).getCell(colNum);
			DataFormatter format = new DataFormatter();
			value = format.formatCellValue(cell);
		}
		return value;
	}

	// ----------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param sheetName
	 * @return Object[][]
	 * @author gcreddy @ This method is demanding the sheetName and generating the
	 * Object[nur-1][nuc] and transfering the data from @ Excle sheet and store into
	 * Object[][] and return Objectg[][]....
	 */

	public static Object[][] getData(String sheetName) {
		// datatype name of the Array

		Object[][] excelData = null;
		sheet = rwb.getSheet(sheetName);
		// number of user rows
		int nur = sheet.getPhysicalNumberOfRows();
		int nuc = sheet.getRow(0).getPhysicalNumberOfCells();
		// generarign Object[][] using sheet data nur-1 and nuc...
		excelData = new Object[nur - 1][nuc];
		int ci = 0;
		int i = 1;
		// FOR I LOOP REPRESENTING THE ROWS
		for (i = 1; i < nur; i++, ci++) {
			int cj = 0;
			// J LOOP LOOP REPRESENTING THE COLUMNS
			int j = 0;
			for (j = 0; j < nuc; j++, cj++) {
				excelData[ci][cj] = getSepcifiecCellValue(i,j);
				System.out.println("Data store at index-- " + "Data[" + ci + "]" + "[" + cj + "]==>>" + "[" + i
						+ "]" + "[" + j + "]" + "--->" + excelData[ci][cj]);	
			}
		}

		return excelData;
	}
		
	//-------------------------------------------------------------------------------
	public static void SetExcelData(String Filepath, String Result, int rownum, int colnum ) {
		cell = sheet.getRow(rownum).createCell(colnum);
		cell.setCellValue(Result);
		try {
			 fout = new FileOutputStream(Filepath);

		} catch (FileNotFoundException e) {
			Reports.fail("outputFile","output file invocation failed", "");
			System.out.println("Unable to locate Excel ");
			e.printStackTrace();
		}
		try {
			rwb.write(fout);
		} catch (IOException e) {
			Reports.fail("", e.toString(),"");
			System.out.println("unable to set Excel Data");
		}
	}  
	//------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
