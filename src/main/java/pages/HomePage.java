package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


public class HomePage {

    private WebDriver driver;
    private By loginBtn = By.cssSelector("span.text");

    public HomePage() {
        driver = DriverManager.getInstance().getWebDriver();
        String baseUrl = "https://www.mashape.com";
        driver.get(baseUrl);
    }

    public LoginModal clickLoginBtn() {
        driver.findElement(loginBtn).click();
        return new LoginModal(driver);
    }

    public DashboardHeader loginAs(String username, String password) {
        try {
            DashboardHeader dashboardHeader = new DashboardHeader(driver);
            if (!dashboardHeader.getCurrentUserName().equals(username)) {
                dashboardHeader.logout();
                LoginModal loginModal = clickLoginBtn();
                loginModal.loginAs(username, password);
            }
        } catch (WebDriverException e) {
            LoginModal loginModal = clickLoginBtn();
            loginModal.loginAs(username, password);
        }
        return new DashboardHeader(driver);
    }
}
