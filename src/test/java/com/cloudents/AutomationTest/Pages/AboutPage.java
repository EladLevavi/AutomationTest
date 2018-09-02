package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

public class AboutPage {

    @FindBy(className = "v-tabs__div")
    public List<WebElement> tabsHeader;

    @FindBy(tagName = "img")
    public List<WebElement> images;

}
