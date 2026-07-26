package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {

        WebElement element = WaitUtils.waitForElementToBeClickable(driver, locator, 10);
        element.click();
    }

    public void type(By locator, String text) {

        WebElement element = WaitUtils.waitForElementToBeVisible(driver, locator, 10);
        element.clear();
        element.sendKeys(text);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
