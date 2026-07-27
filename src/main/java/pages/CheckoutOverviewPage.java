package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    // Locators

    private final By productNames = By.className("inventory_item_name");
    private final By pageTitle = By.className("title");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartItems = By.className("cart_item");
    private final By itemTotal = By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");
    private final By total = By.className("summary_total_label");


    private final By cancelButton = By.id("cancel");
    private final By finishButton = By.id("finish");


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    //Page Information
    public int getCartBadgeCount() {
        return Integer.parseInt(getText(cartBadge));
    }

    public String getPageHeading() {
        return getText(pageTitle);
    }

    // convert list of web elements to return list of strings
    public List<String> getDisplayedProductNames() {
        return driver.findElements(productNames)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    //Actions

    public void clickCancelButton() {
        click(cancelButton);
    }

    public void clickFinishButton() {
        click(finishButton);
    }


}
