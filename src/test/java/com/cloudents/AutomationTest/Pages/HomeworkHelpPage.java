package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import java.util.List;


public class HomeworkHelpPage {

    // ******   Right side   ********

    @FindBy(xpath = "//*[@class='flex right-sidebar']//div//a//div//div//button")
    public WebElement askButton;

    @FindBy(xpath = "//*[@class='question-add-button v-btn theme--light']")
    public WebElement addQuestion;

    @FindBy(xpath = "//*[@class='question-textarea-floating-error']")
    public WebElement textareaError;

    @FindBy(xpath = "//*[@class='question-select-floating-error']")
    public WebElement selectError;

    @FindBy(xpath = "//*[@class='question-component-floating-error']")
    public WebElement priceError;

    @FindBy(xpath = "//*[@class='v-input question-textarea v-textarea v-textarea--no-resize v-text-field v-text-field--single-line v-text-field--solo v-text-field--enclosed theme--light']//textarea")
    public WebElement questionTextarea;

    @FindBy(xpath = "//*[@class='v-input question-textarea v-textarea v-textarea--no-resize v-text-field v-text-field--single-line v-text-field--solo v-text-field--enclosed theme--light']//label")
    public WebElement textAreaLabel;

    @FindBy(xpath = "//*[@class='question-select left']//div//div//div//div")
    public WebElement classSelection;

    @FindBy(xpath = "//*[@class='question-select right']//label")
    public WebElement subjectSelection;

    @FindBy(xpath = "//*[@class='v-menu__content theme--light menuable__content__active question-select-list']//a")
    public List<WebElement> classesList;

    @FindBy(xpath = "//*[@class='add-question-container']//h1")
    public WebElement questionTitle;

    @FindBy(xpath = "//*[@class='q-regular-offer']")
    public WebElement offerText;

    @FindBy(xpath = "//*[@class='q-regular-right-container']//button")
    public List<WebElement> priceButtons;

    @FindBy(xpath = "//*[@class='q-regular-right-container']//input")
    public WebElement priceInput;

    @FindBy(xpath = "//*[@class='v-icon v-icon--right sbf sbf-close theme--light']")
    public WebElement closePopup;

    @FindBy(xpath = "//*[@class='question-options-part']")
    public WebElement browse;







    // *******   Results    **********

    @FindBy(className = "box-stroke")
    public List<WebElement> questionsBox;

    @FindBy(className = "user-date")
    public List<WebElement> questionSubject;

    @FindBy(className = "q-text sbf-font-default ellipsis")
    public List<WebElement> questionsContent;

    @FindBy(className = "q-price pr-3")
    public List<WebElement> questionPrice;

    @FindBy(xpath = "//*[@class='files']//span")
    public List<WebElement> filesIcon;

    @FindBy(className = "delete-btn")
    public WebElement deleteButton;

}
