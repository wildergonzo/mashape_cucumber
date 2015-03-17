package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateApplicationModal {
    private WebDriver driver;
    private WebDriverWait wait;
    private By formCreateApp = By.cssSelector("form.create-app");
    private By nameAppTextField = By.cssSelector("form.create-app > div.modal-body > div.field-group > input[name=\"name\"]");
    private By continueBtn = By.cssSelector("button.btn.btn-info");

    public CreateApplicationModal(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(formCreateApp));
    }

    public void setAppNameTxt(String appName) {
        driver.findElement(nameAppTextField).clear();
        driver.findElement(nameAppTextField).sendKeys(appName);
    }

    public ApplicationSidebar clickContinueBtn() {
        driver.findElement(continueBtn).click();
        return new ApplicationSidebar(driver);
    }
}
