package org.Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareItemPage extends PageBase{

    public CompareItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    WebElement ComparePageHeader;

    @FindBy(css = "#maincontent > div.columns > div > div.product-info-main > div.product-social-links > div > a.action.tocompare")
    WebElement AddItemToCompare;

    @FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div")
    WebElement ItemAddedSuccessMessage;

    @FindBy(css = "body > div.page-wrapper > header > div.header.content > ul > li > a")
    WebElement CompareProductsPageLink;

    @FindBy(css = "#product-comparison > tbody:nth-child(3) > tr > td > strong > a")
    WebElement ProductName;

    @FindBy(linkText = "Remove Product")
    WebElement RemoveItem;

    @FindBy(css = "#maincontent > div.columns > div > div.message.info.empty")
    WebElement comparePageEmpty;

    @FindBy(className = "action-accept")
    public WebElement removeItemAccept;

    /***********************************************************************/

    public String getHeadername(){
        return ComparePageHeader.getText();
    }

    public String getProductName(){
        return ProductName.getText();
    }

    public String getMessage(){
        return ItemAddedSuccessMessage.getText();
    }

    public void OpenComparePage(){
        ButtonClick(CompareProductsPageLink);
    }

    public void AddToCompare(){
        ButtonClick(AddItemToCompare);
    }

    public void DeleteItem(){
        ButtonClick(RemoveItem);
    }

    public String Empty(){
        return comparePageEmpty.getText();
    }
}
