package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name="email")
    public WebElement emailInput;

    @FindBy(linkText = "Sign up")
    public WebElement signUpLink;

    @FindBy(xpath = "//*[@class='side-wrapper image']//img")
    public WebElement image;

}
