package org.example;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.ByteArrayInputStream;

import static org.example.TestMail.driver;


public class AllureListener extends TestListenerAdapter {
    @Attachment(value = "Screenshot", type = "image / png")
    public byte[]  saveScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        saveScreenshot(driver);
        Allure.addAttachment("TestMail", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }
}