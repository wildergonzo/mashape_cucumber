package features;

/**
 * Created by wilder on 3/5/15.
 */

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.When;
import framework.selenium.DriverManager;
import mashape.pages.*;
import framework.utils.Util;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DeleteApplicationStepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homepage;
    private DashboardPage dashboardpage;
    private ApplicationPage applicationpage;
    private CreateAppModal createmodal;
    private ApplicationConfirmModal applicationmodal;
    private Util utils;

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

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("^I want to delete application (.*)$")
    public void selectApplication(String app_name) {
        driver = DriverManager.getInstance().getWebDriver();
        applicationpage = dashboardpage.clickApplicationName(app_name);
    }

    @When("^I navigate to general settings for delete$")
    public void navigateGeneralSettingsMenu() {
        applicationpage.clickGeneralSetting();
    }

    @And("^I click delete button$")
    public void clickDeleteButton() {
        applicationmodal = applicationpage.clickDeleteButton();
    }

    @And("^I confirm deletion of (.*)$")
    public void clickDeleteButton(String appname) {
        applicationmodal.enterApplicationName(appname);
        applicationmodal.clickDeleteButton();
    }

    @Then("^I should be able to delete the application$")
    public void assertUserLogin() {
        Assert.assertFalse(utils.isElementPresent(By.xpath("//h3[contains(.,'apptest1')]")), "The application was not deleted.");
    }
}
