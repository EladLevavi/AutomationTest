package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TutorListPage {

    @FindBy(xpath = "//*[@class='flex pt-4 pb-3']//h1")
    public WebElement title;

    @FindBy(xpath = "//*[@class='flex pb-4']")
    public List<WebElement> subTitles;

    @FindBy(xpath = "//*[@class='v-text-field__slot']//input")
    public WebElement searchBar;

    @FindBy(xpath = "//*[@class='flex tutor-landing-card-container']")
    public List<WebElement> tutorCards;

    @FindBy(xpath = "//*[@class='flex tutor-landing-card-container']//button")
    public WebElement contactButton;

    @FindBy(xpath = "//*[@class='layout tutor-landing-status-row align-center py-5 justify-space-around']/span")
    public List<WebElement> footerTitles;

    @FindBy(xpath = "//*[@class='tutor-carousel-slider-container']/div")
    public List<WebElement> tutorCarousel;

    @FindBy(xpath = "//*[@class='footer-contact-box-icons']//a")
    public List<WebElement> footerContact;

    @FindBy(xpath = "//*[@class='footer-wrap-list w-list-unstyled']//a")
    public List<WebElement> footerLinks;

    @FindBy(xpath = "//*[@class='flex tutor-carousel-arrows']")
    public WebElement carouselArrow;

    @FindBy(xpath = "//*[@class='tutor-carousel-card-top pb-4']")
    public List<WebElement> carouselText;

    @FindBy(xpath = "//*[@class='tutor-carousel-rating']//p")
    public List<WebElement> carouselName;

}
