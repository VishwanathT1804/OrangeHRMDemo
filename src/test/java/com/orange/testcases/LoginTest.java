package com.orange.testcases;

import com.orange.config.ConfiguartionFactory;
import com.orange.datadriven.DataDrivenUtil;
import com.orange.pages.PageManager;
import com.orange.reports.ExtentManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class LoginTest extends BaseTest{

	/*Need to complete*/

	@Test(priority = 1)
	public void validateLoginPageLoad() {
			Assert.assertTrue(PageManager.getLoginPage().getOusername().isDisplayed(), "Username is not displayed");
			ExtentManager.getExtentTest().info("Username is displayed");
			Assert.assertTrue(PageManager.getLoginPage().getPassword().isDisplayed(), "Password is not displayed");
			ExtentManager.getExtentTest().info("Password is displayed");
			Assert.assertTrue(PageManager.getLoginPage().getLoginBtn().isDisplayed(), "Login button is not displayed");
			ExtentManager.getExtentTest().info("Login button is displayed");
	}
	
	@Test(priority = 2, dataProvider = "loginTestData")
	public void validateLogin(Map<String, String> map) {
		PageManager.getLoginPage().login(map);
	}

	@DataProvider(name = "loginTestData")
	public Object[][] getLoginTestDataFromUtil(){
		List<Map<String, String>> loginTestDataFromList = DataDrivenUtil.getLoginTestDataFromExcel(ConfiguartionFactory.getConfig().testDataFilePath(), ConfiguartionFactory.getConfig().testDataSheetName());

		Object[][] loginTestData = new Object[loginTestDataFromList.size()][1];
		for(int i =0; i<loginTestDataFromList.size(); i++){
			loginTestData[i][0] =loginTestDataFromList.get(i);
		}
		return loginTestData;
	}
}
