package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    @FindBy(xpath = "//*[@class='settings-wrapper']//a")
    public List<WebElement> signButtons;

    @FindBy(id="ask")
    public WebElement homeworkHelpTab;

    @FindBy(id="note")
    public WebElement studyDocumentsTab;

    @FindBy(id = "flashcard")
    public WebElement flashcardsTab;

    @FindBy(id = "tutor")
    public WebElement tutorsTab;

    @FindBy(id = "book")
    public WebElement textbooksTab;

    @FindBy(id = "job")
    public WebElement jobsTab;

    @FindBy(id = "transcript")
    public WebElement searchBar;

    @FindBy(xpath = "//*[@class='sort-switch']//label")
    public List<WebElement> sort;

    @FindBy(className = "filter-switch")
    public List<WebElement> filters;

    @FindBy(className = "v-expansion-panel__header")
    public List<WebElement> sortSection;

    @FindBy(linkText = "Ask Your Question")
    public WebElement AskQuestion;

    @FindBy(className = "dialog-wrapp")
    public WebElement loginPopup;

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

}
