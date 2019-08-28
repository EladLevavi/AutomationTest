package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudyRoomPage {

    @FindBy(id = "_Group_6")
    public WebElement logo;

    @FindBy(xpath = "//*[@class = 'v-list theme--light']/div")
    public WebElement studyRoomItem;

    @FindBy(className = "study-card-avatar-area")
    public WebElement enterStudyRoom;

    @FindBy(xpath = "//*[@class = 'logo-nav-wrap']//div")
    public List<WebElement> menuItems;

    @FindBy(xpath = "//*[@class='nav-container']//button")
    public List<WebElement> navActions;

}
