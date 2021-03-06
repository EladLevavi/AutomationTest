package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactPage {

    @FindBy(className = "gm-style-pbc")
    public WebElement map;

    @FindBy(xpath = "//*[@class='icons']")
    public List<WebElement> links;
}
