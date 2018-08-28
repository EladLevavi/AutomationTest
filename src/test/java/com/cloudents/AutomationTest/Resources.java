package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Pages.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertTrue;

class Resources {

    static WebDriver driver;
    static String DRIVERS_LOCATION = "C:\\WebDrivers\\";

    static MainPage mainPage;
    static HomeworkHelpPage homeworkHelpPage;
    static SignInPage signInPage;
    static AboutPage aboutPage;
    static FAQPage faqPage;
    static TermsPage termsPage;
    static PrivacyPage privacyPage;
    static PartnersPage partnersPage;
    static RepsPage repsPage;
    static ContactPage contactPage;
    static SignUpPage signUpPage;
    static TokenPage tokenPage;
    
    final static String HOME_PAGE = "https://dev.spitball.co";
    final static String HOME_PAGE_PROD = "https://www.spitball.co";
    final static String TOKEN_PAGE = "https://token.spitball.co";
    final static String SIGNIN_PAGE = HOME_PAGE + "/register";
    final static String LOGIN_PAGE = HOME_PAGE + "/signin";
    final static String HOMEWORK_PAGE = HOME_PAGE + "/ask";
    final static String STUDY_PAGE = HOME_PAGE + "/note";
    final static String FLASHCARD_PAGE = HOME_PAGE + "/flashcard";
    final static String TUTOR_PAGE = HOME_PAGE + "/tutor";
    final static String BOOK_PAGE = HOME_PAGE + "/book";
    final static String JOB_PAGE = HOME_PAGE + "/job";
    final static String ABOUT_PAGE = HOME_PAGE + "/about";
    final static String FAQ_PAGE = HOME_PAGE + "/faq";
    final static String PARTNERS_PAGE = HOME_PAGE + "/partners";
    final static String REPS_PAGE = HOME_PAGE + "/reps";
    final static String PRIVACY_PAGE = HOME_PAGE + "/privacy";
    final static String TERMS_PAGE = HOME_PAGE + "/terms";
    final static String CONTACT_PAGE = HOME_PAGE + "/contact";
    final static String FACEBOOK_PAGE = "https://www.facebook.com";
    final static String TWITTER_PAGE = "https://www.twitter.com";
    final static String YOUTUBE_PAGE = "https://www.youtube.com";
    final static String INSTAGRAM_PAGE = "https://www.instagram.com";
    final static String MEDIUM_PAGE = "https://medium.com";
    final static String GITHUB_PAGE = "https://github.com";
    final static String LINKEDIN_PAGE = "https://www.linkedin.com";
    final static String TELEGRAM_PAGE = "https://t.me";


    // Handle for the main window
    static String winHandleBefore;


    // Init all web elements on web pages
    static void initElements() {

        mainPage = PageFactory.initElements(driver, MainPage.class);
        homeworkHelpPage = PageFactory.initElements(driver, HomeworkHelpPage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        aboutPage = PageFactory.initElements(driver, AboutPage.class);
        faqPage = PageFactory.initElements(driver, FAQPage.class);
        termsPage = PageFactory.initElements(driver, TermsPage.class);
        privacyPage = PageFactory.initElements(driver, PrivacyPage.class);
        partnersPage = PageFactory.initElements(driver, PartnersPage.class);
        repsPage = PageFactory.initElements(driver, RepsPage.class);
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        tokenPage = PageFactory.initElements(driver, TokenPage.class);
        contactPage = PageFactory.initElements(driver, ContactPage.class);

    }



    // Get the new window handle and test the current URL by comparing it to the URL address parameter
    static void checkNewWindowAddress(String address) {

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        assertTrue(actualURL.contains(address));

        driver.close();
        driver.switchTo().window(winHandleBefore);

    }



    // Run on serial web elements by getting the Web Element list parameter
    static void clickOnWebElements(List<WebElement> list) throws InterruptedException {

        for(Iterator<WebElement> items = list.iterator(); items.hasNext();) {

            WebElement item = items.next();
            item.click();
            Thread.sleep(1000);

        }

    }



    // Scroll the screen from given web element, with number of times to scroll
    static void scroll(WebElement element, int times) throws InterruptedException {

        for(int i=0 ; i < times ; i++) {
            element.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1);
        }

    }

}
