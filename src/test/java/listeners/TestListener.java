package listeners;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest test = (BaseTest) result.getInstance();

        WebDriver driver = test.getDriver();

        if (driver != null) {

            byte[] screenshot = ScreenshotUtils.takeScreenshot(driver);

            Allure.addAttachment(
                    "Failure Screenshot",
                    new ByteArrayInputStream(screenshot)
            );
        }
    }
}
