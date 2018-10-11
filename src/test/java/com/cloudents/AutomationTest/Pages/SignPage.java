package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignPage {


    // ******   Left side   ********

    @FindBy(xpath = "//*[@class='side-wrapper image']//img")
    public WebElement image;





    // ******* Right side   *********

    @FindBy(className = "step-title")
    public WebElement stepTitle;

    @FindBy(className = "sub-title")
    public WebElement subTitle;

    @FindBy(id = "agreeTermDesk")
    public WebElement agreeCheckbox;

    @FindBy(className = "checkbox-terms")
    public WebElement checkboxTerms;

    @FindBy(xpath = "//*[@class='checkbox-terms']//a")
    public List<WebElement> termsLinks;

    @FindBy(className = "has-error")
    public WebElement errorMessage;

    @FindBy(className = "google-signin")
    public List<WebElement> googleButtons;

    @FindBy(className = "seperator-text")
    public WebElement textSeperator;

    @FindBy(className = "sign-with-email")
    public List<WebElement> signWithEmailButtons;






    // ******* Login   ********

    @FindBy(name="email")
    public WebElement enterEmail;

    @FindBy(name = "user password")
    public WebElement password;







    // *******   Footer   *********

    @FindBy(className = "click")
    public List<WebElement> loginLink;

    @FindBy(className = "signin-strip")
    public WebElement signinStrip;






    // *******   Privacy popup window   *******

    @FindBy(className = "continue-btn")
    public List<WebElement> continueButtons;







    // ******   Create password   ********

    @FindBy(className = "continue-registr")
    public WebElement createPassword;

    @FindBy(className = "input-field")
    public WebElement emailInput;

    @FindBy(name = "pass")
    public WebElement passwordField;

    @FindBy(className = "input-hint")
    public WebElement passwordHelp;

    @FindBy(name = "confirm")
    public WebElement passwordConfirm;

}
