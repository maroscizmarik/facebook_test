package com.test.facebook_test.steps;

import com.test.facebook_test.pages.LoginPage;
import com.test.facebook_test.pages.MainPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginSteps {

    @Step
    //please change login credentials to existing account for successful login
    public void userIsLoggedInToFacebook(WebDriver driver) {
        driver.findElement(LoginPage.username).sendKeys("xxxx@xxx.com");
        driver.findElement(LoginPage.password).sendKeys("XXXX");
        CommonSteps.waitForElement(LoginPage.loginBtn, driver);
        driver.findElement(LoginPage.loginBtn).click();
    }

    @Step
    //please change Name in line #29 to assert successful login
    public void userChecksSuccessfulLogin(WebDriver driver) {
        CommonSteps.waitForElement(MainPage.userNavigation, driver);
        String displayedTitle = driver.findElement(MainPage.userNavigationTitle).getText();
        assertThat(displayedTitle)
            .describedAs("Profile Name is not as expected")
            .isEqualTo("Name Surname");
    }

    @Step
    public void userIsLoggedOutFromFacebook(WebDriver driver) {
        driver.findElement(MainPage.logoutMenu).click();
        CommonSteps.waitUntilClickable(MainPage.logoutLink, driver);
        driver.findElement(MainPage.logoutLink).click();
    }

    @Step
    public void userChecksSuccessfulLogout(WebDriver driver) {
        CommonSteps.waitForElement(LoginPage.username, driver);
        assertThat(driver.findElement(LoginPage.loginPageTitle).getText())
            .describedAs("User is not successfully logged out. Title is not correct")
            .isEqualTo("Facebook");
    }
}
