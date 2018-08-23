package com.cloudents.AutomationTest;


import com.cloudents.AutomationTest.Pages.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class CloudentsAutoTests {

    private WebDriver driver;
    private MainPage mainPage;
    private HomeworkHelpPage homeworkHelpPage;
    private SignInPage signInPage;
    private AboutPage aboutPage;
    private FAQPage faqPage;
    private TermsPage termsPage;
    private PrivacyPage privacyPage;
    private PartnersPage partnersPage;
    private RepsPage repsPage;
    private ContactPage contactPage;
    private SignUpPage signUpPage;
    private TokenPage tokenPage;

    // Handle for the main window
    private String winHandleBefore;


    public void initElements() {

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


    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional String browser) {

        if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile myProfile = profile.getProfile("Automation");
            options.setProfile(myProfile);
            System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
            driver = new FirefoxDriver(options);
        }
        else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\WebDrivers\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }
        else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "C:\\WebDrivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        initElements();
        winHandleBefore = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @BeforeTest
    public void waitBetweenTests() throws InterruptedException {
        Thread.sleep(1000);
    }




    @Test
    public void homePage() throws InterruptedException {
        driver.get("http://dev.spitball.co");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask");
    }

    @Test
    public void mainTabs() throws InterruptedException {

        driver.get("https://dev.spitball.co");
        Thread.sleep(1000);

        mainPage.homeworkHelpTab.click();
        Thread.sleep(500);
        mainPage.studyDocumentsTab.click();
        Thread.sleep(500);
        mainPage.flashcardsTab.click();
        Thread.sleep(500);
        mainPage.tutorsTab.click();
        Thread.sleep(500);
        mainPage.textbooksTab.click();
        Thread.sleep(500);
        mainPage.jobsTab.click();
        Thread.sleep(500);

        Thread.sleep(2000);
        clickOnWebElements(mainPage.signButtons);

    }

    @Test
    public void signUp() throws InterruptedException {

        driver.get("https://dev.spitball.co/register");
        Thread.sleep(2000);

        signUpPage.googleButton.click();
        Thread.sleep(2000);
        checkNewWindowAddress("https://accounts.google.com/signin/");
        Thread.sleep(2000);
        //Assert.assertEquals(signUpPage.continueButton.getAttribute("disabled"), "true");
        Assert.assertEquals(signUpPage.signUpImage.getAttribute("src"),"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAckAAAFaCAMAAABCE1auAAADAFBMVEVMaXGcnNacnNX6+vqbm6Sbm9Wdndizs+adndWcnNadnda0tNm2tv+cnNabm9abm9abm9acnNaentmcnNedndjx8f+fn9uoqN2cnNadndeentebm9acnNacnNjl5eWcnNahodydndidndydndaiot2cnNbz9PScnNacnNabm9acnNacnNbz8/PGxuy1teacnNbn5+ebm9acnNecnNacnNacnNedndacnNaentecnNWcnNacnNacnNfe3t7e3t5padZoaNZsbN9oaNWfn9mfn9FpadZpadbh4eHd3d3l5eVra9qcnNabm9fe3t6Li9rm5+dra9hqatfe3t5qatje3t7e3t7c3Oxqatdpadbe3t6ystnf39/d3d1qatdpadZqatfd3d3e3t6iotb29vbe3t76+/v9/f2dnddqatZqataKit9padadnaydnaidnbadnaucnKatrbSbm6TT1NecnNWcnNbp6uqcnNLd3d2bm9XJydXx8vKxsdVoaNXR09TCwtqnp9aZmdXGxtr///+bm7qzs9jW2Nny8/PGxtW6utjY2dra29zf4OHb3N3S1NXv8PDi5OXh4uPd3+Dk5ubt7u7U1tfr7e2jo9a7vOeAgNrO0NTOz+ientaCgtujo9fMzOWurtXp6+vLy9fg4OCwsNWqqtpsbNVpadWkpNWkpNnk5eWLi9ipqdWlpdXAwNXX192srNWcnNamptW+vtu4uNp9fdZxcdbIyNb8/P7FxdzBwdvJydzZ2eDDw9Wvr9vS09zY2O61tdt5edaGhte7u9WVldeystymptqsrNu4uNba2t12dtZvb9bMzdWPj9apqdrP0Nyioth0dNbV1d2YmNm0tNbLy9uDg9eSkticnNm3t9bFxdXm5+nR0tTNzdze3+Xz8/rDw+bAwOSAgNbHx9W7u9rw8fLs7e7r6/f39/vc3N3o6evPz9rb2928vOOgoNm1teDb2/Dm5vXu7/DOztjS0uyCgtfb3OPR0drh4fDv7/jW1u2+vtXJyeibm6+qqsNfYdICAAAAeHRSTlMAZOgv0sRbCkmIaqAEq9Tg7fMnZ3YBFA/8TkPNvDMkjx04I2IWXJvCwK+c5SwLB9kQl2xVyIOMoT7Wtnxy1J/77hHbITCPuSH6YCX5960b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");
        Assert.assertEquals(signUpPage.emailInput.getAttribute("placeholder"),"Enter your email address");
        Thread.sleep(1000);
        signUpPage.emailInput.sendKeys("elad@cloudents.com");
        //Assert.assertEquals(signUpPage.continueButton.getAttribute("disabled"), "true");
        signUpPage.emailInput.clear();
        /*signUpPage.recaptcha.click();
        Assert.assertEquals(signUpPage.continueButton.getAttribute("disabled"), "true");
        signUpPage.emailInput.sendKeys("elad@cloudents.com");
        Thread.sleep(1000);
        Assert.assertEquals(signUpPage.continueButton.getAttribute("disabled"), null);*/

        signUpPage.loginLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(signInPage.image.getAttribute("src"),"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAU4AAAECCAMAAACmF85MAAADAFBMVEVMaXGqqt3////Jyf+cnNeentuqqv+cnNabm9adndacnNaiotyMjNmdndibm9aJidaentabm9WcnNWbm9ecnNacnNacnNWbm9afn9mbm9WcnNacnNWcnNWJidaJidWJidaIiNacnNacnNaiot2JidaJidaJideJidaRkdiNjd2KiteJideJidaKitedndebm9adndaLi9abm9acnNWcnNycnNWOjtmJidaJideIiNabm9Wbm9acnNecnNWcnNacnNabm9aysuacnNadndeentebm9abm9WcnNaZmdmbm9eIiNWLi9qJidaJidahoeuJideIiNaKitiIiNaJideIiNaJidaIiNWIiNWPj92MjNeSkuKJidWKitmIiNaKitaJidaIiNaJidaqquqJidaIiNWJideLi9mJidaKiteJidaKitiKiteLi9iNjdmJidWWluGJidaJidWIiNaJidaIiNWIiNaJidWJidaLi+iJidWKitaIiNaKitaJidaJidaJidacnNabm9acnNbe3t6JidaJidbd3d2JidaLi9eJidfe3t6IiNb///+KitiJidaJidXj4+Pd3d/e3t7e3t7e3t7e3t6JidXd3d3e3t7i4uLf39/d3d3V1d7d3d3e3t7q6ure3t7e3t7e3t7n5+fe3t7g4ODe3t6goNjh4eG3t9rd3d2IiNWbm9W6utmKitWystmNjdbV1d3b292cnNfa2t2MjNaSktaJidWtrdnS0tzc3N3U1Ny1tdnW1tyPj9bOztzJydvY2N3IyNu8vNqLi9XZ2d2zs9nMzNyZmde4uNmrq9nX193AwNqUlNafn9ewsNm2ttm7u9rY2NyXl9eamtfExNu+vtqurtjOztuQkNaRkdahodi3t9rKytuWltfR0dyxsdnLy9zCwtqkpNfGxtubm9eoqNiLi9ajo9i/v9umptjQ0NygoNe1tdm5udqqqtidnde1tdq9vdqiotepqdjBwdvBwdqnp9ecnNWfn9bT092lpdjHx9uvr9ipqdevr9nUP/dgAAAAqnRSTlMADwIEZxUDatRrwBYZTcz+ROHnM7yO9N4oXOX5qoHu5+t2yB7y4XR6ExZUhLB9Oetj/pesJNYb90b985xsn9j8fQhLcj+u7s4o9/se2c0H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");
        driver.navigate().back();
        Thread.sleep(1000);
        signUpPage.termsLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/terms");
        driver.navigate().back();
        Thread.sleep(1000);
        signUpPage.privacyLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/privacy");
        driver.navigate().back();
        Thread.sleep(1000);
        signUpPage.closeButton.click();
        Thread.sleep(1000);
        Assert.assertNotNull(signUpPage.exitDialog);
        signUpPage.cancelButton.click();
        Thread.sleep(1000);
        signUpPage.closeButton.click();
        Thread.sleep(1000);
        signUpPage.verifyExit.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask?q=");

    }

    @Test
    public void login() throws InterruptedException {

        driver.get("https://dev.spitball.co/signin");
        Thread.sleep(1000);

        Assert.assertEquals(signInPage.emailInput.getAttribute("placeholder"),"Enter your email address");
        Assert.assertEquals(signInPage.image.getAttribute("src"),"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAU4AAAECCAMAAACmF85MAAADAFBMVEVMaXGqqt3////Jyf+cnNeentuqqv+cnNabm9adndacnNaiotyMjNmdndibm9aJidaentabm9WcnNWbm9ecnNacnNacnNWbm9afn9mbm9WcnNacnNWcnNWJidaJidWJidaIiNacnNacnNaiot2JidaJidaJideJidaRkdiNjd2KiteJideJidaKitedndebm9adndaLi9abm9acnNWcnNycnNWOjtmJidaJideIiNabm9Wbm9acnNecnNWcnNacnNabm9aysuacnNadndeentebm9abm9WcnNaZmdmbm9eIiNWLi9qJidaJidahoeuJideIiNaKitiIiNaJideIiNaJidaIiNWIiNWPj92MjNeSkuKJidWKitmIiNaKitaJidaIiNaJidaqquqJidaIiNWJideLi9mJidaKiteJidaKitiKiteLi9iNjdmJidWWluGJidaJidWIiNaJidaIiNWIiNaJidWJidaLi+iJidWKitaIiNaKitaJidaJidaJidacnNabm9acnNbe3t6JidaJidbd3d2JidaLi9eJidfe3t6IiNb///+KitiJidaJidXj4+Pd3d/e3t7e3t7e3t7e3t6JidXd3d3e3t7i4uLf39/d3d3V1d7d3d3e3t7q6ure3t7e3t7e3t7n5+fe3t7g4ODe3t6goNjh4eG3t9rd3d2IiNWbm9W6utmKitWystmNjdbV1d3b292cnNfa2t2MjNaSktaJidWtrdnS0tzc3N3U1Ny1tdnW1tyPj9bOztzJydvY2N3IyNu8vNqLi9XZ2d2zs9nMzNyZmde4uNmrq9nX193AwNqUlNafn9ewsNm2ttm7u9rY2NyXl9eamtfExNu+vtqurtjOztuQkNaRkdahodi3t9rKytuWltfR0dyxsdnLy9zCwtqkpNfGxtubm9eoqNiLi9ajo9i/v9umptjQ0NygoNe1tdm5udqqqtidnde1tdq9vdqiotepqdjBwdvBwdqnp9ecnNWfn9bT092lpdjHx9uvr9ipqdevr9nUP/dgAAAAqnRSTlMADwIEZxUDatRrwBYZTcz+ROHnM7yO9N4oXOX5qoHu5+t2yB7y4XR6ExZUhLB9Oetj/pesJNYb90b985xsn9j8fQhLcj+u7s4o9/se2c0H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");
        Assert.assertEquals(signInPage.loginButton.getAttribute("disabled"), null);
        signInPage.emailInput.sendKeys("elad@cloudents.com");
        Assert.assertEquals(signInPage.loginButton.getAttribute("disabled"), null);
        signInPage.emailInput.clear();
        /*signUpPage.recaptcha.click();
        Assert.assertEquals(signInPage.loginButton.getAttribute("disabled"), null);
        signInPage.emailInput.sendKeys("elad@cloudents.com");
        Thread.sleep(1000);
        Assert.assertEquals(signInPage.loginButton.getAttribute("disabled"), null);*/

        signInPage.signUpLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(signUpPage.signUpImage.getAttribute("src"),"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAckAAAFaCAMAAABCE1auAAADAFBMVEVMaXGcnNacnNX6+vqbm6Sbm9Wdndizs+adndWcnNadnda0tNm2tv+cnNabm9abm9abm9acnNaentmcnNedndjx8f+fn9uoqN2cnNadndeentebm9acnNacnNjl5eWcnNahodydndidndydndaiot2cnNbz9PScnNacnNabm9acnNacnNbz8/PGxuy1teacnNbn5+ebm9acnNecnNacnNacnNedndacnNaentecnNWcnNacnNacnNfe3t7e3t5padZoaNZsbN9oaNWfn9mfn9FpadZpadbh4eHd3d3l5eVra9qcnNabm9fe3t6Li9rm5+dra9hqatfe3t5qatje3t7e3t7c3Oxqatdpadbe3t6ystnf39/d3d1qatdpadZqatfd3d3e3t6iotb29vbe3t76+/v9/f2dnddqatZqataKit9padadnaydnaidnbadnaucnKatrbSbm6TT1NecnNWcnNbp6uqcnNLd3d2bm9XJydXx8vKxsdVoaNXR09TCwtqnp9aZmdXGxtr///+bm7qzs9jW2Nny8/PGxtW6utjY2dra29zf4OHb3N3S1NXv8PDi5OXh4uPd3+Dk5ubt7u7U1tfr7e2jo9a7vOeAgNrO0NTOz+ientaCgtujo9fMzOWurtXp6+vLy9fg4OCwsNWqqtpsbNVpadWkpNWkpNnk5eWLi9ipqdWlpdXAwNXX192srNWcnNamptW+vtu4uNp9fdZxcdbIyNb8/P7FxdzBwdvJydzZ2eDDw9Wvr9vS09zY2O61tdt5edaGhte7u9WVldeystymptqsrNu4uNba2t12dtZvb9bMzdWPj9apqdrP0Nyioth0dNbV1d2YmNm0tNbLy9uDg9eSkticnNm3t9bFxdXm5+nR0tTNzdze3+Xz8/rDw+bAwOSAgNbHx9W7u9rw8fLs7e7r6/f39/vc3N3o6evPz9rb2928vOOgoNm1teDb2/Dm5vXu7/DOztjS0uyCgtfb3OPR0drh4fDv7/jW1u2+vtXJyeibm6+qqsNfYdICAAAAeHRSTlMAZOgv0sRbCkmIaqAEq9Tg7fMnZ3YBFA/8TkPNvDMkjx04I2IWXJvCwK+c5SwLB9kQl2xVyIOMoT7Wtnxy1J/77hHbITCPuSH6YCX5960b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");
        driver.get("https://dev.spitball.co/signin");
        Thread.sleep(1000);
        signInPage.exitButton.click();
        Thread.sleep(1000);
        Assert.assertNotNull(signInPage.exitDialog);
        signInPage.closeButton.click();
        Thread.sleep(1000);
        signInPage.exitButton.click();
        Thread.sleep(1000);
        signInPage.verifyButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask");

    }

    @Test
    public void homeworkHelp() throws InterruptedException {

        driver.get("https://dev.spitball.co/ask");
        Thread.sleep(1000);

        clickOnWebElements(mainPage.filters);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Search questions");
        Assert.assertEquals(mainPage.banner.getText(), "Make money while helping others with their homework.");
        homeworkHelpPage.askButton.click();
        Assert.assertTrue(mainPage.signPopup.isDisplayed());

    }

    @Test
    public void studyDocuments() throws InterruptedException {

        driver.get("https://dev.spitball.co/note");
        Thread.sleep(1000);

        mainPage.sort.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?sort=date");
        mainPage.sort.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?sort=relevance");


        mainPage.sortSection.get(1).click();
        Thread.sleep(300);
        clickOnWebElements(mainPage.filters);
        mainPage.sortSection.get(0).click();

        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find study documents in...");
        Assert.assertEquals(mainPage.banner.getText(), "Notes, study guides, exams and more from the best sites.");
        //Assert.assertEquals(studyDocPage.schoolSearch.getAttribute("placeholder"), "Where do you go to school?");


    }

    @Test
    public void flashcards() throws InterruptedException {

        driver.get("https://dev.spitball.co/flashcard");
        Thread.sleep(1000);

        mainPage.sort.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?sort=date");
        mainPage.sort.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?sort=relevance");

        mainPage.sortSection.get(1).click();
        Thread.sleep(300);
        clickOnWebElements(mainPage.filters);
        mainPage.sortSection.get(0).click();

        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Look for flashcards...");
        Assert.assertEquals(mainPage.banner.getText(), "Study from millions of flashcard sets to improve your grades.");
        //Assert.assertEquals(studyDocPage.schoolSearch.getAttribute("placeholder"), "Where do you go to school?");

    }

    @Test
    public void tutors() throws InterruptedException {

        driver.get("https://dev.spitball.co/tutor");
        Thread.sleep(1000);

        mainPage.sort.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/tutor?sort=price");
        mainPage.sort.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/tutor?sort=relevance");

        clickOnWebElements(mainPage.filters);
        mainPage.sortSection.get(0).click();

        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find a tutor...");
        Assert.assertEquals(mainPage.banner.getText(), "Find an expert to help you ace your classes in-person or online.");
        //Assert.assertEquals(studyDocPage.schoolSearch.getAttribute("placeholder"), "Where do you go to school?");

    }

    @Test
    public void textbooks() throws InterruptedException {

        driver.get("https://dev.spitball.co/book/9781400201655");
        Thread.sleep(2000);

        clickOnWebElements(mainPage.filters);
        Thread.sleep(2000);
        mainPage.sort.get(1).click();
        Thread.sleep(500);
        mainPage.sort.get(0).click();
        Thread.sleep(2000);

        mainPage.sortSection.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Textbook title or ISBN...");
        driver.get("https://dev.spitball.co/book");
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.banner.getText(), "Compare the best prices to buy, rent or sell your textbooks.");
        //Assert.assertEquals(studyDocPage.schoolSearch.getAttribute("placeholder"), "Where do you go to school?");

    }

    @Test
    public void jobs() throws InterruptedException {

        driver.get("https://dev.spitball.co/job");
        Thread.sleep(1000);

        clickOnWebElements(mainPage.filters);
        //mainPage.sort.get(1).click();
        //mainPage.sort.get(0).click();

        //mainPage.sortSection.get(0).click();
        //Thread.sleep(1000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Your field of expertise...");
        Assert.assertEquals(mainPage.banner.getText(), "Find jobs and internships catered specifically to students.");

    }

    @Test
    public void about() throws InterruptedException {

        driver.get("https://dev.spitball.co/about");
        Thread.sleep(1000);

        clickOnWebElements(aboutPage.tabsHeader);
        terms();
        privacy();
        partners();
        reps();
        contact();

    }

    @Test
    public void FAQ() throws InterruptedException {

        driver.get("https://dev.spitball.co/faq");
        Thread.sleep(1000);

        clickOnWebElements(faqPage.FaqHeaders);
        Thread.sleep(300);
        faqPage.FaqHeaders.get(8).click();
        mainPage.termsLink.click();
        driver.navigate().back();

        Assert.assertEquals(mainPage.images.get(0).getAttribute("src"), "https://zboxstorage.blob.core.windows.net/zboxhelp/Amazon1.jpg");
        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), "https://zboxstorage.blob.core.windows.net/zboxhelp/Amazon1.jpg");

    }

    @Test
    public void partners() throws InterruptedException {

        driver.get("https://dev.spitball.co/about");
        aboutPage.tabsHeader.get(3).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/partners");
        Assert.assertEquals(partnersPage.image.getAttribute("src"), "data:image/png;base64,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");

    }

    @Test
    public void reps() throws InterruptedException {

        driver.get("https://dev.spitball.co/about");
        aboutPage.tabsHeader.get(4).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/reps");
        Assert.assertEquals(partnersPage.image.getAttribute("src"), "data:image/png;base64,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");

    }

    @Test
    public void privacy() throws InterruptedException {

        driver.get("https://dev.spitball.co/about");
        aboutPage.tabsHeader.get(5).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/privacy");

        privacyPage.link1.click();
        Thread.sleep(1000);
        checkNewWindowAddress("https://www.spitball.co/ask");

        privacyPage.link2.click();
        Thread.sleep(1000);
        checkNewWindowAddress("https://marketingplatform.google.com/about/");
    }

    @Test
    public void terms() throws InterruptedException {

        driver.get("https://dev.spitball.co/about");
        aboutPage.tabsHeader.get(6).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/terms");

        termsPage.docLink.click();
        Thread.sleep(1000);
        checkNewWindowAddress("https://www.copyright.gov/legislation/dmca.pdf");

    }

    @Test
    public void contact() throws InterruptedException {

        driver.get("https://dev.spitball.co/about");
        aboutPage.tabsHeader.get(7).click();
        Thread.sleep(1000);
        Assert.assertNotNull(contactPage.map);
        contactPage.links.get(0).click();
        checkNewWindowAddress("https://www.facebook.com/spitballstudy/");
        contactPage.links.get(1).click();
        checkNewWindowAddress("https://twitter.com/SpitballStudy");
        contactPage.links.get(2).click();
        checkNewWindowAddress("https://www.youtube.com/channel");
        contactPage.links.get(3).click();
        checkNewWindowAddress("https://www.instagram.com/spitballstudy/");
        contactPage.links.get(4).click();
        checkNewWindowAddress("https://t.me/Spitball");
        contactPage.links.get(5).click();
        checkNewWindowAddress("https://medium.com/@spitballstudy");
        contactPage.links.get(6).click();
        checkNewWindowAddress("https://github.com/Cloudents/Spitball");
        contactPage.links.get(7).click();
        checkNewWindowAddress("https://www.linkedin.com/company/spitball/");

    }

    @Test
    public void token() throws InterruptedException {

        driver.get("https://token.spitball.co");
        Thread.sleep(1000);
        /*
        Assert.assertNotNull(tokenPage.youtube);
        tokenPage.spitball2.click();
        checkNewWindowAddress("https://www.spitball.co/ask");
        Thread.sleep(1000);
        tokenPage.downloadWhitepaper.click();
        checkNewWindowAddress("https://zboxstorage.blob.core.windows.net/zboxhelp/ico/Spitball-WP.pdf");
        Thread.sleep(1000);
        tokenPage.joinTelegram.click();
        checkNewWindowAddress("https://t.me/Spitball");
        Thread.sleep(1000);
        //tokenPage.emailText.sendKeys("elad@cloudents.com");
        //tokenPage.subscribeButton.click();
        Assert.assertEquals(tokenPage.emailText.getText(), "");
        scroll(tokenPage.downloadWhitepaper, 20);
        Assert.assertEquals(tokenPage.image1.getAttribute("src"), "https://token.spitball.co/images/muscari/hevra.png");
        scroll(tokenPage.downloadWhitepaper , 25);
        //Assert.assertEquals(tokenPage.image2.getAttribute("src"), "https://token.spitball.co/images/muscari/spitball_app.png");
        scroll(tokenPage.downloadWhitepaper, 25);
        //Assert.assertEquals(tokenPage.image3.getAttribute("src"), "https://token.spitball.co/images/muscari/spitball_economy.png");
        scroll(tokenPage.downloadWhitepaper, 20);
        //Assert.assertEquals(tokenPage.image4.getAttribute("src"), "https://token.spitball.co/images/muscari/partners.png");
        scroll(tokenPage.downloadWhitepaper, 200);
        Assert.assertEquals(tokenPage.contactForm.get(1).getText(), "Your Name");
        Assert.assertEquals(tokenPage.contactForm.get(2).getText(), "Your Email");
        Assert.assertEquals(tokenPage.contactForm.get(3).getText(), "Your Message");
        /*tokenPage.contactForm.get(1).sendKeys("Elad");
        tokenPage.contactForm.get(2).sendKeys("elad@cloudents.com");
        tokenPage.contactForm.get(3).sendKeys("Hi, my name is Elad.");
        Actions actions = new Actions(driver);
        actions.moveToElement(tokenPage.contactForm.get(4)).build().perform();
        tokenPage.contactForm.get(4).click();
        Assert.assertEquals(tokenPage.contactForm.get(1).getText(), "");
        Assert.assertEquals(tokenPage.contactForm.get(2).getText(), "");
        Assert.assertEquals(tokenPage.contactForm.get(3).getText(), "");
        scroll(tokenPage.downloadWhitepaper, 200);
        Thread.sleep(2000);
        tokenPage.privacy.click();
        checkNewWindowAddress("https://www.spitball.co/privacy");
        Thread.sleep(2000);
        tokenPage.terms.click();
        checkNewWindowAddress("https://www.spitball.co/terms");*/
        //Thread.sleep(2000);
        tokenPage.socialLinks.get(0).click();
        checkNewWindowAddress("https://t.me/Spitball");
        tokenPage.socialLinks.get(1).click();
        checkNewWindowAddress("https://www.facebook.com/spitballstudy/");
        tokenPage.socialLinks.get(2).click();
        checkNewWindowAddress("https://twitter.com/SpitballStudy");
        tokenPage.socialLinks.get(3).click();
        checkNewWindowAddress("https://www.youtube.com/channel");
        tokenPage.socialLinks.get(4).click();
        checkNewWindowAddress("https://github.com/Cloudents/Spitball");
        tokenPage.socialLinks.get(5).click();
        checkNewWindowAddress("https://www.linkedin.com/company/spitball/");
        tokenPage.socialLinks.get(6).click();
        checkNewWindowAddress("https://medium.com/@spitballstudy");

        tokenPage.homePage.click();
        //checkNewWindowAddress("https://token.spitball.co/");

    }





    @AfterClass
    public void cleanupTestSeries() {

        driver.quit();

    }




    /* Method to get the new window handle and test the current URL by comparing it to the URL address parameter */

    private void checkNewWindowAddress(String address) {

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        String actualURL = driver.getCurrentUrl();
        assertTrue(actualURL.contains(address));

        driver.close();
        driver.switchTo().window(winHandleBefore);

    }


    /* Method to run on serial web elements by getting the Web Element list parameter */

    private void clickOnWebElements(List<WebElement> list) throws InterruptedException {

        for(Iterator<WebElement> items = list.iterator(); items.hasNext();) {

            WebElement item = items.next();
            item.click();
            Thread.sleep(1000);

        }

    }


    /* Method to scroll the screen from given web element, with number of times to scroll */

    private void scroll(WebElement element, int times) throws InterruptedException {

        for(int i=0 ; i < times ; i++) {
            element.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1);
        }

    }

}
