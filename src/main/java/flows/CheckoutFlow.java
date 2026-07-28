package flows;
//The CheckoutFlow class is a test setup/navigation helper. Its purpose is to perform all the steps required
// to reach the Checkout Overview page, so the actual test class can focus only on testing that page.

import org.openqa.selenium.WebDriver;
import pages.*;

// Once individual page objects exist, CheckoutFlow can coordinate them to
// get your test from login to the checkout page you actually need to test.
//The flow should contain navigation/setup logic—not assertions.
public class CheckoutFlow {
    private final WebDriver driver;

    public CheckoutFlow(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutOverviewPage navigateToCheckoutOverview(
            String username,
            String password,
            String firstName,
            String lastName,
            String postalCode) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(username, password);

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addBackpackToCart();
        productsPage.addBikeLightToCart();

        CartPage cartPage = productsPage.openCart();

        CheckoutInfoPage checkoutInfoPage = cartPage.goToCheckout();

        return checkoutInfoPage.continueCheckout(
                firstName,
                lastName,
                postalCode);
    }
}
