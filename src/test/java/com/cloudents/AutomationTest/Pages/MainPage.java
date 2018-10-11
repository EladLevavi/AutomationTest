package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class MainPage {

    // ******   Header   *******

    @FindBy(className = "logo-link")
    public WebElement homeLink;

    @FindBy(className = "header-login")
    public List<WebElement> signButtons;

    @FindBy(id = "transcript")
    public WebElement searchBar;

    @FindBy(xpath = "//*[@class='title-wrap']//h2")
    public WebElement banner;

    @FindBy(xpath = "//*[@class='v-tabs__container']//a")
    public List<WebElement> tabsContainer;

    @FindBy(className = "v-menu__activator")
    public WebElement userMenuIcon;

    @FindBy(className = "v-list__tile__content")
    public List<WebElement> userMenuItems;




    // ******   Left side   ********

    @FindBy(xpath = "//*[@class='sort-switch']//label")
    public List<WebElement> sort;

    @FindBy(className = "title-label")
    public List<WebElement> filters;

    @FindBy(className = "v-expansion-panel__header")
    public List<WebElement> filterHeaders;

    @FindBy(className = "v-expansion-panel__header")
    public List<WebElement> sortSection;





    // *******   Right side   *******

    @FindBy(xpath = "//*[@class='list']//a")
    public List<WebElement> faqList;

    @FindBy(xpath = "//*[@class='footer']//button")
    public WebElement moreButton;





    // *******   Results area   ******

    @FindBy(className = "box-stroke")
    public List<WebElement> results;





    // ******   Footer   *******

    @FindBy(xpath = "//*[@class='cookie-approve']//button")
    public WebElement cookieApprove;




    // ******   Popup window   ********

    @FindBy(linkText = "Terms of Service.")
    public WebElement termsLink;

    @FindBy(xpath = "//*[@class='v-text-field__slot']//input")
    public List<WebElement> searchBars;

    @FindBy(className = "v-overlay")
    public WebElement exitDialog;

    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/main/div/div[2]/button/i")
    public WebElement backButton;

    @FindBy(xpath = "//*[@class='btn-container']//a")
    public List<WebElement> signButtonsPopup;

    @FindBy(xpath = "//*[@class='v-card__text limited-width']//h1")
    public WebElement exitWindowText;

    @FindBy(className = "dialog-body-text")
    public WebElement dialogPopupText;





    @FindBy(tagName = "img")
    public List<WebElement> images;

}