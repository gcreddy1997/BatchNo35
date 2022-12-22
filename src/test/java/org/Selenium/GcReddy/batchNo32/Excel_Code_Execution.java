package org.Selenium.GcReddy.batchNo32;

import java.io.IOException;

import org.Selenium.batchNo32.Reports.Reports;
import org.Selenium.batchNo32.Utility.ExcelUtils;
import org.testng.annotations.Test;

public class Excel_Code_Execution {
  @Test
  public void ExcelCodeExecution() throws IOException {
	  		  Reports.startTest("ABC", "xyz");
	          ExcelUtils.invokeExcel("C:\\Users\\User\\eclipse-workspace\\org.Selenium.GcReddy.batchNo32\\src\\test\\resources\\Test Data\\inputData1.xlsx");
        	  ExcelUtils.getData("Rama");
        	  ExcelUtils.SetExcelData("anusha.xlsx", "Success", 6, 5);
  }
}
