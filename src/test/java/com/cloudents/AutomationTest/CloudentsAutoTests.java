package com.cloudents.AutomationTest;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static com.cloudents.AutomationTest.Resources.*;



public class CloudentsAutoTests {

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional String browser) {

        if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile myProfile = profile.getProfile("Automation");
            options.setProfile(myProfile);
            System.setProperty(GECKO_DRIVER, DRIVERS_LOCATION + GECKO_FILE);
            driver = new FirefoxDriver(options);
        }
        else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty(CHROME_DRIVER, DRIVERS_LOCATION + CHROME_FILE);
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty(EDGE_DRIVER, DRIVERS_LOCATION + EDGE_FILE);
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }
        /*else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty(IE_DRIVER, DRIVERS_LOCATION + IE_FILE);
            driver = new InternetExplorerDriver();
        }*/

        Resources.initElements();
        Resources.winHandleBefore = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }




    @Test
    public void global() throws InterruptedException {

        homePage();
        Thread.sleep(2000);
        mainTabs();
        Thread.sleep(2000);
        //homeworkHelp();
        //Thread.sleep(2000);
        studyDocuments();
        Thread.sleep(2000);
        flashcards();
        Thread.sleep(2000);
        tutors();
        Thread.sleep(2000);
        textbooks();
        Thread.sleep(2000);
        //jobs();
        //Thread.sleep(2000);
        signUp();
        Thread.sleep(2000);
        login();
        Thread.sleep(2000);
        about();
        Thread.sleep(2000);
        //token();

    }

    @Test
    public void homePage() throws InterruptedException {

        driver.get(HOME_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);

        mainPage.FAQlist.get(0).click();
        Thread.sleep(3000);
        checkNewWindowAddress(FAQ_PAGE + "?id=0");
        mainPage.FAQlist.get(1).click();
        Thread.sleep(3000);
        checkNewWindowAddress(FAQ_PAGE + "?id=1");
        mainPage.FAQlist.get(2).click();
        Thread.sleep(3000);
        checkNewWindowAddress(FAQ_PAGE + "?id=2");
        mainPage.FAQlist.get(3).click();
        Thread.sleep(3000);
        checkNewWindowAddress(FAQ_PAGE + "?id=3");
        mainPage.FAQlist.get(4).click();
        Thread.sleep(3000);
        checkNewWindowAddress(FAQ_PAGE + "?id=4");
        Thread.sleep(3000);

        mainPage.moreButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), FAQ_PAGE);

    }

    @Test
    public void mainTabs() throws InterruptedException {

        driver.get(HOME_PAGE);
        Thread.sleep(3000);

        clickOnWebElements(mainPage.tabsContainer);
        Thread.sleep(5000);

        mainPage.signButtons.get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/register?returnUrl=%2Fjob");
        driver.navigate().back();
        Thread.sleep(3000);
        mainPage.signButtons.get(1).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/signin");

    }

    @Test
    public void signUp() throws InterruptedException {

        driver.get(SIGNUP_PAGE);
        Thread.sleep(1000);

        Assert.assertEquals(signUpPage.image.getAttribute("src"),SIGNUP_IMAGE);
        signUpPage.googleButton.click();
        Assert.assertEquals(signUpPage.errorMessage.getText(), "Please agree to Terms And Services in order to proceed");
        signUpPage.termsLinks.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
        driver.navigate().back();
        signUpPage.termsLinks.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), PRIVACY_PAGE);
        driver.navigate().back();
        Thread.sleep(1000);
        signUpPage.agreeCheckbox.click();
        signUpPage.googleButton.click();
        checkNewWindowAddress(GOOGLE_SIGNIN_PAGE);
        Thread.sleep(1000);
        checkExit();
        Thread.sleep(1000);
        signUpPage.signInLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(loginPage.image.getAttribute("src"), LOGIN_IMAGE);
        Thread.sleep(2000);
        driver.get(SIGNUP_PAGE);
        Thread.sleep(1000);
        signUpPage.agreeCheckbox.click();
        signUpPage.signWithEmail.click();
        Assert.assertEquals(signUpPage.emailInput.getAttribute("placeholder"),"Enter your email address");
        signUpPage.emailInput.sendKeys("elad@cloudents.com");
        signUpPage.emailInput.clear();
        signUpPage.emailInput.sendKeys("elad@cloudents.com");
        Thread.sleep(1000);
        checkExit();

    }

    @Test
    public void login() throws InterruptedException {

        driver.get(LOGIN_PAGE);
        Thread.sleep(1000);

        Assert.assertEquals(loginPage.emailInput.getAttribute("placeholder"),"Enter your email address");
        Assert.assertEquals(loginPage.image.getAttribute("src"),LOGIN_IMAGE);
        loginPage.emailInput.sendKeys("elad@cloudents.com");
        Thread.sleep(1000);
        checkExit();
        loginPage.signUpLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(signUpPage.image.getAttribute("src"), SIGNUP_IMAGE);

    }

    @Test
    public void homeworkHelp() throws InterruptedException {

        driver.get(HOMEWORK_PAGE);
        Thread.sleep(1000);

        mainPage.filterHeaders.get(1).click();
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.filterHeaders);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Search questions");
        Assert.assertEquals(mainPage.banner.getText(), "Make money while helping others with their homework.");
        homeworkHelpPage.askButton.click();
        Assert.assertTrue(mainPage.signPopup.isDisplayed());

    }

    @Test
    public void studyDocuments() throws InterruptedException {

        driver.get(STUDY_PAGE);
        Thread.sleep(2000);

        mainPage.sort.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Relevance");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Date");


        mainPage.sortSection.get(0).click();
        Thread.sleep(1000);
        mainPage.sortSection.get(0).click();
        Thread.sleep(2000);
        clickOnWebElements(mainPage.filters);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find study documents in...");
        Assert.assertEquals(mainPage.banner.getText(), "Notes, study guides, exams and more from the best sites.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");

    }

    @Test
    public void flashcards() throws InterruptedException {

        driver.get(FLASHCARD_PAGE);
        Thread.sleep(1000);

        /*mainPage.sort.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=date");
        mainPage.sort.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=relevance");*/

        //mainPage.sortSection.get(1).click();
        //Thread.sleep(300);
        clickOnWebElements(mainPage.filters);
        mainPage.sortSection.get(0).click();

        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Look for flashcards...");
        Assert.assertEquals(mainPage.banner.getText(), "Study from millions of flashcard sets to improve your grades.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");

    }

    @Test
    public void tutors() throws InterruptedException {

        driver.get(TUTOR_PAGE);
        Thread.sleep(2000);

        /*mainPage.sort.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE + "?sort=price");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE + "?sort=relevance");*/

        clickOnWebElements(mainPage.filters);
        mainPage.sortSection.get(0).click();
        Thread.sleep(2000);

        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find a tutor...");
        Assert.assertEquals(mainPage.banner.getText(), "Find an expert to help you ace your classes in-person or online.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");

    }

    @Test
    public void textbooks() throws InterruptedException {

        driver.get(BOOK_PAGE + "/9781400201655");
        Thread.sleep(10000);

        clickOnWebElements(mainPage.filters);
        Thread.sleep(3000);
        mainPage.sort.get(1).click();
        Thread.sleep(3000);
        mainPage.sort.get(0).click();
        Thread.sleep(3000);

        mainPage.sortSection.get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Textbook title or ISBN...");
        driver.get(BOOK_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.banner.getText(), "Compare the best prices to buy, rent or sell your textbooks.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");

    }

    @Test
    public void jobs() throws InterruptedException {

        driver.get(JOB_PAGE);
        Thread.sleep(2000);

        clickOnWebElements(mainPage.filters);
        mainPage.sort.get(1).click();
        Thread.sleep(1000);
        mainPage.sort.get(0).click();
        Thread.sleep(1000);

        mainPage.sortSection.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Your field of expertise...");
        Assert.assertEquals(mainPage.banner.getText().trim(), "Find jobs and internships catered specifically to students.");

    }

    @Test
    public void about() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(3000);

        //clickOnWebElements(aboutPage.tabsHeader);
        for(int i=0 ; i < 7 ; i++) {

            aboutPage.tabsHeader.get(i).click();

            if (i == 2) {

                Thread.sleep(3000);
                checkNewWindowAddress(MEDIUM_PAGE);

            }

        }

        FAQ();
        partners();
        reps();
        privacy();
        terms();
        contact();

    }

    @Test
    public void FAQ() throws InterruptedException {

        driver.get(FAQ_PAGE);
        Thread.sleep(1000);

        clickOnWebElements(faqPage.FaqHeaders);
        Thread.sleep(300);
        faqPage.FaqHeaders.get(8).click();
        Thread.sleep(1000);
        mainPage.termsLink.click();
        driver.navigate().back();

        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), AMAZON_IMAGE);
        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), AMAZON_IMAGE);

    }

    @Test
    public void partners() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(3).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), PARTNERS_PAGE);
        Assert.assertEquals(partnersPage.image.getAttribute("src"), PARTNERS_IMAGE);

    }

    @Test
    public void reps() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(4).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), REPS_PAGE);
        Assert.assertEquals(repsPage.image.getAttribute("src"), REPS_IMAGE);

    }

    @Test
    public void privacy() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(5).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), PRIVACY_PAGE);

        privacyPage.link1.click();
        Thread.sleep(1000);
        checkNewWindowAddress(HOME_PAGE_PROD);

        privacyPage.link2.click();
        Thread.sleep(1000);
        checkNewWindowAddress(GOOGLE_MARKETING);
    }

    @Test
    public void terms() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(6).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);

        termsPage.docLink.click();
        Thread.sleep(1000);
        checkNewWindowAddress(TERMS_DOC);

    }

    @Test
    public void contact() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(7).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), CONTACT_PAGE);
        Assert.assertNotNull(contactPage.map);
        contactPage.links.get(0).click();
        Thread.sleep(2000);
        checkNewWindowAddress(FACEBOOK_PAGE);
        contactPage.links.get(1).click();
        Thread.sleep(2000);
        checkNewWindowAddress(TWITTER_PAGE);
        contactPage.links.get(2).click();
        Thread.sleep(2000);
        checkNewWindowAddress(YOUTUBE_PAGE);
        contactPage.links.get(3).click();
        Thread.sleep(2000);
        checkNewWindowAddress(INSTAGRAM_PAGE);
        contactPage.links.get(4).click();
        Thread.sleep(2000);
        checkNewWindowAddress(TELEGRAM_PAGE);
        contactPage.links.get(5).click();
        Thread.sleep(2000);
        checkNewWindowAddress(MEDIUM_PAGE);
        contactPage.links.get(6).click();
        Thread.sleep(2000);
        checkNewWindowAddress(GITHUB_PAGE);
        contactPage.links.get(7).click();
        Thread.sleep(2000);
        checkNewWindowAddress(LINKEDIN_PAGE);

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
        tokenPage.emailText.sendKeys("elad@cloudents.com");
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
        tokenPage.contactForm.get(1).sendKeys("Elad");
        tokenPage.contactForm.get(2).sendKeys("elad@cloudents.com");
        tokenPage.contactForm.get(3).sendKeys("Hi, my name is Elad.");
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
        checkNewWindowAddress(TOKEN_PAGE);

    }





    @AfterClass
    public void cleanupTestSeries() {

        driver.quit();

    }

}
