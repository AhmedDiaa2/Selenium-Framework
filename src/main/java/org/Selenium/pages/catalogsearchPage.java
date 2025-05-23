package org.Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class catalogsearchPage extends PageBase{

    public catalogsearchPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(linkText = "Argus All-Weather Tank")
    WebElement ProductItemLink;

    public void openProductPage(){
        ProductItemLink.click();
    }
    public String getItemName(){
        return ProductItemLink.getText();
    }
}
