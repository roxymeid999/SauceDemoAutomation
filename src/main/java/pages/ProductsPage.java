package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    // Locators
    private final By backpackAddButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private final By bikeLightAddButton =
            By.id("add-to-cart-sauce-labs-bike-light");

    private final By fleeceJacketAddButton =
            By.id("add-to-cart-sauce-labs-fleece-jacket");

    private final By cartLink =
            By.className("shopping_cart_link");

    // Actions
    public void addBackpackToCart() {
        click(backpackAddButton);
    }

    public void addBikeLightToCart() {
        click(bikeLightAddButton);
    }

    public void addFleeceJacketToCart() {
        click(fleeceJacketAddButton);
    }

    //Action: Return the next page object for methods that navigate to another page.
    public CartPage openCart() {
        click(cartLink);
        // Navigates to a different page → return the new page object
        return new CartPage(driver);
    }


}
