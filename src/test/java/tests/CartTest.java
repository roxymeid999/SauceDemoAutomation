package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        // Open Website
        driver.get("https://www.saucedemo.com/");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        // Inventory Page
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Save product information
        String expectedName = inventoryPage.getProductName();
        String expectedPrice = inventoryPage.getProductPrice();
        String expectedDescription = inventoryPage.getProductDescription();

        // Add product to cart
        inventoryPage.addBackpackToCart();

        // Verify badge count
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1");

        // Verify button changed to Remove
        Assert.assertEquals(inventoryPage.getRemoveButtonText(), "Remove");

        // Open Cart
        inventoryPage.openCart();

        // Cart Page
        CartPage cartPage = new CartPage(driver);

        // Verify product information
        Assert.assertEquals(cartPage.getProductName(), expectedName);
        Assert.assertEquals(cartPage.getProductPrice(), expectedPrice);
        Assert.assertEquals(cartPage.getProductDescription(), expectedDescription);
    }
}