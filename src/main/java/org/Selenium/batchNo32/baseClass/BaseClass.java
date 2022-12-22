package org.Selenium.batchNo32.baseClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.Selenium.batchNo32.Constants.Constant;
import org.Selenium.batchNo32.Reports.Log;
import org.Selenium.batchNo32.Reports.Reports;
import org.Selenium.batchNo32.Utility.ExcelUtils;
import org.Selenium.batchNo32.Utility.Utility;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;



public class BaseClass {

	public static Properties prop_config;
	public static Properties prop_loct;

	@BeforeSuite
	public void intiliaseFiles() throws IOException {
		DOMConfigurator.configure("Log4j.xml");
		prop_config = Utility.loadProperty(Constant.config_path);
		prop_loct = Utility.loadProperty(Constant.locaters_path);
		ExcelUtils.invokeExcel(Constant.TestData_excel_path);
		Log.info("All files are invoked successfully");
	}

	@AfterTest
	public void FLushReports() {
		Reports.flush();
	}

}
