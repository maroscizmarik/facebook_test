package com.test.facebook_test.pages;

import org.openqa.selenium.By;

public class ProfilePage {

    //Profile page elements are defined here
    //id or class is the best way to target specific element, but sometimes xpath is needed

    public static final By statusInputField = By.xpath(".//*[contains(@data-testid, 'status-attachment-mentions-input')]");
    public static final By statusSubmitBtn = By.xpath(".//*[contains(@data-testid, 'react-composer-post-button')]");
    public static final By displayedStatus = By.xpath(".//*[contains(@class, 'userContent')]//p");

}
