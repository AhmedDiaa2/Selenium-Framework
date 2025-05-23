package org.Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends PageBase{

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "email_address")
    WebElement FgtEmailField;

    @FindBy(className = "submit")
    WebElement ResetBtn;

    @FindBy(id = "email_address-error")
    WebElement RstErrorMessage;

    /*************************************/

    @FindBy(linkText = "Forgot Your Password?")
    WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
    WebElement forgotPasswordMessage;



    /******************************Function*******************************************/

    public void resetPassword(String email){
        sendTextInElement(FgtEmailField,email);
        ButtonClick(ResetBtn);
    }

    public String RstError(){

        return RstErrorMessage.getText();
    }

    public void NavigateToPasswordResetPage(){

        ButtonClick(forgotPassword);
    }

    public String RstSuccess(){

        return forgotPasswordMessage.getText();
    }


}
