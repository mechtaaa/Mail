package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMail extends Settings {
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
        int nextNumber = startPageMail.getNumber();
        pageMail.clickSendMail();
        Assert.assertTrue(startPageMail.getNumberTwo(nextNumber)>nextNumber);
    }
}