package org.Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "minicart-wrapper")
    public WebElement CheckCart;

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/div")
    public WebElement CartDropDownToCheckout;

    @FindBy(linkText = "View and Edit Cart")
    public WebElement ViewCart;

    @FindBy(css = "#minicart-content-wrapper > div.block-content > strong")
    public WebElement CartEmptyDropDown;

    @FindBy(tagName = "h1")
    WebElement CartHeader;

    @FindBy(linkText = "Argus All-Weather Tank")
    WebElement Cart_productItemName;

    @FindBy(linkText = "Remove item")
    WebElement RemoveItemBtn;

    @FindBy(linkText = "Edit")
    WebElement editItemBtn;

    @FindBy(css = "#maincontent > div.columns > div > div.cart-empty > p:nth-child(1)")
    WebElement noItemsInCart;

    @FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div")
    WebElement updatedSuccessMessage;

    /********************************************************************/

    public String getCartHeader(){
        return CartHeader.getText();
    }
    public String getProductname(){
        return Cart_productItemName.getText();
    }

    public String noItemsinCart(){
        return noItemsInCart.getText();
    }

    public void showCart(){
        ButtonClick(CheckCart);
    }

    public void ViewAndEditCart(){
        ButtonClick(ViewCart);
    }

    public void RemoveItem(){
        ButtonClick(RemoveItemBtn);
    }

    public void EditItem(){
        ButtonClick(editItemBtn);
    }

    public String updateMessage(){
        return updatedSuccessMessage.getText();
    }

}
