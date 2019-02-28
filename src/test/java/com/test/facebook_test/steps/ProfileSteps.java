package com.test.facebook_test.steps;

import com.test.facebook_test.pages.MainPage;
import com.test.facebook_test.pages.ProfilePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfileSteps {
    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    @Step
    public void userNavigatesToProfilePage(WebDriver driver) {
        driver.findElement(MainPage.userNavigation).click();
        CommonUtils.waitUntilClickable(ProfilePage.statusInputField, driver);
    }

    @Step
    public void userUpdatesStatusAndChecksTheResult(WebDriver driver) {
        String status = environmentVariables.getProperty("facebook.status");
        driver.findElement(ProfilePage.statusInputField).sendKeys(status);
        driver.findElement(ProfilePage.statusSubmitBtn).click();

        CommonUtils.waitUntilElementDisappears(ProfilePage.statusSubmitBtn, driver);
        assertThat(driver.findElements(ProfilePage.displayedStatus).get(0).getText())
                .describedAs("Displayed text is not equal to written text")
                .isEqualTo(status);
    }
}
