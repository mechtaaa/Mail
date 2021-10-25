package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;
import static org.example.TestMail.driver;

@Listeners({AllureListener.class})
public class BaseTest {

    public void initialize(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver(){
        return driver;
    }
}