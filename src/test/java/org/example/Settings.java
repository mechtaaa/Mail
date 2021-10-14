package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

public class Settings {

    public ChromeDriver driver;
    public PageMail pageMail;
    public StartPageMail startPageMail;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        // для всех тестов будет загружаться драйвер
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }
}
