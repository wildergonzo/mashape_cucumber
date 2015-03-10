package mashape.pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by wilder on 3/6/2015.
 */
public class CreateAppModal {
    private WebDriver driver;
    private WebDriverWait wait;
    private By formCreate = By.cssSelector("form.create-app");
    private By applicationNameTxt = By.xpath("//input[@placeholder='Application Name']");
    private By continueBtn = By.cssSelector("button.btn.btn-info");

    public CreateAppModal(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        // Wait until Add new application form is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(formCreate));
    }

    public void setNameApp(String name) {
        // Fill data to create an application
        driver.findElement(applicationNameTxt).clear();
        driver.findElement(applicationNameTxt).sendKeys(name);
    }

    public ApplicationPage clickContinueBtn() {
        driver.findElement(continueBtn).click();
        return new ApplicationPage(driver);
    }

}