package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.className("inventory_item_name");
    private final By productPrice = By.className("inventory_item_price");
    private final By productDescription = By.className("inventory_item_desc");

    public String getProductName() {
        return findElement(productName).getText();
    }

    public String getProductPrice() {
        return findElement(productPrice).getText();
    }

    public String getProductDescription() {
        return findElement(productDescription).getText();
    }
}