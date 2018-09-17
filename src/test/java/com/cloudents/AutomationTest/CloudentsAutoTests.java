package com.cloudents.AutomationTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static com.cloudents.AutomationTest.Resources.*;
import static org.testng.Assert.assertTrue;




public class CloudentsAutoTests {

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional String browser) throws Exception {

        /*if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile myProfile = profile.getProfile("Automation");
            options.setProfile(myProfile);
            //options.addArguments("--headless");
            System.setProperty(GECKO_DRIVER, DRIVERS_LOCATION + GECKO_FILE);
            driver = new FirefoxDriver(options);
        }
        else if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless");
            System.setProperty(CHROME_DRIVER, DRIVERS_LOCATION + CHROME_FILE);
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty(EDGE_DRIVER, DRIVERS_LOCATION + EDGE_FILE);
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("Safari")) {
            DesiredCapabilities caps = DesiredCapabilities.safari();
            caps.setCapability("platform", "macOS 10.12");
            caps.setCapability("version", "11.0");
            driver = new SafariDriver();
        }


        Resources.initElements();
        Resources.winHandleBefore = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

    }

    @BeforeClass
    public void setup() {

        /*System.setProperty(EDGE_DRIVER, DRIVERS_LOCATION + EDGE_FILE);
        driver = new EdgeDriver();*/

        /*FirefoxOptions options = new FirefoxOptions();
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myProfile = profile.getProfile("Automation");
        myProfile.setPreference("browser.privatebrowsing.autostart", true);
        options.setProfile(myProfile);
        System.setProperty(GECKO_DRIVER, DRIVERS_LOCATION + GECKO_FILE);
        driver = new FirefoxDriver(options);*/

        ChromeOptions options = new ChromeOptions();
        System.setProperty(CHROME_DRIVER, DRIVERS_LOCATION + CHROME_FILE);
        //options.addArguments("--incognito");
        //options.addArguments("--disable-notifications");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.geolocation", 2);
        options.setExperimentalOption("prefs", prefs);
        // Attach to already opened chrome instance
        //options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Resources.initElements();
        Resources.winHandleBefore = driver.getWindowHandle();
        driver.get(HOME_PAGE);
        mainPage.cookieApprove.click();

    }

    @Test
    public void global() throws InterruptedException {

        //common();
        about();
        FAQ();
        partners();
        reps();
        privacy();
        terms();
        contact();
        //mainTabs();
        /*homeworkHelp();
        studyDocuments();
        flashcards();
        tutors();
        textbooks();
        jobs();*/
        //signUp();
        //login();
        //token();

    }

    @Test
    public void common() throws InterruptedException {

        driver.get(HOME_PAGE);
        mainPage.homeLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);
        for (int i = 0 ; i < 5 ; i++) {
            mainPage.FAQlist.get(i).click();
            Thread.sleep(2000);
            checkNewWindowAddress(FAQ_PAGE + "?id=" + i);
        }
        mainPage.moreButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), FAQ_PAGE);
        driver.get(HOME_PAGE);
        mainPage.signButtons.get(0).click();
        Thread.sleep(2000);
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        assertTrue(actualURL.contains(SIGNUP_PAGE));
        driver.get(HOME_PAGE);
        mainPage.signButtons.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE);

    }

    @Test
    public void mainTabs() throws InterruptedException {

        driver.get(HOME_PAGE);
        clickOnWebElements(mainPage.tabsContainer);

    }

    @Test
    public void signUp() throws InterruptedException {

        driver.get(SIGNUP_PAGE);
        Assert.assertEquals(signUpPage.image.getAttribute("src"),SIGNUP_IMAGE);
        Assert.assertEquals(signUpPage.googleButton.getText(),"Sign Up with Google");
        Assert.assertEquals(signUpPage.signWithEmail.getText(),"Sign Up with Email");
        signUpPage.termsLinks.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
        driver.navigate().back();
        signUpPage.termsLinks.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), PRIVACY_PAGE);
        driver.navigate().back();
        signUpPage.loginLink.click();
        Assert.assertEquals(loginPage.image.getAttribute("src"), LOGIN_IMAGE);
        driver.get(SIGNUP_PAGE);
        signUpPage.googleButton.click();
        Assert.assertEquals(signUpPage.errorMessage.getText(), "Please agree to Terms And Services in order to proceed");
        driver.navigate().refresh();
        signUpPage.signWithEmail.click();
        Assert.assertEquals(signUpPage.errorMessage.getText(), "Please agree to Terms And Services in order to proceed");
        signUpPage.agreeCheckbox.click();
        signUpPage.googleButton.click();
        checkNewWindowAddress(GOOGLE_SIGNIN_PAGE);
        signUpPage.signWithEmail.click();
        Assert.assertEquals(signUpPage.emailInput.getAttribute("placeholder"),"Enter your email address");
        signUpPage.emailInput.sendKeys("elad@cloudents.com");
        checkExit();

    }

    @Test
    public void login() throws InterruptedException {

        driver.get(LOGIN_PAGE);
        Assert.assertEquals(loginPage.emailInput.getAttribute("placeholder"),"Enter your email address");
        Assert.assertEquals(loginPage.image.getAttribute("src"),LOGIN_IMAGE);
        loginPage.emailInput.sendKeys("elad@cloudents.com");
        loginPage.signUpLink.click();
        Assert.assertEquals(signUpPage.image.getAttribute("src"), SIGNUP_IMAGE);
        checkExit();

    }

    @Test
    public void homeworkHelp() throws InterruptedException {

        driver.get(HOMEWORK_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Search questions");
        Assert.assertEquals(mainPage.banner.getText(), "Make money while helping others with their homework.");
        Assert.assertEquals(mainPage.filterHeaders.size(), 2);
        Assert.assertEquals(mainPage.filters.size(), 26);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.filterHeaders);
        homeworkHelpPage.askButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(mainPage.signPopup.isDisplayed());

    }

    @Test
    public void studyDocuments() throws InterruptedException {

        driver.get(STUDY_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find study documents in...");
        Assert.assertEquals(mainPage.banner.getText(), "Notes, study guides, exams and more from the best sites.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        mainPage.sort.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Relevance");
        mainPage.sort.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Date");
        Assert.assertEquals(mainPage.filterHeaders.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 5);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void flashcards() throws InterruptedException {

        driver.get(FLASHCARD_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Look for flashcards...");
        Assert.assertEquals(mainPage.banner.getText(), "Study from millions of flashcard sets to improve your grades.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        mainPage.sort.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=Relevance");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=Date");
        Assert.assertEquals(mainPage.filterHeaders.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 8);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void tutors() throws InterruptedException {

        driver.get(TUTOR_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find a tutor...");
        Assert.assertEquals(mainPage.banner.getText(), "Find an expert to help you ace your classes in-person or online.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        mainPage.sort.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE + "?sort=Price");
        mainPage.sort.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE + "?sort=Relevance");
        Assert.assertEquals(mainPage.filterHeaders.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 2);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void textbooks() throws InterruptedException {

        driver.get(BOOK_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.banner.getText(), "Compare the best prices to buy, rent or sell your textbooks.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Textbook title or ISBN...");
        driver.get(BOOK_PAGE + "/9781400201655");
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.filterHeaders.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 3);
        clickOnWebElements(mainPage.filters);
        mainPage.sort.get(1).click();
        mainPage.sort.get(0).click();
        mainPage.sortSection.get(0).click();

    }

    @Test
    public void jobs() throws InterruptedException {

        driver.get(JOB_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Your field of expertise...");
        Assert.assertEquals(mainPage.banner.getText().trim(), "Find jobs and internships catered specifically to students.");
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.filterHeaders.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 4);
        clickOnWebElements(mainPage.filters);
        mainPage.sortSection.get(0).click();

    }

    @Test
    public void about() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(aboutPage.images.get(0).getAttribute("src"), HOME_PAGE + ABOUT_IMAGE1);
        Assert.assertEquals(aboutPage.images.get(1).getAttribute("src"), ABOUT_IMAGE2);
        Assert.assertEquals(aboutPage.images.get(2).getAttribute("src"), ABOUT_IMAGE3);
        for(int i=0 ; i < 7 ; i++) {
            aboutPage.tabsHeader.get(i).click();
            if (i == 2) {
                Thread.sleep(3000);
                checkNewWindowAddress(MEDIUM_PAGE);
            }
        }

    }

    @Test
    public void FAQ() throws InterruptedException {

        driver.get(FAQ_PAGE);
        Thread.sleep(500);
        clickOnWebElements(faqPage.FaqHeaders);
        faqPage.FaqHeaders.get(8).click();
        mainPage.termsLink.click();
        driver.get(FAQ_PAGE);
        Thread.sleep(500);
        for(int i=0 ; i < 2 ; i++) {
            faqPage.FaqHeaders.get(i + 9).click();
            Thread.sleep(500);
            faqPage.support.click();
            Thread.sleep(500);
        }
        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), AMAZON_IMAGE);
        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), AMAZON_IMAGE);

    }

    @Test
    public void partners() throws InterruptedException {

        driver.get(PARTNERS_PAGE);
        Assert.assertEquals(partnersPage.image.getAttribute("src"), PARTNERS_IMAGE);
        partnersPage.partnerEmail.click();
        Thread.sleep(500);

    }

    @Test
    public void reps() throws InterruptedException {

        driver.get(REPS_PAGE);
        Assert.assertEquals(repsPage.image.getAttribute("src"), REPS_IMAGE);
        repsPage.workEmail.click();
        Thread.sleep(500);

    }

    @Test
    public void privacy() throws InterruptedException {

        driver.get(PRIVACY_PAGE);
        privacyPage.link1.click();
        Thread.sleep(1000);
        checkNewWindowAddress(HOME_PAGE_PROD);
        scroll(privacyPage.link2, 1);
        privacyPage.link2.click();
        checkNewWindowAddress(GOOGLE_MARKETING);
        scroll(privacyPage.support.get(0), 1);
        privacyPage.support.get(0).click();
        Thread.sleep(500);
        scroll(privacyPage.support.get(1), 1);
        privacyPage.support.get(1).click();
        Thread.sleep(500);
        scroll(privacyPage.support.get(2), 1);
        privacyPage.support.get(2).click();
        Thread.sleep(500);

    }

    @Test
    public void terms() throws InterruptedException {

        driver.get(TERMS_PAGE);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
        Thread.sleep(1000);
        scroll(termsPage.copyrights, 1);
        termsPage.copyrights.click();
        Thread.sleep(5000);
        checkNewWindowAddress(COPYRIGHTS_DOC);
        scroll(termsPage.support, 1);
        Thread.sleep(3000);
        termsPage.support.click();
        Thread.sleep(1000);

    }

    @Test
    public void contact() throws InterruptedException {

        driver.get(CONTACT_PAGE);
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
        contactPage.support.click();
        Thread.sleep(1000);

    }

    @Test
    public void token() throws InterruptedException {

        driver.get(TOKEN_PAGE);
        Thread.sleep(1000);
        Assert.assertNotNull(tokenPage.youtube);
        tokenPage.logo.get(0).click();
        checkNewWindowAddress(HOME_PAGE_PROD);
        tokenPage.innerLinks.get(0).click();
        checkNewWindowAddress(WHITEPAPER_DOC);
        tokenPage.innerLinks.get(1).click();
        checkNewWindowAddress(TELEGRAM_PAGE);
        Assert.assertEquals(tokenPage.emailText.getAttribute("placeholder"), "Enter your email");
        tokenPage.emailText.sendKeys("elad@cloudents.com");
        //tokenPage.subscribeButton.click();
        //Assert.assertNull(tokenPage.emailText.getText());
        scroll(tokenPage.innerLinks.get(0), 22);
        Assert.assertEquals(tokenPage.images.get(3).getAttribute("src"), HEVRA_IMAGE);
        scroll(tokenPage.innerLinks.get(0) , 22);
        Assert.assertEquals(tokenPage.images.get(4).getAttribute("src"), SPITBALL_APP_IMAGE);
        scroll(tokenPage.innerLinks.get(0), 22);
        Assert.assertEquals(tokenPage.images.get(5).getAttribute("src"), ECONOMY_IMAGE);
        scroll(tokenPage.innerLinks.get(0), 44);
        for(int i=6, j=0 ; i < 22 ; i+=2, j++) {
            Assert.assertEquals(tokenPage.images.get(i).getAttribute("src"), PERSONAL_IMAGES[j]);
        }
        Thread.sleep(1000);
        scroll(tokenPage.innerLinks.get(0), 22);
        Assert.assertEquals(tokenPage.images.get(22).getAttribute("src"), TOKEN_PARTNERS_IMAGE);
        Thread.sleep(1000);
        scroll(tokenPage.innerLinks.get(0), 17);
        Thread.sleep(2000);
        Assert.assertEquals(tokenPage.placeHolders.get(0).getText(), "Your Name");
        Assert.assertEquals(tokenPage.placeHolders.get(1).getText(), "Your Email");
        Assert.assertEquals(tokenPage.placeHolders.get(2).getText(), "Your Message");
        tokenPage.contactForm.get(0).sendKeys("Elad");
        tokenPage.contactForm.get(1).sendKeys("elad@cloudents.com");
        tokenPage.textArea.sendKeys("Hi, my name is Elad.");
        /*tokenPage.submitButton.click();
        Assert.assertEquals(tokenPage.contactForm.get(1).getText(), "");
        Assert.assertEquals(tokenPage.contactForm.get(2).getText(), "");
        Assert.assertEquals(tokenPage.contactForm.get(3).getText(), "");*/
        tokenPage.support.click();
        tokenPage.joinTelegram.get(1).click();
        Thread.sleep(1000);
        checkNewWindowAddress(TELEGRAM_PAGE);
        scroll(tokenPage.innerLinks.get(0), 15);
        Thread.sleep(1000);
        for(int i = 0 ; i < 7 ; i++) {
            tokenPage.socialLinks.get(i).click();
            Thread.sleep(1000);
            checkNewWindowAddress(TOKEN_SOCIAL[i]);
        }
        tokenPage.innerLinks.get(6).click();
        Thread.sleep(5000);
        checkNewWindowAddress(WHITEPAPER_DOC);
        tokenPage.innerLinks.get(7).click();
        Thread.sleep(1000);
        checkNewWindowAddress(HOME_PAGE_PROD);
        tokenPage.footerLinks.get(0).click();
        Thread.sleep(1000);
        checkNewWindowAddress(PRIVACY_PAGE_PROD);
        tokenPage.footerLinks.get(1).click();
        Thread.sleep(1000);
        checkNewWindowAddress(TERMS_PAGE_PROD);
        for(int i = 0 ; i < 4 ; i++) {
            tokenPage.innerLinks.get(i).click();
            Thread.sleep(1000);
            scroll(tokenPage.innerLinks.get(i),50);
            Thread.sleep(1000);
        }
        tokenPage.footerBrand.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TOKEN_PAGE + "/");
    }




    @AfterClass
    public void cleanupTestSeries() {

        driver.quit();

    }

}
