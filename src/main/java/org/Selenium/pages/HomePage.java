package org.Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver){
        super(driver);
    }

    //********** Sign in and Create Account ************

    @FindBy(linkText = "Create an Account")
    WebElement Registration;

    @FindBy(linkText = "Sign In")
    WebElement SignIn;

    @FindBy(css = "body > div.page-wrapper > header > div.header.content > a")
    WebElement Logo;

    //********** Sign in and Create Account ************

    public void OpenRegistrationPage(){

        ButtonClick(Registration);
    }
    public void OpenLoginPage(){

        ButtonClick(SignIn);
    }
    public void ReturnToHomePage(){

        ButtonClick(Logo);
    }


}
