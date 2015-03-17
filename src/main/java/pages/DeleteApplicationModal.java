package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeleteApplicationModal {
    private WebDriver driver;
    private WebDriverWait wait;
    private By nameAppTextField = By.name("confirm");
    private By yesDeleteAppBtn = By.xpath("//button[contains(.,'Yes, delete this Application')]");

    public DeleteApplicationModal(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameAppTextField));
    }

    public void setAppNameTxt(String appName) {
        driver.findElement(nameAppTextField).clear();
        driver.findElement(nameAppTextField).sendKeys(appName);
    }

    public void clickYesDeleteAppBtn() {
        driver.findElement(yesDeleteAppBtn).click();
    }
}
