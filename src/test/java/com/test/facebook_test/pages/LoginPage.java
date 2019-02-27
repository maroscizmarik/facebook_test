package com.test.facebook_test.pages;

import org.openqa.selenium.By;

public class LoginPage {

    //Login page elements are defined here
    //id or class is the best way to target specific element, but sometimes xpath is needed
    //Facebook source code is generating some ids and classes dynamically, so it makes it much harder to target them
    //On real testing environment I presume that classes and ids would be defined more consistently

    public static final By loginPageTitle = By.xpath(".//h1//u");
    public static final By username = By.id("email");
    public static final By password = By.id("pass");
    public static final By loginBtn = By.xpath(".//*[contains(@data-testid, 'royal_login_button')]");
}
