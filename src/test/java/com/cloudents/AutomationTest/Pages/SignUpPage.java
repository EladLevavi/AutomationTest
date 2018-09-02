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

    @FindBy(className = "v-btn__content")
    public WebElement signWithEmail;

    @FindBy(className = "has-error")
    public WebElement errorMessage;

    @FindBy(className = "click")
    public WebElement loginLink;

    @FindBy(xpath = "//*[@class='side-wrapper image']//img")
    public WebElement image;

}
