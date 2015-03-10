package features;

/**
 * Created by wilder on 3/4/15.
 */

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import java.util.concurrent.TimeUnit;

import mashape.pages.ApplicationPage;
import mashape.pages.CreateAppModal;
import mashape.pages.DashboardPage;
import mashape.pages.HomePage;
import org.openqa.selenium.*;
import org.testng.Assert;
import framework.selenium.DriverManager;

public class CreateApplicationStepDefinitions {
    private WebDriver driver;
    private HomePage homepage;
    private DashboardPage dashboardpage;
    private CreateAppModal createmodal;
    private ApplicationPage applicationpage;

    @Before
    public void setUp() {
        homepage = new HomePage();
        dashboardpage = homepage.loginAs("wildergonzo", "Control123");
    }

    @Given("^I want to create a new application$")
    public void clickAddNewApplication() {
        driver = DriverManager.getInstance().getWebDriver();
        createmodal = dashboardpage.clickNewApp();
    }

    @When("^I enter the application name (.*)$")
    public void enterApplicationName(String app_name) {
        createmodal.setNameApp(app_name);
    }

    @And("^I press Continue button$")
    public void clickContinueButton() {
        applicationpage = createmodal.clickContinueBtn();
    }


    @Then("^I should be able to create app$")
    public void assertUserLogin() {
        String newApp = "apptest1";
        Assert.assertEquals(applicationpage.getAppName(), newApp.toUpperCase(), "The app was not successfully created");
    }

}
