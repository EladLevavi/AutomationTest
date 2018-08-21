package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div[1]/div/div/div[2]/div/form/div[1]/input")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/button")
    public WebElement closeButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/button")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/div/button")
    public WebElement exitButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div[1]/div/div/div[2]/div/div[2]/p")
    public WebElement signinLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div[1]/div/div/div[2]/div/button/span[1]")
    public WebElement signupWithGoogle;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div[1]/div/div/div[1]/div/img")
    public WebElement signupImage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div[1]/div/div/div[1]/img")
    public WebElement signinImage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div[1]/div/div/div[2]/div/form/input")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div[1]/div/div/div[2]/div/form/input")
    public WebElement loginButton;

    @FindBy(tagName = "iframe")
    public WebElement recaptcha;

}
