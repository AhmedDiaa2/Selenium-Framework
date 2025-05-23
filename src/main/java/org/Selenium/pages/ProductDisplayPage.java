package org.Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDisplayPage extends PageBase{
    public ProductDisplayPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    WebElement Productname;

    @FindBy(id = "option-label-size-143-item-168")
    WebElement mediumSize;

    @FindBy(id = "option-label-color-93-item-52")
    WebElement grayColor;

    @FindBy(id = "product-addtocart-button")
    public WebElement AddToCartBtn;

    @FindBy(id = "product-updatecart-button")
    WebElement updateCartBtn;

    @FindBy(id = "qty")
    WebElement qtyInput;

    @FindBy(css = "#product-options-wrapper > div > div > div.swatch-attribute.size > span.swatch-attribute-selected-option")
    WebElement selectedSize;

    @FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div")
    WebElement AddedSuccessMessage;


    /****************************************Functions**********************************************/

    public String getproductName(){
        return Productname.getText();
    }

    public String getSize(){
        return mediumSize.getText();
    }

    public String getSelectedSize(){
        return selectedSize.getText();
    }

    public void pickSize(){
        ButtonClick(mediumSize);
    }

    public void pickColor(){
        ButtonClick(grayColor);
    }

    public void AddToCart(){
        ButtonClick(AddToCartBtn);
    }

    public void updateQty(String qty){
        qtyInput.clear();
        sendTextInElement(qtyInput,qty);
    }

    public void updateCart(){
        ButtonClick(updateCartBtn);
    }

    public String AlertMessage(){
        return AddedSuccessMessage.getText();
    }
}
