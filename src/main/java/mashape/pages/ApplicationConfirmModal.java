package mashape.pages;

/**
 * Created by wilder on 3/5/15.
 */

import framework.selenium.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationConfirmModal {
    private WebDriver driver;
    private WebDriverWait wait;
    private By AppNameTextBox =  By.name("confirm");
    private By DeleteButton = By.xpath("//button[contains(.,'Yes, delete this Application')]");
    public ApplicationConfirmModal(WebDriver driver) {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
    }

    public void enterApplicationName(String appname) {
        WebElement appname_tbx =  driver.findElement(AppNameTextBox);
        appname_tbx.clear();
        appname_tbx.sendKeys(appname);
    }

    public void clickCancelButton() {
        driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();
    }

    public void clickDeleteButton() {
        driver.findElement(DeleteButton).click();
    }
}
