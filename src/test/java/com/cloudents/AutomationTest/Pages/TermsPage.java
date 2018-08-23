package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TermsPage {

    @FindBy(linkText = "http://www.copyright.gov/legislation/dmca.pdf")
    public WebElement docLink;

}
