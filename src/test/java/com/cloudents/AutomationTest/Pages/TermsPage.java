package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TermsPage {

    @FindBy(linkText = "http://www.copyright.gov/legislation/dmca.pdf")
    public WebElement copyrights;

    @FindBy(className = "term")
    public WebElement anchor;

}
