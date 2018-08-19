package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudyDocPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[1]")
    public WebElement dateSortion;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[1]")
    public WebElement relevanceSortion;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li[2]/div[1]")
    public WebElement sourcesSection;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[1]/label[2]")
    public WebElement cloudentsSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[2]/label[2]")
    public WebElement courseheroSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[3]/label[2]")
    public WebElement koofersSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[4]/label[2]")
    public WebElement oneclassSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li[2]/div[2]/div/div[5]/label[2]")
    public WebElement studysoupSource;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[2]/a/div/div/div[2]/div/div[1]/div[2]/span")
    public WebElement studyItem;

}
