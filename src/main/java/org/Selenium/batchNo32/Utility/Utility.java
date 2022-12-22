package org.Selenium.batchNo32.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.Selenium.batchNo32.Reports.Log;
import org.Selenium.batchNo32.Reports.Reports;
import org.Selenium.batchNo32.appModule.LaunchEnv1;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import jdk.internal.org.jline.utils.Log;

public class Utility extends LaunchEnv1{

	public static Properties prop;
	public static FileInputStream fis;
	public static WebElement element;
	public static Properties locator_prop;
	public static String filepath;

	/**
	 * 
	 * @param Filepath
	 * @return Properties
	 * @author GcReddy
	 * @throws FileNotFoundException @ this method is demanding the File path.
	 * Provided file invoked and creating an object for Properties data type and
	 * loading the entinre file with Key
	 * @key and value fair and storing prop variable and return the Properties as
	 *      data type.
	 */

	public static Properties loadProperty(String Filepath) throws FileNotFoundException {
		prop = null;
		fis = new FileInputStream(Filepath);
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
//---------------------------------------------------------------------------------------------------------	

	public static WebElement getLocator(String key) throws FileNotFoundException, InterruptedException {
		element = null;
		//String x = "GcReddy";
		 locator_prop =Utility.loadProperty("C:\\Users\\User\\eclipse-workspace\\org.Selenium.GcReddy.batchNo32\\src\\test\\resources\\Repository\\Locator.properties");
		 String value = locator_prop.getProperty(key);
		 System.out.println("Value of the :" + key +" is =  : "+value);
		
		 if(key.endsWith("_id")) {
			 element = driver.findElement(By.id(value));
			 elementHighLight(element);
			 
		 }else if(key.endsWith("_xpath")){
			 element =driver.findElement(By.xpath(value));
			 elementHighLight(element);
		 }else if(key.endsWith("_name")) {
			 element = driver.findElement(By.name(value));	
			 elementHighLight(element);
		 }else if(key.endsWith("_className")) {
			 element = driver.findElement(By.className(value));
			 elementHighLight(element);
		 }
		return element;	
		
	}
//--------------------------------------------------------------------------------------------------------
public static void elementHighLight(WebElement element) throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Thread.sleep(300);
	js.executeScript(" arguments[0].setAttribute('style','background:yellow; border:2px dashed blue'); ",element);	
	
//	 js.executeScript(" arguments[0].setAttribute('style', 'background:yellow; border: 2px dashed red');" , element);
	
	Thread.sleep(1000);
}
//--------------------------------------------------------------------------------------------

/***************************************************************************************
 * This function will close the current session
 * 
 * @throws IOException
 **************************************************************************************/
public static void closeBrowser()  {
	try {		
		driver.quit();
		Log.info("Closing Browser successfully... ");

	} catch (Exception e) {
		Reports.fail("Closing Browser", e.toString(), "");					
		Log.info("Closing the browser is failed..... due to :"+e.fillInStackTrace());	
	}

}

//------------------------------------------------------------------------------
// if multiple elements on the same locator then if you want to work with one element
// provide the index and make it unique to work with it.
// this method will List<WebElement>
public static List<WebElement> ElementCollection(String xpath)
{
	List<WebElement> collections = driver.findElements(By.xpath(xpath));
	return collections;
}

//-------------------------------------------------------------------------------------------------------------------
// by default data and time format (default format) will return...
// i.e. Fri May 27 19:48:53 IST 2022
public static void getCurrentDate() {
	Date date = new Date();
	System.out.println(date);		
}

/***************************************************************************************
 * This function will give you System date time in string format
 * 
 * @return This function will return date time in String format.
 **************************************************************************************/
// 07-13-2022
	public static String getDate() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	// Fri May 27 19:48:53 IST 2022
	String founddate = dateFormat.format(date);
	//  2022/05/27 19:48:53
	
	String[] parts = founddate.split(" ");
	String[] appenderpart1 = parts[0].split("/");
	String appender = appenderpart1[1] + "-" + appenderpart1[2] + "-" + appenderpart1[0];
	return appender;
	//05-27-2022
}

/***************************************************************************************
 * This function will give you System date time in string format
 * 
 * @return This function will return date time in String format.
 **************************************************************************************/
// 0527195509
	public static String getDatetime() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String founddate = dateFormat.format(date);
	Log.info(dateFormat.format(date));    // 2014/08/06 15:59:48

	String[] parts = founddate.split(" ");
	// String part1 = parts[0]; // 004
	String[] appenderpart1 = parts[0].split("/");
	String[] appenderpart2 = parts[1].split(":");
	String appender = appenderpart1[1] + appenderpart1[2] + appenderpart2[0] + appenderpart2[1] + appenderpart2[2];
	Log.info(appender);
	return appender;
	//0806155948
}

/*****************************************************************************************
 * This function wait implicitly for mentioned time duration.
 * 
 * @exception Exception
 ****************************************************************************************/
public static void waitImplicit() {
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}

/*****************************************************************************************
 * This function will dynamically wait for pageload.
 * 
 * @exception Exception
 ****************************************************************************************/
public static void Elementwait() throws Exception {
   	Log.info("Waiting for page load");
	WebDriverWait explicitwait = new WebDriverWait(driver, 120);
	explicitwait.withTimeout(60, TimeUnit.SECONDS);
	explicitwait.pollingEvery(2, TimeUnit.SECONDS);
	explicitwait.ignoring(NoSuchElementException.class);
//	explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img.timer.center-block")));	
}

//----------------------------------------------------------------------------------------------		
	public static void waitForElementClickable(String Key) throws InterruptedException, FileNotFoundException {

		Log.info("Waiting for the Element to be clickable");
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.withTimeout(60, TimeUnit.SECONDS);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(InvalidSelectorException.class);
		wait.ignoring(WebDriverException.class);
		wait.until(ExpectedConditions.elementToBeClickable(Utility.getLocator("Key")));

}

	/*****************************************************************************************
	 * This function will dynamically wait for text on element to be present.
	 * 
	 * @param Key
	 * @param text
	 * @throws InterruptedException 
	 * @throws FileNotFoundException 
	 * @exception Exception
	 ****************************************************************************************/
	public static void waitForTextToBeDisplayed(String Key) throws InterruptedException, FileNotFoundException {
			Thread.sleep(1000);
			Log.info("Waiting for the Element to be visible");
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.withTimeout(80, TimeUnit.SECONDS);
			wait.pollingEvery(3, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(InvalidSelectorException.class);
			wait.until(ExpectedConditions.visibilityOf(Utility.getLocator("Key")));		
	}

	/*************************************************************************************
	 * This function will get screenshot on Success of executed Test Cases.
	 * 
	 * @return filepath This function will return the String path of the
	 *         screenshot.
	 * @exception IOException
	 **************************************************************************************/
	public static String getSuccessScreenshot() {
		try {
			filepath = null;
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			filepath = System.getProperty("user.dir") + "\\Screenshots\\SuccessScreenshots\\"
					+ System.currentTimeMillis() + ".png";
			FileUtils.copyFile(file, new File(filepath));
		} catch (IOException e) {
			Reports.fail("",e.toString(),"");
			e.printStackTrace();
		}
		return filepath;
	}

	/***************************************************************************************
	 * This function will take screenshot on faliure of test cases.
	 * 
	 * @return filepath
	 * @see Use this function on negative secnarios.
	 * 
	 **************************************************************************************/
	
	public static String getfailScreenshot() {
		try {
			filepath = null;
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			filepath = System.getProperty("user.dir") + "\\Screenshots\\FaliureScreenshots\\" + System.currentTimeMillis()
					+ ".png";
			FileUtils.copyFile(file, new File(filepath));
		} catch (IOException e) {
			Reports.fail("",e.toString(),"");
			e.printStackTrace();
		}
		return filepath;
	}

	/*******************************************************************************************
	 * This function will clean the framework and will delete the files and
	 * folder for specific mentioned time duration
	 * 
	 * @param daysBack
	 * @param dirWay
	 ******************************************************************************************/
	public static void FrameworkcleanUp(int daysBack, String dirWay) {
	
		File directory = new File(dirWay);
		if (directory.exists()) {
	
			File[] listFiles = directory.listFiles();
			long purgeTime = System.currentTimeMillis() - (daysBack * 24 * 60 * 60 * 1000);
			for (File listFile : listFiles) {
				if (listFile.lastModified() < purgeTime) {
					if (!listFile.delete()) {
						System.err.println("Unable to delete file: " + listFile);
					}
				}
			}
		}
	}
	






}
