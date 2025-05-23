package org.Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase{

    public UserLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    static WebElement loginemailField;

    @FindBy(id = "pass")
    static WebElement loginpasswordField;

    @FindBy(id = "send2")
    static WebElement signinBtn;

    //***************************//

    @FindBy(className = "logged-in")
    WebElement Username;

    //***************************//

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")
    WebElement LoginEmailDuplicate;

    //***************************//

    @FindBy(id = "email-error")
    WebElement LoginEmailErrorMessage;

    @FindBy(id = "pass-error")
    WebElement passwordErrorMessage;

    //***************************//

    @FindBy(tagName = "h1")
    WebElement LoginHeader;

    /******************************Function*******************************************/

    public static void userLogin(String email, String password){
        loginemailField.clear();
        loginpasswordField.clear();
        sendTextInElement(loginemailField,email);
        sendTextInElement(loginpasswordField,password);
        ButtonClick(signinBtn);
    }

    public String getUserName(){

        return Username.getText();
    }

    public String LoginError(){

        return LoginEmailErrorMessage.getText();
    }

    public String passwordError(){

        return passwordErrorMessage.getText();
    }


    public String getLoginHeader(){

        return LoginHeader.getText();
    }

    public String DuplicatedEmail(){

        return LoginEmailDuplicate.getText();
    }

}
