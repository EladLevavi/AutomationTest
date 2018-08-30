package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.List;

public class MainPage {

    @FindBy(className = "header-login")
    public List<WebElement> signButtons;

    @FindBy(id = "transcript")
    public WebElement searchBar;

    @FindBy(xpath = "//*[@class='sort-switch']//label")
    public List<WebElement> sort;

    @FindBy(className = "filter")
    public List<WebElement> filters;

    @FindBy(className = "v-expansion-panel__header__icon")
    public List<WebElement> filterHeaders;

    @FindBy(className = "v-expansion-panel__header")
    public List<WebElement> sortSection;

    @FindBy(xpath = "//*[@class='title-wrap']//h2")
    public WebElement banner;

    @FindBy(className = "dialog-wrapp")
    public WebElement signPopup;

    @FindBy(linkText = "Terms of Service.")
    public WebElement termsLink;

    @FindBy(tagName = "img")
    public List<WebElement> images;

    @FindBy(xpath = "//*[@class='layout column']//input")
    public WebElement searchSchool;

    @FindBy(xpath = "//*[@class='content']//a")
    public List<WebElement> FAQlist;

    @FindBy(xpath = "//*[@class='footer']//button")
    public WebElement moreButton;

    @FindBy(xpath = "//*[@class='v-tabs__container']//a")
    public List<WebElement> tabsContainer;

    @FindBy(className = "back-button")
    public WebElement closeIcon;

    @FindBy(className = "continue-btn")
    public WebElement verifyExit;

    @FindBy(className = "close-btn")
    public WebElement cancelButton;

}
