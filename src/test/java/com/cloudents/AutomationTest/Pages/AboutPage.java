package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class AboutPage {

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/nav/div/div/div[2]/div/div/div/div/div/div[2]/a")
    public WebElement HowWorks;

    @FindBy(linkText = "FAQ")
    public WebElement FAQ;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/nav/div/div/div[2]/div/div/div/div/div/div[4]/a")
    public WebElement Blog;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/nav/div/div/div[2]/div/div/div/div/div/div[5]/a")
    public WebElement Partners;

    @FindBy(xpath ="/html/body/div[1]/div[1]/div/div/nav/div/div/div[2]/div/div/div/div/div/div[6]/a")
    public WebElement Reps;

    @FindBy(xpath ="/html/body/div[1]/div[1]/div/div/nav/div/div/div[2]/div/div/div/div/div/div[7]/a")
    public WebElement Privacy;

    @FindBy(xpath ="/html/body/div[1]/div[1]/div/div/nav/div/div/div[2]/div/div/div/div/div/div[8]/a")
    public WebElement Terms;

    @FindBy(xpath ="/html/body/div[1]/div[1]/div/div/nav/div/div/div[2]/div/div/div/div/div/div[9]/a")
    public WebElement Contact;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/main/div/div[2]/div/div/div[1]/div[1]/h2")
    public WebElement AboutHeader1;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/main/div/div[2]/div/div/div[2]/div[1]/h2")
    public WebElement AboutHeader2;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/main/div/div[2]/div/div/div[3]/div[1]/h2")
    public WebElement AboutHeader3;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/main/div/div[2]/div/div/div[1]/div[1]/p")
    public WebElement WhatIsSpitball;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/main/div/div[2]/div/div/div[2]/div[1]/p")
    public WebElement OurTechnology;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/main/div/div[2]/div/div/div[3]/div[1]/p")
    public WebElement Personalization;

}
