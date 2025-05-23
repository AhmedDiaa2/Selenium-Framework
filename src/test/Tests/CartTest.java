import org.Selenium.pages.CartPage;
import org.Selenium.pages.CompareItemPage;
import org.Selenium.pages.ProductDisplayPage;
import org.Selenium.pages.catalogsearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends TestBase{

    ProductDisplayPage productDetails;
    catalogsearchPage catalogObject;
    CartPage cartObject;

    final String EmptyCartText = "You have no items in your shopping cart.";

    @BeforeMethod
    void init(){
        cartObject = new CartPage(driver);
        catalogObject = new catalogsearchPage(driver);
        productDetails = new ProductDisplayPage(driver);
    }

    @Test(priority = 1)
    public void check_EmptyCart() {
        cartObject.showCart();

        if(cartObject.CartDropDownToCheckout.isDisplayed()) {
            Assert.assertEquals(cartObject.CartEmptyDropDown.getText(), EmptyCartText);
        }
    }

    @Test(priority = 2)
    public void AddItem_ToCart() {
        catalogObject.openProductPage();
        productDetails.pickSize();
        productDetails.pickColor();
        productDetails.AddToCart();

        Assert.assertEquals(productDetails.AlertMessage(),"You added Argus All-Weather Tank to your shopping cart.");
    }

    @Test(priority = 3)
    public void EditQuantity_OfItemInCart() {

        final String updatedQty = "5";

        cartObject.showCart();
        cartObject.ViewAndEditCart();
        cartObject.EditItem();

        productDetails.updateQty(updatedQty);
        productDetails.updateCart();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div")));
        try {
            Assert.assertEquals(cartObject.updateMessage(),"Argus All-Weather Tank was updated in your shopping cart.");
        } catch (StaleElementReferenceException elementHasDisappeared) {
            WebElement updated = driver.findElement(By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div"));
            Assert.assertEquals(updated.getText(),"Argus All-Weather Tank was updated in your shopping cart.");
        }

    }

    @Test(priority = 4)
    public void RemoveItemFromCart() throws InterruptedException {

        Thread.sleep(500);

        cartObject.showCart();
        cartObject.ViewAndEditCart();

        cartObject.RemoveItem();
        Assert.assertEquals(cartObject.noItemsinCart(), "You have no items in your shopping cart.");

    }


}
