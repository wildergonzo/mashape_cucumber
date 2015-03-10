package features;

/**
 * Created by wilder on 3/3/15.
 */
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import mashape.pages.HomePage;
import mashape.pages.LoginModal;
import mashape.pages.DashboardPage;

public class LoginStepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homepage;
    private LoginModal loginmodal;
    private DashboardPage dashboardpage;

    @Given("^I want to access to my account$")
    public void clickLoginOption() {
        homepage = new HomePage();
        loginmodal = homepage.clickLoginBtn();
    }

    @When("^I enter my username (.*)$")
    public void enterUsername(String user) {
        loginmodal.setUserNameTxt(user);
    }

    @And("^I enter my password (.*)$")
    public void enterPassword(String pass) {
        loginmodal.setPasswordTxt(pass);
    }

    @And("^I click submit button$")
    public void clickSubmitButton() { dashboardpage = loginmodal.clickLoginBtn(); }

    @Then("^I should be able to login website$")
    public void assertUserLogin() {
        String expectedUser = "wildergonzo";
        Assert.assertEquals(dashboardpage.getCurrentUserName(), expectedUser);
    }

}
