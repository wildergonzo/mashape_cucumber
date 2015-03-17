package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardHeader {

    private WebDriver driver;
    private WebDriverWait wait;
    private By userNameDropdown = By.cssSelector("span.dropdown-toggle.name");
    private By applicationsDropdown = By.cssSelector("span.dropdown-toggle.title");
    private By createAppOption = By.cssSelector("span.text");
    private By logoutOption = By.xpath("//span[contains(.,'Logout')]");

    public DashboardHeader(WebDriver driver) {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
    }

    public String getCurrentUserName() {
        return driver.findElement(userNameDropdown).getText();
    }

    private void clickApplicationsDropdown() {
        driver.findElement(applicationsDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAppOption));
    }

    public CreateApplicationModal clickCreateApplicationDropdown() {
        clickApplicationsDropdown();
        driver.findElement(createAppOption).click();
        return new CreateApplicationModal(driver);
    }

    public ApplicationSidebar clickApplicationNameDropdown(String appName) {
        clickApplicationsDropdown();
        driver.findElement(By.linkText(appName)).click();
        return new ApplicationSidebar(driver);
    }

    public void logout() {
        driver.findElement(userNameDropdown).click();
        driver.findElement(logoutOption).click();
        DriverManager.getInstance().quitDriver();
    }

    public Dashboard goToDashboardPage() {
        driver.get("https://www.mashape.com/dashboard");
        return new Dashboard(driver);
    }
}

