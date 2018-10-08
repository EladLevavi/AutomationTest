package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TermsPage {

    @FindBy(xpath = "//*[@class='term']//a")
    public List<WebElement> links;

    @FindBy(className = "term")
    public WebElement anchor;

}
