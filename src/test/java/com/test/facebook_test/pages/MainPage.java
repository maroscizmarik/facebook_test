package com.test.facebook_test.pages;

import org.openqa.selenium.By;

public class MainPage {

    //Main page elements are defined here
    //id or class is the best way to target specific element, but sometimes xpath is needed
    //Facebook source code is generating some ids and classes dynamically, so it makes it much harder to target them
    //On real testing environment I presume that classes and ids would be defined more consistently

    public static final By userNavigation = By.id("userNav");
    public static final By userNavigationTitle = By.xpath(".//*[@id = 'userNav']//div[contains(@class, 'linkWrap')]");
    public static final By logoutMenu = By.id("logoutMenu");
    public static final By logoutLink = By.xpath(".//a[contains(@data-gt, 'menu_logout')]");
}
