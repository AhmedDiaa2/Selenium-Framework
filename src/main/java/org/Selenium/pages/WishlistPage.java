package org.Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.plaf.metal.MetalBorders;

public class WishlistPage extends PageBase{

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    WebElement WishlistHeader;

    //Button in Product Display page
    @FindBy(css = "#maincontent > div.columns > div > div.product-info-main > div.product-social-links > div > a.action.towishlist")
    WebElement AddItemToWishlist;

    @FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div")
    WebElement WishlistItemMessage;

    @FindBy(css = "#maincontent > div.columns > div.column.main > div:nth-child(6) > div > p > span")
    WebElement itemCounter;

    @FindBy(css = "#wishlist-sidebar > li > div > div > div.product-item-actions > div.actions-secondary > a")
    WebElement RemoveButton;

    @FindBy(css = "#wishlist-sidebar > li > div > div > strong > a > span")
    WebElement ItemNameInWishlist;

    @FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div > div")
    WebElement MustLoginToAddItem;

    @FindBy(css = "#wishlist-view-form > div.message.info.empty > span")
    WebElement noItems;


    /**************************************************************************/

    public void AddItemToWishlist(){
        ButtonClick(AddItemToWishlist);
    }

    public String getHeaderName(){
        return WishlistHeader.getText();
    }

    public String getItemNameInWishlist(){
        return ItemNameInWishlist.getText();
    }

    public String getWishlistCounter(){
        return itemCounter.getText();
    }

    public void RemoveItemFromWishlist(){
        ButtonClick(RemoveButton);
    }

    public String getUnregisteredAddingItemtoWishlist(){
        return MustLoginToAddItem.getText();
    }

    public String EmptyWishlist(){
        return noItems.getText();
    }

    public String successMessage(){
        return WishlistItemMessage.getText();
    }
}
