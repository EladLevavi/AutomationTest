package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlashcardsPage {

    // ********   results   *********

    @FindBy(xpath = "//*[@class='flex result-cell mb-3 xs-12 order-xs2']//a")
    public List<WebElement> flashcardsBox;

}
