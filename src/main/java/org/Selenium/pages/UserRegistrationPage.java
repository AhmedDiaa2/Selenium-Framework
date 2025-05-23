package org.Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UserRegistrationPage extends PageBase{

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    WebElement fnField;

    @FindBy(id = "lastname")
    WebElement lnField;

    @FindBy(id = "email_address")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "password-confirmation")
    WebElement confirmPasswordField;

    //******************//

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
    WebElement rgstBtn;

    @FindBy(css = ".action.switch")
    WebElement headerDropdownLinks;

    @FindBy(linkText = "Sign Out")
    WebElement signOut;

    @FindBy(id = "lastname-error")
    WebElement RequiredFieldError;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement rgstSuccess;



    /******************************Function*******************************************/

    public void userRegistration(String firstname,String lastname ,String email,String password){
        sendTextInElement(fnField,firstname);
        sendTextInElement(lnField,lastname);
        sendTextInElement(emailField,email);
        sendTextInElement(passwordField, password);
        sendTextInElement(confirmPasswordField,password);
        ButtonClick(rgstBtn);
    }
    public void userLogout(){
        ButtonClick(headerDropdownLinks);
        ButtonClick(signOut);
    }

    public String FieldError(){
        return RequiredFieldError.getText();
    }

    public String RegisterSuccess(){
        return rgstSuccess.getText();
    }

    public void assertDynamicElementValue(String expectedValue) {
        waitForElementToUpdate(); // Implement this if needed
        String actualValue = rgstSuccess.getText();
        Assert.assertEquals(actualValue, expectedValue);
    }

    private void waitForElementToUpdate() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(rgstSuccess, "Thank you for registering with Main Website Store.")));
    }

}
