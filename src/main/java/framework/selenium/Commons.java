package framework.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by CARLEDRISS on 3/16/2015.
 */
public class Commons {

    public static boolean isElementPresent(By by) {
        try {
            DriverManager.getInstance().getWebDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
