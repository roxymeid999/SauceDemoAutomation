package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameLocator = By.id("user-name");
    private final By passwordLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        type(usernameLocator, username);
    }

    public void enterPassword(String password) {
        type(passwordLocator, password);
    }

    public void clickLoginButton() {
        click(loginButtonLocator);
    }

    public void loginAs(String username, String password) {
        type(usernameLocator, username);
        type(passwordLocator, password);
        click(loginButtonLocator);
    }
}
