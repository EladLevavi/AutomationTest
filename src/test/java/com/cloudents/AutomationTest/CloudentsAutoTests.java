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
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);

        mainPage.FAQlist.get(0).click();
        Thread.sleep(2000);
        checkNewWindowAddress(FAQ_PAGE + "?id=0");
        mainPage.FAQlist.get(1).click();
        Thread.sleep(2000);
        checkNewWindowAddress(FAQ_PAGE + "?id=1");
        mainPage.FAQlist.get(2).click();
        Thread.sleep(2000);
        checkNewWindowAddress(FAQ_PAGE + "?id=2");
        mainPage.FAQlist.get(3).click();
        Thread.sleep(2000);
        checkNewWindowAddress(FAQ_PAGE + "?id=3");
        mainPage.FAQlist.get(4).click();
        Thread.sleep(2000);
        checkNewWindowAddress(FAQ_PAGE + "?id=4");
        Thread.sleep(2000);

        mainPage.moreButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FAQ_PAGE);

    }

    @Test
    public void mainTabs() throws InterruptedException {

        driver.get(HOME_PAGE);
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

        driver.get(SIGNIN_PAGE);
        Thread.sleep(2000);

        signUpPage.googleButton.click();
        Thread.sleep(2000);
        checkNewWindowAddress(GOOGLE_SIGNIN_PAGE);
        Thread.sleep(2000);
        Assert.assertNull(signUpPage.continueButton.getAttribute("disabled"));
        Assert.assertEquals(signUpPage.signUpImage.getAttribute("src"),"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAckAAAFaCAMAAABCE1auAAADAFBMVEVMaXGcnNacnNX6+vqbm6Sbm9Wdndizs+adndWcnNadnda0tNm2tv+cnNabm9abm9abm9acnNaentmcnNedndjx8f+fn9uoqN2cnNadndeentebm9acnNacnNjl5eWcnNahodydndidndydndaiot2cnNbz9PScnNacnNabm9acnNacnNbz8/PGxuy1teacnNbn5+ebm9acnNecnNacnNacnNedndacnNaentecnNWcnNacnNacnNfe3t7e3t5padZoaNZsbN9oaNWfn9mfn9FpadZpadbh4eHd3d3l5eVra9qcnNabm9fe3t6Li9rm5+dra9hqatfe3t5qatje3t7e3t7c3Oxqatdpadbe3t6ystnf39/d3d1qatdpadZqatfd3d3e3t6iotb29vbe3t76+/v9/f2dnddqatZqataKit9padadnaydnaidnbadnaucnKatrbSbm6TT1NecnNWcnNbp6uqcnNLd3d2bm9XJydXx8vKxsdVoaNXR09TCwtqnp9aZmdXGxtr///+bm7qzs9jW2Nny8/PGxtW6utjY2dra29zf4OHb3N3S1NXv8PDi5OXh4uPd3+Dk5ubt7u7U1tfr7e2jo9a7vOeAgNrO0NTOz+ientaCgtujo9fMzOWurtXp6+vLy9fg4OCwsNWqqtpsbNVpadWkpNWkpNnk5eWLi9ipqdWlpdXAwNXX192srNWcnNamptW+vtu4uNp9fdZxcdbIyNb8/P7FxdzBwdvJydzZ2eDDw9Wvr9vS09zY2O61tdt5edaGhte7u9WVldeystymptqsrNu4uNba2t12dtZvb9bMzdWPj9apqdrP0Nyioth0dNbV1d2YmNm0tNbLy9uDg9eSkticnNm3t9bFxdXm5+nR0tTNzdze3+Xz8/rDw+bAwOSAgNbHx9W7u9rw8fLs7e7r6/f39/vc3N3o6evPz9rb2928vOOgoNm1teDb2/Dm5vXu7/DOztjS0uyCgtfb3OPR0drh4fDv7/jW1u2+vtXJyeibm6+qqsNfYdICAAAAeHRSTlMAZOgv0sRbCkmIaqAEq9Tg7fMnZ3YBFA/8TkPNvDMkjx04I2IWXJvCwK+c5SwLB9kQl2xVyIOMoT7Wtnxy1J/77hHbITCPuSH6YCX5960b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");
        Assert.assertEquals(signUpPage.emailInput.getAttribute("placeholder"),"Enter your email address");
        Thread.sleep(2000);
        signUpPage.emailInput.sendKeys("elad@cloudents.com");
        Assert.assertNull(signUpPage.continueButton.getAttribute("disabled"));
        signUpPage.emailInput.clear();
        //signUpPage.recaptcha.click();
        //Assert.assertNotNull(signUpPage.continueButton.getAttribute("disabled"));
        signUpPage.emailInput.sendKeys("elad@cloudents.com");
        Thread.sleep(2000);
        Assert.assertNull(signUpPage.continueButton.getAttribute("disabled"));

        signUpPage.loginLink.click();
        Thread.sleep(2000);
        Assert.assertEquals(signInPage.image.getAttribute("src"),"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAU4AAAECCAMAAACmF85MAAADAFBMVEVMaXGqqt3////Jyf+cnNeentuqqv+cnNabm9adndacnNaiotyMjNmdndibm9aJidaentabm9WcnNWbm9ecnNacnNacnNWbm9afn9mbm9WcnNacnNWcnNWJidaJidWJidaIiNacnNacnNaiot2JidaJidaJideJidaRkdiNjd2KiteJideJidaKitedndebm9adndaLi9abm9acnNWcnNycnNWOjtmJidaJideIiNabm9Wbm9acnNecnNWcnNacnNabm9aysuacnNadndeentebm9abm9WcnNaZmdmbm9eIiNWLi9qJidaJidahoeuJideIiNaKitiIiNaJideIiNaJidaIiNWIiNWPj92MjNeSkuKJidWKitmIiNaKitaJidaIiNaJidaqquqJidaIiNWJideLi9mJidaKiteJidaKitiKiteLi9iNjdmJidWWluGJidaJidWIiNaJidaIiNWIiNaJidWJidaLi+iJidWKitaIiNaKitaJidaJidaJidacnNabm9acnNbe3t6JidaJidbd3d2JidaLi9eJidfe3t6IiNb///+KitiJidaJidXj4+Pd3d/e3t7e3t7e3t7e3t6JidXd3d3e3t7i4uLf39/d3d3V1d7d3d3e3t7q6ure3t7e3t7e3t7n5+fe3t7g4ODe3t6goNjh4eG3t9rd3d2IiNWbm9W6utmKitWystmNjdbV1d3b292cnNfa2t2MjNaSktaJidWtrdnS0tzc3N3U1Ny1tdnW1tyPj9bOztzJydvY2N3IyNu8vNqLi9XZ2d2zs9nMzNyZmde4uNmrq9nX193AwNqUlNafn9ewsNm2ttm7u9rY2NyXl9eamtfExNu+vtqurtjOztuQkNaRkdahodi3t9rKytuWltfR0dyxsdnLy9zCwtqkpNfGxtubm9eoqNiLi9ajo9i/v9umptjQ0NygoNe1tdm5udqqqtidnde1tdq9vdqiotepqdjBwdvBwdqnp9ecnNWfn9bT092lpdjHx9uvr9ipqdevr9nUP/dgAAAAqnRSTlMADwIEZxUDatRrwBYZTcz+ROHnM7yO9N4oXOX5qoHu5+t2yB7y4XR6ExZUhLB9Oetj/pesJNYb90b985xsn9j8fQhLcj+u7s4o9/se2c0H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");
        driver.get(SIGNIN_PAGE);
        Thread.sleep(2000);
        signUpPage.termsLinks.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),TERMS_PAGE);
        driver.get(SIGNIN_PAGE);
        Thread.sleep(2000);
        signUpPage.termsLinks.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),PRIVACY_PAGE);
        driver.navigate().back();
        Thread.sleep(2000);
        signUpPage.closeButton.click();
        Thread.sleep(2000);
        Assert.assertNotNull(signUpPage.exitDialog);
        signUpPage.cancelButton.click();
        Thread.sleep(2000);
        signUpPage.closeButton.click();
        Thread.sleep(2000);
        signUpPage.verifyExit.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);

    }

    @Test
    public void login() throws InterruptedException {

        driver.get(LOGIN_PAGE);
        Thread.sleep(1000);

        Assert.assertEquals(signInPage.emailInput.getAttribute("placeholder"),"Enter your email address");
        Assert.assertEquals(signInPage.image.getAttribute("src"),"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAU4AAAECCAMAAACmF85MAAADAFBMVEVMaXGqqt3////Jyf+cnNeentuqqv+cnNabm9adndacnNaiotyMjNmdndibm9aJidaentabm9WcnNWbm9ecnNacnNacnNWbm9afn9mbm9WcnNacnNWcnNWJidaJidWJidaIiNacnNacnNaiot2JidaJidaJideJidaRkdiNjd2KiteJideJidaKitedndebm9adndaLi9abm9acnNWcnNycnNWOjtmJidaJideIiNabm9Wbm9acnNecnNWcnNacnNabm9aysuacnNadndeentebm9abm9WcnNaZmdmbm9eIiNWLi9qJidaJidahoeuJideIiNaKitiIiNaJideIiNaJidaIiNWIiNWPj92MjNeSkuKJidWKitmIiNaKitaJidaIiNaJidaqquqJidaIiNWJideLi9mJidaKiteJidaKitiKiteLi9iNjdmJidWWluGJidaJidWIiNaJidaIiNWIiNaJidWJidaLi+iJidWKitaIiNaKitaJidaJidaJidacnNabm9acnNbe3t6JidaJidbd3d2JidaLi9eJidfe3t6IiNb///+KitiJidaJidXj4+Pd3d/e3t7e3t7e3t7e3t6JidXd3d3e3t7i4uLf39/d3d3V1d7d3d3e3t7q6ure3t7e3t7e3t7n5+fe3t7g4ODe3t6goNjh4eG3t9rd3d2IiNWbm9W6utmKitWystmNjdbV1d3b292cnNfa2t2MjNaSktaJidWtrdnS0tzc3N3U1Ny1tdnW1tyPj9bOztzJydvY2N3IyNu8vNqLi9XZ2d2zs9nMzNyZmde4uNmrq9nX193AwNqUlNafn9ewsNm2ttm7u9rY2NyXl9eamtfExNu+vtqurtjOztuQkNaRkdahodi3t9rKytuWltfR0dyxsdnLy9zCwtqkpNfGxtubm9eoqNiLi9ajo9i/v9umptjQ0NygoNe1tdm5udqqqtidnde1tdq9vdqiotepqdjBwdvBwdqnp9ecnNWfn9bT092lpdjHx9uvr9ipqdevr9nUP/dgAAAAqnRSTlMADwIEZxUDatRrwBYZTcz+ROHnM7yO9N4oXOX5qoHu5+t2yB7y4XR6ExZUhLB9Oetj/pesJNYb90b985xsn9j8fQhLcj+u7s4o9/se2c0H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");
        Assert.assertNull(signInPage.loginButton.getAttribute("disabled"));
        signInPage.emailInput.sendKeys("elad@cloudents.com");
        Assert.assertNull(signInPage.loginButton.getAttribute("disabled"));
        signInPage.emailInput.clear();
        /*signUpPage.recaptcha.click();
        Assert.assertEquals(signInPage.loginButton.getAttribute("disabled"), null);
        signInPage.emailInput.sendKeys("elad@cloudents.com");
        Thread.sleep(1000);
        Assert.assertEquals(signInPage.loginButton.getAttribute("disabled"), null);*/

        signInPage.signUpLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(signUpPage.signUpImage.getAttribute("src"),"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAckAAAFaCAMAAABCE1auAAADAFBMVEVMaXGcnNacnNX6+vqbm6Sbm9Wdndizs+adndWcnNadnda0tNm2tv+cnNabm9abm9abm9acnNaentmcnNedndjx8f+fn9uoqN2cnNadndeentebm9acnNacnNjl5eWcnNahodydndidndydndaiot2cnNbz9PScnNacnNabm9acnNacnNbz8/PGxuy1teacnNbn5+ebm9acnNecnNacnNacnNedndacnNaentecnNWcnNacnNacnNfe3t7e3t5padZoaNZsbN9oaNWfn9mfn9FpadZpadbh4eHd3d3l5eVra9qcnNabm9fe3t6Li9rm5+dra9hqatfe3t5qatje3t7e3t7c3Oxqatdpadbe3t6ystnf39/d3d1qatdpadZqatfd3d3e3t6iotb29vbe3t76+/v9/f2dnddqatZqataKit9padadnaydnaidnbadnaucnKatrbSbm6TT1NecnNWcnNbp6uqcnNLd3d2bm9XJydXx8vKxsdVoaNXR09TCwtqnp9aZmdXGxtr///+bm7qzs9jW2Nny8/PGxtW6utjY2dra29zf4OHb3N3S1NXv8PDi5OXh4uPd3+Dk5ubt7u7U1tfr7e2jo9a7vOeAgNrO0NTOz+ientaCgtujo9fMzOWurtXp6+vLy9fg4OCwsNWqqtpsbNVpadWkpNWkpNnk5eWLi9ipqdWlpdXAwNXX192srNWcnNamptW+vtu4uNp9fdZxcdbIyNb8/P7FxdzBwdvJydzZ2eDDw9Wvr9vS09zY2O61tdt5edaGhte7u9WVldeystymptqsrNu4uNba2t12dtZvb9bMzdWPj9apqdrP0Nyioth0dNbV1d2YmNm0tNbLy9uDg9eSkticnNm3t9bFxdXm5+nR0tTNzdze3+Xz8/rDw+bAwOSAgNbHx9W7u9rw8fLs7e7r6/f39/vc3N3o6evPz9rb2928vOOgoNm1teDb2/Dm5vXu7/DOztjS0uyCgtfb3OPR0drh4fDv7/jW1u2+vtXJyeibm6+qqsNfYdICAAAAeHRSTlMAZOgv0sRbCkmIaqAEq9Tg7fMnZ3YBFA/8TkPNvDMkjx04I2IWXJvCwK+c5SwLB9kQl2xVyIOMoT7Wtnxy1J/77hHbITCPuSH6YCX5960b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");
        driver.get(LOGIN_PAGE);
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
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);

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

        /*mainPage.sort.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=date");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=relevance");*/


        //mainPage.sortSection.get(1).click();
        //Thread.sleep(500);
        clickOnWebElements(mainPage.filters);
        mainPage.sortSection.get(0).click();

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
