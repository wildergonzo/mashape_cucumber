package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginModal {

    private WebDriver driver;
    private WebDriverWait wait;
    private By formLogin = By.cssSelector("form.login");
    private By nameTextField = By.cssSelector("form.login > div.input-group.connected > input[name=\"name\"]");
    private By passwordTextField = By.cssSelector("form.login > div.input-group.connected > input[name=\"password\"]");
    private By loginBtn = By.cssSelector("form.login > button[name=\"regular\"]");

    public LoginModal(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(formLogin));
    }

    public void setUserNameTxt(String username) {
        driver.findElement(nameTextField).clear();
        driver.findElement(nameTextField).sendKeys(username);
    }

    public void setPasswordTxt(String password) {
        driver.findElement(passwordTextField).clear();
        driver.findElement(passwordTextField).sendKeys(password);
    }

    public DashboardHeader clickLoginBtn() {
        driver.findElement(loginBtn).click();
        return new DashboardHeader(driver);
    }

    public DashboardHeader loginAs(String username, String password) {
        setUserNameTxt(username);
        setPasswordTxt(password);
        return clickLoginBtn();
    }
}
