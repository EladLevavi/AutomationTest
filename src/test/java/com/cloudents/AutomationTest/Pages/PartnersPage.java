package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnersPage {

    @FindBy(tagName = "img")
    public WebElement image;

    @FindBy(linkText = "partner@spitball.co")
    public WebElement partnerEmail;

}
