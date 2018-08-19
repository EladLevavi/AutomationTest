package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextbooksPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[1]/div/div[1]/label[2]")
    public WebElement sellSortion;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[1]/div/div[1]")
    public WebElement buyRentSortion;

    @FindBy(css = "#app > div.application--wrap > main > div > div:nth-child(2) > div > div > div > div.flex.first-grid.hidden-xs-only.left-side-bar > div > div:nth-child(3) > div > ul > li > div.v-expansion-panel__body > div > div:nth-child(1)")
    public WebElement newType;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[2]/label[2]")
    public WebElement rentalType;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li/div[2]/div/div[3]/label[2]")
    public WebElement usedType;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/main/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/a/span/div/div/div[2]")
    public WebElement firstBook;

}
