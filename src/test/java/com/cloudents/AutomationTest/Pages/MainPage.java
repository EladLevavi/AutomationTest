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

    @FindBy(linkText = "What is Spitball?")
    public WebElement WhatLink;

    @FindBy(linkText = "How does Spitball work?")
    public WebElement HowLink;

    @FindBy(linkText = "How does Spitball differ from other student websites?")
    public WebElement HowDifferLink;

    @FindBy(linkText = "What is an SBL?")
    public WebElement SblLink;

    @FindBy(linkText = "What can I do with my SBL?")
    public WebElement WhatCanLink;

    @FindBy(name = "q")
    public WebElement SearchBar;
}
