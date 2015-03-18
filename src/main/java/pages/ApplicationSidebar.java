package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationSidebar {
    private WebDriver driver;
    private WebDriverWait wait;
    private By toolbarSide = By.cssSelector("aside.page-sidebar");
    private By nameAppSection = By.cssSelector("div.name");
    private By generalSettingsLink = By.xpath("//div[@class='page']/descendant::a[@class='settings']/span[contains(.,'General Settings')]");

    public ApplicationSidebar(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(toolbarSide));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCurrentAppName() {
        return driver.findElement(nameAppSection).getText();
    }

    public ApplicationSettings clickSettingsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(generalSettingsLink));
        driver.findElement(generalSettingsLink).click();
        return new ApplicationSettings(driver);
    }
}
