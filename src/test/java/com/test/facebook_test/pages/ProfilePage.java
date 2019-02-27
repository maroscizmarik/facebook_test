package com.test.facebook_test.pages;

import org.openqa.selenium.By;

public class ProfilePage {

    //Profile page elements are defined here
    //id or class is the best way to target specific element, but sometimes xpath is needed
    //Facebook source code is generating some ids and classes dynamically, so it makes it much harder to target them
    //On real testing environment I presume that classes and ids would be defined more consistently

    public static final By statusInputField = By.xpath(".//*[contains(@data-testid, 'status-attachment-mentions-input')]");
    public static final By statusSubmitBtn = By.xpath(".//*[contains(@data-testid, 'react-composer-post-button')]");

    //id value of status field is dynamically generated and therefor it changes every time the page is rendered.
    // I can't figure out simple solution at the moment, but in real test environment I believe, we can solve this issue by using custom ids or classes
    public static final By displayedStatus = By.xpath(".//*[@id = 'js_9b']/p");

}
