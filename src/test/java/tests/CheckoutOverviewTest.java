package tests;

import base.BaseTest; // inherit shared test set up
import org.testng.Assert; // import assertions
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

import java.util.List;

public class CheckoutOverviewTest extends BaseTest {

    private CheckoutOverviewPage checkoutOverviewPage;

    private final String expectedProductName = "Sauce Labs Backpack";
    private final double expectedProductPrice = 29.99;

    @BeforeMethod
    public void navigateToCheckoutOverview() {

        LoginPage loginPage = new LoginPage(driver); // create object - page object can now interact with login page

        loginPage.loginAs( // call the method
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        CheckoutInfoPage checkoutInfoPage = cartPage.goToCheckout();

        checkoutOverviewPage = checkoutInfoPage.continueCheckout(
                "Lisa",
                "Harrison",
                "20190"
        );
    }

    @Test
    public void verifyCheckoutOverviewBrowserTab() {

        Assert.assertEquals(
                checkoutOverviewPage.getPageTitle(),
                "Swag Labs",
                "Browser tab title is incorrect."
        );
    }

    //Validation: Page heading displays Checkout: Overview
    @Test
    public void verifyCheckoutOverviewPageHeading() {

        Assert.assertEquals(
                checkoutOverviewPage.getPageHeading(),
                "Checkout: Overview",
                "Checkout Overview heading is incorrect."
        );
    }

    //Validation: Cart badge agrees with number of displayed products
    @Test
    public void verifyCartBadgeMatchesDisplayedProductCount() {

        Assert.assertEquals(
                checkoutOverviewPage.getCartBadgeCount(),
                checkoutOverviewPage.getDisplayedProductCount(),
                "Cart badge count should match the number of displayed products."
        );
        System.out.println();
    }

    // Validate: Selected backpack is shown
    @Test
    public void verifySelectedProductAppearsOnOverviewPage() {

        List<String> displayedProductNames =
                checkoutOverviewPage.getDisplayedProductNames();

        Assert.assertTrue(
                displayedProductNames.contains(expectedProductName),
                expectedProductName + " was not displayed on the overview page."
        );
    }

    @Test
    public void verifySelectedProductPrice() {

        List<Double> displayedProductPrices =
                checkoutOverviewPage.getDisplayedProductPrices();

        Assert.assertTrue(
                displayedProductPrices.contains(expectedProductPrice),
                "Expected product price was not displayed."
        );
    }

    @Test
    public void verifyItemTotalMatchesDisplayedProductPrices() {

        double calculatedProductTotal =
                checkoutOverviewPage.calculateDisplayedProductTotal();

        double displayedItemTotal =
                checkoutOverviewPage.getItemTotal();

        Assert.assertEquals(
                displayedItemTotal,
                calculatedProductTotal,
                0.01,
                "Item total should equal the sum of displayed product prices."
        );
    }

    //Total Amount
    @Test
    public void verifyTotalEqualsItemTotalPlusTax() {

        double expectedTotal =
                checkoutOverviewPage.getItemTotal()
                        + checkoutOverviewPage.getTax();

        Assert.assertEquals(
                checkoutOverviewPage.getTotal(),
                expectedTotal,
                0.01,
                "Total should equal the item total plus tax."
        );
        System.out.println("Actual Total is: " + checkoutOverviewPage.getTotal());
        System.out.println("Expected Total is: " + expectedTotal);
    }

    @Test
    public void verifyFinishAndCancelButtons() {

        Assert.assertTrue(
                checkoutOverviewPage.isFinishButtonDisplayed(),
                "Finish button should be displayed."
        );

        Assert.assertTrue(
                checkoutOverviewPage.isFinishButtonEnabled(),
                "Finish button should be enabled."
        );

        Assert.assertTrue(
                checkoutOverviewPage.isCancelButtonDisplayed(),
                "Cancel button should be displayed."
        );

        Assert.assertTrue(
                checkoutOverviewPage.isCancelButtonEnabled(),
                "Cancel button should be enabled."
        );
    }

}
