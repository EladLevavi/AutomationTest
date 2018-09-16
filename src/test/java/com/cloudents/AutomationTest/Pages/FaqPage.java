package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FAQPage {

    @FindBy(className = "v-expansion-panel__container")
    public List<WebElement> FaqHeaders;

}
