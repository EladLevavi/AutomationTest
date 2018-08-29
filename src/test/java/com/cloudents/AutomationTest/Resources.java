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
    final static String DRIVERS_LOCATION = "C:\\WebDrivers\\";
    final static String CHROME_DRIVER = "webdriver.chrome.driver";
    final static String CHROME_FILE = "chromedriver.exe";
    final static String GECKO_DRIVER = "webdriver.gecko.driver";
    final static String GECKO_FILE = "geckodriver.exe";
    final static String EDGE_DRIVER = "webdriver.edge.driver";
    final static String EDGE_FILE = "MicrosoftWebDriver.exe";
    final static String IE_DRIVER = "webdriver.ie.driver";
    final static String IE_FILE = "IEDriverServer.exe";

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
    final static String TWITTER_PAGE = "https://twitter.com";
    final static String YOUTUBE_PAGE = "https://www.youtube.com";
    final static String INSTAGRAM_PAGE = "https://www.instagram.com";
    final static String MEDIUM_PAGE = "https://medium.com";
    final static String GITHUB_PAGE = "https://github.com";
    final static String LINKEDIN_PAGE = "https://www.linkedin.com";
    final static String TELEGRAM_PAGE = "https://t.me";
    final static String GOOGLE_SIGNIN_PAGE = "https://accounts.google.com/signin/";
    final static String AMAZON_IMAGE = "https://zboxstorage.blob.core.windows.net/zboxhelp/Amazon1.jpg";
    final static String PARTNERS_IMAGE = "data:image/png;base64,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";
    final static String REPS_IMAGE = "data:image/png;base64,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";
    final static String GOOGLE_MARKETING = "https://marketingplatform.google.com/about/";
    final static String TERMS_DOC = "https://www.copyright.gov/legislation/dmca.pdf";
    final static String WHITEPAPER_DOC = "https://zboxstorage.blob.core.windows.net/zboxhelp/ico/Spitball-WP.pdf";
    final static String HEVRA_IMAGE = "https://token.spitball.co/images/muscari/hevra.png";
    final static String SPITBALL_APP_IMAGE = "https://token.spitball.co/images/muscari/spitball_app.png";
    final static String ECONOMY_IMAGE = "https://token.spitball.co/images/muscari/spitball_economy.png";
    final static String EIDAN_IMAGE = "https://token.spitball.co/images/muscari/Eidan.png";
    final static String RAM_IMAGE = "https://token.spitball.co/images/muscari/Ram.png";
    final static String JORDAN_IMAGE = "https://token.spitball.co/images/muscari/Jordan.png";
    final static String ROB_IMAGE = "https://token.spitball.co/images/muscari/Rob.png";
    final static String SHLOMI_IMAGE = "https://token.spitball.co/images/muscari/Shlomi.png";
    final static String HADAR_IMAGE = "https://token.spitball.co/images/muscari/Hadar.png";
    final static String TORI_IMAGE = "https://token.spitball.co/images/muscari/Tori.png";
    final static String OLA_IMAGE = "https://token.spitball.co/images/muscari/Ola.png";
    final static String TOKEN_PARTNERS_IMAGE = "https://token.spitball.co/images/muscari/partners.png";



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
