package features;

/**
 * Created by wilder on 3/4/15.
 */

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.When;
import framework.selenium.DriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import mashape.pages.HomePage;
import mashape.pages.DashboardPage;
import mashape.pages.ApplicationPage;
import mashape.pages.CreateAppModal;
import org.testng.Assert;


import static junit.framework.Assert.assertTrue;

public class EditApplicationStepDefinitions {
    private WebDriver driver;
    private HomePage homepage;
    private CreateAppModal createmodal;
    private DashboardPage dashboardpage;
    private ApplicationPage applicationpage;

    @Before
    public void setUp() {
        homepage = new HomePage();
        dashboardpage = homepage.loginAs("wildergonzo", "Control123");
        driver = DriverManager.getInstance().getWebDriver();
        createmodal = dashboardpage.clickNewApp();
        createmodal.setNameApp("apptest1");
        applicationpage = createmodal.clickContinueBtn();
        driver.get("https://www.mashape.com/dashboard");
    }

    @Given("^I want to edit application (.*)$")
    public void selectApplication(String app_name) {
        driver = DriverManager.getInstance().getWebDriver();
        dashboardpage = new DashboardPage(driver);
        applicationpage = dashboardpage.clickApplicationName(app_name);
    }

    @When("^I navigate to general settings$")
    public void navigateGeneralSettingsMenu() {
        applicationpage.clickGeneralSetting();
    }

    @And("^I enter new name (.*)$")
    public void enterApplicationName(String app_newname) {
        applicationpage.enterApplicationName(app_newname);
    }

    @And("^I save changes$")
    public void clickSaveButton() {
        applicationpage.clickSaveButton();
    }

    @Then("^I should be able to update the application name$")
    public void assertUserLogin() {
        String newApp = "apptest1updated";
        Assert.assertEquals(applicationpage.getAppName(), newApp.toUpperCase(), "The app was not successfully updated");
    }
}
