package com.cloudents.AutomationTest.Pages;

import com.cloudents.AutomationTest.CloudentsAutoTests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

import static com.cloudents.AutomationTest.CloudentsAutoTests.mainPage;
import static com.cloudents.AutomationTest.Resources.Methods.*;

public class UniversityPage extends CloudentsAutoTests {

    @FindBy(xpath = "//*[@class='select-university-container set-school']//span")
    public List<WebElement> uniTitles;

    @FindBy(xpath = "//*[@class='select-school-container']//input")
    public List<WebElement> schoolInput;

    @FindBy(xpath = "//*[@class='skip-container']//a")
    public WebElement skip;

    @FindBy(xpath = "//*[@class='first-container']//div")
    public List<WebElement> navigationContainer;

    @FindBy(xpath = "//*[@class='select-university-container set-school']//a")
    public List<WebElement> next;

    @FindBy(xpath = "//*[@class='v-input__append-inner']")
    public List<WebElement> clear;

    @FindBy(className = "v-list__tile__content")
    public List<WebElement> searchResults;

    @FindBy(className = "title")
    public WebElement changingTitle;

    @FindBy(xpath = "//*[@class='select-class-string']//span")
    public List<WebElement> classTitle;

    @FindBy(xpath = "//*[@class='v-select__selections']//input")
    public WebElement classInput;

    @FindBy(className = "v-icon chip-close sbf sbf-close theme--light")
    public List<WebElement> removeCourse;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/main/div/div[4]/div[6]/div/div[2]")
    public WebElement fromTitle;

    @FindBy(xpath = "//*[@class='uni-select-component main-container']//a")
    public WebElement doneButton;

    @FindBy(xpath = "//*[@class='v-menu__content theme--light menuable__content__active set-class-dropdown-container']//div//div")
    public WebElement classResults;

}
