package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMail extends BaseTest  {
    public static WebDriver driver;
    public PageMail pageMail;
    public StartPageMail startPageMail;

    @BeforeTest
    public void setUp() {
        BaseTest baseTest = new BaseTest();
        baseTest.initialize();
        driver = getDriver();
        driver.get("https://www.google.com/");
    }

    @Step("Проверка на колличество писем")
    @Test
    public void firstTaskTest() throws InterruptedException {
        startPageMail = new StartPageMail(driver);
        pageMail = new PageMail(driver);
        startPageMail.clickInput();
        startPageMail.writeLogin("azov123azov@gmail.com");
        startPageMail.clickInputLogin();
        startPageMail.writePass("azov123321azov");
        Thread.sleep(3000);
        startPageMail.clickInputMail();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        pageMail.writeWhom("azov123azov@gmail.com");
        pageMail.writeTopic("Simbirsoft theme");
        pageMail.writeText("Найдено " + startPageMail.getNumber() + " писемо\\ьма");
        pageMail.clickSendMail();
        startPageMail.resultAssert();
    }
}