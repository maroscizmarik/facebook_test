package com.test.facebook_test.steps;

import com.test.facebook_test.pages.LoginPage;
import com.test.facebook_test.pages.MainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginSteps {
    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    @Step
    //please set login credentials to existing account for successful login in serenity.properties file
    public void userIsLoggedInToFacebook(WebDriver driver) {
        String username = environmentVariables.getProperty("facebook.username");
        String password = environmentVariables.getProperty("facebook.password");

        driver.findElement(LoginPage.username).sendKeys(username);
        driver.findElement(LoginPage.password).sendKeys(password);
        CommonUtils.waitUntilClickable(LoginPage.loginBtn, driver);
        driver.findElement(LoginPage.loginBtn).click();
    }

    @Step
    //please set name and surname for successful login assertion in serenity.properties file
    public void userChecksSuccessfulLogin(WebDriver driver) {
        String name = environmentVariables.getProperty("facebook.name");
        String surname = environmentVariables.getProperty("facebook.surname");

        CommonUtils.waitForElement(MainPage.userNavigation, driver);
        String displayedTitle = driver.findElement(MainPage.userNavigationTitle).getText();
        assertThat(displayedTitle)
            .describedAs("Profile Name is not as expected")
            .isEqualTo(name.concat(" ").concat(surname));
    }

    @Step
    public void userIsLoggedOutFromFacebook(WebDriver driver) {
        driver.findElement(MainPage.logoutMenu).click();
        CommonUtils.waitUntilClickable(MainPage.logoutLink, driver);
        driver.findElement(MainPage.logoutLink).click();
    }

    @Step
    public void userChecksSuccessfulLogout(WebDriver driver) {
        CommonUtils.waitForElement(LoginPage.username, driver);
        assertThat(driver.findElement(LoginPage.loginPageTitle).getText())
            .describedAs("User is not successfully logged out. Title is not correct")
            .isEqualTo("Facebook");
    }
}
