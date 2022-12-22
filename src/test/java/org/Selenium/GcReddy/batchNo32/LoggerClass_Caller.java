package org.Selenium.GcReddy.batchNo32;

import org.Selenium.batchNo32.Reports.Log;
import org.testng.annotations.Test;

public class LoggerClass_Caller {
  
	@Test
  public void TestCase1() {
		Log.startTest("Test Case 1");
			Log.info("General information is printing ");
			Log.pass(" Chrome browser invoked successfully" );
			Log.fail("Test case failed due to expected messages is differed ");
			Log.warn("The given data is not correct, hence using this data for execution");
			Log.fatal("Data base filled hence further execution is not possible");
		Log.endTest();
				
  }
	
	@Test
	public void TestCase2() {
		Log.startTest("Test Case 2");
			Log.info("General information is printing ");
			Log.pass(" Chrome browser invoked successfully" );
			Log.fail("Test case failed due to expected messages is differed ");
			Log.warn("The given data is not correct, hence using this data for execution");
			Log.fatal("Data base filled hence further execution is not possible");
	    Log.endTest();
	}
	
	@Test
	public void userIDFieldValidation() {
		Log.startTest("userID Field Validation");
			Log.info("Chrome invoked successfully");
			Log.info("The gmail url https://gmail.com is invoked successfully");
			Log.info("Entered valid userName in the text box ");
			Log.pass("Epected title is displaying in the gmail home page");
			Log.info("Entered Valid userName int he text box");
			Log.fail("Expected title is not displaying hence, test case will fail");
		Log.endTest();		
	}
}
