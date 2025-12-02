package com.orange.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orange.constants.FrameworkConstants;

public final class ExtentReport {

	private ExtentReport() {
	}

	private static ExtentReports extentReports;

	public static void initReport() {
		if (extentReports == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.REPORT_PATH);
			spark.config().setDocumentTitle("Orange-HRM-Title");
			spark.config().setReportName("Orange-HRM-Report");
			spark.config().setTheme(Theme.DARK);

			extentReports = new ExtentReports();
			extentReports.attachReporter(spark);
		}
	}

	public static void flushReport() {
		if (extentReports != null) {
			extentReports.flush();
		}
	}

	public static void creatExtentReport(String testName) {
		ExtentTest extentTest = extentReports.createTest(testName);
		ExtentManager.setExtentTest(extentTest);
	}

}
