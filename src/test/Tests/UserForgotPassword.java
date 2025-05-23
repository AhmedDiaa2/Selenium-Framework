import Data.TestData;
import org.Selenium.pages.ForgotPasswordPage;
import org.Selenium.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserForgotPassword extends TestBase{

    HomePage home;
    ForgotPasswordPage RstPass;

    @BeforeMethod
    void init(){
        home = new HomePage(driver);
        RstPass = new ForgotPasswordPage(driver);
    }

    @Test(dataProvider = "forgotPass",dataProviderClass = TestData.class)
    public void ResetPassword_cases(String email,String condition){

        ChangePassword(email);

        switch(condition){
            case "success":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
                Assert.assertEquals(RstPass.RstSuccess(), "If there is an account associated with " + email +
                        " you will receive an email with a link to reset your password.");
                break;
            case "empty":
                Assert.assertEquals(RstPass.RstError(), "This is a required field.");
                break;
            case "invalidemail":
                Assert.assertEquals(RstPass.RstError(), "Please enter a valid email address (Ex: johndoe@domain.com).");
                break;
            default:
                break;
        }
    }

    private void ChangePassword(String Email_input){
        home.OpenLoginPage();
        RstPass.NavigateToPasswordResetPage();
        RstPass.resetPassword(Email_input);
    }
}
