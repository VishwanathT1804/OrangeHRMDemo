package com.orange.testcases;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	@Test(priority = 1)
	public void validation1() {
		System.out.println("validation1");
	}
	
	@Test(priority = 2)
	public void validation2() {
		System.out.println("validation2");
	}
}
