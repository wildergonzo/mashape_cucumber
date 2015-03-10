package mashape.pages;

import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;

import framework.selenium.DriverManager;

/**
 * Created by wilder on 3/3/15.
 */

public class HomePage {
    private WebDriver driver;
    private String baseUrl;
    private By loginBtn = By.xpath("//span[contains(@class,'text')]");

    public HomePage() {
        driver = DriverManager.getInstance().getWebDriver();
        baseUrl = "https://www.mashape.com";
        driver.get(baseUrl);
    }

    public LoginModal clickLoginBtn() {
        driver.findElement(loginBtn).click();
        return new LoginModal(driver);
    }

    public DashboardPage loginAs(String username, String password) {
        try {
            DashboardPage dashboard = new DashboardPage(driver);
            if (!dashboard.getCurrentUserName().equals(username)) {
                //dashboard.logout();
                LoginModal loginModal = clickLoginBtn();
                loginModal.loginAs(username, password);
            }
        } catch (WebDriverException e) {
            LoginModal loginModal = clickLoginBtn();
            loginModal.loginAs(username, password);
        }
        return new DashboardPage(driver);
    }

}
