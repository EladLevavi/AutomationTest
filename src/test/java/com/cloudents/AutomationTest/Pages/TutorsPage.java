package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TutorsPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[1]/label[2]")
    public WebElement priceSortion;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[1]")
    public WebElement relevanceSortion;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[1]/label[2]")
    public WebElement onlineLessonsFilter;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[2]/label[2]")
    public WebElement inPersonFilter;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[1]/div[3]/div[1]/h2")
    public WebElement bannerText;

}
