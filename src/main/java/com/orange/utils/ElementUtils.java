package com.orange.utils;

import com.orange.constants.FrameworkConstants;
import com.orange.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ElementUtils {

    private ElementUtils(){
    }
    private static WebDriverWait  wait;
   /* =========================================WAITING MECHANISM==================================================================*/

    public static WebElement waitUptoVisibilityOfLocator(By by){
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitUptoClickability(By by){
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement waitUptoClickability(WebElement element){
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
   /* =============================================ELEMENT OPERATIONS======================================================== */

    public static WebElement getElementBy(By by){
       return waitUptoVisibilityOfLocator(by);
    }

    public static void sendKeys(By by, String sendKeysValue){
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
        waitUptoVisibilityOfLocator(by).sendKeys(sendKeysValue);
    }

    public static void click(By by){
        waitUptoClickability(by).click();
    }


    /*==================================================MISCELLANEOUS======================================================================*/

    public static void refreshPage(){
        DriverManager.getDriver().navigate().refresh();
    }

    public static void navigateToPage(String url){
        DriverManager.getDriver().navigate().to(url);
    }
}
