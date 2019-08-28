package com.cloudents.AutomationTest.Resources;

import com.cloudents.AutomationTest.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;
import static com.cloudents.AutomationTest.CloudentsAutoTests.*;
import static com.cloudents.AutomationTest.Resources.Drivers.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public class Methods {


    // Init all web elements on web pages
    public static void initElements() {

        mainPage = PageFactory.initElements(driver, MainPage.class);
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        homeworkHelpPage = PageFactory.initElements(driver, HomeworkHelpPage.class);
        studyDocumentsPage = PageFactory.initElements(driver, StudyDocumentsPage.class);
        flashcardsPage = PageFactory.initElements(driver, FlashcardsPage.class);
        signPage = PageFactory.initElements(driver, SignPage.class);
        aboutPage = PageFactory.initElements(driver, AboutPage.class);
        tokenPage = PageFactory.initElements(driver, TokenPage.class);
        myWalletPage = PageFactory.initElements(driver, MyWalletPage.class);
        askPopup = PageFactory.initElements(driver, AskPopup.class);
        universityPage = PageFactory.initElements(driver, UniversityPage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        studyRoomPage = PageFactory.initElements(driver, StudyRoomPage.class);
        tutorListPage = PageFactory.initElements(driver, TutorListPage.class);
        coursesPage = PageFactory.initElements(driver, CoursesPage.class);

    }


    public static void exitDialog() throws InterruptedException {

        signPage.closeIcon.get(1).click();
        Thread.sleep(500);
        Assert.assertNotNull(mainPage.exitDialog);
        Assert.assertEquals(signPage.continueButtons.get(0).getText(), EXIT_BUTTON_TEXT);
        Assert.assertEquals(mainPage.exitWindowText.getText(), EXIT_CONFIRM_TEXT);

    }


    public static void newWindow(String address) {

        Set<String> winHandles = driver.getWindowHandles();
        winHandles.forEach(winHandle -> driver.switchTo().window(winHandle));
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains(address));
        driver.close();
        driver.switchTo().window(winHandleBefore);

    }


    public static void personalizePopup(int tab) throws InterruptedException {

        //Assert.assertTrue(mainPage.signPopup.isDisplayed());
        if (tab == 0)
            Assert.assertEquals(mainPage.dialogPopupText.getText(), ASK_QUESTION_POPUP_TEXT);
        else
            Assert.assertEquals(mainPage.dialogPopupText.getText(), PERSONALIZE_POPUP_TEXT);
        Assert.assertEquals(mainPage.signButtonsPopup.get(0).getText(), "Sign Up");
        mainPage.signButtonsPopup.get(0).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains(SIGNUP_PAGE));
        driver.navigate().back();
        Thread.sleep(1000);
        homeworkHelpPage.askButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.signButtonsPopup.get(1).getText(), "Login");
        mainPage.signButtonsPopup.get(1).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains(LOGIN_PAGE));
        driver.navigate().back();

    }


    public static void textValidation(int tab) {

        Assert.assertEquals(mainPage.tabsContainer.get(tab).getText(), TABS_TITLE[tab]);
        //Assert.assertEquals(mainPage.banner.getText(), BANNER_TEXT[tab]);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"), SEARCHBAR_PLACEHOLDERS[tab]);
        if (tab == 0)
            Assert.assertEquals(homeworkHelpPage.askButton.getText(), "Add a Question");
        /*if (tab!=0 && tab!=5)
            Assert.assertEquals(mainPage.searchBars.get(1).getAttribute("placeholder"), PERSONALIZE_SEARCHBAR);*/
    }

    public static void resultsCount(int tab) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(2000);

        if (tab == 0) {
            if (homeworkHelpPage.questionsBox.size() <= 50)
                Assert.fail();
        } else if (tab == 1) {
            if (studyDocumentsPage.documentsBox.size() <= 50)
                Assert.fail();
        } else if (tab == 2) {
            if (flashcardsPage.flashcardsBox.size() <= 50)
                Assert.fail();
        }
    }

    public static void loginUser() throws InterruptedException {

        //mainPage.israeliClose.click();
        landingPage.signButtons.get(0).click();
        Thread.sleep(500);
        signPage.signWithEmail.click();
        Thread.sleep(500);
        signPage.emailInput.sendKeys(USERNAME);
        signPage.loginButton.click();
        Thread.sleep(500);
        signPage.password.sendKeys(PASSWORD);
        signPage.loginButton.click();

    }


    public static void loadFFDriver() {

        FirefoxOptions options = new FirefoxOptions();
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myProfile = profile.getProfile("Automation");
        myProfile.setPreference("browser.privatebrowsing.autostart", true);
        options.setProfile(myProfile);
        System.setProperty(GECKO_DRIVER, DRIVERS_LOCATION + GECKO_FILE);
        driver = new FirefoxDriver(options);
    }

    public static void loadEdgeDriver() {

        System.setProperty(EDGE_DRIVER, DRIVERS_LOCATION + EDGE_FILE);
        driver = new EdgeDriver();
    }

    public static void loadChromeDriver() {

        ChromeOptions options = new ChromeOptions();
        System.setProperty(CHROME_DRIVER, DRIVERS_LOCATION + CHROME_FILE);
        //options.addArguments("--incognito");
        options.addArguments("--unsafely-allow-protected-media-identifier-for-domain");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.managed_default_content_settings.geolocation", 2);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);

    }

    public static void footerLinksTest() throws InterruptedException {

        Actions builder = new Actions(Drivers.driver);

        builder.sendKeys(Keys.END).perform();

        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(tutorListPage.footerContact.get(i).getAttribute("href"), TUTOR_FOOTER_CONTACT[i]);
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(tutorListPage.footerLinks.get(i).getText(), TUTOR_FOOTER_LINKS[i]);
            if (i == 1 || i == 6)
                continue;
            tutorListPage.footerLinks.get(i).click();
            Thread.sleep(1000);
            Assert.assertEquals(Drivers.driver.getCurrentUrl(), TUTOR_FOOTER_REDIRECT[i]);
            Drivers.driver.navigate().back();
            Thread.sleep(1000);
            builder.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
            Thread.sleep(1000);
        }
    }

    public static void tutorCarouselTest() throws InterruptedException {

        tutorListPage.carouselArrow.click();
        Thread.sleep(1000);
        tutorListPage.carouselArrow.click();
        Thread.sleep(1000);

        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(tutorListPage.carouselText.get(i).getText(), TUTOR_CAROUSEL_TEXT[i]);
        }

        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(tutorListPage.carouselName.get(i).getText(), TUTOR_CAROUSEL_NAME[i]);
        }
        tutorListPage.carouselArrow.click();
        Thread.sleep(1000);
        Assert.assertEquals(tutorListPage.carouselText.get(2).getText(), TUTOR_CAROUSEL_TEXT[2]);
        Assert.assertEquals(tutorListPage.carouselName.get(2).getText(), TUTOR_CAROUSEL_NAME[2]);

    }

    public static void landingCarouselTest() throws InterruptedException {

        landingPage.carouselArrow.click();
        Thread.sleep(1000);
        landingPage.carouselArrow.click();
        Thread.sleep(1000);

        Assert.assertEquals(landingPage.carousel.size(), 3);
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(tutorListPage.footerContact.get(i).getAttribute("href"), TUTOR_FOOTER_CONTACT[i]);
        }
        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(landingPage.carouselText.get(i).getText(), TUTOR_CAROUSEL_TEXT[i]);
        }

        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(landingPage.carouselName.get(i).getText(), TUTOR_CAROUSEL_NAME[i]);
            Assert.assertEquals(landingPage.carouselTitle.get(i).getText(), TUTOR_CAROUSEL_TITLE[i]);
        }
        landingPage.carouselArrow.click();
        Thread.sleep(1000);
        Assert.assertEquals(landingPage.carouselText.get(2).getText(), TUTOR_CAROUSEL_TEXT[2]);
        Assert.assertEquals(landingPage.carouselName.get(2).getText(), TUTOR_CAROUSEL_NAME[2]);

    }

    public static void footerLinksHebTest() throws InterruptedException {

        Actions builder = new Actions(Drivers.driver);

        // Switch to Hebrew
        Assert.assertEquals(landingPage.hebrewButton.getText(), TUTOR_ENGLISH);
        Thread.sleep(2000);


        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(tutorListPage.footerLinks.get(i).getText(), TUTOR_FOOTER_LINKS_H[i]);
            if (i == 1 || i == 6)
                continue;
            tutorListPage.footerLinks.get(i).click();
            Thread.sleep(1000);
            Assert.assertEquals(Drivers.driver.getCurrentUrl(), TUTOR_FOOTER_REDIRECT[i]);
            Drivers.driver.navigate().back();
            Thread.sleep(1000);
            builder.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
            Thread.sleep(1000);
        }
    }

    public static void tutorCarouselHebTest() throws InterruptedException {

        tutorListPage.carouselArrow.click();
        Thread.sleep(1000);
        tutorListPage.carouselArrow.click();
        Thread.sleep(1000);

        Assert.assertEquals(tutorListPage.tutorCarousel.size(), 3);
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(tutorListPage.footerContact.get(i).getAttribute("href"), TUTOR_FOOTER_CONTACT[i]);
        }
        for(int i = 0 ; i < 2 ; i ++) {
            Assert.assertEquals(tutorListPage.carouselText.get(i).getText(), TUTOR_CAROUSEL_TEXT_H[i]);
        }

        for(int i = 0 ; i < 2 ; i ++) {
            Assert.assertEquals(tutorListPage.carouselName.get(i).getText(), TUTOR_CAROUSEL_NAME_H[i]);
        }
        tutorListPage.carouselArrow.click();
        Thread.sleep(1000);
        Assert.assertEquals(tutorListPage.carouselText.get(2).getText(), TUTOR_CAROUSEL_TEXT_H[2]);
        Assert.assertEquals(tutorListPage.carouselName.get(2).getText(), TUTOR_CAROUSEL_NAME_H[2]);

    }

    public static void landingCarouselHebTest() throws InterruptedException {

        landingPage.carouselArrow.click();
        Thread.sleep(1000);
        landingPage.carouselArrow.click();
        Thread.sleep(1000);

        for(int i = 0 ; i < 2 ; i ++) {
            Assert.assertEquals(landingPage.carouselText.get(i).getText(), TUTOR_CAROUSEL_TEXT_H[i]);
        }

        for(int i = 0 ; i < 2 ; i ++) {
            Assert.assertEquals(landingPage.carouselName.get(i).getText(), TUTOR_CAROUSEL_NAME_H[i]);
        }
        landingPage.carouselArrow.click();
        Thread.sleep(1000);
        Assert.assertEquals(landingPage.carouselText.get(2).getText(), TUTOR_CAROUSEL_TEXT_H[2]);
        Assert.assertEquals(landingPage.carouselName.get(2).getText(), TUTOR_CAROUSEL_NAME_H[2]);

    }

    public static void addTestCourse() throws InterruptedException {

        coursesPage.addCourse.click();
        Thread.sleep(2000);
        coursesPage.input.sendKeys("Statistics");
        Thread.sleep(2000);
        coursesPage.coursesResult.get(1).click();
        Thread.sleep(2000);
        coursesPage.doneButton.click();

    }

}
