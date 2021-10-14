package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageMail {

    public WebDriver driver;
    public PageMail(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//textarea[@class='vO']")
    WebElement whom;

    @FindBy(xpath = "//input[@class='aoT']")
    WebElement topic;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    WebElement letter;

    @FindBy(xpath = "//div[text()='Отправить']")
    WebElement sendMail;

    public void writeWhom(String mail){ whom.sendKeys(mail); } // кому

    public void writeTopic(String text){
        topic.sendKeys(text);
    } // тема

    public void writeText(String text){ letter.sendKeys(text); } //письмо

    public void clickSendMail(){
        sendMail.click();
    } //нажать отправить
}
