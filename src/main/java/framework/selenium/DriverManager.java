package framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by wilder on 3/6/2015.
 */
public class DriverManager {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private static DriverManager instance = null;
    private String browser = "Firefox";

    private DriverManager() {
        initializeWebDriver();
    }

    public static DriverManager getInstance() {
        if (instance == null || instance.driver == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Get the Web driver
     *
     * @return
     */
    public WebDriver getWebDriver() {
        return driver;
    }

    /**
     * Get the Web Driver wait
     *
     * @return
     */
    public WebDriverWait getWait() {
        return webDriverWait;
    }

    /**
     * Quite the Driver and set to null the Web Driver
     */
    public void quitDriver() {
        try {
            driver.quit();
        } catch (Exception e) {
        }
        driver = null;
    }

    private void initializeWebDriver() {
        if (browser.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browser.equals("Safari")) {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 30);
    }
}
