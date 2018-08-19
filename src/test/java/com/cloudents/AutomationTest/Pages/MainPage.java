package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(linkText = "Sign Up")
    public WebElement SignUpButton;

    @FindBy(linkText="Login")
    public WebElement LoginButton;

    @FindBy(id="ask")
    public WebElement HWhelpTab;

    @FindBy(id="note")
    public WebElement StudyDocsTab;

    @FindBy(id = "flashcard")
    public WebElement FlashcardsTab;

    @FindBy(id = "tutor")
    public WebElement TutorsTab;

    @FindBy(id = "book")
    public WebElement BooksTab;

    @FindBy(id = "job")
    public WebElement JobsTab;

    @FindBy(id = "transcript")
    public WebElement SearchBar;
}
