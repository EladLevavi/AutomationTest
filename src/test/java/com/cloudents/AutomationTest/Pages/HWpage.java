package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;


public class HWpage {

    @FindBy(linkText="Ask Your Question")
    public WebElement ask;

    @FindBy(className = "top-block")
    public WebElement question;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[1]/label[2]")
    public WebElement artsItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[2]/label[2]")
    public WebElement biologyItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[3]/label[2]")
    public WebElement blockchainItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[4]/label[2]")
    public WebElement businessItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[5]/label[2]")
    public WebElement chemistryItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[6]/label[2]")
    public WebElement computerScienceItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[7]/label[2]")
    public WebElement economicsItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[8]/label[2]")
    public WebElement educationItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[9]/label[2]")
    public WebElement geographyItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[10]/label[2]")
    public WebElement healthItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[11]/label[2]")
    public WebElement historyItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[12]/label[2]")
    public WebElement languagesItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[13]/label[2]")
    public WebElement lawItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[14]/label[2]")
    public WebElement literatureItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[15]/label[2]")
    public WebElement mathItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[16]/label[2]")
    public WebElement physicsItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[17]/label[2]")
    public WebElement psychologyItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[18]/label[2]")
    public WebElement religionItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[19]/label[2]")
    public WebElement socialItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[20]/label[2]")
    public WebElement technologyItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li/div[2]/div/div[21]/label[2]")
    public WebElement miscItem;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div/div/div/div[1]/a/div/div/div[2]/div/div/div/div/i")
    public WebElement questionArea;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/a/div/div/p")
    public WebElement answerText;

    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/main/div/div[2]/div[1]/div[2]/div/div/div[1]/div/p")
    public WebElement answerPage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[1]/div[3]/div[1]/h2")
    public WebElement bannerText;

}
