package features;

/**
 * Created by wilder on 3/3/15.
 */

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.DashboardHeader;
import pages.HomePage;
import pages.LoginModal;

public class LoginStepDefinitions {
    private LoginModal loginmodal;
    private DashboardHeader dashboardHeader;

    @Given("^I want to access to my account$")
    public void clickLoginOption() {
        HomePage homepage = new HomePage();
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
    public void clickSubmitButton() {
        dashboardHeader = loginmodal.clickLoginBtn();
    }

    @Then("^I should be able to login website (.*)$")
    public void assertUserLogin(String expectedUser) {
        Assert.assertEquals(dashboardHeader.getCurrentUserName(), expectedUser);
    }
}
