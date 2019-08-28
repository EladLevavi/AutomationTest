package com.cloudents.AutomationTest.Pages;

import com.cloudents.AutomationTest.CloudentsAutoTests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

import static com.cloudents.AutomationTest.CloudentsAutoTests.mainPage;
import static com.cloudents.AutomationTest.Resources.Methods.*;

public class UniversityPage extends CloudentsAutoTests {

    @FindBy(xpath = "//*[@class='subheading font-weight-bold']")
    public WebElement title;

    @FindBy(xpath = "//*[@class='text-capitalize']")
    public WebElement doneButton;

    @FindBy(id = "university-input")
    public WebElement universityInput;

    @FindBy(xpath = "//*[@class='list-item subheading cursor-pointer py-2 mx-2 justify-space-between align-center font-weight-regular']")
    public List<WebElement> universityResults;

}
