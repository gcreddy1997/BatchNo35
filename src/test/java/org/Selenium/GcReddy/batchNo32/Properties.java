package org.Selenium.GcReddy.batchNo32;

import java.io.FileNotFoundException;

import org.Selenium.batchNo32.Reports.Reports;
import org.Selenium.batchNo32.Utility.Utility;
import org.testng.annotations.Test;

public class Properties {
  @Test
  public void LoaidngProperties() throws FileNotFoundException, InterruptedException {
	  Reports.startTest("Locator invocation", "Locators invoked successfully" );
	  Utility.getLocator("Login_un_txtbox_id");
	  Utility.getLocator("Login_pw_txtbox_id");
	  Utility.getLocator("Login_submit_button_xpath");
	 Reports.endTest();
	 Reports.flush();
  }
}
