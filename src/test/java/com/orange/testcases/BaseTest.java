package com.orange.testcases;

import com.orange.driver.Driver;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected Logger log;
	
	@BeforeMethod
	public void setUp() {
		Driver.initDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}

}
