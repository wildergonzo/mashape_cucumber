package features;

/**
 * Created by wilder on 3/4/15.
 */

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;

public class CreateApplicationStepDefinitions {
    private DashboardHeader dashboardHeader;
    private Dashboard dashboard;
    private ApplicationSidebar applicationSidebar;

    @Given("^Login as (.*) (.*)$")
    public void loginAs(String username, String password) {
        HomePage homepage = new HomePage();
        dashboardHeader = homepage.loginAs(username, password);
    }

    @When("^Create a new application (.*) in Dashboard")
    public void createNewAppInDashboard(String app) {
        dashboard = dashboardHeader.goToDashboardPage();

        // Click on Add New Application link in dashboard page.
        CreateApplicationModal newAppModal = dashboard.clickAddNewApplicationLink();

        // Fill data to create an application
        newAppModal.setAppNameTxt(app);
        applicationSidebar = newAppModal.clickContinueBtn();
    }

    @When("^Create a new application (.*) in Dropdown")
    public void createNewAppFromDropdown(String app) {
        // Click on dropdown Application from header dashboard page and select Create Application option
        CreateApplicationModal createApplicationModal = dashboardHeader.clickCreateApplicationDropdown();

        // Fill data to create an application
        createApplicationModal.setAppNameTxt(app);
        applicationSidebar = createApplicationModal.clickContinueBtn();
    }

    @Then("^New App (.*) should be displayed in Sidebar")
    public void appShouldBeDisplayedInSidebar(String app) {
        // Verify that app was created successfully
        Assert.assertEquals("The new application: " + app + "was not created successfully.",
                applicationSidebar.getCurrentAppName(), app.toUpperCase());
    }

    @Then("^New App (.*) should be displayed in Dashboard")
    public void appShouldBeDisplayedInDashboard(String app) {
        // Verify in dashboard page that application was created.
        dashboard = dashboardHeader.goToDashboardPage();
        Assert.assertTrue("The new application: " + app + "was not created successfully.",
                dashboard.isAppDisplayed(app));
    }
}
