package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name="email")
    public WebElement emailInput;

    @FindBy(className="recaptcha-checkbox-checkmark")
    public WebElement recaptchaBox;
}
