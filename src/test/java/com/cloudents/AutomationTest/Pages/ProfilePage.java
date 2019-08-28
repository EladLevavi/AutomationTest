package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage {

    @FindBy(xpath = "//*[@class='v-tabs__div']//a")
    public List<WebElement> profileTabs;

    @FindBy(className = "question-card-wrapper")
    public List<WebElement> questionCard;

    @FindBy(className = "mb-3")
    public List<WebElement> documentCard;

    @FindBy(xpath = "//*[@class='text-wrap headline font-weight-bold']/span")
    public WebElement introText;

    @FindBy(xpath = "//*[@class='about-title subheading font-weight-bold  mb-2']")
    public WebElement bioTitle;

    @FindBy(xpath = "//*[@class='courses-title  subheading font-weight-bold mb-4']")
    public List<WebElement> coursesTitle;

    @FindBy(xpath = "//*[@class='layout reviews-container column']//span")
    public WebElement reviewsTitle;

    @FindBy(xpath = "//*[@class='word-break']")
    public WebElement userName;

    @FindBy(xpath = "//*[@class='tutor-price small-text']")
    public List<WebElement> priceHour;

    @FindBy(xpath = "//*[@class='text-xs-center text-sm-left  user-university caption text-capitalize']")
    public WebElement university;

}
