package com.cloudents.AutomationTest;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static com.cloudents.AutomationTest.Resources.*;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CloudentsAutoTests {



    @BeforeTest
    public void setup() throws InterruptedException {

        driver = new SafariDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Resources.initElements();
        Resources.winHandleBefore = driver.getWindowHandle();
        driver.get(HOME_PAGE);
        Thread.sleep(2000);
        mainPage.cookieApprove.click();

    }


    @Test
    public void global() throws InterruptedException {

        common();
        about();
        mainTabs();
        homeworkHelp();
        studyDocuments();
        flashcards();
        tutors();
        textbooks();
        jobs();
        signUp();
        login();
        //token();

    }

    @Test
    public void common() throws InterruptedException {

        driver.get(HOME_PAGE);
        Thread.sleep(3000);
        mainPage.homeLink.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);
        for (int i = 0 ; i < 5 ; i++) {
            Thread.sleep(5000);
            mainPage.FAQlist.get(i).click();
            Thread.sleep(5000);
            checkNewWindowAddress(FAQ_PAGE + "?id=" + i);
        }
        mainPage.moreButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), FAQ_PAGE);
        driver.navigate().back();
        mainPage.signButtons.get(0).click();
        Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        assertTrue(actualURL.contains(SIGNUP_PAGE));
        driver.navigate().back();
        mainPage.signButtons.get(1).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE);

    }

    @Test
    public void mainTabs() throws InterruptedException {

        driver.get(HOME_PAGE);
        Thread.sleep(2000);
        clickOnWebElements(mainPage.tabsContainer);

    }

    @Test
    public void signUp() throws InterruptedException {

        mainPage.signButtons.get(0).click();
        Thread.sleep(3000);
        assertTrue(driver.getCurrentUrl().contains(SIGNUP_PAGE));
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Ask Questions & receive instant help \n or \n Answer Questions & make money");
        Assert.assertEquals(signUpPage.googleButton.getText(), "Sign Up with Google");
        Assert.assertEquals(signUpPage.signWithEmail.getText(), "Sign Up with Email");
        Assert.assertEquals(signUpPage.checkboxTerms.getText(), "I agree to Spitball's Terms of Services and Privacy Policy");
        Assert.assertEquals(signUpPage.signinStrip.getText(), "Do you already have an account?   \n" + "                    Sign in");
        Assert.assertEquals(signUpPage.image.getAttribute("src"),SIGNUP_IMAGE);
        signUpPage.termsLinks.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
        Thread.sleep(1000);
        driver.navigate().back();
        signUpPage.termsLinks.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), PRIVACY_PAGE);
        driver.navigate().back();
        Thread.sleep(1000);
        signUpPage.googleButton.click();
        Assert.assertEquals(signUpPage.errorMessage.getText(), "Please agree to Terms And Services in order to proceed");
        driver.navigate().refresh();
        signUpPage.signWithEmail.click();
        Assert.assertEquals(signUpPage.errorMessage.getText(), "Please agree to Terms And Services in order to proceed");
        signUpPage.agreeCheckbox.click();
        //Assert.assertNull(signUpPage.errorMessage);
        //signUpPage.googleButton.click();
        //checkNewWindowAddress(GOOGLE_SIGNIN_PAGE);
        signUpPage.signWithEmail.click();
        Thread.sleep(3000);
        //Assert.assertEquals(signUpPage.stepTitle.getText(), "Start with your email. We need to know how to contact you.");
        Assert.assertEquals(signUpPage.emailInput.getAttribute("placeholder"), "Enter your email");
        Assert.assertEquals(signUpPage.passwordField.getAttribute("placeholder"), "Choose password");
        Assert.assertEquals(signUpPage.confirmPassword.getAttribute("placeholder"), "Confirm password");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getText(), "Continue");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.enterEmail.sendKeys(USER_NAME);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.passwordField.sendKeys(PASSWORD);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.confirmPassword.sendKeys(PASSWORD);
        //Assert.assertNull(signUpPage.continueButtons.get(1).getAttribute("disabled"));
        Assert.assertEquals(signUpPage.passwordHelp.getText(), "Weak");
        driver.navigate().back();
        Thread.sleep(2000);
        signUpPage.loginLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE);
        signUpPage.signWithEmail.click();
        signUpPage.continueButtons.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Welcome back\nplease login");
        driver.navigate().back();
        mainPage.backButton.click();
        Thread.sleep(500);
        Assert.assertNotNull(mainPage.exitDialog);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getText(), "Exit");
        Assert.assertEquals(mainPage.exitWindowText.getText(), "Are you sure you want to exit?");
        Thread.sleep(2000);
        signUpPage.continueButtons.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);

    }

    @Test
    public void resetPassword() throws InterruptedException {

        mainPage.signButtons.get(1).click();
        Thread.sleep(1500);
        signUpPage.signWithEmail.click();
        Thread.sleep(1500);
        signUpPage.continueButtons.get(1).click();
        Thread.sleep(1500);
        signUpPage.signinStrip.click();
        Assert.assertEquals(loginPage.image.getAttribute("src"), LOGIN_IMAGE);
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Reset your password");
        Assert.assertEquals(signUpPage.subTitle.getText(), "Don’t be ashamed. It happens to the best.");
        Assert.assertEquals(signUpPage.enterEmail.getAttribute("placeholder"), "Enter your email");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.enterEmail.sendKeys(USER_NAME);
        Assert.assertNull(signUpPage.continueButtons.get(1).getAttribute("disabled"));
        signUpPage.enterEmail.clear();
        signUpPage.enterEmail.sendKeys(" ");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        Assert.assertEquals(signUpPage.signWithPassword.getText(), "I remember now!");
        signUpPage.signWithPassword.click();
        Thread.sleep(1500);
        Assert.assertEquals(loginPage.image.getAttribute("src"), LOGIN_IMAGE);
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Welcome back please login");

    }

    @Test
    public void login() throws InterruptedException {

        mainPage.signButtons.get(1).click();
        Thread.sleep(500);
        Assert.assertEquals(signUpPage.stepTitle.getText(),"Ask Questions & receive instant help or Answer Questions & make money");
        Assert.assertEquals(signUpPage.googleButton.getText(),"Sign In with Google");
        Assert.assertEquals(signUpPage.signWithEmail.getText(),"Sign In with Email");
        Assert.assertEquals(signUpPage.signinStrip.getText(),"Need an account?  Sign up");
        Assert.assertEquals(loginPage.image.getAttribute("src"),SIGNUP_IMAGE);
        Thread.sleep(1000);
        //signUpPage.googleButton.click();
        //checkNewWindowAddress(GOOGLE_SIGNIN_PAGE);
        signUpPage.signWithEmail.click();
        signUpPage.createPassword.click();
        Assert.assertEquals(signUpPage.stepTitle.getText(),"Create your password");
        Assert.assertEquals(signUpPage.enterEmail.getText(),"Enter your email");
        Assert.assertEquals(signUpPage.signWithPassword.getText(),"I already have a password");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getText(),"Create password");
        Assert.assertEquals(loginPage.image.getAttribute("src"),LOGIN_IMAGE);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.enterEmail.sendKeys(USER_NAME);
        Assert.assertNull(signUpPage.continueButtons.get(1).getAttribute("disabled"));
        signUpPage.enterEmail.clear();
        signUpPage.enterEmail.sendKeys(" ");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.signinStrip.click();
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Welcome back\nplease login");
        Assert.assertEquals(loginPage.emailInput.getAttribute("placeholder"),"Enter your email");
        Assert.assertEquals(loginPage.password.getAttribute("placeholder"),"Enter password");
        Assert.assertEquals(signUpPage.signinStrip.getText(), "Forgot password?");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("value"), "Login");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        loginPage.emailInput.sendKeys(USER_NAME);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        loginPage.password.sendKeys(PASSWORD);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.signinStrip.click();
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Reset your password");
        driver.navigate().back();
        mainPage.backButton.click();
        Thread.sleep(500);
        Assert.assertNotNull(mainPage.exitDialog);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getText(), "Exit");
        Assert.assertEquals(mainPage.exitWindowText.getText(), "Are you sure you want to exit?");
        Thread.sleep(2000);
        signUpPage.continueButtons.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);
        driver.navigate().back();
        loginPage.signUpLink.click();

    }

    @Test
    public void homeworkHelp() throws InterruptedException {

        mainPage.tabsContainer.get(0).click();
        /*Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Search questions");
        Assert.assertEquals(mainPage.banner.getText(), "Make money while helping others with their homework.");
        Thread.sleep(3000);
        scroll(mainPage.moreButton, 15);
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.filterHeaders.size(),2 );
        Assert.assertEquals(mainPage.filters.size(), 26);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.filterHeaders);*/
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(3000);
        System.out.println(homeworkHelpPage.questionBox.size());
        if (homeworkHelpPage.questionBox.size() <= 50)
            Assert.fail();
        /*homeworkHelpPage.askButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(mainPage.signPopup.isDisplayed());*/

    }

    @Test
    public void studyDocuments() throws InterruptedException {

        mainPage.tabsContainer.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find study documents in...");
        Assert.assertEquals(mainPage.banner.getText(), "Notes, study guides, exams and more from the best sites.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        mainPage.sort.get(1).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Relevance");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Date");
        Assert.assertEquals(mainPage.filterHeaders.size(),1 );
        Assert.assertEquals(mainPage.filters.size(), 5);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void flashcards() throws InterruptedException {

        mainPage.tabsContainer.get(2).click();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Look for flashcards...");
        Assert.assertEquals(mainPage.banner.getText(), "Study from millions of flashcard sets to improve your grades.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        mainPage.sort.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=Relevance");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=Date");
        Assert.assertEquals(mainPage.filterHeaders.size(),1 );
        Assert.assertEquals(mainPage.filters.size(), 8);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void tutors() throws InterruptedException {

        mainPage.tabsContainer.get(3).click();
        Thread.sleep(500);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find a tutor...");
        Assert.assertEquals(mainPage.banner.getText(), "Find an expert to help you ace your classes in-person or online.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        mainPage.sort.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE + "?sort=Price");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE + "?sort=Relevance");
        Assert.assertEquals(mainPage.filterHeaders.size(),1 );
        Assert.assertEquals(mainPage.filters.size(), 2);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void textbooks() throws InterruptedException {

        mainPage.tabsContainer.get(4).click();
        Thread.sleep(500);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Textbook title or ISBN...");
        Assert.assertEquals(mainPage.banner.getText(), "Compare the best prices to buy, rent or sell your textbooks.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        driver.get(BOOK_PAGE + "/9781400201655");
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.filterHeaders.size(),1 );
        Assert.assertEquals(mainPage.filters.size(), 3);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void jobs() throws InterruptedException {

        mainPage.tabsContainer.get(5).click();
        Thread.sleep(500);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Your field of expertise...");
        Assert.assertEquals(mainPage.banner.getText().trim(), "Find jobs and internships catered specifically to students.");
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.filterHeaders.size(),1 );
        Assert.assertEquals(mainPage.filters.size(), 4);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sort);

    }

    @Test
    public void about() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Assert.assertEquals(aboutPage.images.get(0).getAttribute("src"), HOME_PAGE + ABOUT_IMAGE1);
        Assert.assertEquals(aboutPage.images.get(1).getAttribute("src"), ABOUT_IMAGE2);
        Assert.assertEquals(aboutPage.images.get(2).getAttribute("src"), ABOUT_IMAGE3);
        for(int i=0 ; i < 7 ; i++) {
            Thread.sleep(2000);
            aboutPage.tabsHeader.get(i).click();
            if (i == 2) {
                Thread.sleep(2000);
                checkNewWindowAddress(MEDIUM_PAGE);
            }
        }

    }

    @Test
    public void FAQ() throws InterruptedException {

        driver.get(FAQ_PAGE);
        Thread.sleep(2000);
        clickOnWebElements(faqPage.FaqHeaders);
        faqPage.FaqHeaders.get(8).click();
        mainPage.termsLink.click();
        driver.get(FAQ_PAGE);
        Thread.sleep(2000);
        for(int i=0 ; i < 2 ; i++) {
            faqPage.FaqHeaders.get(i + 9).click();
            Thread.sleep(2000);
            faqPage.support.click();
            Thread.sleep(2000);
        }
        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), AMAZON_IMAGE);
        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), AMAZON_IMAGE);

    }

    @Test
    public void partners() {

        driver.get(PARTNERS_PAGE);
        Assert.assertEquals(partnersPage.image.getAttribute("src"), PARTNERS_IMAGE);
        partnersPage.partnerEmail.click();

    }

    @Test
    public void reps() {

        driver.get(REPS_PAGE);
        Assert.assertEquals(repsPage.image.getAttribute("src"), REPS_IMAGE);
        repsPage.workEmail.click();

    }

    @Test
    public void privacy() throws InterruptedException {

        driver.get(PRIVACY_PAGE);
        privacyPage.link1.click();
        Thread.sleep(500);
        //checkNewWindowAddress(HOME_PAGE_PROD);
        scroll(privacyPage.link1, 30);
        privacyPage.link2.click();
        Thread.sleep(2000);
        //checkNewWindowAddress(GOOGLE_MARKETING);

    }

    @Test
    public void terms() throws InterruptedException {

        driver.get(TERMS_PAGE);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
        scroll(termsPage.anchor, 50);
        termsPage.copyrights.click();
        //checkNewWindowAddress(COPYRIGHTS_DOC);

    }

    @Test
    public void contact() {

        driver.get(CONTACT_PAGE);
        Assert.assertNotNull(contactPage.map);
        contactPage.links.get(0).click();
        //checkNewWindowAddress(FACEBOOK_PAGE);
        contactPage.links.get(1).click();
        //checkNewWindowAddress(TWITTER_PAGE);
        contactPage.links.get(2).click();
        //checkNewWindowAddress(YOUTUBE_PAGE);
        contactPage.links.get(3).click();
        //checkNewWindowAddress(INSTAGRAM_PAGE);
        contactPage.links.get(4).click();
        //checkNewWindowAddress(TELEGRAM_PAGE);
        contactPage.links.get(5).click();
        //checkNewWindowAddress(MEDIUM_PAGE);
        contactPage.links.get(6).click();
        //checkNewWindowAddress(GITHUB_PAGE);
        contactPage.links.get(7).click();
        //checkNewWindowAddress(LINKEDIN_PAGE);

    }

    @Test
    public void token() throws InterruptedException {

        driver.get(TOKEN_PAGE);
        Thread.sleep(2000);
        /*
        Assert.assertNotNull(tokenPage.youtube);
        tokenPage.spitball2.click();
        checkNewWindowAddress(HOME_PAGE);
        Thread.sleep(1000);
        tokenPage.downloadWhitepaper.click();
        checkNewWindowAddress(WHITEPAPER_DOC);
        Thread.sleep(1000);
        tokenPage.joinTelegram.click();
        checkNewWindowAddress(TELEGRAM_PAGE);
        Thread.sleep(1000);
        Assert.assertEquals(tokenPage.emailText.getAttribute("placeholder"), "Enter your email");
        tokenPage.emailText.sendKeys(USERNAME);
        //tokenPage.subscribeButton.click();
        //Assert.assertNull(tokenPage.emailText.getText());
        scroll(tokenPage.downloadWhitepaper, 22);
        Assert.assertEquals(tokenPage.images.get(3).getAttribute("src"), HEVRA_IMAGE);
        Thread.sleep(1000);
        scroll(tokenPage.downloadWhitepaper , 22);
        Assert.assertEquals(tokenPage.images.get(4).getAttribute("src"), SPITBALL_APP_IMAGE);
        Thread.sleep(1000);
        scroll(tokenPage.downloadWhitepaper, 22);
        Assert.assertEquals(tokenPage.images.get(5).getAttribute("src"), ECONOMY_IMAGE);
        Thread.sleep(1000);
        scroll(tokenPage.downloadWhitepaper, 45);
        Assert.assertEquals(tokenPage.images.get(6).getAttribute("src"), EIDAN_IMAGE);
        Thread.sleep(1000);
        Assert.assertEquals(tokenPage.images.get(8).getAttribute("src"), RAM_IMAGE);
        Thread.sleep(1000);
        Assert.assertEquals(tokenPage.images.get(10).getAttribute("src"), JORDAN_IMAGE);
        Thread.sleep(1000);
        Assert.assertEquals(tokenPage.images.get(12).getAttribute("src"), ROB_IMAGE);
        Thread.sleep(1000);
        Assert.assertEquals(tokenPage.images.get(14).getAttribute("src"), SHLOMI_IMAGE);
        Thread.sleep(1000);
        Assert.assertEquals(tokenPage.images.get(16).getAttribute("src"), HADAR_IMAGE);
        Thread.sleep(1000);
        Assert.assertEquals(tokenPage.images.get(18).getAttribute("src"), TORI_IMAGE);
        Thread.sleep(1000);
        Assert.assertEquals(tokenPage.images.get(20).getAttribute("src"), OLA_IMAGE);
        Thread.sleep(1000);
        scroll(tokenPage.downloadWhitepaper, 22);
        Assert.assertEquals(tokenPage.images.get(22).getAttribute("src"), TOKEN_PARTNERS_IMAGE);
        Thread.sleep(1000);
        */
        scroll(tokenPage.downloadWhitepaper, 120);
        scroll(tokenPage.downloadWhitepaper, 22);
        Thread.sleep(1000);
        //Assert.assertEquals(tokenPage.contactForm.get(1).getText(), "Your Name");
        //Assert.assertEquals(tokenPage.contactForm.get(2).getText(), "Your Email");
        //Assert.assertEquals(tokenPage.contactForm.get(3).getText(), "Your Message");
        tokenPage.contactForm.get(1).sendKeys(FIRST_NAME);
        tokenPage.contactForm.get(2).sendKeys(USER_NAME);
        tokenPage.contactForm.get(3).sendKeys(MESSAGE);
        //Actions actions = new Actions(driver);
        //actions.moveToElement(tokenPage.contactForm.get(4)).build().perform();
        //tokenPage.contactForm.get(4).click();
        //Assert.assertEquals(tokenPage.contactForm.get(1).getText(), "");
        //Assert.assertEquals(tokenPage.contactForm.get(2).getText(), "");
        //Assert.assertEquals(tokenPage.contactForm.get(3).getText(), "");
        scroll(tokenPage.downloadWhitepaper, 15);
        Thread.sleep(2000);

        for(int i = 0 ; i < 5 ; i++) {
            tokenPage.internalLinks.get(i).click();
        }

        tokenPage.homePage.click();
        //checkNewWindowAddress(TOKEN_PAGE);

    }





    @AfterClass
    public void cleanupTestSeries() {

        driver.quit();

    }

}
