package org.Selenium.GcReddy.batchNo32;



import java.util.List;

import org.Selenium.batchNo32.Reports.Log;
import org.Selenium.batchNo32.Reports.Reports;
import org.Selenium.batchNo32.Utility.ExcelUtils;
import org.Selenium.batchNo32.Utility.Utility;
import org.Selenium.batchNo32.appModule.LaunchEnv1;
import org.Selenium.batchNo32.appModule.LoginActions;
import org.Selenium.batchNo32.appModule.LoginActions_multiple;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import jdk.internal.org.jline.utils.Log;

public class LoginActions_MultipleData extends LoginActions {
  @BeforeMethod
  public void OpenBrowserAndURL() throws InterruptedException {
	  Reports.startTest("LoginActions", "Executing the test case for Positive Data only");
	  Log.startTest("Login Actions for Multiple Data");
	  // launch browser..
	  Assert.assertTrue(LaunchEnv1.BrowserInvocation(prop_config.getProperty("Open_Browser")));
	  // launch URL
	  Assert.assertTrue(LaunchEnv1.invokeUrl(prop_config.getProperty("Uibank_url")));
  }  
           
  @Test (dataProvider ="ramu") // every column representation
  public  void Login_Runner_MultipleData(String rm, String un, String pw, String criteria, String ExpOutput, String result ) {	 
		  try {
	      List<WebElement> l1=		Utility.ElementCollection("");
	      Assert.assertTrue(LoginActions_multiple.loginforMultipleData(rm, un, pw, criteria, ExpOutput, result)) ;  
		 
		  }catch(Exception e) {
			  e.printStackTrace();
		  
		  System.out.println("It is executing for error message where runMode = NO...");
		  Log.info("It is executing for error message where runMode = NO...");
		  Reports.info("No data" , "It is executing for error message where runMode = NO...");	 
		  }		  
  }
      
  @AfterMethod
  public void closeBroser() {
	 LaunchEnv1.closeBrowser();
	 Reports.endTest();
	 Log.endTest();
  } 
  
  
  //Annotator
  @DataProvider (name="ramu")
  public static Object[][] ExcelSheetReading() {	  
	  Object[][] excelData = ExcelUtils.getData("UIbank_Data");
	return excelData;	 
  }
  

  
  
  }
  
  
 
  

