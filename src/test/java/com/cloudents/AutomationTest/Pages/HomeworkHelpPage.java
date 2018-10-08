package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;


public class HomeworkHelpPage {

    @FindBy(xpath="//*[@class='flex xs12']//a")
    public WebElement askButton;

    @FindBy(className = "q-text")
    public List<WebElement> questionBox;

    @FindBy(className = "p-result")
    public WebElement resultsArea;

}
