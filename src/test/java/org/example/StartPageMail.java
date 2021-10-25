package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StartPageMail {
    public WebDriver driver;

    public StartPageMail(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(text(), 'Войти')]")
    WebElement input;

    @FindBy(xpath = "//input[@type='email']")
    WebElement login;

    @FindBy(xpath = "//span[@jsname='V67aGc']")
    WebElement inputLogin;

    @FindBy(xpath = "//input[@name='password']")
    WebElement pass;

    @FindBy(xpath = "//span[contains(text(), 'Далее')]")
    WebElement inputPass;

    @FindBy(xpath = "//a[@class='gb_f']")
    WebElement mail;

    @FindBy(xpath = "//div[contains(text(), 'Написать')]")
    WebElement mailWrite;

    public void clickInput(){ input.click(); } //нажать Почта

    public void writeLogin(String mail){ login.sendKeys(mail); } // написать Логин в строке Логин

    public void clickInputLogin(){ inputLogin.click(); } //нажать Войти после ввода логина

    public void writePass(String text){ pass.sendKeys(text); } //написать Пароль в строке Пароль

    public void clickInputMail(){ inputPass.click(); mail.click(); mailWrite.click(); }//войти в почту после всех вводов

    public int getNumber() {
        int  number = driver.findElements(By.xpath("//span[contains(text(), 'Simbirsoft theme')]")).size();
        return number;
    }

    public int getNumberTwo(int number){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan((By.xpath("//span[contains(text(), 'Simbirsoft theme')]")), number));
        return getNumber();
    }

    public void resultAssert(){
        int nextNumber = getNumber();
        Assert.assertTrue(getNumberTwo(nextNumber)<nextNumber);
    }
}