package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TokenPage {

    @FindBy(xpath = "//*[@class='container']//img")
    public List<WebElement> logo;

    @FindBy(className = "ytp-cued-thumbnail-overlay-image")
    public WebElement youtube;

    @FindBy(xpath = "//*[@id='contact-form']//input")
    public List<WebElement> contactForm;

    @FindBy(xpath = "//*[@id='contact-form']//textarea")
    public WebElement textArea;

    @FindBy(xpath = "//*[@id='contact-form']//button")
    public WebElement submitButton;

    @FindBy(className = "footer-brand")
    public WebElement homePage;

    @FindBy(xpath = "//*[@class='input-field animated fadeInUp']//input")
    public List<WebElement> contactFields;

    @FindBy(className = "input-round")
    public WebElement emailText;

    @FindBy(xpath = "//*[@id='subscribe-form']/button")
    public WebElement subscribeButton;

    @FindBy(tagName = "img")
    public List<WebElement> images;

    @FindBy(xpath = "//*[@class='footer-links']//a")
    public List<WebElement> footerLinks;

    @FindBy(xpath = "//*[@class='contact-info-alt']//a")
    public List<WebElement> joinTelegram;

    @FindBy(xpath = "//*[@class='social']//a")
    public List<WebElement> socialLinks;

    @FindBy(xpath = "//*[@class='navbar-nav animated remove-animation fadeInDown']//li")
    public List<WebElement> headerLinks;

    @FindBy(className = "footer-brand")
    public WebElement footerBrand;

    @FindBy(linkText = "token@spitball.co")
    public WebElement support;

    @FindBy(xpath = "//*[@class='navbar-brand animated fadeInDown']//a")
    public WebElement logoHeaderLink;

}
