package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TokenPage {

    @FindBy(className = "navbar-brand")
    public WebElement spitball2;

    @FindBy(className = "ytp-cued-thumbnail-overlay-image")
    public WebElement youtube;

    @FindBy(className = "nav-link")
    public WebElement downloadWhitepaper;

    @FindBy(id = "telegram-nav")
    public WebElement joinTelegram;

    @FindBy(xpath = "//*[@id='contact-form']//div")
    public List<WebElement> contactForm;

    @FindBy(className = "footer-brand")
    public WebElement homePage;

    @FindBy(linkText = "Privacy Policy")
    public WebElement privacy;

    @FindBy(linkText = "Terms & Conditions")
    public WebElement terms;

    @FindBy(className = "input-round")
    public WebElement emailText;

    @FindBy(xpath = "//*[@id=\"subscribe-form\"]/button")
    public WebElement subscribeButton;

    @FindBy(className = "col-xl-4")
    public List<WebElement> sectionLinks;

    @FindBy(xpath = "//*[class='social']//href")
    public List<WebElement> socialLinks;

    @FindBy(xpath = "//*[@class='img-holder']//img")
    public WebElement image1;

    @FindBy(xpath = "//*[@class='container']//img")
    public WebElement image2;

    @FindBy(xpath = "//*[@class='animated']//img")
    public WebElement image3;

    @FindBy(xpath = "//*[@class='col-md-10']//img")
    public WebElement image4;

}
