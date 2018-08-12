package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HWpage {

    @FindBy(linkText="Ask Your Question")
    public WebElement ask;

    @FindBy(className = "top-block")
    public WebElement question;

}
