package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LandingPage {

    // ******      Header     ********

    @FindBy(xpath = "//*[@class='v-toolbar__items landing-header-items']/a[1]")
    public WebElement learnLink;

    @FindBy(xpath = "//*[@class='v-toolbar__items landing-header-items']/a[2]")
    public WebElement earnLink;

    @FindBy(xpath = "//*[@class='login-action login']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class='login-action signup']")
    public WebElement signupButton;

    @FindBy(xpath = "//*[@class='v-menu__activator']//button")
    public WebElement userMenu;

    @FindBy(xpath = "//*[@class='v-list__tile__title subheading']")
    public List<WebElement> userItems;

    @FindBy(xpath = "//*[@class='hero-text-container']//h1")
    public WebElement headerTitle;

    @FindBy(xpath = "//*[@class='hero-text-container']//h3")
    public WebElement headerSubTitle;

    @FindBy(xpath = "//*[@class='cta-button']")
    public WebElement ctaButton;

    @FindBy(xpath = "//*[@class='video-link']")
    public WebElement videoLink;

    @FindBy(xpath = "//*[@class='v-card__text stat-text-title px-0']")
    public List<WebElement> statHeaders;

    @FindBy(xpath = "//*[@class='intro-one-title']")
    public WebElement title1;

    @FindBy(xpath = "//*[@class='intro-one-sub-title']")
    public WebElement subTitle1;

    @FindBy(xpath = "//*[@class='intro-two-title']")
    public WebElement title2;

    @FindBy(xpath = "//*[@class='intro-two-sub-title']")
    public WebElement subTitle2;

    @FindBy(xpath = "//*[@class='gif-container-question']")
    public WebElement gifImage1;

    @FindBy(xpath = "//*[@class='gif-container-document']")
    public WebElement gifImage2;

    @FindBy(xpath = "//*[@class='v-input__slot']//input")
    public List<WebElement> dropdownLists;

    @FindBy(xpath = "//*[@class='v-list__tile__content']")
    public List<WebElement> dropdownItems;

    @FindBy(xpath = "//*[@class='subheading dark']")
    public WebElement schoolItem;






    // *******      FAQ header    ********

    @FindBy(xpath = "//*[@class='faq-wrap']//h3")
    public List<WebElement> faqTitle;

    @FindBy(xpath = "//*[@class='faq-wrap']//p")
    public List<WebElement> faqText;

    @FindBy(xpath = "//*[@class='cta-sbl sb-rounded-btn']")
    public WebElement faqCta;




    // *******     Reviews section   *******

    @FindBy(xpath = "//*[@class='reviews-title']")
    public WebElement reviewsTitle;

    @FindBy(xpath = "//*[@class='review-name']")
    public List<WebElement> reviewNames;

    @FindBy(xpath = "//*[@class='review-title']")
    public List<WebElement> reviewTitles;

    @FindBy(xpath = "//*[@class='review-text']")
    public List<WebElement> reviewTexts;



    // ********     Subjects section   *********

    @FindBy(xpath = "//*[@class='subjects']//h3")
    public WebElement subjectTitle;

    @FindBy(xpath = "//*[@class='subjects']//span")
    public WebElement subjectSubTitle;

    @FindBy(xpath = "//*[@class='flex subject-item xs3']")
    public List<WebElement> subjectsList;


    // ********      Footer    *********

    @FindBy(xpath = "//*[@class='join-title']")
    public WebElement footerTitle;

    @FindBy(xpath = "//*[@class='join-cta']")
    public WebElement footerCta;

    @FindBy(xpath = "//*[@class='s-cookie-container']//span")
    public WebElement cookieText;

    @FindBy(xpath = "//*[@class='cookie-approve']//button")
    public WebElement cookieButton;

    @FindBy(xpath = "//*[@class='footer-card social-card v-card v-sheet theme--light elevation-0']//a")
    public List<WebElement> socialLinks;

    @FindBy(xpath = "//*[@class='footer-link']")
    public List<WebElement> footerLinks;


}
