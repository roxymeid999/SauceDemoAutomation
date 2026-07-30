package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test(groups = { "smoke", "regression" })
    public void successfulLoginTest(){


        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAs("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));

    }
}
