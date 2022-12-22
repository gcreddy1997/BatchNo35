package org.Selenium.GcReddy.batchNo32;

import org.Selenium.batchNo32.Reports.Reports;
import org.testng.annotations.Test;

public class ReportsCaller {
  @Test
  public void testcase1() {
	  Reports.startTest("TestCase1", "Test case one is executing");
	  Reports.info("Step1", "Step1 is executing");
	  Reports.pass("STep2", "This is pass test step");
	  Reports.endTest();
  }
  
  @Test
  public void testcase2() {
	  Reports.startTest("TestCase2", "Test case two is executing");
	  Reports.info("Step1", "Step1 is executing");
	  Reports.pass("STep2", "This is pass test step");
	  Reports.fail("Step3", "It is fail test case", "screenshot.png");
	  Reports.endTest();
	  Reports.flush();
  }
  
  @Test
  public void testcase3() {
	  Reports.startTest("TestCase3", "Test case two is executing");
	  Reports.info("Step1", "Step1 is executing");
	  Reports.pass("STep2", "This is pass test step");	 
	  Reports.warn("Step4", "it is a working");
	  Reports.endTest();
	  Reports.flush();
  }
}
