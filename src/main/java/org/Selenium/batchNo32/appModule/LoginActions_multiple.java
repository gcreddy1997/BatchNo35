package org.Selenium.batchNo32.appModule;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.Selenium.batchNo32.Constants.Constant;
import org.Selenium.batchNo32.Reports.Log;
import org.Selenium.batchNo32.Reports.Reports;
import org.Selenium.batchNo32.Utility.Utility;
import org.testng.Assert;

//import jdk.internal.org.jline.utils.Log;

public class LoginActions_multiple extends Utility {
	public static boolean flag;

	public static Properties prop_loct;
	public static String actualOutput;

	public static boolean loginforMultipleData(String rm, String un, String pw, String criteria, String expOutput,
			String status) throws FileNotFoundException, InterruptedException {
		flag = false;
	if(rm.equalsIgnoreCase("Yes")) {
		try {
			prop_loct = Utility.loadProperty(Constant.locaters_path);

			Utility.getLocator("Login_un_txtbox_id").sendKeys(un);
			Utility.getLocator("Login_pw_txtbox_id").sendKeys(pw);
			Utility.getLocator("Login_submit_button_xpath").click();

			if (criteria.equalsIgnoreCase("valid")) {
				actualOutput = Utility.getLocator("Home_sucMessage_message_xpath").getText();
				Assert.assertEquals(actualOutput, expOutput);
				Log.info("Test case passed");
				Reports.pass("for valid data", "Test case passed for valid data");
				flag = true;
			} else if (criteria.equalsIgnoreCase("invalid") && un == "") {
				actualOutput = Utility.getLocator("Login_errwithoutun_message_xpath").getText();
				Assert.assertEquals(actualOutput, expOutput);
				Log.info("Test case passed for invalid without un");
				Reports.pass("for invalid without un", "Test case passed for invalid data without username");
				flag = true;
			} else if (criteria.equalsIgnoreCase("invalid") && un != "") {
				actualOutput = Utility.getLocator("Login_errMessage_message_xpath").getText();
				Assert.assertEquals(actualOutput, expOutput);
				Log.info("Test case passed for invalid without un");
				Reports.pass("for invalid with un", "Test case passed for invalid data with username");
				flag = true;
			}else
				Log.info("Test case failed");
			    Reports.pass("Login Ations", "Test case failed");			
		} catch (Exception e) {
			Reports.fail("Login Actions", "Login Actions faile due to " + e.toString(), "");
			Log.fail("Login actions failed due to :" + e.fillInStackTrace().toString());
		}
		
	}else {
		System.out.println("Run mode is no for this data");
		
	}
	return flag;
	}
}
