package com.orange.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.orange.driver.Driver;

public class BaseTest {
	
	@BeforeClass
	public void setUp() {
		Driver.initDriver();
	}
	
	@AfterClass
	public void tearDown() {
		Driver.quitDriver();
	}

}
