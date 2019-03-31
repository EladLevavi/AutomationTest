package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudyDocumentsPage {


    @FindBy(xpath = "//*[@class='flex upload-document-button result-cell mb-3 upload-files-action-card xs-12 regularCard']//button")
    public WebElement uploadButton;

    @FindBy(xpath = "//*[@class='v-icon close-upload-btn-icon v-icon--link sbf sbf-close theme--light']")
    public WebElement closeUpload;

    @FindBy(xpath = "//*[@class='v-stepper__items sb-stepper-item']//span")
    public WebElement subTitle;

    @FindBy(xpath = "//*[@class='sb-steps-wrap v-card v-sheet theme--light elevation-0']//h2")
    public WebElement stepTitle;

    @FindBy(xpath = "//*[@class='flex justify-center align-center xs12 sm6 d-flex']")
    public List<WebElement> courseDropdown;

    @FindBy(xpath = "//*[@class='v-menu__content theme--light menuable__content__active']/div/div/div")
    public List<WebElement> coursesList;

    @FindBy(id = "file")
    public WebElement browse;





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
