package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {

    //Constructor
    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }
    //Locators
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");

    //Actions
    public void inputFirstName(String first) {
        type(firstName, first);
    }

    public void inputLastName(String last) {
        type(lastName, last);
    }

    public void inputZip(String postCodeNum) {
        type(postalCode, postCodeNum);
    }


    //Action: Return the next page object for methods that navigate to another page.
    public CheckoutOverviewPage continueCheckout(
            String first,
            String last,
            String zip) {

        type(firstName, first);
        type(lastName, last);
        type(postalCode, zip);

        click(continueBtn);

        return new CheckoutOverviewPage(driver);
    }
}
