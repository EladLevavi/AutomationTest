package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    @FindBy(name="email")
    public WebElement emailInput;

    @FindBy(className = "continue-btn")
    public WebElement loginButton;

    @FindBy(className = "close-btn")
    public WebElement closeButton;

    @FindBy(className = "back-button")
    public WebElement exitButton;

    @FindBy(linkText = "Sign up")
    public WebElement signUpLink;

    @FindBy(className = "v-dialog registration-dialog v-dialog--active")
    public WebElement exitDialog;

    @FindBy(className = "continue-btn")
    public WebElement verifyButton;

    @FindBy(tagName = "img")
    public WebElement image;

    @FindBy(tagName = "iframe")
    public WebElement recaptcha;

}
