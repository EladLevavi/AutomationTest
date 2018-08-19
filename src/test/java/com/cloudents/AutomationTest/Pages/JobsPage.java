package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobsPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[1]/div/div[1]")
    public WebElement dateSortion;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/main/div/div[2]/div[2]/div/div/div[1]/div/div[1]/label[1]")
    public WebElement relevanceSortion;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[1]/label[2]")
    public WebElement fullTimeFilter;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[2]/label[2]")
    public WebElement partTimeFilter;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[3]/label[2]")
    public WebElement contractorFilter;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[4]/label[2]")
    public WebElement temporaryFilter;

}
