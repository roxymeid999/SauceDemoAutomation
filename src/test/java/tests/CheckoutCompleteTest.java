package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;
import pages.LoginPage;
import utils.ConfigReader;

import static org.testng.TestRunner.PriorityWeight.priority;

public class CheckoutCompleteTest extends BaseTest {

    @Test(priority = 1, groups = { "regression" })
    public void checkoutCompleteOrderConfirmationMessageTest(){

        driver.get(ConfigReader.getProperty("loginUrl"));

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAs(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));


        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        checkoutCompletePage.completeItemCheckoutStartToFinish("Roxy", "Zak", "000000");

        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-complete.html"));

        Assert.assertEquals(checkoutCompletePage.orderConfirmation(),"Thank you for your order!");
        Assert.assertEquals(checkoutCompletePage.orderConfirmationMessage(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");

    }

    @Test(priority = 1, groups = { "regression" })
    public void checkoutCompleteOrderConfirmationButtonsTest(){

        driver.get(ConfigReader.getProperty("loginUrl"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        checkoutCompletePage.completeItemCheckoutStartToFinish("Roxy", "Zak", "000000");

        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-complete.html"));

        checkoutCompletePage.clickOnBackHomeButton();

        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));

    }
}
