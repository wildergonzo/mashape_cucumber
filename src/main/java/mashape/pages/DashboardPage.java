package mashape.pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by wilder on 3/3/15.
 */
public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By dashboardContainer = By.xpath("//div[@class='inner-container']");
    //private By dashboardContainer = By.cssSelector("div.add-container.block > p");
    private By currentUserTxt = By.cssSelector("span.dropdown-toggle.name");
    private By appDropdown = By.cssSelector("span.dropdown-toggle.title");
    //private By newAppBtn = By.cssSelector("span.text");
    private By newAppBtn = By.cssSelector("div.add-container.block > p");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardContainer));
    }

    public void clickAddNewApplication(){
        driver.findElement(By.xpath("//p[contains(.,'Add New Application')]")).click();
    }

    public void enterApplicationName(String appname){
        driver.findElement(By.name("name")).sendKeys(appname);
    }

    public void clickContinueButton(){
        driver.findElement(By.cssSelector("//div.modal-footer > button[class=\"btn btn-info\"]")).click();
    }

    public ApplicationPage clickApplicationName(String appname){
        driver.findElement(By.xpath("//h3[contains(.,'" + appname + "')]")).click();
        return new ApplicationPage(driver);
    }

    //from example
    public String getCurrentUserName() {
        return driver.findElement(currentUserTxt).getText();
    }

    public void clickApplicationDropdown() {
        driver.findElement(appDropdown).click();
    }

    public CreateAppModal clickNewApp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newAppBtn));
        driver.findElement(newAppBtn).click();
        return new CreateAppModal(driver);
    }

}