package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlashcardsPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div[2]/div/div/div[1]/div/div[1]/label[2]")
    public WebElement dateSortion;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div[2]/div/div/div[1]/div/div[1]")
    public WebElement relevanceSortion;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[1]/label[2]")
    public WebElement brainscapeSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[2]/label[2]")
    public WebElement cloudentsSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[3]/label[2]")
    public WebElement courseHeroSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[4]/label[2]")
    public WebElement cramSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[5]/label[2]")
    public WebElement koofersSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[6]/label[2]")
    public WebElement quizletSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[7]/label[2]")
    public WebElement studyBlueSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[8]/label[2]")
    public WebElement studySoupSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li[2]/div[1]")
    public WebElement sortionArea;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li[1]/div[2]/div/div/button/div")
    public WebElement personilize;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/input")
    public WebElement searchSchool;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[1]/div[3]/div[1]/h2")
    public WebElement bannerText;

}
