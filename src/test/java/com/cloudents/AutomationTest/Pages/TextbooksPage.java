package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextbooksPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[1]/div/div[1]/label[2]")
    public WebElement sellSortion;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[1]/div/div[1]")
    public WebElement buyRentSortion;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[1]/label[1]")
    public WebElement newType;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[2]/label[2]")
    public WebElement rentalType;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[3]/label[2]")
    public WebElement usedType;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div/div/div/div[1]")
    public WebElement firstBook;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div[1]/div[3]/div[1]/h2")
    public WebElement bannerText;

}
