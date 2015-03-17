package pages;

import framework.selenium.Commons;
import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

    private WebDriver driver;
    private WebDriverWait wait;
    private By addNewApplicationLink = By.cssSelector("div.add-container.block > p");

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addNewApplicationLink));
    }

    public CreateApplicationModal clickAddNewApplicationLink() {
        driver.findElement(addNewApplicationLink).click();
        return new CreateApplicationModal(driver);
    }

    public ApplicationSidebar clickApplicationLnk(String appName) {
        driver.findElement(By.xpath("//div[@data-name='" + appName + "']")).click();
        return new ApplicationSidebar(driver);
    }

    public boolean isAppDisplayed(String appName) {
        return Commons.isElementPresent(By.xpath("//div[@data-name='" + appName + "']"));
    }
}

