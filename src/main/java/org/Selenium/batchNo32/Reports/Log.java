package org.Selenium.batchNo32.Reports;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Log {

	public static Logger logger = Logger.getLogger(Reports.class.getName());

	public static void startTest(String TestCaseName) {
		// configuring the log4j.xml
		DOMConfigurator.configure("Log4j.xml");
		logger.info("                                                                                          ");
		logger.info(" --------------------------------- " + TestCaseName + " -----------------------------------");
		logger.info(" ***************************************************************************************** ");
	}

	public static void info(String description) {
		logger.info(description);
	}

	public static void pass(String description) {
		logger.info(description);
	}

	public static void fail(String description) {
		logger.info(description);
	}

	public static void warn(String description) {
		logger.info(description);
	}

	public static void fatal(String description) {
		logger.info(description);
	}

	public static void endTest() {
		logger.info(" ######################################################################## ");
	}

}
