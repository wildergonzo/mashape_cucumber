package mashape.pages;
import org.openqa.selenium.*;
import framework.selenium.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by wilder on 3/3/15.
 */


public class LoginModal {
    private WebDriver driver;
    private WebDriverWait wait;

    private By formLogin = By.cssSelector("form.login");
    private By usernameTextField = By.xpath("//input[@placeholder='Email or Username']");
    private By passwordTextField = By.cssSelector("form.login > div.input-group.connected > input[name=\"password\"]");
    private By loginBtn = By.cssSelector("form.login > button[name=\"regular\"]");

    public LoginModal(WebDriver driver) {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
    }

    /*public void enterUsername(String username){
        driver.findElement(By.xpath("//input[@placeholder='Email or Username']")).sendKeys(username);
        //driver.findEl1ement(By.cssSelector("form.login > div.input-group.connected > input[name=\"password\"]")).sendKeys("test");
        // Wait until form to login is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(formLogin));
    }

    public void enterPassword(String password){
        driver.findElement(By.cssSelector("form.login > div.input-group.connected > input[name=\"password\"]")).sendKeys(password);

    }

    public DashboardPage clickLogin() {
        driver.findElement(By.cssSelector("form.login > button[name=\"regular\"]")).click();
        return new DashboardPage(driver);
    }*/


    public void setUserNameTxt(String username) {
        driver.findElement(usernameTextField).clear();
        driver.findElement(usernameTextField).sendKeys(username);
    }

    public void setPasswordTxt(String password) {
        driver.findElement(passwordTextField).clear();
        driver.findElement(passwordTextField).sendKeys(password);
    }

    public DashboardPage clickLoginBtn() {
        driver.findElement(loginBtn).click();
        return new DashboardPage(driver);
    }

    public DashboardPage loginAs(String username, String password) {
        setUserNameTxt(username);
        setPasswordTxt(password);
        return clickLoginBtn();
    }
}
