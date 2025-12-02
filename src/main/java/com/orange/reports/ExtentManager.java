package com.orange.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();
	
	public static void setExtentTest(ExtentTest extentTest) {
		threadLocal.set(extentTest);
	}
	
	public static ExtentTest getExtentTest() {
		return threadLocal.get();
	}
	
	public static void unload() {
		threadLocal.remove();
	}

}
