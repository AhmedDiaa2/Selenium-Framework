
//Add item to compare successfully (Assert add successfully, assert CompareProduct button is displayed at top, Assert item name in the compare page)
//Remove item from compare page (Assert it is removed)

import org.Selenium.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompareItemTest extends TestBase{

    catalogsearchPage catalogObject;
    CompareItemPage CompareItemObject;
    ProductDisplayPage ProductObject;

    @BeforeMethod
    void init(){
        catalogObject = new catalogsearchPage(driver);
        CompareItemObject = new CompareItemPage(driver);
        ProductObject = new ProductDisplayPage(driver);
    }

    @Test(priority = 1)
    public void User_IsAbleToAdd_andRemove_ItemToCompare(){

        catalogObject.openProductPage();
        CompareItemObject.AddToCompare();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div.page-wrapper > header > div.header.content > ul > li > a")));

        Assert.assertEquals(ProductObject.AlertMessage(),"You added product Argus All-Weather Tank to the comparison list.");

        CompareItemObject.OpenComparePage();

        Assert.assertEquals(CompareItemObject.getHeadername(),"Compare Products");
        Assert.assertEquals(CompareItemObject.getProductName(),"Argus All-Weather Tank");


    }

    @Test(priority = 2)
    public void User_IsAbleTo_Remove_ItemInCompare(){

        CompareItemObject.DeleteItem();
        CompareItemObject.removeItemAccept.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div")));
        Assert.assertEquals(CompareItemObject.getMessage(),"You removed product Argus All-Weather Tank from the comparison list.");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#maincontent > div.columns > div > div.message.info.empty")));
        Assert.assertEquals(CompareItemObject.Empty(),"You have no items to compare.");

    }
}
