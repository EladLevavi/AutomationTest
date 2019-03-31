package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage {

    @FindBy(xpath = "//*[@class='main-block']//li")
    public List<WebElement> profileMenu;

    @FindBy(className = "question-card-wrapper")
    public List<WebElement> questionCard;

    @FindBy(className = "mb-3 d-block note-block")
    public List<WebElement> documentCard;

}
