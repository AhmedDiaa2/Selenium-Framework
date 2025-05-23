import Data.TestData;
import org.Selenium.pages.HomePage;
import org.Selenium.pages.UserLoginPage;
import org.Selenium.pages.UserRegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.Selenium.pages.UserLoginPage.userLogin;


/* Overall steps */
//1- open website
//2- Click Register with a new account
//3- logout
//4- click sign in
//5- Enter email and password

/* test cases */
//Login Successfully
//Login with invalid email or password assert error message

public class UserLoginTest extends TestBase{

    HomePage home;
    UserLoginPage userLogin;
    UserRegistrationPage register;

    @BeforeMethod
    void init(){
        home = new HomePage(driver);
        register = new UserRegistrationPage(driver);
        userLogin = new UserLoginPage(driver);
        home.OpenLoginPage();
    }

    @Test(priority = 1,dataProvider = "LoginData",dataProviderClass = TestData.class)
    public void userCanLogin_Successfully(String email,String password, String condition){

        userLogin(email,password);

        switch (condition) {
            case "success":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className("logged-in")));
                Assert.assertEquals(userLogin.getUserName(),"Welcome, ahmed diaa!");
                register.userLogout();
                break;

            case "NotRegistered":
                Assert.assertEquals(userLogin.DuplicatedEmail(), "The account sign-in was incorrect or your account is disabled temporarily. " +
                        "Please wait and try again later.");
                break;

            case "invalidemail":
                Assert.assertEquals(userLogin.LoginError(),"Please enter a valid email address (Ex: johndoe@domain.com).");
                break;

            case "error":
                Assert.assertEquals(userLogin.LoginError(),"This is a required field.");
                Assert.assertEquals(userLogin.passwordError(),"This is a required field.");
                break;

            default:
                break;
        }
    }
}
