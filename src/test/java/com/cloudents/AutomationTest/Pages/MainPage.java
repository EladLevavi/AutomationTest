package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class MainPage {

    // ******   Header   *******

    @FindBy(id = "transcript")
    public WebElement searchBar;

    @FindBy(className = "header-login")
    public List<WebElement> signButtons;

    @FindBy(className = "v-menu__activator")
    public WebElement userMenuIcon;

    @FindBy(xpath = "//*[@class='v-list menu-list theme--light']//a")
    public List<WebElement> userMenuItems;

    @FindBy(xpath = "//*[@class='v-tabs__container']//a")
    public List<WebElement> tabsContainer;

    @FindBy(className = "bold")
    public WebElement balance;

    @FindBy(className = "setting-buysbl-button")
    public WebElement getPoints;

    @FindBy(xpath = "//*[@class='close-buy-dialog']//i")
    public WebElement closeBuyPoints;

    @FindBy(xpath = "//*[@class='layout buy-tokens-price-container pt-4 justify-center']/div")
    public List<WebElement> buyOptions;

    @FindBy(id = "email")
    public WebElement paypalEmail;

    @FindBy(id = "password")
    public WebElement paypalPassword;

    @FindBy(id = "btnNext")
    public WebElement paypalNext;

    @FindBy(id = "confirmButtonTop")
    public WebElement confirmButton;

    @FindBy(id = "btnLogin")
    public WebElement paypalLogin;

    @FindBy(xpath = "//*[@class='buy-tokens-title-text']")
    public List<WebElement> headers;

    @FindBy(xpath = "//*[@class='buy-tokens-bold-text mt-3']")
    public List<WebElement> titles;

    @FindBy(xpath = "//*[@class='buy-tokens-normal-text mt-1']")
    public List<WebElement> subTitles;

    @FindBy(className = "buy-tokens-center-price-title")
    public List<WebElement> pointsOption;

    @FindBy(className = "buy-tokens-choose-button")
    public List<WebElement> chooseButtons;

    @FindBy(className = "buy-tokens-text-small")
    public List<WebElement> pointsConvertion;

    @FindBy(className = "zoid-outlet")
    public WebElement checkoutButton;

    @FindBy(className = "buy-tokens-text-absolute")
    public WebElement mostPopular;

    @FindBy(xpath = "//*[@class='filter-button-container']")
    public WebElement filter;

    @FindBy(xpath = "//*[@class='filter-single-title']")
    public WebElement filterTitle;

    @FindBy(xpath = "//*[@class='filter-list']//button")
    public List<WebElement> filterItems;

    @FindBy(xpath = "//*[@class='apply elevation-0 v-btn theme--light']")
    public WebElement applyFilter;

    @FindBy(xpath = "//*[@class='v-icon close-icon-filter v-icon--link sbf sbf-close theme--light']")
    public WebElement closeFilter;

    @FindBy(id = "ask")
    public WebElement homeworkHelpTab;

    @FindBy(id = "note")
    public WebElement studyDocumentsTab;

    @FindBy(xpath = "//*[@class='v-input__icon v-input__icon--clear']")
    public WebElement clearSearch;

    @FindBy(xpath = "//*[@class='light-btn elevation-0 ma-0 v-btn v-btn--round theme--light']")
    public List<WebElement> actionButtons;

    @FindBy(xpath = "//*[@class='v-dialog login-popup v-dialog--active v-dialog--scrollable']")
    public WebElement loginPopup;

    @FindBy(xpath = "//*[@class='close-btn text-md-right']")
    public WebElement closePopup;

    @FindBy(xpath = "//*[@class='v-toolbar__title subheading']")
    public WebElement requestTitle;

    @FindBy(name = "add-request-textarea")
    public WebElement requestText;

    @FindBy(xpath = "//*[@class='v-select__slot']//input")
    public WebElement course;

    @FindBy(xpath = "//*[@class='v-btn v-btn--flat theme--light blue--text text--darken-1']")
    public WebElement closeRequest;

    @FindBy(xpath = "//*[@class='white--text v-btn v-btn--depressed v-btn--round theme--light']")
    public WebElement submitRequest;

    @FindBy(xpath = "//*[@class='v-messages__message']")
    public List<WebElement> requiredMessage;

    @FindBy(xpath = "//*[@class='v-list__tile v-list__tile--link theme--light']")
    public List<WebElement> coursesList;

    @FindBy(xpath = "//*[@class='v-text-field__slot']//input")
    public List<WebElement> requestFields;

    @FindBy(xpath = "//*[@class='v-select__slot']//input")
    public List<WebElement> requestUniversity;

    @FindBy(xpath = "//*[@class='txt-buy-tokens']//p")
    public List<WebElement> pointsMessages;






    // ****** Onboarding **********

    @FindBy(className = "step-title")
    public List<WebElement> stepTitle;

    @FindBy(xpath = "//*[@class='present-row']//span")
    public WebElement finalStep;

    @FindBy(className = "bottom-text")
    public List<WebElement> bottomText;

    @FindBy(className = "sml-text-row")
    public WebElement finalText;

    @FindBy(xpath = "//*[@class='actions-wrap']//button")
    public WebElement nextWindow;

    @FindBy(xpath = "//*[@class='progress-wrap']//button")
    public WebElement skipButton;

    @FindBy(xpath = "//*[@class='actions-wrap']/button[2]")
    public WebElement finishButton;




    // ******   Walkthrough   ********

    @FindBy(className = "v-step__header")
    public WebElement header;

    @FindBy(className = "v-step__content")
    public WebElement content;

    @FindBy(xpath = "//*[@class='v-step__buttons']//button")
    public List<WebElement> navButtons;

    @FindBy(className = "v-step__button")
    public WebElement skipBtn;






    // *******   Top Earners   *******

    @FindBy(xpath = "//*[@class='v-list__tile__action leader-ammount']//span")
    public List<WebElement> leaders;

    @FindBy(xpath = "//*[@class='total-data']//span")
    public WebElement total;

    @FindBy(xpath = "//*[@class='main-leaders-content v-card v-sheet theme--light']//span")
    public WebElement topEarner;








    // *******  Referral Dialog   *******

    @FindBy(xpath = "//*[@class='flex mb-3 xs12']//span")
    public WebElement spreadText;

    @FindBy(xpath = "//*[@class='text-xs-center ref-subtitle']")
    public WebElement earnText;

    @FindBy(xpath = "//*[@class='bottom-sub']")
    public WebElement subTitle;

    @FindBy(xpath = "//*[@class='bottom-sub bottom-sub-small']")
    public WebElement smallLetters;

    @FindBy(xpath = "//*[@class='share-icon-container']//span//span")
    public List<WebElement> shareIcons;

    @FindBy(className = "referral-btn")
    public WebElement copyButton;

    @FindBy(xpath = "//*[@class='referral-btn copied']")
    public WebElement copiedButton;

    @FindBy(xpath = "//*[@class='bottom-sub bottom-sub-small']")
    public WebElement invitedText;

    @FindBy(xpath = "//*[@class='close-btn text-md-right']")
    public WebElement closeReferral;

    @FindBy(xpath = "//*[@class='share-text']")
    public List<WebElement> shareText;

    @FindBy(xpath = "//*[@class='input-field inputPrepIcon errorTextStr']")
    public WebElement referralLink;












    // ******   Feed   *********

    @FindBy(xpath = "//*[@class='question-body-content-container align-switch-l']//span")
    public List<WebElement> questionBody;








    // ******   Right side   ********

    @FindBy(xpath = "//*[@class='marketing-box-component mb-3']")
    public WebElement marketingBox;







    // ******   Left side   ********

    @FindBy(xpath = "//*[@class='sort-switch']//label")
    public List<WebElement> sort;

    @FindBy(className = "v-expansion-panel__header")
    public List<WebElement> filterSections;

    @FindBy(className = "title-label")
    public List<WebElement> filters;








    // ******   Popup window   ********


    @FindBy(xpath = "//*[@class='v-text-field__slot']//input")
    public List<WebElement> searchBars;

    @FindBy(className = "v-overlay")
    public WebElement exitDialog;

    @FindBy(xpath = "//*[@class='btn-container']//a")
    public List<WebElement> signButtonsPopup;

    @FindBy(xpath = "//*[@class='v-card__text limited-width']//h1")
    public WebElement exitWindowText;

    @FindBy(className = "dialog-body-text")
    public WebElement dialogPopupText;

}