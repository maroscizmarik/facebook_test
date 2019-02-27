package com.test.facebook_test.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonSteps {

    //these methods help the whole test flow to wait for particular elements and can be used wherever are needed

    public static void waitForElement(By by, WebDriver driver) {
        WebElement element = driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilClickable(By by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
