package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;


public class HomeworkHelpPage {

    @FindBy(className="ask-question")
    public WebElement askButton;

    @FindBy(className = "box-stroke")
    public List<WebElement> questionBox;

}
