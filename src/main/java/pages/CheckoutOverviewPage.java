package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    // Page information
    private final By pageHeading = By.className("title");
    private final By cartBadge = By.className("shopping_cart_badge");

    // Product information
    private final By cartItems = By.className("cart_item");
    private final By productNames = By.className("inventory_item_name");
    private final By productPrices = By.className("inventory_item_price");

    // Summary information
    private final By itemTotal = By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");
    private final By total = By.className("summary_total_label");

    // Buttons
    private final By cancelButton = By.id("cancel");
    private final By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    // Page information

    public String getPageHeading() {
        return getText(pageHeading);
    }

    public int getCartBadgeCount() {
        return Integer.parseInt(getText(cartBadge));
    }

    public int getDisplayedProductCount() {
        return driver.findElements(cartItems).size();
    }

    // Product information

    public List<String> getDisplayedProductNames() {
        return driver.findElements(productNames)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<Double> getDisplayedProductPrices() {
        return driver.findElements(productPrices)
                .stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .map(Double::parseDouble)
                .toList();
    }

    public double calculateDisplayedProductTotal() {
        return getDisplayedProductPrices()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    // Checkout summary

    public double getItemTotal() {
        return parseAmount(getText(itemTotal));
    }

    public double getTax() {
        return parseAmount(getText(tax));
    }

    public double getTotal() {
        return parseAmount(getText(total));
    }

    private double parseAmount(String text) {
        String amount = text.substring(text.indexOf("$") + 1);
        return Double.parseDouble(amount);
    }

    // Button information

    public boolean isFinishButtonDisplayed() {
        return findElement(finishButton).isDisplayed();
    }

    public boolean isFinishButtonEnabled() {
        return findElement(finishButton).isEnabled();
    }

    public boolean isCancelButtonDisplayed() {
        return findElement(cancelButton).isDisplayed();
    }

    public boolean isCancelButtonEnabled() {
        return findElement(cancelButton).isEnabled();
    }

    // Navigation actions

    public void clickCancelButton() {
        click(cancelButton);
    }

    public CheckoutCompletePage clickFinishButton() {
        click(finishButton);
        return new CheckoutCompletePage(driver);
    }

}
