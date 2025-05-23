
//successful register,login then navigate to a product and add it to wishlist
//Not logged in then navigate to a product and add it to wishlist (Should redirect to the login page with an error message
// "You must login or register to add items to your wishlist.")

//Removing item from wishlist

import Data.TestData;
import org.Selenium.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.Selenium.pages.UserLoginPage.userLogin;

public class WishlistTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    WishlistPage wishlistObject;
    catalogsearchPage catalogObject;
    UserLoginPage loginObject;
    SoftAssert softAssert;

    @BeforeMethod
    void init(){
        wishlistObject = new WishlistPage(driver);
        catalogObject = new catalogsearchPage(driver);
        homeObject = new HomePage(driver);
        registerObject = new UserRegistrationPage(driver);
        loginObject = new UserLoginPage(driver);
        softAssert = new SoftAssert();
    }

    private void AddingToWishList(){
        catalogObject.openProductPage();
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("#maincontent > div.columns > div > div.product-info-main > div.product-social-links > div > a.action.towishlist")));
        wishlistObject.AddItemToWishlist();
    }

    @Test(priority = 1, dataProvider = "wishlistlogin",dataProviderClass = TestData.class)
    public void RegisteredUser_ISAbleToAddItemToWishlist(String email, String password){

        homeObject.OpenLoginPage();
        userLogin(email,password);
        homeObject.ReturnToHomePage();

        AddingToWishList();

        softAssert.assertEquals(catalogObject.getItemName() + " has been added to your Wish List. Click here to continue shopping."
                ,wishlistObject.getItemNameInWishlist() + " has been added to your Wish List. Click here to continue shopping.");
        softAssert.assertEquals(wishlistObject.getHeaderName(),"My Wish List");
        softAssert.assertEquals(wishlistObject.getWishlistCounter(), "1 Item");

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void RegisteredUser_RemoveItemFromWishlist(){

        String ItemName = wishlistObject.getItemNameInWishlist();
        wishlistObject.RemoveItemFromWishlist();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div")));

        softAssert.assertEquals(wishlistObject.successMessage(),ItemName + " has been removed from your Wish List.");
        softAssert.assertEquals(wishlistObject.EmptyWishlist(),"You have no items in your wish list.");

    }

    @Test(priority = 3)
    public void UnRegisteredUser_UnableToAddItemToWishlist(){
        homeObject.ReturnToHomePage();
        registerObject.userLogout();
        AddingToWishList();
        softAssert.assertEquals(loginObject.getLoginHeader(),"Customer Login");
        softAssert.assertEquals(wishlistObject.getUnregisteredAddingItemtoWishlist(),"You must login or register to add items to your wishlist.");
        softAssert.assertAll();
    }

}
