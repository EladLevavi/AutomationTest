package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(linkText = "Sign Up")
    public WebElement SignUpButton;

    @FindBy(linkText="Login")
    public WebElement LoginButton;

    @FindBy(linkText="Homework Help")
    public WebElement HWhelpTab;

    @FindBy(linkText="Study Documents")
    public WebElement StudyDocsTab;

    @FindBy(linkText = "Flashcards")
    public WebElement FlashcardTab;

    @FindBy(linkText = "Tutors")
    public WebElement TutorsTab;

    @FindBy(linkText = "Textbooks")
    public WebElement BooksTab;

    @FindBy(linkText = "Jobs")
    public WebElement JobsTab;

    @FindBy(name = "q")
    public WebElement SearchBar;
}
