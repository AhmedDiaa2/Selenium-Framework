import org.Selenium.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchingTest extends TestBase{

    SearchPage SearchObject;
    ProductDisplayPage productDetails;
    catalogsearchPage catalogObject;

    String fullProductToSearch = "Argus All-Weather Tank";

    @BeforeMethod
    void init(){
        SearchObject = new SearchPage(driver);
        productDetails = new ProductDisplayPage(driver);
        catalogObject = new catalogsearchPage(driver);
    }

    @Test
    public void UserCAnSearchForAProduct(){

        SearchObject.Search(fullProductToSearch);

        catalogObject.openProductPage();

        Assert.assertEquals(productDetails.getproductName(), fullProductToSearch);
    }
}

//Check search for no results input:tnak
//Test searching with special characters in the query.
//Check for case insensitivity in search queries.