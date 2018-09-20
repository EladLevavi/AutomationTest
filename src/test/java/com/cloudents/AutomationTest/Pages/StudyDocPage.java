package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudyDocPage {

    @FindBy(className = "d-block")
    public List<WebElement> studyBlocks;

}
