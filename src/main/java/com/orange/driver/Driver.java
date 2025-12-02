package com.orange.driver;

import org.openqa.selenium.WebDriver;

import com.orange.config.ConfiguartionFactory;

public final class Driver {
	
	private Driver() {}

	public static void initDriver() {
		if (DriverManager.getDriver() == null) {
			WebDriver driver = DriverFactory.getDriver(ConfiguartionFactory.getConfig().browser());
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get(ConfiguartionFactory.getConfig().appurl());
		}
	}

	public static void quitDriver() {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
