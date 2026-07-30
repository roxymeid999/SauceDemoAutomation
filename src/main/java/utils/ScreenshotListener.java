package utils;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

public class ScreenshotListener implements ITestListener {

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        try {
            // Автоматически ищем поле driver в твоем запущенном тесте
            Field driverField = currentClass.getClass().getDeclaredField("driver");
            driverField.setAccessible(true);
            WebDriver driver = (WebDriver) driverField.get(currentClass);

            if (driver != null) {
                saveScreenshot(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}