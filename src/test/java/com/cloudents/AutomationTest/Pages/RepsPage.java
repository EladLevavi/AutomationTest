package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepsPage {

    @FindBy(tagName = "img")
    public WebElement image;

    @FindBy(linkText = "work@spitball.co")
    public WebElement workEmail;

}
