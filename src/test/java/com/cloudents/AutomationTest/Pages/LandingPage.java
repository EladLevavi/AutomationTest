package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LandingPage {

    // ******      Header     ********

    @FindBy(xpath = "//*[@class='flex tutor-list-header-right hidden-sm-and-down']//a")
    public WebElement hebrewButton;

    @FindBy(xpath = "//*[@class='flex tutor-list-header-right hidden-sm-and-down']//button")
    public List<WebElement> signButtons;

    @FindBy(xpath = "//*[@id='Layer_1']")
    public WebElement logoIcon;




    // ***** First paragraph *****

    @FindBy(xpath = "//*[@class='flex landing-headeline-section-text-container xs12 lg6']//h2")
    public WebElement title;

    @FindBy(xpath = "//*[@class='flex landing-headeline-section-text-container xs12 lg6']//h3")
    public WebElement subTitle;

    @FindBy(xpath = "//*[@class='flex landing-headeline-section-text-container xs12 lg6']//button")
    public WebElement upperCta;



    // ****** Inbetween section ******

    @FindBy(xpath = "//*[@class='layout landing-headelien-headlineStatus-container align-center justify-space-between row wrap']/span")
    public List<WebElement> counters;



    // ****** Second paragraph *****

    @FindBy(xpath = "//*[@class='flex landing-section1-text-container']//h3")
    public WebElement secondTitle;

    @FindBy(xpath = "//*[@class='flex landing-section1-text-container']//h4")
    public WebElement secondSubTitle;



    // ****** Third paragraph ******

    @FindBy(xpath = "//*[@class='flex landing-section2-text-container']//h3")
    public WebElement thirdTitle;

    @FindBy(xpath = "//*[@class='flex landing-section2-text-container']//h4")
    public WebElement thirdSubTitle;




    // ***** Third paragraph *****

    @FindBy(xpath = "//*[@class='flex landing-section3-text-container']//h3")
    public WebElement rdTitle;

    @FindBy(xpath = "//*[@class='flex landing-section3-text-container']//h4")
    public WebElement rdSubTitle;



    // ***** Fifth paragraph *****

    @FindBy(xpath = "//*[@class='flex landing-section4-text-container']//h3")
    public WebElement fifthTitle;

    @FindBy(xpath = "//*[@class='flex landing-section4-text-container']//h4")
    public WebElement fifthSubTitle;



    // ***** Sixth paragraph ******

    @FindBy(xpath = "//*[@class='flex landing-section5-text-container']//h3")
    public WebElement sixthTitle;

    @FindBy(xpath = "//*[@class='flex landing-section5-text-container']//h4")
    public WebElement sixthSubTitle;



    // ***** Seventh paragraph ******

    @FindBy(xpath = "//*[@class='flex landing-section6-text-container']//h3")
    public WebElement seventhTitle;

    @FindBy(xpath = "//*[@class='flex landing-section6-text-container']//h4")
    public WebElement seventhSubTitle;




    // ***** Footer ******

    @FindBy(xpath = "//*[@class='landing-carousel-card']")
    public List<WebElement> carousel;

    @FindBy(xpath = "//*[@class='flex landing-sub-footer-section-container']//h3")
    public WebElement footerTitle;

    @FindBy(xpath = "//*[@class='flex landing-sub-footer-section-container']//button")
    public WebElement footerCta;

    @FindBy(xpath = "//*[@class='flex landing-carousel-arrows']")
    public WebElement carouselArrow;

    @FindBy(xpath = "//*[@class='landing-carousel-card-text']")
    public List<WebElement> carouselText;

    @FindBy(xpath = "//*[@class='landing-carousel-card-name']")
    public List<WebElement> carouselName;

    @FindBy(xpath = "//*[@class='landing=carousel-card-title']")
    public List<WebElement> carouselTitle;

}
