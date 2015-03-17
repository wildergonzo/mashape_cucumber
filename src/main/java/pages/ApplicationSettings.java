package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ApplicationSettings {
    private WebDriver driver;
    private WebDriverWait wait;
    private By AppBasicSettingsText = By.xpath("//h4[contains(.,'Application Basic Settings')]");
    private By formSettings = By.cssSelector("div.settings");
    private By nameTextField = By.cssSelector("div.form-group > input[name=\"name\"]");
    private By descriptionTextArea = By.cssSelector("textarea[name=\"description\"]");
    private By saveBtn = By.xpath("//button[contains(.,'Save')]");
    private By deleteBtn = By.cssSelector("a.btn.btn-danger > span.btn-text");

    public ApplicationSettings(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppBasicSettingsText));
        wait.until(ExpectedConditions.visibilityOfElementLocated(formSettings));
    }

    public void setAppNameTxt(String appName) {
        driver.findElement(nameTextField).clear();
        driver.findElement(nameTextField).sendKeys(appName);
    }

    public void setAppDescriptionTxt(String appDescription) {
        driver.findElement(descriptionTextArea).clear();
        driver.findElement(descriptionTextArea).sendKeys(appDescription);
    }

    public void clickSaveBtn() {
        driver.findElement(saveBtn).click();
    }

    public DeleteApplicationModal clickDeleteBtn() {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(formSettings));
        webElement.findElement(deleteBtn).click();
        return new DeleteApplicationModal(driver);
    }
}
