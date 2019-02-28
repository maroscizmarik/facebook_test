package com.test.facebook_test.pages;

import org.openqa.selenium.By;

public class LoginPage {

    //Login page elements are defined here
    //id or class is the best way to target specific element, but sometimes xpath is needed

    public static final By loginPageTitle = By.xpath(".//h1//u");
    public static final By username = By.id("email");
    public static final By password = By.id("pass");
    public static final By loginBtn = By.xpath(".//*[contains(@data-testid, 'royal_login_button')]");
}
