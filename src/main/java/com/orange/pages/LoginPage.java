package com.orange.pages;

import com.orange.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class LoginPage {

    private By ousername = By.xpath("//input[@placeholder='Username']");
    private By opassword = By.xpath("//input[@placeholder='Password']");
    private By loginBtn = By.xpath("//button[normalize-space()='Login']");

    public WebElement getOusername(){
       return ElementUtils.getElementBy(ousername);
    }

    public WebElement getPassword(){
        return ElementUtils.getElementBy(opassword);
    }

    public WebElement getLoginBtn(){
        return ElementUtils.getElementBy(loginBtn);
    }


    public void login(Map<String,String> map){
        ElementUtils.sendKeys(ousername, map.get("username"));
        ElementUtils.sendKeys(opassword, map.get("password"));
        ElementUtils.click(loginBtn);
    }

}
