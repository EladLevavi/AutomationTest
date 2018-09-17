package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PrivacyPage {

    @FindBy(linkText = "www.spitball.co")
    public WebElement link1;

    @FindBy(linkText = "here")
    public WebElement link2;

    @FindBy(linkText = "support@spitball.co")
    public List<WebElement> support;

}
