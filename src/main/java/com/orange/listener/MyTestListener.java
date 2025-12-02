package com.orange.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.orange.reports.ExtentManager;
import com.orange.reports.ExtentReport;

public class MyTestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.creatExtentReport(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentManager.getExtentTest().pass(result.getName()+" testcase is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentManager.getExtentTest().fail(result.getName()+" testcase is failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentManager.getExtentTest().skip(result.getName()+" testcase is skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentReport.initReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.flushReport();
	}

}
