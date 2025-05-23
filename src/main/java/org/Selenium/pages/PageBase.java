package org.Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;


    public PageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public static void ButtonClick(WebElement element){
        element.click();
    }

    public static void sendTextInElement(WebElement element, String text){
        element.sendKeys(text);
    }


}
