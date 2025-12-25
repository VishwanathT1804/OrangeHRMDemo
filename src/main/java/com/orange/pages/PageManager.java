package com.orange.pages;



public class PageManager {

    private static LoginPage loginPage;

    public static LoginPage getLoginPage(){
        if(loginPage==null) {
             loginPage = new LoginPage();
        }
        return loginPage;
    }
}
