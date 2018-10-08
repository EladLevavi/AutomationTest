package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage {

    @FindBy(className = "input-field")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@class='checkbox-terms']//a")
    public List<WebElement> termsLinks;

    @FindBy(className = "google-signin")
    public WebElement googleButton;

    @FindBy(id = "agreeTermDesk")
    public WebElement agreeCheckbox;

    @FindBy(className = "sign-with-email")
    public WebElement signWithEmail;

    @FindBy(className = "has-error")
    public WebElement errorMessage;

    @FindBy(className = "click")
    public WebElement loginLink;

    @FindBy(xpath = "//*[@class='side-wrapper image']//img")
    public WebElement image;

    @FindBy(className = "step-title")
    public WebElement stepTitle;

    @FindBy(className = "checkbox-terms")
    public WebElement checkboxTerms;

    @FindBy(className = "signin-strip")
    public WebElement signinStrip;

    @FindBy(className = "continue-registr")
    public WebElement createPassword;

    @FindBy(name = "pass")
    public WebElement passwordField;

    @FindBy(name = "confirm")
    public WebElement confirmPassword;

    @FindBy(className = "continue-btn")
    public List<WebElement> continueButtons;

    @FindBy(className = "sub-title")
    public WebElement subTitle;

    @FindBy(className = "input-field")
    public WebElement enterEmail;

    @FindBy(className = "input-hint")
    public WebElement passwordHelp;

}
