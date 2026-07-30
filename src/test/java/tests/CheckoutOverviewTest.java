package tests;
/*
import base.BaseTest;
// import the checkout flows page to enable this test execution
import flows.CheckoutFlow;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutOverviewPage;

public class CheckoutOverviewTest extends BaseTest {

    private CheckoutOverviewPage checkoutOverviewPage;


    @BeforeMethod
    public void navigateToOverviewPage() {

        CheckoutFlow checkoutFlow = new CheckoutFlow(driver);

        checkoutOverviewPage =
                checkoutFlow.navigateToCheckoutOverview(
                        "standard_user",
                        "secret_sauce",
                        "Joe",
                        "Bloggs",
                        "12345"
                );
    }
    // Verify Checkout Overview Browser Tab.
    @Test
    public void verifyCheckoutOverviewPageTab() {
        Assert.assertEquals(
                checkoutOverviewPage.getPageTitle(),
                "Swag Labs"
        );
    }

// Verify Checkout Overview page title.
@Test
public void verifyCheckoutOverviewPage() {
    Assert.assertEquals(
            checkoutOverviewPage.getPageHeading(),
            "Checkout: Overview"
    );
    System.out.println("Actual Page Heading: " + checkoutOverviewPage.getPageHeading());
    System.out.println("Expected Page Heading is: Checkout: Overview");
}

// Verify cart badge count matches the number of displayed products.
@Test
public void verifyCartBadgeCount() {

    int cartBadgeCount =
            checkoutOverviewPage.getCartBadgeCount();

    int displayedProductCount =
            checkoutOverviewPage
                    .getDisplayedProductNames()
                    .size();

    Assert.assertEquals(
            cartBadgeCount,
            displayedProductCount,
            "Cart badge count should match displayed product count."
    );
    System.out.println("Total cart items = " + cartBadgeCount + " Total Displayed Items are: " + displayedProductCount);
}
// Verify each selected product appears on the overview page.
// Verify product names and prices match the cart.
// Verify item total equals the sum of all displayed product prices.
// Verify total equals item total plus tax.
// Verify Finish and Cancel buttons are displayed and enabled.


}
*/