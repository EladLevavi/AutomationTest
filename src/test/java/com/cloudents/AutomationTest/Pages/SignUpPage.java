package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage {

    @FindBy(className = "input-field")
    public WebElement emailInput;

    @FindBy(className = "click")
    public WebElement loginLink;

    @FindBy(tagName = "a")
    public List<WebElement> termsLinks;

    @FindBy(className = "google-signin")
    public WebElement googleButton;

    @FindBy(className = "continue-btn")
    public WebElement continueButton;

    @FindBy(tagName = "iframe")
    public WebElement recaptcha;

    @FindBy(xpath = "//*[@class='side-wrapper image']//img")
    public WebElement signUpImage;

    @FindBy(className = "back-button")
    public WebElement closeButton;

    @FindBy(className = "dialog__content dialog__content__active")
    public WebElement exitDialog;

    @FindBy(className = "close-btn")
    public WebElement cancelButton;

    @FindBy(className = "continue-btn")
    public WebElement verifyExit;

    @FindBy(tagName = "img")
    public WebElement image;

}
