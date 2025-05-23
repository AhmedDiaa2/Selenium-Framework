import Data.TestData;
import org.Selenium.pages.HomePage;
import org.Selenium.pages.UserRegistrationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

/* Overall steps */
//1- open website
//2- Click create account
//3- enter required fields
//4- Click Create an account

/* test cases */
//Register with valid fields
//Register with invalid field assert error message

public class UserRegistrationTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;

    @BeforeMethod
    void init(){
        homeObject = new HomePage(driver);
        registerObject = new UserRegistrationPage(driver);
        homeObject.OpenRegistrationPage();
    }

    @Test(priority = 1,dataProvider = "registerData",dataProviderClass = TestData.class)
    public void UserCanRegister_Successfully(String Fname, String Lname, String mail, String pass, String condition){

        registerObject.userRegistration(Fname,Lname,mail,pass);
        switch (condition) {
            case "success":
                Assert.assertEquals(registerObject.RegisterSuccess(), "Thank you for registering with Main Website Store.");
                registerObject.userLogout();
                break;
            case "duplicate":
                var errorMessage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div"));
                Assert.assertEquals(errorMessage.getText(), "There is already an account with this email address. " +
                        "If you are sure that it is your email address, click here to get your password and access your account.");
                break;
            case "error":
                Assert.assertEquals(registerObject.FieldError(),"This is a required field.");
                break;
            default:
                break;
        }


    }

}
