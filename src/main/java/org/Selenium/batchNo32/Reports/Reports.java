package org.Selenium.batchNo32.Reports;

import java.util.HashMap;
import java.util.Map;

import org.Selenium.batchNo32.Constants.Constant;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jdk.internal.org.jline.utils.Log;

public class Reports {

	// create a variable for extent Reports..
	public static ExtentReports reports = new ExtentReports(Constant.ReportsPath, false);
	public static ExtentTest test;

	public static void startTest(String Testcasename, String Description) {
		test = reports.startTest(Testcasename, Description);
		addSystemInfo();
		test.assignCategory("Regression");
		test.assignAuthor("Venkat");
	}

	public static void addSystemInfo() {
		// mapping the system time to selenium code
		Map<String, String> Sysinfo = new HashMap<String, String>();
		Sysinfo.put("Selenium Versin", "3.141.0");
		reports.addSystemInfo(Sysinfo);
	}

	public static void info(String testStepname, String details) {
		test.log(LogStatus.INFO, testStepname, details);
	}

	public static void pass(String testStepname, String details) {
		test.log(LogStatus.PASS, testStepname, details);
	}

	public static void fail(String testStepname, String details, String imagePath) {
		test.log(LogStatus.FAIL, testStepname, details + test.addScreenCapture(imagePath));
	}

	public static void warn(String testStepname, String details) {
		test.log(LogStatus.WARNING, testStepname,
				"<Span style ='font-Weight:Bold; color:Red'>" + details + "</span>");
	}

	public static void fatal(String testStepname, String details) {
		test.log(LogStatus.FATAL, testStepname, details);
	}

	public static void endTest() {
		reports.endTest(test);
	}

	public static void flush() {
		reports.flush();
	}

}
