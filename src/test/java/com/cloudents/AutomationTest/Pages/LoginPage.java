package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name="email")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/button/i")
    public WebElement closeButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/button/i")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/div/button")
    public WebElement exitButton;

    @FindBy(linkText = "Sign up")
    public WebElement signupLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div[1]/div/div/div[1]/img")
    public WebElement loginImage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div[1]/div/div/div[1]/div/img")
    public WebElement signupImage;

    @FindBy(tagName = "iframe")
    public WebElement recaptcha;

}
