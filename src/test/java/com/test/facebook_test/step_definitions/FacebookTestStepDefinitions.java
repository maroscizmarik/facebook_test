package com.test.facebook_test.step_definitions;

import com.test.facebook_test.steps.LoginSteps;
import com.test.facebook_test.steps.ProfileSteps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class FacebookTestStepDefinitions {

    WebDriver browser;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_x86_2.41.exe");

        //chrome options serve to configure the driver
        //i.e. turning of notification pop up, or maximize the window after opening
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setCapability("resolution", "1920x1080");
        browser = new ChromeDriver(chromeOptions);
        browser.get("https://www.facebook.com");
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    //@Steps annotation is Serenity BDD feature which helps maintain tests and create meaningful reports
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private ProfileSteps profileSteps;

    //step definitions help to maintain the code and keep the readability
    //text defined in "" is mapped to Cucumber feature file facebook.feature, where every step of the test scenario represents single method

    @Given("^User is logged in to Facebook$")
    public void userIsLoggedInToFacebook() {
        loginSteps.userIsLoggedInToFacebook(browser);
    }

    @And("^User checks successful login$")
    public void userChecksSuccessfulLogin() {
        loginSteps.userChecksSuccessfulLogin(browser);
    }

    @And("^User navigates to profile page$")
    public void userNavigatesToProfilePage() {
        profileSteps.userNavigatesToProfilePage(browser);
    }

    @When("^User updates status and checks the result$")
    public void userUpdatesStatusAndChecksTheResult() {
        profileSteps.userUpdatesStatusAndChecksTheResult(browser);
    }

    @Then("^User is logged out from Facebook$")
    public void userIsLoggedOutFromFacebook() {
        loginSteps.userIsLoggedOutFromFacebook(browser);
    }

    @And("^User checks successful logout$")
    public void userChecksSuccessfulLogout() {
        loginSteps.userChecksSuccessfulLogout(browser);
    }
}
