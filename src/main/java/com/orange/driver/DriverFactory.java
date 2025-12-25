package com.orange.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {
	}

	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("CHROME")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Except CHROME and EDGE, No other browsers are supported");
		}
		driver.manage().window().maximize();
		return driver;
	}
}
