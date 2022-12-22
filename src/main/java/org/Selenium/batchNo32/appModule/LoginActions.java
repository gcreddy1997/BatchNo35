package org.Selenium.batchNo32.appModule;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.Selenium.batchNo32.Constants.Constant;
import org.Selenium.batchNo32.Reports.Log;
import org.Selenium.batchNo32.Reports.Reports;
import org.Selenium.batchNo32.Utility.Utility;

//import jdk.internal.org.jline.utils.Log;

public class LoginActions extends Utility {
	public static boolean flag;

	public static Properties  prop_loct ; 
	
	public static boolean loginForPositiveData(String un, String pw) throws FileNotFoundException, InterruptedException {
		 flag = false;
	 try {
		 prop_loct =Utility.loadProperty(Constant.locaters_path);
		
		Utility.getLocator("Login_un_txtbox_id").sendKeys(un);
		Utility.getLocator("Login_pw_txtbox_id").sendKeys(pw);
		Utility.getLocator("Login_submit_button_xpath").click(); 
		Reports.info("Login Actions", "Login Actions completed successfully");
		Log.info("Login Actions completed successfully");
		flag=true;
	 }catch(Exception e) {
			 Reports.fail("Login Actions", "Login Actions faile due to "+e.toString(), "");
			 Log.fail("Login actions failed due to :"+ e.fillInStackTrace().toString());
		 }
		
		return flag;
	}

}
