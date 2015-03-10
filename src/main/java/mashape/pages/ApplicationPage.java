package mashape.pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by wilder on 3/5/15.
 */
public class ApplicationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By OptionsPanel = By.cssSelector("div.page>aside[class=page-sidebar]");
    private By GeneralOption = By.xpath("//span[contains(.,'General Settings')]");
    private By AppNameTextBox = By.cssSelector("div.form-group > input[name=\"name\"]");
    private By DeleteButton = By.cssSelector("a.btn.btn-danger > span.btn-text");
    //private By SaveButton = By.cssSelector("form.basic > div.panel-footer clearfix > button[class=\"btn btn-default submit\"]");
    private By SaveButton = By.xpath("//button[contains(.,'Save')]");

    public ApplicationPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(OptionsPanel));
    }

    public void clickGeneralSetting() {
        driver.findElement(GeneralOption).click();
    }

    public void enterApplicationName(String appname) {
        WebElement tbx_appname = driver.findElement(AppNameTextBox);
        tbx_appname.clear();
        tbx_appname.sendKeys(appname);
    }

    public void clickSaveButton() {
        driver.findElement(SaveButton).click();
    }

    public ApplicationConfirmModal clickDeleteButton() {
        driver.findElement(DeleteButton).click();

        return new ApplicationConfirmModal(driver);
    }

    public String getAppName() {
        return driver.findElement(By.xpath("//div[@class='name']")).getText();
    }
}
