package org.Selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search")
    WebElement searchField;

    @FindBy(css= "#search_mini_form > div.actions > button")
    WebElement searchButton;

    @FindBy(id = "search_autocomplete")
    List<WebElement> searchAutocomplete;

    //******************************************//

    public void Search(String productName){
        sendTextInElement(searchField,productName);
        ButtonClick(searchButton);
    }
}
