package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    //Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Locator
    private final By checkoutBtn = By.id("checkout");


    //Action: Return the next page object for methods that navigate to another page.
    public CheckoutInfoPage goToCheckout() {
        click(checkoutBtn);
        // Navigates to a different page → return the new page object
        return new CheckoutInfoPage(driver);
    }
}
