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

    @FindBy(xpath = "//*[@id='contact-form']//input")
    public List<WebElement> contactForm;

    @FindBy(className = "footer-brand")
    public WebElement homePage;

    @FindBy(linkText = "Privacy")
    public WebElement privacy;

    @FindBy(linkText = "Terms & Conditions")
    public WebElement terms;

    @FindBy(className = "input-round")
    public WebElement emailText;

    @FindBy(xpath = "//*[@id='subscribe-form']/button")
    public WebElement subscribeButton;

    @FindBy(className = "col-xl-4")
    public List<WebElement> sectionLinks;

    @FindBy(tagName = "//*[class='col-xl-4']//a")
    public List<WebElement> internalLinks;

    @FindBy(tagName = "img")
    public List<WebElement> images;

    @FindBy(xpath = "//*[@class='container']//a")
    public List<WebElement> footerLinks;

}
