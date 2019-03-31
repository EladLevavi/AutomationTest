package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignPage {

    // *******   Header   **********

    @FindBy(className = "back-button")
    public List<WebElement> closeIcon;






    // ******   Left side   ********

    @FindBy(xpath = "//*[@class='side-wrapper image']//img")
    public WebElement image;





    // ******* Right side   *********

    @FindBy(className = "step-title")
    public WebElement stepTitle;

    @FindBy(className = "sub-title")
    public WebElement subTitle;

    @FindBy(xpath = "//*[@class='checkbox-terms']//span")
    public WebElement agreeCheckbox;

    @FindBy(id = "agreeTermDesk")
    public WebElement checkBox;

    @FindBy(className = "seperator-text")
    public WebElement textSeperator;







    // ******* Signup *********

    @FindBy(xpath = "//*[@class='limited-width form-wrap']//button[2]")
    public WebElement signupWithGoogle;

    @FindBy(xpath = "//*[@class='limited-width form-wrap']//button[4]")
    public WebElement signupWithEmail;

    @FindBy(id = "recaptcha-anchor")
    public WebElement recaptcha;

    @FindBy(xpath = "//*[@class='form-one']//button")
    public WebElement continueSignup;





    // ******* Login   ********

    @FindBy(xpath = "//*[@class='limited-width form-wrap']//button[1]")
    public WebElement signWithGoogle;

    @FindBy(id = "identifierId")
    public WebElement gmailInput;

    @FindBy(id = "identifierNext")
    public WebElement gmailNext;

    @FindBy(name = "password")
    public WebElement gmailPassword;

    @FindBy(id = "passwordNext")
    public WebElement passwordNext;

    @FindBy(xpath = "//*[@class='limited-width form-wrap']//button[3]")
    public WebElement signWithEmail;

    @FindBy(name="email")
    public WebElement enterEmail;

    @FindBy(name = "user password")
    public WebElement password;

    @FindBy(xpath = "//*[@class='form-one']//button")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@class='signin-strip']//a")
    public WebElement forgotPassword;

    @FindBy(xpath = "//*[@class='limited-width']//button")
    public WebElement loginButton;







    // *******   Footer   *********

    @FindBy(className = "click")
    public List<WebElement> loginLink;

    @FindBy(className = "signin-strip")
    public WebElement signinStrip;






    // *******   Privacy popup window   *******

    @FindBy(className = "v-btn__content")
    public List<WebElement> continueButtons;







    // ******   Create password   ********

    @FindBy(className = "input-field")
    public WebElement emailInput;

    @FindBy(name = "pass")
    public WebElement passwordField;

    @FindBy(name = "confirm")
    public WebElement passwordConfirm;

}
