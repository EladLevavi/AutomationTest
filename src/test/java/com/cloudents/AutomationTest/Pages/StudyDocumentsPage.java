package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudyDocumentsPage {


    @FindBy(xpath = "//*[@class='flex upload-document-button result-cell mb-3 upload-files-action-card xs-12 regularCard']//button")
    public WebElement uploadButton;

    @FindBy(xpath = "//*[@class='v-icon close-upload-btn-icon v-icon--link sbf sbf-close theme--light']")
    public WebElement closeUpload;

    @FindBy(className = "sb-step-title")
    public WebElement windowTitle;

    @FindBy(xpath = "//*[@class='flex justify-center align-center mb-3 grow-1 xs12 sm6 row']//span")
    public WebElement stepTitle;

    @FindBy(xpath = "//*[@class='flex justify-center align-center xs12 sm6 d-flex']")
    public List<WebElement> courseDropdown;

    @FindBy(xpath = "//*[@class='v-menu__content theme--light menuable__content__active']/div/div/div")
    public List<WebElement> coursesList;

    @FindBy(className = "btn-label")
    public List<WebElement> dropbox;

    @FindBy(id = "file")
    public WebElement browse;

    @FindBy(xpath = "//*[@class='d-block note-block cell']")
    public List<WebElement> documentCards;






    // *****     Document Preview    ******

    @FindBy(xpath = "//*[@class='pt-3 font-weight-bold subheading']")
    public WebElement previewTitle;

    @FindBy(xpath = "//*[@class='body-1 get-online']")
    public WebElement previewSubTitle;

    @FindBy(xpath = "//*[@class='unlockBox headline hidden-sm-and-down']//p")
    public WebElement unlockTitle;

    @FindBy(xpath = "//*[@class='white--text pa-3 font-weight-bold text-xs-center']")
    public WebElement unlockButton;

    @FindBy(xpath = "//*[@class='py-2 font-weight-bold text-truncate']")
    public List<WebElement> tutorTitle;

    @FindBy(xpath = "//*[@class='font-weight-bold mb-2']")
    public WebElement moreTutors;

    @FindBy(xpath = "//*[@class='caption py-3 px-2 v-btn v-btn--depressed v-btn--round v-btn--small theme--light']")
    public WebElement moreDocuments;

    @FindBy(xpath = "//*[@class='white--text caption py-3 px-2 mb-0 v-btn v-btn--depressed v-btn--round v-btn--small theme--light tutor-btn']")
    public List<WebElement> sendButtons;

    @FindBy(xpath = "//*[@class='v-icon grey--text v-icon--link sbf sbf-arrow-back-chat theme--light arrow-back hidden-sm-and-down']")
    public WebElement backButton;

    @FindBy(xpath = "//*[@class='white--text py-4 font-weight-bold']")
    public WebElement downloadButton;

    @FindBy(xpath = "//*[@class='tutor-result-card-other pa-2 mb-3 row wrap justify-space-between overflow-hidden ab-default-card']")
    public List<WebElement> tutorCards;

    @FindBy(xpath = "//*[@class='subheading font-weight-bold tutor-name text-truncate mb-2']")
    public List<WebElement> tutorCardsTitle;

    @FindBy(xpath = "//*[@class='white--text caption py-3 px-2 mb-0 v-btn v-btn--depressed v-btn--round v-btn--small theme--light tutor-btn']")
    public List<WebElement> tutorCardsButton;

    @FindBy(xpath = "//*[@class='flex title-holder']//span")
    public WebElement courseTutors;

    @FindBy(id = "None")
    public WebElement noneFilter;







    // *******   Left side   **********

    @FindBy(xpath = "//*[@class='sort-filter']//filter")
    public List<WebElement> filters;



    // ******   Feed   *********

    @FindBy(className = "doc-title")
    public List<WebElement> docTitle;


    // ********   results   ********

    @FindBy(xpath = "//*[@class='flex result-cell mb-2 xs-12 order-xs2']")
    public List<WebElement> documentsBox;

    @FindBy(xpath = "//*[@class='details-wrap']//span")
    public List<WebElement> documentDetails;

}
