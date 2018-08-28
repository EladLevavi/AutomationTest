package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FAQPage {

    @FindBy(xpath = "//*[@class='faq']//li")
    public List<WebElement> FaqHeaders;

}
