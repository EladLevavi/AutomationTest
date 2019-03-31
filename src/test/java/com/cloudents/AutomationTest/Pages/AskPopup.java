package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AskPopup {

    @FindBy(xpath = "//*[@class='header-row']//span")
    public WebElement header;

    @FindBy(xpath = "//*[@class='student_icon']//img")
    public WebElement studentIcon;

    @FindBy(xpath = "//*[@class='text-block sbf-card-default']//textarea")
    public WebElement questionTextarea;

    @FindBy(xpath = "//*[@class='flex inputBorder xs8']//select")
    public WebElement subjectDropdown;

    @FindBy(xpath = "//*[@class='point-btn pts-10']//label")
    public WebElement tenSBL;

    @FindBy(xpath = "//*[@class='point-btn pts-20']//label")
    public WebElement twentySBL;

    @FindBy(xpath = "//*[@class='point-btn pts-40']//label")
    public WebElement fortySBL;

    @FindBy(xpath = "//*[@class='point-btn pts-80']//label")
    public WebElement eightySBL;

    @FindBy(xpath = "//*[@class='point-btn other inputBorder']//input")
    public WebElement otherAmount;

    @FindBy(xpath = "//*[@class='actions_text colors-actions']//button")
    public List<WebElement> colorOptions;

    @FindBy(className = "text-xs-center")
    public WebElement tip;

    @FindBy(xpath = "//*[@class='flex xs12 text-blue my-points subheading']//span")
    public WebElement youHave;

    @FindBy(id = "file-input")
    public WebElement uploadIcon;

    @FindBy(xpath = "//*[@class='textarea']//div")
    public WebElement textArea;

    @FindBy(xpath = "//div[contains(@class, 'v-btn__content') and contains(.//span, 'Ask')]")
    public WebElement askButton;

    @FindBy(xpath = "//*[@class='flex input-error xs4']//span")
    public WebElement subjectError;

    @FindBy(xpath = "//*[@class='flex error-block xs12']//div")
    public WebElement priceError;

}
