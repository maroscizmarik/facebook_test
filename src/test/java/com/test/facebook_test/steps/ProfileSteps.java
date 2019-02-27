package com.test.facebook_test.steps;

import com.test.facebook_test.pages.MainPage;
import com.test.facebook_test.pages.ProfilePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfileSteps {

    @Step
    public void userNavigatesToProfilePage(WebDriver driver) {
        driver.findElement(MainPage.userNavigation).click();
        CommonSteps.waitForElement(ProfilePage.statusInputField, driver);
    }

    @Step
    public void userUpdatesStatusAndChecksTheResult(WebDriver driver) {
        String status = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        driver.findElement(ProfilePage.statusInputField).sendKeys(status);
        driver.findElement(ProfilePage.statusSubmitBtn).click();

        //this step might fail most probably, because location of the element is hard to specify. See ProfilePage.java line #15
        CommonSteps.waitForElement(ProfilePage.displayedStatus, driver);
        assertThat(driver.findElement(ProfilePage.displayedStatus).getText())
                .describedAs("Displayed text is not equal to written text")
                .isEqualTo(status);
    }
}
