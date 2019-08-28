package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignPage {

    // *******   Header   **********

    @FindBy(className = "back-button")
    public List<WebElement> closeIcon;

    @FindBy(tagName = "body")
    public WebElement body;






    // ******   Left side   ********

    @FindBy(xpath = "//*[@class='leftSection']")
    public WebElement leftSection;





    // ******* Right side   *********

    @FindBy(xpath = "//*[@class='getStarted-top']//p")
    public WebElement stepTitle;

    @FindBy(xpath = "//*[@class='getStarted-top']//span")
    public WebElement subTitle;

    @FindBy(xpath = "//*[@class='line-terms']//label")
    public WebElement agreeCheckbox;

    @FindBy(id = "checkBox")
    public WebElement checkBox;

    @FindBy(xpath = "//*[@class='hidden-xs-only or']")
    public WebElement textSeperator;

    @FindBy(xpath = "//*[@class='setEmail']//p")
    public WebElement loginTitle;







    // ******* Signup *********

    @FindBy(xpath = "//*[@class='google elevation-5 btn-login v-btn v-btn--large v-btn--round theme--light']")
    public WebElement signupWithGoogle;

    @FindBy(xpath = "//*[@class='email v-btn v-btn--flat v-btn--large v-btn--round theme--light']")
    public WebElement signupWithEmail;

    @FindBy(xpath = "//*[@class='ctnBtn white--text btn-login v-btn v-btn--large v-btn--round theme--light']")
    public WebElement continueSignup;





    // ******* Login   ********

    @FindBy(xpath = "//*[@class='google elevation-5 btn-login v-btn v-btn--large v-btn--round theme--light']")
    public WebElement signWithGoogle;

    @FindBy(id = "identifierId")
    public WebElement gmailInput;

    @FindBy(id = "identifierNext")
    public WebElement gmailNext;

    @FindBy(xpath = "//*[@class='aXBtI I0VJ4d Wic03c']//input")
    public WebElement gmailPassword;

    @FindBy(id = "passwordNext")
    public WebElement passwordNext;

    @FindBy(xpath = "//*[@class='email v-btn v-btn--flat v-btn--large v-btn--round theme--light']")
    public WebElement signWithEmail;

    @FindBy(name="email")
    public WebElement enterEmail;

    @FindBy(name = "pass")
    public WebElement password;

    @FindBy(xpath = "//*[@class='white--text btn-login v-btn v-btn--large v-btn--round theme--light']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@class='setPassword']//span")
    public WebElement forgotPassword;

    @FindBy(xpath = "//*[@class='white--text btn-login v-btn v-btn--large v-btn--round theme--light']")
    public WebElement loginButton;







    // *******   Footer   *********

    @FindBy(className = "click")
    public List<WebElement> loginLink;

    @FindBy(xpath = "//*[@class='getStarted-bottom']//span")
    public List<WebElement> signinStrip;






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
