package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {

    @FindBy(className = "header-login")
    public List<WebElement> signButtons;

    @FindBy(id = "transcript")
    public WebElement searchBar;

    @FindBy(xpath = "//*[@class='sort-switch']//label")
    public List<WebElement> sort;

    @FindBy(className = "filter")
    public List<WebElement> filters;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li[1]/div[2]/div/div[1]")
    public WebElement unanswered;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li[1]/div[2]/div/div[2]")
    public WebElement answered;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div/div/div/div[1]/div/div/div/ul/li[1]/div[2]/div/div[3]")
    public WebElement sold;

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

    @FindBy(xpath = "//*[@class='list']//a")
    public List<WebElement> FAQlist;

    @FindBy(xpath = "//*[@class='footer']//button")
    public WebElement moreButton;

    @FindBy(xpath = "//*[@class='v-tabs__container']//a")
    public List<WebElement> tabsContainer;

    @FindBy(className = "v-icon")
    public List<WebElement> closeIcons;

    @FindBy(className = "continue-btn")
    public WebElement verifyExit;

    @FindBy(className = "back-button")
    public WebElement backButton;

    @FindBy(className = "v-overlay")
    public WebElement exitDialog;

    @FindBy(className = "logo-link")
    public WebElement homeLink;

    @FindBy(xpath = "//*[@class='cookie-approve']//button")
    public WebElement cookieApprove;

    @FindBy(xpath = "//*[@class='v-card__text limited-width']//h1")
    public WebElement exitWindowText;

}
