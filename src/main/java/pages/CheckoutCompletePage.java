package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private final By AddToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By navigateToCart = By.cssSelector(".shopping_cart_link");

    private final By inventoryItemName = By.cssSelector(".inventory_item_name");
    private final By checkoutButton = By.id("checkout");


    private final By firstNameForm = By.cssSelector("[data-test='firstName']");
    private final By lastNameForm = By.cssSelector("[data-test='lastName']");
    private final By postcodeForm = By.cssSelector("[data-test='postalCode']");
    private final By checkoutButtonContinue = By.id("continue");

    private final By checkoutOverviewFinishButton = By.id("finish");

    private final By orderConfirmationCheckout = By.cssSelector(".complete-header");
    private final By orderConfirmationMessageCheckout = By.cssSelector(".complete-text");
    private final By backHomeButton = By.id("back-to-products");
    private final By generatePdfOrderButton = By.id("generate-pdf-order");

    public void clickOnAddToCartBackpack(){
        click(AddToCartBackpack);
    }

    public void clickOnNavigateToCart(){
        click(navigateToCart);
    }

    public void isInventoryItemName(){
        findElement(inventoryItemName).isDisplayed();
    }

    public void clickOnCheckoutButton(){
        WebElement element = WaitUtils.waitForElementToBeClickable(driver, checkoutButton, 10);
        element.click();
    }

    public void checkoutSubmissionForm(String firstName, String lastName, String postcode){


        type(firstNameForm, firstName);
        type(lastNameForm, lastName);
        type(postcodeForm, postcode);
        click(checkoutButtonContinue);
    }

    public void clickOnCheckoutOverviewFinishButton(){
        click(checkoutOverviewFinishButton);
    }

    public void clickOnBackHomeButton(){
        click(backHomeButton);
    }

    public void clickGeneratePdfOrderButton(){
        click(generatePdfOrderButton);
    }

    public String orderConfirmation() {
        return findElement(orderConfirmationCheckout).getText();
    }

    public String orderConfirmationMessage() {
        return findElement(orderConfirmationMessageCheckout).getText();
    }

    public void completeItemCheckoutStartToFinish(String firstName, String lastName, String postcode){
        clickOnAddToCartBackpack();
        clickOnNavigateToCart();
        isInventoryItemName();
        clickOnCheckoutButton();
        checkoutSubmissionForm(firstName, lastName, postcode);
        isInventoryItemName();
        clickOnCheckoutOverviewFinishButton();
    }

}
