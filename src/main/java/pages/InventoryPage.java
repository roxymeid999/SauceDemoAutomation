package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
public InventoryPage (WebDriver driver){
    super(driver);
}
    private final By backpackName = By.id("item_4_title_link");
    private final By backpackPrice = By.className("inventory_item_price");
    private final By backpackDescription = By.className("inventory_item_desc");
    private final By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By cartBadge = By.className("shopping_cart_badge");

    public void addBackpackToCart() {
        click(addToCartButton);
    }
    public void openCart() {
        click(cartIcon);
    }
    public String getProductName() {
        return findElement(backpackName).getText();
    }
    public String getProductPrice() {
        return findElement(backpackPrice).getText();
    }
    public String getProductDescription() {
        return findElement(backpackDescription).getText();
    }
    public String getCartBadgeCount() {
        return findElement(cartBadge).getText();
    }

    private final By removeButton = By.id("remove-sauce-labs-backpack");
    public String getRemoveButtonText() {
        return findElement(removeButton).getText();
    }



}
