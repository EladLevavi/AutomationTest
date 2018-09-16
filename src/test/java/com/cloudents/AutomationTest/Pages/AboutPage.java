package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

public class AboutPage {

    @FindBy(xpath = "//*[@class='v-tabs__wrapper']//a")
    public List<WebElement> tabsHeader;

    @FindBy(tagName = "img")
    public List<WebElement> images;

}
