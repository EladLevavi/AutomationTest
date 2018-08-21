package com.cloudents.AutomationTest;


import com.cloudents.AutomationTest.Pages.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class CloudentsAutoTests {

    private WebDriver driver;
    private MainPage mainPage;
    private HWpage HwPage;
    private LoginPage loginPage;
    private AboutPage aboutPage;
    private FaqPage faqPage;
    private TermsPage termsPage;
    private PrivacyPage privacyPage;
    private PartnersPage partnersPage;
    private RepsPage repsPage;
    private StudyDocPage studyDocPage;
    private FlashcardsPage flashcardsPage;
    private TutorsPage tutorsPage;
    private TextbooksPage textbooksPage;
    private JobsPage jobsPage;
    private SignUpPage signupPage;
    private TokenPage tokenPage;

    // Handle for the main window

    private String winHandleBefore;

    final private static String[] FAQText = {
        "Spitball is the first decentralized global marketplace for students. From class notes & study guides, to textbooks, tutors, jobs and more, Spitball brings the best that the internet has to offer students, all together in one place. Spitball allows students to ask and answer questions, share notes, buy & sell textbooks and more - making it the ideal one-stop shop for students.",
        "Spitball acts as an aggregator of academic content and a marketplace for students to come together and exchange information, goods and services. Because it's a decentralized marketplace, third-party transaction fees are greatly reduced, providing cheaper goods for consumers and more money in the pockets of sellers!",
        "Unlike other student websites, Spitball brings a new level of personalization and variety of content to students. Not only do we provide our users with the ability to customize their results to their school and classes, Spitball also aggregates content from over 25 leading student sites and services.\n\nIn addition to these unique features, Spitball is the only decentralized marketplace for students - allowing students from all over the world to ask and answer questions, share notes, buy & sell textbooks and more - all while cutting out costly transaction fees.",
        "SBL are the internal points of the Spitball system. Certain goods and services can only be purchased using SBL. Similarly, you can receive SBL for contributing to the Spitball community.",
        "SBL are redeemable for Amazon gift cards with real CASH value! See below for more details on how to redeem your SBL.",
        "That's right! There's no catch. Earned SBL can be redeemed for Amazon gift cards with real cash value! To see the Cash-Out Ratios, see the image below.",
        "Awarded SBL are points given by Spitball for actions such as registration, promoting Spitball on social media, etc. These SBL can only be used within the system and are not redeemable for cash rewards. Earned SBL are points received by answering questions or providing services on the Spitball platform. These can be used for all of the actions that Awarded SBL can be used for and also are redeemable for cash rewards.",
        "\"You may cash out anytime you reach the minimum SBL balance (1000), but there is a significant advantage to hold onto your SBL. As your balance of SBL increases, so does their value. For example, if you have 1000 SBL and want to cash out, you will only make $1 per 100 SBL, whereas if you wait until your balance is 4000 SBL before cashing out, you will earn $1 per 40 SBL. \"",
        "Spitball's rules can be found in our Terms of Service.",
        "If you don’t see your school on Spitball and think we should add it, email us at support@spitball.co",
        "Your class could be new, or none of your classmates have posted documents online. Don’t fret - we have flashcards, tutors and textbooks to help you ace your exams. If you still can’t find what you need, shoot us an email at support@spitball.co or contact us on social media and we’ll try to help you out!",
        "Don’t forget to personalize your results to your university and specific courses. You can do this on the search results page by clicking “Personalize” on the left hand side.",
        "You can contact us through the chat on our homepage, or email us at support@spitball.co",
        "Spitball was created as a community for collaborative learning. Students benefit from sharing knowledge, and our objective is to make students' lives easier by creating one unified platform to meet all of their academic needs. We are founded on the principles of transparency and collaboration and are firmly opposed to plagiarism, cheating, and any form of academic misconduct.",
        "Yes, Spitball is a free service. Some of our partner sites, however, may require you to pay to unlock certain content, meet with a tutor, find homework help or buy a textbook.",
        "From the search results page, click “Personalize” on the left hand side to update your university and courses. You can also click the three dots in the top right corner of your screen."
    };

    private void loadPageElements() {

        mainPage = PageFactory.initElements(driver, MainPage.class);
        HwPage = PageFactory.initElements(driver, HWpage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        aboutPage = PageFactory.initElements(driver, AboutPage.class);
        faqPage = PageFactory.initElements(driver, FaqPage.class);
        termsPage = PageFactory.initElements(driver, TermsPage.class);
        privacyPage = PageFactory.initElements(driver, PrivacyPage.class);
        partnersPage = PageFactory.initElements(driver, PartnersPage.class);
        repsPage = PageFactory.initElements(driver, RepsPage.class);
        studyDocPage = PageFactory.initElements(driver, StudyDocPage.class);
        flashcardsPage = PageFactory.initElements(driver, FlashcardsPage.class);
        tutorsPage = PageFactory.initElements(driver, TutorsPage.class);
        textbooksPage = PageFactory.initElements(driver, TextbooksPage.class);
        jobsPage = PageFactory.initElements(driver, JobsPage.class);
        signupPage = PageFactory.initElements(driver, SignUpPage.class);
        tokenPage = PageFactory.initElements(driver, TokenPage.class);

    }

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional String browser) {
        /*
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
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

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://dev.spitball.co");

        loadPageElements();

        // Store the current window handle
        winHandleBefore = driver.getWindowHandle();*/

    }

    @BeforeClass
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        //driver = new FirefoxDriver();

        //System.setProperty("webdriver.edge.driver", "C:\\WebDrivers\\MicrosoftWebDriver.exe");
        //driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loadPageElements();

        // Store the current window handle
        winHandleBefore = driver.getWindowHandle();
    }

    @Test
    public void DefaultHomePage() throws InterruptedException {
        driver.get("http://dev.spitball.co");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask");
    }

    @Test
    public void MainTabsNavigation() throws InterruptedException {

        driver.get("https://dev.spitball.co");

        clickOnIt(mainPage.HWhelpTab,2);
        Assert.assertEquals(mainPage.HWhelpTab.getAttribute("className"),"v-tabs__div mr-4 vertical spitball-text-ask v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Search questions");
        Assert.assertEquals(HwPage.bannerText.getText(), "Make money while helping others with their homework.");

        clickOnIt(mainPage.StudyDocsTab, 2);
        Assert.assertEquals(mainPage.StudyDocsTab.getAttribute("className"),"v-tabs__div mr-4 vertical spitball-text-note v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Find study documents in...");
        Assert.assertEquals(studyDocPage.bannerText.getText(), "Notes, study guides, exams and more from the best sites.");

        clickOnIt(mainPage.FlashcardsTab, 2);
        Assert.assertEquals(mainPage.FlashcardsTab.getAttribute("className"),"v-tabs__div mr-4 vertical spitball-text-flashcard v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Look for flashcards...");
        Assert.assertEquals(flashcardsPage.bannerText.getText(), "Study from millions of flashcard sets to improve your grades.");

        clickOnIt(mainPage.TutorsTab, 2);
        Assert.assertEquals(mainPage.TutorsTab.getAttribute("className"),"v-tabs__div mr-4 vertical spitball-text-tutor v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/tutor?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Find a tutor...");
        Assert.assertEquals(tutorsPage.bannerText.getText(), "Find an expert to help you ace your classes in-person or online.");

        clickOnIt(mainPage.BooksTab, 2);
        Assert.assertEquals(mainPage.BooksTab.getAttribute("className"),"v-tabs__div mr-4 vertical spitball-text-book v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/book?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Textbook title or ISBN...");
        Assert.assertEquals(textbooksPage.bannerText.getText(), "Compare the best prices to buy, rent or sell your textbooks.");

        clickOnIt(mainPage.JobsTab, 2);
        Assert.assertEquals(mainPage.JobsTab.getAttribute("className"),"v-tabs__div mr-4 vertical spitball-text-job v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/job?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Your field of expertise...");
        Assert.assertEquals(jobsPage.bannerText.getText(), "Find jobs and internships catered specifically to students.");

        /*clickOnIt(mainPage.StudyDocsTab, 2);
        mainPage.SearchBar.sendKeys("testing");
        clickOnIt(mainPage.FlashcardsTab, 2);
        Assert.assertEquals(mainPage.SearchBar.getText(),"testing");
        clickOnIt(mainPage.TutorsTab, 2);
        Assert.assertEquals(mainPage.SearchBar.getText(),"testing");
        clickOnIt(mainPage.BooksTab, 2);
        Assert.assertEquals(mainPage.SearchBar.getText(),"testing");*/

    }

    @Test
    public void HWPageContent() throws InterruptedException {

        driver.get("https://dev.spitball.co");

        clickOnIt(HwPage.artsItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Arts");
        clickOnIt((HwPage.artsItem),1);

        clickOnIt(HwPage.biologyItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Biology");
        clickOnIt(HwPage.biologyItem,1);

        clickOnIt(HwPage.blockchainItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Blockchain");
        clickOnIt(HwPage.blockchainItem,1);

        clickOnIt(HwPage.businessItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Business");
        clickOnIt(HwPage.businessItem,1);

        clickOnIt(HwPage.chemistryItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Chemistry");
        clickOnIt(HwPage.chemistryItem,1);

        clickOnIt(HwPage.computerScienceItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Computer%20Science");
        clickOnIt(HwPage.computerScienceItem,1);

        clickOnIt(HwPage.economicsItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Economics");
        clickOnIt(HwPage.economicsItem,1);

        clickOnIt(HwPage.educationItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Education");
        clickOnIt(HwPage.educationItem,1);

        clickOnIt(HwPage.geographyItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Geography");
        clickOnIt(HwPage.geographyItem,1);

        clickOnIt(HwPage.healthItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Health%20%26%20Medicine");
        clickOnIt(HwPage.healthItem,1);

        clickOnIt(HwPage.historyItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=History");
        clickOnIt(HwPage.historyItem,1);

        clickOnIt(HwPage.languagesItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Languages");
        clickOnIt(HwPage.languagesItem,1);

        clickOnIt(HwPage.lawItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Law%20%26%20Politics");
        clickOnIt(HwPage.lawItem,1);

        clickOnIt(HwPage.literatureItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Literature");
        clickOnIt(HwPage.literatureItem,1);

        clickOnIt(HwPage.mathItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Mathematics");
        clickOnIt(HwPage.mathItem,1);

        clickOnIt(HwPage.physicsItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Physics");
        clickOnIt(HwPage.physicsItem,1);

        clickOnIt(HwPage.psychologyItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Psychology");
        clickOnIt(HwPage.psychologyItem,1);

        clickOnIt(HwPage.religionItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Religion%2FPhilosophy");
        clickOnIt(HwPage.religionItem,1);

        clickOnIt(HwPage.socialItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Social%20Studies");
        clickOnIt(HwPage.socialItem,1);

        clickOnIt(HwPage.technologyItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Technology");
        clickOnIt(HwPage.technologyItem,1);

        clickOnIt(HwPage.miscItem,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Miscellaneous");
        clickOnIt(HwPage.miscItem,1);

        clickOnIt(HwPage.artsItem,1);
        clickOnIt(HwPage.biologyItem,1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask?source=Arts&source=Biology");

        /*driver.get("https://dev.spitball.co");
        String answerText = HwPage.answerText.getText();
        clickOnIt(HwPage.questionArea, 1);
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask");
        //Assert.assertEquals(answerText, HwPage.answerPage.getText());
        answerText.toLowerCase().contains(HwPage.answerPage.getText());*/

        clickOnIt(mainPage.AskQuestion,1);
        Assert.assertNotNull(mainPage.loginPopup);

    }

    @Test
    public void StudyDocContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/note?q=");

        clickOnIt(studyDocPage.dateSortion, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?q=&sort=date");

        clickOnIt(studyDocPage.relevanceSortion, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?q=&sort=relevance");

        clickOnIt(studyDocPage.sourcesSection, 1);

        /*clickOnIt(studyDocPage.cloudentsSource, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?q=&sort=relevance&source=CourseHero");
        clickOnIt(studyDocPage.cloudentsSource, 2);*/

        clickOnIt(studyDocPage.courseheroSource, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?q=&sort=relevance&source=CourseHero");
        clickOnIt(studyDocPage.courseheroSource, 1);

        clickOnIt(studyDocPage.koofersSource, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?q=&sort=relevance&source=Koofers");
        clickOnIt(studyDocPage.koofersSource, 1);

        clickOnIt(studyDocPage.oneclassSource, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?q=&sort=relevance&source=OneClass");
        clickOnIt(studyDocPage.oneclassSource, 1);

        clickOnIt(studyDocPage.studysoupSource, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?q=&sort=relevance&source=StudySoup");
        clickOnIt(studyDocPage.studysoupSource, 1);

        Assert.assertEquals(studyDocPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        clickOnIt(studyDocPage.searchSchool, 1);
        Assert.assertNotNull(mainPage.loginPopup);

        driver.get("https://dev.spitball.co/note?q=");
        Thread.sleep(1000);

        clickOnIt(studyDocPage.personilize, 1);
        Assert.assertNotNull(mainPage.loginPopup);

    }

    @Test
    public void FlashcardsContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/flashcard?q=");

        clickOnIt(flashcardsPage.dateSortion,2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?q=&sort=date");

        clickOnIt(flashcardsPage.relevanceSortion, 2);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/flashcard?q=&sort=relevance");

        clickOnIt(flashcardsPage.sortionArea, 2);

        clickOnIt(flashcardsPage.brainscapeSource, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?q=&sort=relevance&source=brainscape");
        clickOnIt(flashcardsPage.brainscapeSource, 2);

        /*clickOnIt(flashcardsPage.cloudentsSource, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?q=&sort=relevance&source=cloudents");
        clickOnIt(flashcardsPage.cloudentsSource, 2);*/

        clickOnIt(flashcardsPage.courseHeroSource, 2);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/flashcard?q=&sort=relevance&source=CourseHero");
        clickOnIt(flashcardsPage.courseHeroSource, 2);

        clickOnIt(flashcardsPage.cramSource, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?q=&sort=relevance&source=Cram");
        clickOnIt(flashcardsPage.cramSource, 2);

        clickOnIt(flashcardsPage.koofersSource, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?q=&sort=relevance&source=Koofers");
        clickOnIt(flashcardsPage.koofersSource, 2);

        clickOnIt(flashcardsPage.quizletSource, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?q=&sort=relevance&source=Quizlet");
        clickOnIt(flashcardsPage.quizletSource, 2);

        clickOnIt(flashcardsPage.studyBlueSource, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?q=&sort=relevance&source=StudyBlue");
        clickOnIt(flashcardsPage.studyBlueSource, 2);

        clickOnIt(flashcardsPage.studySoupSource, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?q=&sort=relevance&source=StudySoup");
        clickOnIt(flashcardsPage.studySoupSource, 2);

        clickOnIt(studyDocPage.personilize, 2);
        Assert.assertNotNull(mainPage.loginPopup);

        driver.get("https://dev.spitball.co/flashcard?q=");
        Thread.sleep(2000);

        Assert.assertEquals(flashcardsPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        clickOnIt(flashcardsPage.searchSchool, 2);
        Assert.assertNotNull(mainPage.loginPopup);

    }

    @Test
    public void TutorsContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/tutor?q=");
        Thread.sleep(1000);

        clickOnIt(tutorsPage.priceSortion,2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/tutor?q=&sort=price");

        clickOnIt(tutorsPage.relevanceSortion,2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/tutor?q=&sort=relevance");

        clickOnIt(tutorsPage.onlineLessonsFilter, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/tutor?q=&sort=relevance&filter=online");
        clickOnIt(tutorsPage.onlineLessonsFilter, 2);

        clickOnIt(tutorsPage.inPersonFilter, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/tutor?q=&sort=price&filter=inPerson");
        clickOnIt(tutorsPage.inPersonFilter, 2);

    }

    /*@Test
    public void TextbooksContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/book/9781400201655");

        clickOnIt(textbooksPage.newType, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/book/9781400201655?filter=new");
        clickOnIt(textbooksPage.newType, 2);

        clickOnIt(textbooksPage.rentalType, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/book/9781400201655?filter=rental");
        clickOnIt(textbooksPage.rentalType, 2);

        clickOnIt(textbooksPage.usedType, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/book/9781400201655?filter=used");
        clickOnIt(textbooksPage.usedType, 2);

    }*/

    /*@Test
    public void JobsContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/job?q=");

        clickOnIt(jobsPage.dateSortion, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/job?q=&sort=date");

        clickOnIt(jobsPage.relevanceSortion, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/job?q=&sort=relevance");

        clickOnIt(jobsPage.fullTimeFilter,1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/job?q=&sort=relevance&jobType=Full%20Time");
        clickOnIt(jobsPage.fullTimeFilter,1);

        clickOnIt(jobsPage.partTimeFilter, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/job?q=&sort=relevance&jobType=Part%20Time");
        clickOnIt(jobsPage.partTimeFilter, 1);

        clickOnIt(jobsPage.contractorFilter,1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/job?q=&sort=relevance&jobType=Contractor");
        clickOnIt(jobsPage.contractorFilter,1);

        clickOnIt(jobsPage.temporaryFilter, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/job?q=&sort=relevance&jobType=Temporary");
        clickOnIt(jobsPage.temporaryFilter, 1);

    }*/

    @Test
    public void FAQPageContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/faq");

        clickOnIt(faqPage.FAQ1, 1);
        Assert.assertEquals(faqPage.FAQ1Content.getText(),FAQText[0]);

        clickOnIt(faqPage.FAQ2, 1);
        Assert.assertEquals(faqPage.FAQ2Content.getText(),FAQText[1]);

        clickOnIt(faqPage.FAQ3, 1);
        Assert.assertEquals(faqPage.FAQ3Content.getText(),FAQText[2]);

        clickOnIt(faqPage.FAQ4, 1);
        Assert.assertEquals(faqPage.FAQ4Content.getText(),FAQText[3]);

        clickOnIt(faqPage.FAQ5, 1);
        Assert.assertEquals(faqPage.FAQ5Content.getText(),FAQText[4]);

        clickOnIt(faqPage.FAQ6, 1);
        Assert.assertEquals(faqPage.FAQ6Content.getText(),FAQText[5]);

        clickOnIt(faqPage.FAQ7, 1);
        Assert.assertEquals(faqPage.FAQ7Content.getText(),FAQText[6]);

        clickOnIt(faqPage.FAQ8, 1);
        Assert.assertEquals(faqPage.FAQ8Content.getText(),FAQText[7]);

        clickOnIt(faqPage.FAQ9, 1);
        Assert.assertEquals(faqPage.FAQ9Content.getText(),FAQText[8]);

        clickOnIt(faqPage.FAQ10, 1);
        Assert.assertEquals(faqPage.FAQ10Content.getText(),FAQText[9]);

        clickOnIt(faqPage.FAQ11, 1);
        Assert.assertEquals(faqPage.FAQ11Content.getText(),FAQText[10]);

        clickOnIt(faqPage.FAQ12, 1);
        Assert.assertEquals(faqPage.FAQ12Content.getText(),FAQText[11]);

        clickOnIt(faqPage.FAQ13, 1);
        Assert.assertEquals(faqPage.FAQ13Content.getText(),FAQText[12]);

        clickOnIt(faqPage.FAQ14, 1);
        Assert.assertEquals(faqPage.FAQ14Content.getText(),FAQText[13]);

        clickOnIt(faqPage.FAQ15, 1);
        Assert.assertEquals(faqPage.FAQ15Content.getText(),FAQText[14]);

        clickOnIt(faqPage.FAQ16, 1);
        Assert.assertEquals(faqPage.FAQ16Content.getText(),FAQText[15]);

        clickOnIt(faqPage.FAQ9, 1);
        clickOnIt(faqPage.termsLink, 1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.spitball.co/terms");

    }

    @Test
    public void signUpNavigation() throws InterruptedException {

        driver.get("https://dev.spitball.co");
        Thread.sleep(2000);

        clickOnIt(mainPage.SignUpButton,2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/register?returnUrl=%2Fask");

        Assert.assertEquals(signupPage.emailInput.getAttribute("placeholder"), "Enter your email address");
        signupPage.emailInput.sendKeys("elad@cloudents.com");
        Thread.sleep(2000);
        //signupPage.recaptcha.click();

        clickOnIt(signupPage.closeButton, 2);
        signupPage.cancelButton.click();
        clickOnIt(signupPage.signupWithGoogle,2);
        checkNewWindowAddress("https://accounts.google.com/signin/");

        Assert.assertEquals(signupPage.signupImage.getAttribute("src"), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAckAAAFaCAMAAABCE1auAAADAFBMVEVMaXGcnNacnNX6+vqbm6Sbm9Wdndizs+adndWcnNadnda0tNm2tv+cnNabm9abm9abm9acnNaentmcnNedndjx8f+fn9uoqN2cnNadndeentebm9acnNacnNjl5eWcnNahodydndidndydndaiot2cnNbz9PScnNacnNabm9acnNacnNbz8/PGxuy1teacnNbn5+ebm9acnNecnNacnNacnNedndacnNaentecnNWcnNacnNacnNfe3t7e3t5padZoaNZsbN9oaNWfn9mfn9FpadZpadbh4eHd3d3l5eVra9qcnNabm9fe3t6Li9rm5+dra9hqatfe3t5qatje3t7e3t7c3Oxqatdpadbe3t6ystnf39/d3d1qatdpadZqatfd3d3e3t6iotb29vbe3t76+/v9/f2dnddqatZqataKit9padadnaydnaidnbadnaucnKatrbSbm6TT1NecnNWcnNbp6uqcnNLd3d2bm9XJydXx8vKxsdVoaNXR09TCwtqnp9aZmdXGxtr///+bm7qzs9jW2Nny8/PGxtW6utjY2dra29zf4OHb3N3S1NXv8PDi5OXh4uPd3+Dk5ubt7u7U1tfr7e2jo9a7vOeAgNrO0NTOz+ientaCgtujo9fMzOWurtXp6+vLy9fg4OCwsNWqqtpsbNVpadWkpNWkpNnk5eWLi9ipqdWlpdXAwNXX192srNWcnNamptW+vtu4uNp9fdZxcdbIyNb8/P7FxdzBwdvJydzZ2eDDw9Wvr9vS09zY2O61tdt5edaGhte7u9WVldeystymptqsrNu4uNba2t12dtZvb9bMzdWPj9apqdrP0Nyioth0dNbV1d2YmNm0tNbLy9uDg9eSkticnNm3t9bFxdXm5+nR0tTNzdze3+Xz8/rDw+bAwOSAgNbHx9W7u9rw8fLs7e7r6/f39/vc3N3o6evPz9rb2928vOOgoNm1teDb2/Dm5vXu7/DOztjS0uyCgtfb3OPR0drh4fDv7/jW1u2+vtXJyeibm6+qqsNfYdICAAAAeHRSTlMAZOgv0sRbCkmIaqAEq9Tg7fMnZ3YBFA/8TkPNvDMkjx04I2IWXJvCwK+c5SwLB9kQl2xVyIOMoT7Wtnxy1J/77hHbITCPuSH6YCX5960b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");
        signupPage.signinLink.click();
        Assert.assertEquals(signupPage.signinImage.getAttribute("src"), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAU4AAAECCAMAAACmF85MAAADAFBMVEVMaXGqqt3////Jyf+cnNeentuqqv+cnNabm9adndacnNaiotyMjNmdndibm9aJidaentabm9WcnNWbm9ecnNacnNacnNWbm9afn9mbm9WcnNacnNWcnNWJidaJidWJidaIiNacnNacnNaiot2JidaJidaJideJidaRkdiNjd2KiteJideJidaKitedndebm9adndaLi9abm9acnNWcnNycnNWOjtmJidaJideIiNabm9Wbm9acnNecnNWcnNacnNabm9aysuacnNadndeentebm9abm9WcnNaZmdmbm9eIiNWLi9qJidaJidahoeuJideIiNaKitiIiNaJideIiNaJidaIiNWIiNWPj92MjNeSkuKJidWKitmIiNaKitaJidaIiNaJidaqquqJidaIiNWJideLi9mJidaKiteJidaKitiKiteLi9iNjdmJidWWluGJidaJidWIiNaJidaIiNWIiNaJidWJidaLi+iJidWKitaIiNaKitaJidaJidaJidacnNabm9acnNbe3t6JidaJidbd3d2JidaLi9eJidfe3t6IiNb///+KitiJidaJidXj4+Pd3d/e3t7e3t7e3t7e3t6JidXd3d3e3t7i4uLf39/d3d3V1d7d3d3e3t7q6ure3t7e3t7e3t7n5+fe3t7g4ODe3t6goNjh4eG3t9rd3d2IiNWbm9W6utmKitWystmNjdbV1d3b292cnNfa2t2MjNaSktaJidWtrdnS0tzc3N3U1Ny1tdnW1tyPj9bOztzJydvY2N3IyNu8vNqLi9XZ2d2zs9nMzNyZmde4uNmrq9nX193AwNqUlNafn9ewsNm2ttm7u9rY2NyXl9eamtfExNu+vtqurtjOztuQkNaRkdahodi3t9rKytuWltfR0dyxsdnLy9zCwtqkpNfGxtubm9eoqNiLi9ajo9i/v9umptjQ0NygoNe1tdm5udqqqtidnde1tdq9vdqiotepqdjBwdvBwdqnp9ecnNWfn9bT092lpdjHx9uvr9ipqdevr9nUP/dgAAAAqnRSTlMADwIEZxUDatRrwBYZTcz+ROHnM7yO9N4oXOX5qoHu5+t2yB7y4XR6ExZUhLB9Oetj/pesJNYb90b985xsn9j8fQhLcj+u7s4o9/se2c0H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");

        clickOnIt(signupPage.closeButton, 2);
        signupPage.exitButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask");

    }

    @Test
    public void loginNavigation() throws InterruptedException {

        driver.get("https://dev.spitball.co");

        clickOnIt(mainPage.LoginButton, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/signin");

        loginPage.emailInput.sendKeys("elad@cloudents.com");
        clickOnIt(loginPage.closeButton,1);
        loginPage.cancelButton.click();
        //loginPage.recaptcha.click();

        Assert.assertEquals(loginPage.loginImage.getAttribute("src"), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAU4AAAECCAMAAACmF85MAAADAFBMVEVMaXGqqt3////Jyf+cnNeentuqqv+cnNabm9adndacnNaiotyMjNmdndibm9aJidaentabm9WcnNWbm9ecnNacnNacnNWbm9afn9mbm9WcnNacnNWcnNWJidaJidWJidaIiNacnNacnNaiot2JidaJidaJideJidaRkdiNjd2KiteJideJidaKitedndebm9adndaLi9abm9acnNWcnNycnNWOjtmJidaJideIiNabm9Wbm9acnNecnNWcnNacnNabm9aysuacnNadndeentebm9abm9WcnNaZmdmbm9eIiNWLi9qJidaJidahoeuJideIiNaKitiIiNaJideIiNaJidaIiNWIiNWPj92MjNeSkuKJidWKitmIiNaKitaJidaIiNaJidaqquqJidaIiNWJideLi9mJidaKiteJidaKitiKiteLi9iNjdmJidWWluGJidaJidWIiNaJidaIiNWIiNaJidWJidaLi+iJidWKitaIiNaKitaJidaJidaJidacnNabm9acnNbe3t6JidaJidbd3d2JidaLi9eJidfe3t6IiNb///+KitiJidaJidXj4+Pd3d/e3t7e3t7e3t7e3t6JidXd3d3e3t7i4uLf39/d3d3V1d7d3d3e3t7q6ure3t7e3t7e3t7n5+fe3t7g4ODe3t6goNjh4eG3t9rd3d2IiNWbm9W6utmKitWystmNjdbV1d3b292cnNfa2t2MjNaSktaJidWtrdnS0tzc3N3U1Ny1tdnW1tyPj9bOztzJydvY2N3IyNu8vNqLi9XZ2d2zs9nMzNyZmde4uNmrq9nX193AwNqUlNafn9ewsNm2ttm7u9rY2NyXl9eamtfExNu+vtqurtjOztuQkNaRkdahodi3t9rKytuWltfR0dyxsdnLy9zCwtqkpNfGxtubm9eoqNiLi9ajo9i/v9umptjQ0NygoNe1tdm5udqqqtidnde1tdq9vdqiotepqdjBwdvBwdqnp9ecnNWfn9bT092lpdjHx9uvr9ipqdevr9nUP/dgAAAAqnRSTlMADwIEZxUDatRrwBYZTcz+ROHnM7yO9N4oXOX5qoHu5+t2yB7y4XR6ExZUhLB9Oetj/pesJNYb90b985xsn9j8fQhLcj+u7s4o9/se2c0HcbtNV1nwbtbcDzAR9CmPUOTfkwyz82c2tV/BLWwkIYwMx9BKvPXx6aYLh4meXd6rorXCd0iWyfu+PmJU0wEzm8Qacv67w4u347Ishuqo688MxpldFe9CNusRdWIrRHgAABFHSURBVHja7Z13XBTXFscHDLIoir3ERhTsJjHFEjX23ntvidEUjSnGxK4vxeQZU17J673PXnBZEJBQRUFAhUiVElAx1o9ii8pT35t7t7C77M7cmZ3dnRnO7w92PsvdMt+95dxzzz2XYRSowADuT0AgA5KFJtIFMAE6BDxlEUdSN0mHmYJk4jkZaMqnSZPR5EmAAWon9J0wssujxx5/rGHwxPWyqadpBiGEgqDyykezM/CUkWYg160AT3n6TUS6Zo7nYwDDfT2OOpPHzuhxgCFL7QwyNXmonfJYYxzPIAR+Fvl4dgaasvIEmjArAoFAIBAIBNK+kCQBN8DZANX4ieYvNH+iMYCQh2YTUvmbAE9Z9BPUssVLLVqiJwCFHGqOWnB/W6DmgEIOvYBe4v5uRC8ACqid0HcqwvqEkV0dOMHuBIFAIBAIBGooAucx4ASBQCAQCAQCgUAgFar3p3N7vvn+3gXdNoeGdn0vLHz6rPeXD3h17UYgI1ZTV3TpH653rpBV67ZunwqMKLVkzrZuekEt/GJOH2AlpMW9vhyqp1TIvn7LgJhr9em5wBZX5LH/xicWVZdERSXlpJ06VXumsCgr9+KJONsy02cGAzdnajy7/xQrJUN0/M0UI+tUxpRLVTUXrEWHvjsHVt0dtWjASiug/NzDCayAYh7kFlir6ar5HwBB29GnyzxLA7+Y/i1LqbSbJy1Eu/aDNm+F2e89S70sT2JFKaq8wPzSwcuXAElOM7qEmfvL62dYCbqSfcRcQ+c3AppDFppgJCceZSUqKSPZ9B7TZjdwmIN2mkCczpMMkwxMEbGm95m1oSHbRjNN7Ty5PIZ1UzGJBvJWYZ813Kr5GiEQF3+KlUFR2aZh/uUGOsa/E0puv6CElUklNeQNQ/tK/kq79/iZr8a2HGO+6vDiMH/Tlf+wFzuYnxzTcqz5ym/PbiXAbLQ1hAznEayM+u4gAfqR1CG+O2pjemlHhNq1JldN2yPU1vTftgi1b0quWrdDqKPpNtqg7krwwL1FbvxqFCurDkWTt32tt7Rv1aMVGoEfx3VCE1GrHtzV6O5I1wkNx08OR510qPtoU7GJqNM4/OQIUzFfO46ICy7uBiu78shsfsfr0r4XV+1Gce17AmrLVTudH+M/nquQHdHIZgzTbCTqyFXV8f6Mn46rxG3RBK7lj7JUYt8am2REj01lPaCUE/i910g0QV1C4wHta20nrqNbOaxHlENGpJA3pH03V02arxvwrXqSQeh/rKeUkE060JnSvp2LAYd3kPKltpCbzWI9qIhI/BE9JX095+ZQkyZ8JpQP1Qvf6YU7rEf1gLhFemnfeH+DWJuprId1mFigA7ROczvuNw0lrMeVSni+om2aK/Ay5ZFU1gtKxT6RKUO0THP/YLx+Uc16RRW4fr6nyKVjebJe9saBHXFnWS+pkCzLKTC4QZ6zABrPwvd3k/WasvDnvTVDgTTlOAtgK767eNaLIvb8R8qjGSTDWQB98b3VJHgTZ8JV/JnvKKvflOcsgKnY7REbxXpVp7A/ZLOiuk+ZzgL4Bk+GaJZ+K7Pu5hsiDceyC2WoyWfwdPNlDxMi+/zIdj8/5in88BzzPH54kiGZS5oxz+KHp5lnzJsCZTgL4FXc7Chc7ylX6+K5YmVw1Sd6wZoXi9P9vjO4K+44he8+1y4+Th9d6zZP7J/ftF5JzV2GswD6czd18JBg1FGZYwynIcVdnLUGLzR30TzdG9fnUPnkKk/Uj4mNTXKXZxF+G2VNNt2cFc3YgRuuYLSRwVmM8feJTmMarqTfyM07e4q2uS/QUvzSfDxVrxQK5Mh3EbSdX28V5EqxOYgm8i5F51qCS87XDs1FoTTTocsug+AvOiwG3bYZrwwULoDbOL6ut2Zw9sO3LdQHXuLZVFBh53krdRitYvOr+ENso3AvslorNIM3cXeTIVSFvufBWWxTLtNZDxtXxfve5TieViv7ZlbjiEOhGLkHfFte8h1qmhNl8725EXe1XTTSc4bRzIey+XDGJQj3sBFCrrqu2tiPMJO7lVKjEM4C3h1ZVs/JYZdFDGk8737UoJXB3X+hk56z/tBxmhen1Rz6r+syuXy/1gGuQLgWbM/Z2Dx0GNaT0F3H3o1/v6AFf1qk6zIneOPn8cL7XA3gfJe7j9uOqzjooWNr5MdpiZxP5yuUItQ3v6t+musdb7SC6wcPoB8db9fAB+qgsKnPKZF3Bov3G6o/zruXw2zdeA+dy7uP6s0N86kMpVi+Uj/wjnXHBKKW1HFUy9vcXXxnO0N8eB9/jUcRmfaD/UU+UOcs03reHuG84LLmdLXjxG09zmEgKikm38S++7zGByrCpsW6lsExji6x2sZ5koQn+ss00NbrOeGLUeGZa3eP261p8PaKd83eqFT+AcvhV8O/2d2sCksrOMmV6KdynI5t3dx91nO5xfKDMhtBZ/lL2XcfReh68T2O6GUbN/ICJbMSTom/wUlbZzPrWZ3sKaFEFTGCXidO9s7kbHSYNWYmoquWz8CtXcFjO8WBDZ85a+u1WcdZcVa8PpKlwWn3uxlrEJ52nkUHLM+cV7YlT3GcyDYa15yQew6vcFDhtPNanUGP8MNDZPUvV3FFvlAuTorDbvB8/TANzh/4QV2nwXnB3lRAVdxcKuE+irL1AS5ULk7ho5iCcTul2g0sUO/u0JQ6be/0QOje9fSz6Fxd88c7uKbKZXj6oHb2FTSurWPREd5J5lGbNV5KH0hO+nU8rqO8uqfwhqNXFYtTuO9cLeQ3q9N1PlAWV3uEntJnb/arpObdvX/F3kv3popHdrxhvZAyWOMgz3THMsO/wYvzmNBn/MgV+kbFdifOjVRJh5NNTXbZJ1ZQrYAIdyt4wT1cvVOijXgkoo4qvC7U1Fn2lrjGXs+65Qz5EPXmq1ws5CO30x1XmOoCE07Q2Po8wq9fq1qcONCrjBpnmgsPssGaxCZHYO4kGGBzjndoV7oGOEQcCMV2OoeUYTeU8Cld6BOqVL3cvo0u4NgakRDntAnn0LmYOZ0U+oRrvME1Sj+cBcfI/igiEvMIv1P4SpyQ36mEYu71vmpx4kXMB/LhLBPMN1tgFN4HN0u1jX069+0zZcN5gCJ/72V+nmcE1ouUrWnct78iE87MMj2NjvH+fIdUbcdvto0uchNnVAEVzmjez8NO/zDV4hzs6NJ1p7EbMw4Kwkwu52/sONZkqWpx4vw+InauFTpnZHU/p+Xx1tAjZUVCvx2unfNUizOs3nIY33Y3l53jubr+N+ps4uWy6GMOgV81t36ouplJ8cOl4TBPVfedlNuCDvGts8fdruVdRqbun5NwAkXV4gynmUeTWhMfKbCSmXtUDpxRXOFuqjaUaNydl5KFh+zYOzLg/JYrvFK1ON8WCro0OXWj6Y7YOFn3yySL9CRZ+2ecb1plEP2tmcRwjk5rkp/C0lhn6xwxuXF6SkVmGOvarChPku3S8F510ew7b952GxeIJeDjAdc7ljqpmvl6Eco3+ziq7V2jR24a6XAW8bpAFKludckel9eFBKdgALH1cnVkROpFKTLRZA7VOligsRlUDT5R0UuZTrWjLjnhfOtCT22pTfBB3YbrAr1onTdtio+pFzZyPkuYaLz0PJS+0pDB1mR6K3B2Y2IIkRCkcsd1WoNegix7Wp2E4eRXVQgvbqht+4aJZz/z0hsO1oqJdpJByZitl6hi0uATapz9rzQ+VSA+/lO12UefrtGb+qhFeJgwVwr9OYcwhQK9ZJkyhFRecDFeFbkamBLwK9S3EXstOX1o9edMKImwLiYI7N0TV5L1bug0MUGLXZr8ha7NTjVa8ftxXhr9F/4D8FBUTgI07XdMxnyvd0snjGY6LlTu0k5STJIVMflAFpMDIHY1XvwfUxBhaW39XSluKUIgxrbQ1cCulHVhcVkSl5E8+zsb/Ts10ln6nvPu4qyxDNRiAmzw4NVXMTRFZUlcT47C679/IDa+H4jaMkjVewpFgDlZM0rAn7pBKTQDxWX62rCKHLuI/1yqd2fu0jTFI2VQ7OyyjdFTjHtOSpbEqeZjx/R5rA9wJjoP2tmlCJySsiQGm85kdZbxxyc4sRE/Rym1U0KWxD77uBv4F6sQnNitN1TYiA8M4P4EBHqWZyBu7UFi8/r1fnnNrq+VghNbnR9T3KgugAnQIc/zlJYl8W+fKATnRSqrkyOpm6TDTD3OU9pP9mtl4EzCBvB+hobnZM/TlJ4l8afKwJlFu2F40mQ0eZJyJ/Cj/64InPmUR+54q3ZK1l/q44xwV2SP/OEDrpXqxJtEk1rFW32ndP2TVYCw+2Md1RDhlZHdHf3c9zTJthAq9wexO5sqmCbzD9/jxGuYoTMYbejPvqYZk6yls8o+9DVOvCIwb5FWcDJ/9C1NY6kGkv4ImPJeFN4Hv1Q7uaQZ5hc+HdZxz7lcQzSZ33ziQ5x4EWRpsJZwMr/0Hc2UOO0dQfqnX/kMJw7pmTZDWzh9NxpdUt4BZSqean6Lp5f9NUeT+ep3PsGJYxUGb9AeTubDn/mA5g3pR4srXb/1Ps1MvKQx63NN4vT3ujF/FOemCQ1mtKmv/uBlnCTx0mxGq/rQu5OjeL2WDipyor96czgiUaTTZ2gYJ/O192iS/fHhwYymJXHynnP8QF6FuEGdHHf/urZpMp//vjpNghuDnIVQbKR/xRk8G5oyROM0mfVd9aczxdJMu4+Kq4/fQnnUr0g1yHq4sJsHhXpOODHdwQcicRaRIyVq792jzdRSTdK0yLavIAi5fTy9h7SCxMQcF4czA1Xjh0eohHIUirTuZJSJZmel8sSnZupDxJ0VnogI/1uILhNA+kBZZ+pBMhwB7jnND8E3WyUGZwW6yoFMR+doCieQHR2WXeAy9JviNwbs3uNnvhrbcoz5qsOLw8yJE/yHvdjB/OSYlmPNV357dkv8fnNxgiX9VRFnWyc8RPce3UL3UinKJpG9ryHyHXEvYWNAd9TGdE5fR4TatSZXTdsj1Nb037YItW9Krlq3Q6gjuWrUBnWX+gWHLCVbJ1PpeRrzahA6R2N4ZpK8K0v545FI6kiSQdKPeQo/PMc8jx+eZEi28WbMs/jhaeYZc55JsRsDerRCI/DjuE5oImrVg7sa3R3pOqHh+MnhqJMOdR9tKjYRdRqHnxxhKiZNazeTASlPjK1UeYim2DWSWm2HgPUuFqfovpOrdqO49j0BteWqnc6P8R/PVciOaGQzhmk2EnXkqup4f8ZPx1XitmgC1/JHWSqxNAW/RoJay6LknVceMm1yn7VE3t5ewsYAl9B4QLuhxlvIgGSIkJOmqWrq32ws9+gZKN7udNWk+boBd/ROV1MOjxS5YFaaEjLN80R6CgmzIhcDDu8g5Y6mvuUsIZpU5RQTY1O/bpBS1h6cmkNNmvCZUO594Bthpu2/5THuwoy5YdqE3FW9aeFl0KCd5v3UWUZ3YCakl+qVVTV9pdnh5hQz1yQ3+ZxEc4q/VXOZBq8PuoSZEyRlZ0qBmXLbnOM3dOYMoMlpyZY1lrzv34msomk3LdmUBm9ZBCTN6r11k+UYslvp9Lli068ONL9s6UeDgKKN+nRZadn+F1KQIZzH2Jh646Q1HeCqnlAz602TZq8bWndWXnT8JZcJ/GsLc6MH1u2+3LvCH+g5teu7hNsl78svy847XlFSWZt0NCEmqvLMg7MR8WUnBtqW2ddlGXBzrdd7fRxCvW347QHAUrgb/WznSmGUC3e9sh5Y0frvVvSb1dUVyc1fLu8bDIxEV9O1fWcu7//xvmkrQ9dM2dRt2vS9/bf1mrN4I5ABgUAgEAgEAoFAIBAIBAKBQCAQCAQCgUAgEAgEAoFAIBAIBAKB1CkkvxT0cYBT3ThBIBAIBAKBQCAQTE5hegM4QSAQCAQCgcSZQcJZr1X6cYDTgzj/D1zbt+/87XgXAAAAAElFTkSuQmCC");
        loginPage.signupLink.click();
        Assert.assertEquals(loginPage.signupImage.getAttribute("src"), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAckAAAFaCAMAAABCE1auAAADAFBMVEVMaXGcnNacnNX6+vqbm6Sbm9Wdndizs+adndWcnNadnda0tNm2tv+cnNabm9abm9abm9acnNaentmcnNedndjx8f+fn9uoqN2cnNadndeentebm9acnNacnNjl5eWcnNahodydndidndydndaiot2cnNbz9PScnNacnNabm9acnNacnNbz8/PGxuy1teacnNbn5+ebm9acnNecnNacnNacnNedndacnNaentecnNWcnNacnNacnNfe3t7e3t5padZoaNZsbN9oaNWfn9mfn9FpadZpadbh4eHd3d3l5eVra9qcnNabm9fe3t6Li9rm5+dra9hqatfe3t5qatje3t7e3t7c3Oxqatdpadbe3t6ystnf39/d3d1qatdpadZqatfd3d3e3t6iotb29vbe3t76+/v9/f2dnddqatZqataKit9padadnaydnaidnbadnaucnKatrbSbm6TT1NecnNWcnNbp6uqcnNLd3d2bm9XJydXx8vKxsdVoaNXR09TCwtqnp9aZmdXGxtr///+bm7qzs9jW2Nny8/PGxtW6utjY2dra29zf4OHb3N3S1NXv8PDi5OXh4uPd3+Dk5ubt7u7U1tfr7e2jo9a7vOeAgNrO0NTOz+ientaCgtujo9fMzOWurtXp6+vLy9fg4OCwsNWqqtpsbNVpadWkpNWkpNnk5eWLi9ipqdWlpdXAwNXX192srNWcnNamptW+vtu4uNp9fdZxcdbIyNb8/P7FxdzBwdvJydzZ2eDDw9Wvr9vS09zY2O61tdt5edaGhte7u9WVldeystymptqsrNu4uNba2t12dtZvb9bMzdWPj9apqdrP0Nyioth0dNbV1d2YmNm0tNbLy9uDg9eSkticnNm3t9bFxdXm5+nR0tTNzdze3+Xz8/rDw+bAwOSAgNbHx9W7u9rw8fLs7e7r6/f39/vc3N3o6evPz9rb2928vOOgoNm1teDb2/Dm5vXu7/DOztjS0uyCgtfb3OPR0drh4fDv7/jW1u2+vtXJyeibm6+qqsNfYdICAAAAeHRSTlMAZOgv0sRbCkmIaqAEq9Tg7fMnZ3YBFA/8TkPNvDMkjx04I2IWXJvCwK+c5SwLB9kQl2xVyIOMoT7Wtnxy1J/77hHbITCPuSH6YCX5960b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");

        clickOnIt(signupPage.closeButton, 1);
        signupPage.exitButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask");

    }

    @Test
    public void AboutPageContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/about");

        clickOnIt(aboutPage.HowWorks, 2);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/about");
        Assert.assertEquals(aboutPage.HowWorks.getAttribute("className"),"v-tabs__item--active v-tabs__item");
        Assert.assertEquals(aboutPage.AboutHeader1.getText(),"How Spitball Works");
        Assert.assertEquals(aboutPage.WhatIsSpitball.getText(),"Our Homework Help offers students a quick and simple way to Ask and Answer tricky homework questions. Spitball incentivizes knowledgeable students to support one another for profit, bringing students from all over the world together to help each other succeed in school. Ask Your Question OR answer someone else’s, a win-win!");
        Assert.assertEquals(aboutPage.AboutHeader2.getText(),"Our Technology");
        Assert.assertEquals(aboutPage.OurTechnology.getText(),"Our platform combines artificial intelligence & machine learning with blockchain technology. This means we are able to bring you customized, relevant content while eliminating the “middle man” (aka, outdated banking systems and other controlling websites), enabling students to directly exchange knowledge, goods and services. By doing this, we can greatly reduce transaction fees and put the power back in the hands of students! Spitball’s technology uses “smart contracts” (a piece of code programmed to execute automatically) to keep track of your knowledge and reward you for asking and answering questions; in a safe, secure & extremely efficient way. It doesn’t get any better than this! We promise.");
        Assert.assertEquals(aboutPage.AboutHeader3.getText(),"Cashing Out");
        Assert.assertEquals(aboutPage.Personalization.getText(), "Ah, the good stuff. So you wanna cash out? No problem! Just go to your wallet (make sure you have enough redeemable SBL), click on Cash Out and choose your reward. Your Amazon Coupon will be sent to your email within 24 hours. Easy Peasy! Tip: We encourage students to save some SBL Tokens in order to ask tough homework questions in the future.");

        clickOnIt(aboutPage.FAQ, 1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/faq");
        Assert.assertEquals(aboutPage.FAQ.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        clickOnIt(aboutPage.Blog, 1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/blog");
        Assert.assertEquals(aboutPage.Blog.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        clickOnIt(aboutPage.Partners, 1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/partners");
        Assert.assertEquals(aboutPage.Partners.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        clickOnIt(aboutPage.Reps, 1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/reps");
        Assert.assertEquals(aboutPage.Reps.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        clickOnIt(aboutPage.Privacy, 1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/privacy");
        Assert.assertEquals(aboutPage.Privacy.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        clickOnIt(aboutPage.Terms, 1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/terms");
        Assert.assertEquals(aboutPage.Terms.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        clickOnIt(aboutPage.Contact, 1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/contact");
        Assert.assertEquals(aboutPage.Contact.getAttribute("className"),"v-tabs__item--active v-tabs__item");

    }

    @Test
    public void TermsPageContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/terms");

        Assert.assertEquals(termsPage.header1.getText(),"Terms of Service");
        Assert.assertEquals(termsPage.header2.getText(),"Your Stuff & Your Privacy");
        Assert.assertEquals(termsPage.header3.getText(),"Your Responsibilities");
        Assert.assertEquals(termsPage.header4.getText(),"Account Security");
        Assert.assertEquals(termsPage.header5.getText(),"Software and Updates");
        Assert.assertEquals(termsPage.header6.getText(),"Spitball Property and Feedback");
        Assert.assertEquals(termsPage.header7.getText(),"Acceptable Use Policy");
        Assert.assertEquals(termsPage.header8.getText(),"Objectionable Content Policy");
        Assert.assertEquals(termsPage.header9.getText(),"Other Sites");
        Assert.assertEquals(termsPage.header10.getText(),"Termination");
        Assert.assertEquals(termsPage.header11.getText(),"Spitball is Available \"AS-IS\"");
        Assert.assertEquals(termsPage.header12.getText(),"Limitation of Liability");
        Assert.assertEquals(termsPage.header13.getText(),"Export Restrictions");
        Assert.assertEquals(termsPage.header14.getText(),"Modifications");
        Assert.assertEquals(termsPage.header15.getText(),"Spitball Acceptable Use Terms and Use Policy");
        Assert.assertEquals(termsPage.header16.getText(),"Copyright");
        Assert.assertEquals(termsPage.header17.getText(),"Spitball DMCA Policy");

        Assert.assertEquals(termsPage.part1.getText(),"Last Modified 1/1/2018");
        Assert.assertEquals(termsPage.part2.getText(),"These terms of service govern your access to and use of Spitball websites and services (the \"Services\"), so please carefully read them before using the Services.");
        Assert.assertEquals(termsPage.part3.getText(),"By using the Services you agree to be bound by these Terms. If you are using the Services on behalf of an organization, you are agreeing to these Terms for that organization and promising that you have the authority to bind that organization to these terms. In that case, \"you\" and \"your\" will refer to that organization.");
        Assert.assertEquals(termsPage.part4.getText(),"You may use the Services only in compliance with these Terms. You may use the Services only if you have the power to form a contract with Spitball and are not barred under any applicable laws from doing so. The Services may continue to change over time as we refine and add more features. We may stop, suspend, or modify the Services at any time without prior notice to you. We may also remove any content from our Services at our discretion.");
        Assert.assertEquals(termsPage.part5.getText(),"This Services agreement is between you and Spitball and governs use of this service directly through any browser or through apps made available through the Apple App Store, Google Play Store or any other means. By using Spitball services or installing the Spitball Apps, you agree to be bound by this Agreement and understand that there is no tolerance for objectionable content. If you do not agree with the terms and conditions of this Agreement, you are not entitled to use the Spitball App or services. In order to ensure Spitball provides the best experience possible for everyone, we strongly enforce a no tolerance policy for objectionable content.");
        Assert.assertEquals(termsPage.part6.getText(),"By using our Services you provide us with information, folders, and files that you submit to Spitball (together, \"your stuff\"). You retain full ownership to your stuff. We don't claim any ownership to any of it. These Terms do not grant us any rights to your stuff or intellectual property except for the limited rights that are needed to run the Services, as explained below.");
        Assert.assertEquals(termsPage.part7.getText(),"We may need your permission to do things you ask us to do with your stuff, for example, hosting your files, or sharing them at your discretion. This includes product features visible to you, for example, image thumbnails or document previews. It also includes design choices we make to technically administer our Services, for example, how we redundantly backup data to keep it safe. You give us the permissions we need to do those things solely to provide the Services. This permission also extends to trusted third parties we work with to provide the Services, for example Amazon, which provides our storage space (again, only to provide the Services).");
        Assert.assertEquals(termsPage.part8.getText(),"To be clear, aside from the rare exceptions we identify in our Privacy Policy, no matter how the Services change, we won't share your content with others, including law enforcement, for any purpose unless you direct us to. How we gather and use your information generally is also explained in our Privacy Policy.");
        Assert.assertEquals(termsPage.part9.getText(),"You are solely responsible for your conduct, the content of your files and folders, and your communications with others while using the Services. For example, it's your responsibility to ensure that you have the rights or permission needed to comply with these Terms.");
        Assert.assertEquals(termsPage.part10.getText(),"We may choose to review public content for compliance with our community guidelines, but you acknowledge that Spitball has no obligation to monitor any information on the Services. We are not responsible for the accuracy, completeness, appropriateness, or legality of files, user posts, or any other information you may be able to access using the Services.");
        Assert.assertEquals(termsPage.part11.getText(),"Files and other content in the Services may be protected by intellectual property rights of others. Please do not copy, upload, download, or share files unless you have the right to do so. You, not Spitball, will be fully responsible and liable for what you copy, share, upload, download or otherwise use while using the Services. You must not upload spyware or any other malicious software to the Service.");
        Assert.assertEquals(termsPage.part12.getText(),"You, and not Spitball, are responsible for maintaining and protecting all of your stuff. Spitball will not be liable for any loss or corruption of your stuff, or for any costs or expenses associated with backing up or restoring any of your stuff.");
        Assert.assertEquals(termsPage.part13.getText(),"If your contact information, or other information related to your account, changes, you must notify us promptly and keep your information current. The Services are not intended for use by you if you are under 13 years of age. By agreeing to these Terms, you are representing to us that you are over 13.");
        Assert.assertEquals(termsPage.part14.getText(),"You are responsible for safeguarding the password that you use to access the Services and you agree not to disclose your password to any third party. You are responsible for any activity using your account, whether or not you authorized that activity. You should immediately notify Spitball of any unauthorized use of your account. You acknowledge that if you wish to protect your transmission of data or files to Spitball, it is your responsibility to use a secure encrypted connection to communicate with the Services.");
        Assert.assertEquals(termsPage.part15.getText(),"Some use of our Service requires you to download a client software package. Spitball hereby grants you a limited, nonexclusive, nontransferable, revocable license to use the Software, solely to access the Services. Your license to use the Software is automatically revoked if you violate these Terms in a manner that implicates our intellectual property rights. We hereby reserve all rights not expressly granted in these Terms. You must not reverse engineer or decompile the Software, nor attempt to do so, nor assist anyone else to do so. Our Services may update the Software on your device automatically when a new version is available. Our pause syncing feature pauses syncing of your files, but may not cease all data transfer, so you should exit the desktop client if you'd like to stop data transfer.");
        Assert.assertEquals(termsPage.part16.getText(),"These terms do not grant you any right, title, or interest in the Services, Software, or the content in the Services. While we appreciate it when users send us feedback, please be aware that we may use any feedback, comments, or suggestions you send us or post in our forums without any obligation to you. The Software and other technology we use to provide the Services are protected by copyright, trademark, and other laws of both the United States and foreign countries. These Terms do not grant you any rights to use the Spitball trademarks, logos, domain names, or other brand features.");
        Assert.assertEquals(termsPage.part17.getText(),"You will not, and will not attempt to, misuse the Services, and will use the Services only in a manner consistent with the Spitball Acceptable Use Policy.");
        Assert.assertEquals(termsPage.part18.getText(),"Content may be submitted to Spitball, who will moderate all content and ultimately decide whether or not to post a submission or remove a post submitted to the extent such content includes, is in conjunction with, or alongside any, Objectionable Content. Objectionable Content includes, but is not limited to: (i) sexually explicit materials; (ii) obscene, defamatory, libelous, slanderous, violent and/or unlawful content or profanity; (iii) content that infringes upon the rights of any third party, including copyright, trademark, privacy, publicity or other personal or proprietary right, or that is deceptive or fraudulent; (iv) content that promotes the use or sale of illegal or regulated substances, tobacco products, ammunition and/or firearms; and (v) gambling, including without limitation, any online casino, sports books, bingo or poker.");
        Assert.assertEquals(termsPage.part19.getText(),"The Services may contain links to third-party websites or resources. Spitball does not endorse and is not responsible or liable for their availability, accuracy, the related content, products, or services. You are solely responsible for your use of any such websites or resources. Other sites may provide features that allow you to share your stuff with others or to make it public. There are many things that users may do with that stuff (for example, copy it, modify it, re-share it). Please consider carefully what you choose to share or make public. Spitball has no responsibility for that activity. Also, if we provide you with any software under an open source license, there may be provisions in those licenses that expressly conflict with these Terms, in which case the open source provisions will apply.");
        Assert.assertEquals(termsPage.part20.getText(),"Though we'd much rather you stay, you can stop using our Services any time. We reserve the right to suspend or end the Services at any time, with or without cause, and with or without notice. For example, we may suspend or terminate your use if you are not complying with these Terms, or use the Services in any way that would cause us legal liability or disrupt others' use of the Services. If we suspend or terminate your use, we will try to let you know in advance and help you retrieve data, though there may be some cases (for example, repeatedly or flagrantly violating these Terms, a court order, or danger to other users) where we may suspend immediately.");
        Assert.assertEquals(termsPage.part21.getText(),"Though we want to provide a great service, there are certain things about the service we can't promise. For example, THE SERVICES AND SOFTWARE ARE PROVIDED \"AS IS\", AT YOUR OWN RISK, WITHOUT EXPRESS OR IMPLIED WARRANTY OR CONDITION OF ANY KIND. WE ALSO DISCLAIM ANY WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT. Spitball will have no responsibility for any harm to your computer system, loss or corruption of data, or other harm that results from your access to or use of the Services or Software. Some states do not allow the types of disclaimers in this paragraph, so they may not apply to you.");
        Assert.assertEquals(termsPage.part22.getText(),"TO THE FULLEST EXTENT PERMITTED BY LAW, IN NO EVENT WILL Spitball, ITS AFFILIATES, OFFICERS, EMPLOYEES, AGENTS, SUPPLIERS OR LICENSORS BE LIABLE FOR (A) ANY INDIRECT, SPECIAL, INCIDENTAL, PUNITIVE, EXEMPLARY OR CONSEQUENTIAL (INCLUDING LOSS OF USE, DATA, BUSINESS, OR PROFITS) DAMAGES, REGARDLESS OF LEGAL THEORY, WHETHER OR NOT Spitball HAS BEEN WARNED OF THE POSSIBILITY OF SUCH DAMAGES, AND EVEN IF A REMEDY FAILS OF ITS ESSENTIAL PURPOSE; (B) AGGREGATE LIABILITY FOR ALL CLAIMS RELATING TO THE SERVICES MORE THAN THE GREATER OF $15 OR THE AMOUNTS PAID BY YOU TO Spitball FOR THE PAST THREE MONTHS OF THE SERVICES IN QUESTION. Some states do not allow the types of limitations in this paragraph, so they may not apply to you.");
        Assert.assertEquals(termsPage.part23.getText(),"The export and re-export of the Software may be controlled by the United States Export Administration Regulations. The Software may not be used in Cuba; Iran; North Korea; Sudan; or Syria or any country that is subject to an embargo by the United States. If you are a resident or national of, or a business located in, any of those countries, you may not download or use the Software. In addition, the Software may not be distributed to persons on the Table of Denial Orders; the Entity List; or the List of Specially Designated Nationals.");
        Assert.assertEquals(termsPage.part24.getText(),"We may revise these Terms from time to time and the most current version will always be posted on our website. If a revision, in our sole discretion, is material we will notify you (for example via email to the email address associated with your account). Other changes may be posted to our blog or terms page, so please check those pages regularly. By continuing to access or use the Services after revisions become effective, you agree to be bound by the revised Terms. If you do not agree to the new terms, please stop using the Services.");
        Assert.assertEquals(termsPage.part25.getText(),"Spitball takes privacy very seriously and we are constantly improving our services to better serve our customers.");
        Assert.assertEquals(termsPage.part26.getText(),"You agree not to misuse the Spitball services. For example, you must not, and must not attempt to, use the services to do the following things.");
        Assert.assertEquals(termsPage.part27.getText(),"Spitball respects others' intellectual property and asks that you do too. We will respond to notices of alleged copyright infringement if they comply with the law and are properly provided to us. Such notices should be reported using our DMCA Process. We reserve the right to delete or disable content alleged to be infringing and to terminate repeat infringers. Our designated agent for notice of alleged copyright infringement on the Services is provided at the end of this document:");
        Assert.assertEquals(termsPage.part28.getText(),"Spitball (\"Spitball\") respects the intellectual property rights of others and expects its users to do the same. In accordance with the Digital Millennium Copyright Act of 1998, the text of which may be found on the U.S. Copyright Office website at http://www.copyright.gov/legislation/dmca.pdf, Spitball will respond expeditiously to claims of copyright infringement committed using the Spitball service and/or the Spitball website (the \"Site\") if such claims are reported to Spitball's Designated Copyright Agent identified in the sample notice below.");
        Assert.assertEquals(termsPage.part29.getText(),"If you are a copyright owner, authorized to act on behalf of one, or authorized to act under any exclusive right under copyright, please report alleged copyright infringements taking place on or through the Site by completing the following DMCA Notice of Alleged Infringement and delivering it to Spitball's Designated Copyright Agent. Upon receipt of Notice as described below, Spitball will take whatever action, in its sole discretion, it deems appropriate, including removal of the challenged content from the Site.");
        Assert.assertEquals(termsPage.part30.getText(),"Deliver this Notice, with all items completed, to Spitball's Designated Copyright Agent:");
        Assert.assertEquals(termsPage.part31.getText(), "Copyright Agent\nCloudents LTD.\nHanasi Harishon, 38\nRehovot, Israel\nsupport@spitball.co");

        Assert.assertEquals(termsPage.contractHeader.getText(),"DMCA Notice of Alleged Infringement (\"Notice\")");
        Assert.assertEquals(termsPage.contract1.getText(),"Identify the copyrighted work that you claim has been infringed, or - if multiple copyrighted works are covered by this Notice - you may provide a representative list of the copyrighted works that you claim have been infringed.");
        Assert.assertEquals(termsPage.contract2.getText(),"Identify the material or link you claim is infringing (or the subject of infringing activity) and to which access is to be disabled, including at a minimum, if applicable, the URL of the link shown on the Site or the exact location where such material may be found.");
        Assert.assertEquals(termsPage.contract3.getText(),"Provide your company affiliation (if applicable), mailing address, telephone number, and, if available, email address.");
        Assert.assertEquals(termsPage.contract4.getText(), "Include both of the following statements in the body of the Notice:\n\"I hereby state that I have a good faith belief that the disputed use of the copyrighted material is not authorized by the copyright owner, its agent, or the law (e.g., as a fair use).\"\n\"I hereby state that the information in this Notice is accurate and, under penalty of perjury, that I am the owner, or authorized to act on behalf of, the owner, of the copyright or of an exclusive right under the copyright that is allegedly infringed.\"");
        Assert.assertEquals(termsPage.contract5.getText(), "Provide your full legal name and your electronic or physical signature.");

        clickOnIt(termsPage.docLink, 3);
        checkNewWindowAddress("https://www.copyright.gov/legislation/dmca.pdf");

    }

    @Test
    public void PrivacyPageContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/privacy");

        Assert.assertEquals(privacyPage.header1.getText(), "Privacy Policy");
        Assert.assertEquals(privacyPage.header2.getText(), "Gathering and Storing Information");
        Assert.assertEquals(privacyPage.header3.getText(), "Use of Personal Information");
        Assert.assertEquals(privacyPage.header4.getText(), "Sharing and Disclosure");
        Assert.assertEquals(privacyPage.header5.getText(), "Data Retention");
        Assert.assertEquals(privacyPage.header6.getText(), "Security");
        Assert.assertEquals(privacyPage.header7.getText(), "Spitball Community");
        Assert.assertEquals(privacyPage.header8.getText(), "Our Policy towards Children");
        Assert.assertEquals(privacyPage.header9.getText(), "Other Sites");
        Assert.assertEquals(privacyPage.header10.getText(), "Contacting Us");
        Assert.assertEquals(privacyPage.header11.getText(), "Changes to our Privacy Policy");

        Assert.assertEquals(privacyPage.part1.getText(), "Last Modified 1/1/2018");
        Assert.assertEquals(privacyPage.part2.getText(), "This Privacy Policy provides our company policies and procedures for gathering, using, and disclosing your information. Users can access the Spitball service through our website, located at www.spitball.co, applications on Devices, and through third-parties. A \"Device\" is defined as any computer used to access the Spitball Service, including without limitation a desktop, laptop, mobile phone, tablet, web enabled TV, or other consumer electronic device. This Privacy Policy governs your access of the Spitball Service, regardless of how you access it, and by using our Services you agree to the gathering, transfer, processing, storage, disclosure and other uses described in this Privacy Policy. All of the various forms of data, content, and information described below are referred to as \"information.\"");
        Assert.assertEquals(privacyPage.part3.getText(), "At Spitball we take security and privacy very seriously. Your personal information is actively protected by us. Communications with our web and mobile services are encrypted using industry standard AES encryption, we use European data centres and your passwords are stored using non-reversible encryption.");
        Assert.assertEquals(privacyPage.part4.getText(), "Spitball may gather and store the following information during the running of the Spitball Service:");
        Assert.assertEquals(privacyPage.part5.getText(), "Information You Provide: During account registration we gather personal information, which may include your name, email, university, and classes. If you sign up using Facebook we gather your Facebook name.");
        Assert.assertEquals(privacyPage.part6.getText(), "Cookies: We use \"cookies\" to gather information and improve our Services. A cookie is a small data file that we transfer to your Device. We may use \"persistent cookies\" to save your registration ID and login password for future logins to the Service. We may use \"session ID cookies\" to enable certain features of the Service, to better understand how you interact with the Service and to monitor aggregate usage and web traffic routing on the Service. You can change how your computer manages cookies through your browser, by changing its options, to stop accepting cookies or to prompt you before accepting a cookie from the websites you visit.");
        Assert.assertEquals(privacyPage.part7.getText(), "Personal Information: In the course of using the Spitball Service, we may gather personal information that can be used to contact or identify you. Personal Information is or may be used: (i) to provide and improve our Service, (ii) to administer your use of the Service, (iii) to better understand your needs and interests, (iv) to personalize and improve your experience, and (v) to provide or offer software updates and product announcements. If you no longer wish to receive communications from us, please follow the \"unsubscribe\" instructions provided in the Spitball email messages.");
        Assert.assertEquals(privacyPage.part8.getText(), "Analytics: We gather some information (using third party services) using logging and cookies, which can sometimes be correlated with Personal Information. We use this information for the above purposes and to monitor and analyze use of the Service, for the Service's technical administration, to increase our Service's functionality and user-friendliness, and to verify users have the authorization needed for the Service to process their requests. As of the date this policy went into effect, we use Google Analytics. To learn more about the privacy policy of Google Analytics, click here.");
        Assert.assertEquals(privacyPage.part9.getText(), "Your profile page will display your Personal Information and elsewhere on the Service according to the preferences you set in your account. Any information you choose to provide should reflect how much you want others to know about you. Please consider carefully what information you disclose in your profile page and your desired level of anonymity. Through your Spitball account you can review and revise your profile information at any time. Through certain features of the Service, you may also have the ability to make some of your information public. Public information may be broadly and quickly disseminated. Please consider what information you want to make public.");
        Assert.assertEquals(privacyPage.part10.getText(), "Service Providers, Business Partners and Others: Spitball may use certain trusted third party companies and individuals to help us provide, analyze, and improve the Service (including but not limited to data storage, maintenance services, database management, web analytics, payment processing, and improvement of the Service's features). These third parties may have access to your information only for purposes of performing these tasks on our behalf and under obligations similar to those in this Privacy Policy.");
        Assert.assertEquals(privacyPage.part11.getText(), "Compliance with Laws and Law Enforcement Requests; Protection of Spitball' Rights: We may disclose to parties outside Spitball files stored in your Spitball account and information about you that we gather when we have a good faith belief that disclosure is reasonably necessary to (a) comply with a law, regulation or compulsory legal request; (b) protect the safety of any person from death or serious bodily injury; (c) prevent fraud or abuse of Spitball or its users; or (d) to protect Spitball' property rights. If we provide your Spitball files to a law enforcement agency as set forth above, we will remove Spitball' encryption from the files before providing them to law enforcement. However, Spitball will not be able to decrypt any files that you encrypted prior to storing them on Spitball.");
        Assert.assertEquals(privacyPage.part12.getText(), "Business Transfers: If we are involved in a merger, acquisition, or sale of all or a portion of our assets, your information may be transferred as part of that transaction, but we will notify you (for example, via email and/or a prominent notice on our website) of any change in control or use of your Personal Information or Files, or if either become subject to a different Privacy Policy. We will also notify you of choices you may have regarding the information.");
        Assert.assertEquals(privacyPage.part13.getText(), "Non-private or Non-Personal Information: We may disclose your non-private, aggregated, or otherwise non-personal information, such as usage statistics of our Service.");
        Assert.assertEquals(privacyPage.part14.getText(), "We will retain your information for as long as your account is active or as needed to provide you services. If you wish to cancel your account or request that we no longer use your information to provide you services, you may request that we delete your account and we will do so promptly. We may retain and use your information as necessary to comply with our legal obligations, resolve disputes, and enforce our agreements. Consistent with these requirements, we will try to delete your information quickly upon request. Please note, however, that there might be latency in deleting information from our servers and backed-up versions might exist after deletion. In addition, we do not delete from our servers files that you have in common with other users.");
        Assert.assertEquals(privacyPage.part15.getText(), "The security of your information is important to us. When you enter sensitive information (such as your login and password) we encrypt the transmission of that information using secure socket layer technology (SSL).");
        Assert.assertEquals(privacyPage.part16.getText(), "We follow generally accepted standards to protect the information submitted to us, both during transmission and once we receive it. No method of electronic transmission or storage is 100% secure, however. Therefore, we cannot guarantee its absolute security. If you have any questions about security on our website, you can contact us at support@spitball.co");
        Assert.assertEquals(privacyPage.part17.getText(), "Our Service offers publicly accessible community services such as Q&As and comments. You should be aware that any information you provide in these areas may be read, gathered, and used by others who access them. Your posts may remain even after you cancel your account.");
        Assert.assertEquals(privacyPage.part18.getText(), "Our Services are directed to students in higher education and not directed to persons under 17. We do not knowingly gather personally identifiable information from children under 13. If a parent or guardian becomes aware that his or her child has provided us with Personal Information without their consent, he or she should contact us at support@spitball.co. If we become aware that a child under 13 has provided us with Personal Information, we will take steps to delete such information from our files.");
        Assert.assertEquals(privacyPage.part19.getText(), "Spitball contains links to other websites not owned or operated by Spitball. If you click on such a link, you may be taken away from Spitball to an entirely different website. This Policy applies only to Spitball and not to any third-party website that may be accessed through links on Spitball. We encourage you to be aware when we link to other websites and to read the privacy policies of each website.");
        Assert.assertEquals(privacyPage.part20.getText(), "If you have any questions about this Privacy Policy, please contact us at support@spitball.co.");
        Assert.assertEquals(privacyPage.part21.getText(), "This Privacy Policy may change from time to time. If we make a change to this privacy policy that we believe materially changes your rights, we will provide you with notice (for example, by email). And we may provide notice of changes in other circumstances as well. By continuing to use the Service after those changes become effective, you agree to be bound by the revised Privacy Policy.");

        clickOnIt(privacyPage.link1, 1);
        checkNewWindowAddress("https://www.spitball.co/ask");

        clickOnIt(privacyPage.link2, 1);
        checkNewWindowAddress("https://marketingplatform.google.com/about/");
    }

    @Test
    public void PartnersPageContent() throws InterruptedException {

        driver.get("https://www.spitball.co/partners");
        Thread.sleep(1000);
        Assert.assertEquals(partnersPage.partnerText.getText(), "Does your company make students’ lives easier? Are you interested in joining the community or accepting SBL on your website? Reach out to us at partner@spitball.co");

    }

    @Test
    public void RepsPageContent() throws InterruptedException {

        driver.get("https://www.spitball.co/reps");
        Thread.sleep(1000);
        Assert.assertEquals(repsPage.repsText.getText(), "Want to help grow the Spitball community at your school or university? Reach out to us at work@spitball.co");

    }

    @Test
    public void TokenSite() throws InterruptedException {

        driver.get("https://token.spitball.co");
        Thread.sleep(1000);

        tokenPage.headerLink.click();
        checkNewWindowAddress("https://www.spitball.co/ask");
        Thread.sleep(1000);
        Assert.assertEquals(tokenPage.header1.getText(), "The World’s First");
        tokenPage.downloadWhitepaper.click();
        checkNewWindowAddress("https://zboxstorage.blob.core.windows.net/zboxhelp/ico/Spitball-WP.pdf");
        Thread.sleep(1000);
        tokenPage.joinTelegram.click();
        checkNewWindowAddress("https://t.me/Spitball");
        Thread.sleep(1000);
        tokenPage.joinUsOnTelegram.click();
        checkNewWindowAddress("https://t.me/Spitball");
        Thread.sleep(1000);
        tokenPage.emailText.sendKeys("elad@cloudents.com");
        tokenPage.subscribeButton.click();
        Assert.assertEquals(tokenPage.emailText.getText(), "");
        for(int i=0 ; i < 20 ; i++) {
            tokenPage.downloadWhitepaper.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1);
        }
        Assert.assertEquals(tokenPage.header2.getText(), "Living in a world of change...");
        Assert.assertEquals(tokenPage.image1.getAttribute("src"), "https://token.spitball.co/images/muscari/hevra.png");
        for(int i=0 ; i < 20 ; i++) {
            tokenPage.downloadWhitepaper.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1);
        }
        Assert.assertEquals(tokenPage.header3a.getText(), "Spitball 2.0");
        Assert.assertEquals(tokenPage.header3b.getText(), "Selected Use Cases");
        Assert.assertEquals(tokenPage.image2.getAttribute("src"), "https://token.spitball.co/images/muscari/spitball_app.png");
        for(int i=0 ; i < 20 ; i++) {
            tokenPage.downloadWhitepaper.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1);
        }
        Assert.assertEquals(tokenPage.header4a.getText(), "Spitball 2.0");
        Assert.assertEquals(tokenPage.header4b.getText(), "Token Economy");
        Assert.assertEquals(tokenPage.image3.getAttribute("src"), "https://token.spitball.co/images/muscari/spitball_economy.png");
        for(int i=0 ; i < 20 ; i++) {
            tokenPage.downloadWhitepaper.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1);
        }
        Assert.assertEquals(tokenPage.header5.getText(), "Roadmap");
        Assert.assertEquals(tokenPage.image4.getAttribute("src"), "https://token.spitball.co/images/muscari/partners.png");
        for(int i=0 ; i < 20 ; i++) {
            tokenPage.downloadWhitepaper.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1);
        }
        Assert.assertEquals(tokenPage.header6.getText(), "The Leadership Team");
        for(int i=0 ; i < 20 ; i++) {
            tokenPage.downloadWhitepaper.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1);
        }
        Assert.assertEquals(tokenPage.header7.getText(), "Our Partners");
        for(int i=0 ; i < 130 ; i++) {
            tokenPage.downloadWhitepaper.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1);
        }
        Assert.assertEquals(tokenPage.header8.getText(), "Get In Touch");
        tokenPage.yourName.sendKeys("Elad");
        tokenPage.yourEmail.sendKeys("elad@cloudents.com");
        tokenPage.yourMessage.sendKeys("Hi, my name is Elad.");
        Actions actions = new Actions(driver);
        actions.moveToElement(tokenPage.submitButton).build().perform();
        tokenPage.submitButton.click();
        Assert.assertEquals(tokenPage.yourName.getText(), "");
        Assert.assertEquals(tokenPage.yourEmail.getText(), "");
        Assert.assertEquals(tokenPage.yourMessage.getText(), "");
        for(int i=0 ; i < 20 ; i++) {
            tokenPage.downloadWhitepaper.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1);
        }
        tokenPage.whitepaperLink.click();
        checkNewWindowAddress("https://zboxstorage.blob.core.windows.net/zboxhelp/ico/Spitball-WP.pdf");
        Thread.sleep(2000);
        tokenPage.oldSpitball.click();
        checkNewWindowAddress("https://www.spitball.co/ask");
        Thread.sleep(2000);
        tokenPage.privacy.click();
        checkNewWindowAddress("https://www.spitball.co/privacy");
        Thread.sleep(2000);
        tokenPage.terms.click();
        checkNewWindowAddress("https://www.spitball.co/terms");
        Thread.sleep(2000);
        tokenPage.roadmapLink.click();
        Assert.assertNotNull(driver.getCurrentUrl());
        Thread.sleep(2000);
        tokenPage.usecasesLink.click();
        Assert.assertNotNull(driver.getCurrentUrl());
        Thread.sleep(2000);
        tokenPage.teamLink.click();
        Assert.assertNotNull(driver.getCurrentUrl());
        Thread.sleep(2000);
        tokenPage.contactLink.click();
        Assert.assertNotNull(driver.getCurrentUrl());
        Thread.sleep(2000);
        tokenPage.telegramIcon.click();
        checkNewWindowAddress("https://t.me/Spitball");
        Thread.sleep(2000);
        tokenPage.facebookIcon.click();
        checkNewWindowAddress("https://www.facebook.com/spitballstudy/");
        Thread.sleep(2000);
        tokenPage.twitterIcon.click();
        checkNewWindowAddress("https://twitter.com/SpitballStudy");
        Thread.sleep(2000);
        tokenPage.youtubeIcon.click();
        checkNewWindowAddress("https://www.youtube.com/channel/UC9qGHTJixreP2bbwugmSi2Q?view_as=subscriber");
        Thread.sleep(2000);
        tokenPage.githubIcon.click();
        checkNewWindowAddress("https://github.com/Cloudents/Spitball");
        Thread.sleep(2000);
        tokenPage.linkedinIcon.click();
        checkNewWindowAddress("https://www.linkedin.com/");
        Thread.sleep(2000);
        tokenPage.mediumIcon.click();
        checkNewWindowAddress("https://medium.com/@spitballstudy");
        Thread.sleep(2000);
        tokenPage.homePage.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://token.spitball.co/");

    }

    @AfterClass
    public void cleanupTestSeries() {

        driver.quit();

    }


    /* Help function to get the new window handle and test the current URL by comparing it to the URL address parameter */

    private void checkNewWindowAddress(String address) {

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        String actualURL = driver.getCurrentUrl();
        assertTrue(actualURL.contains(address));
        //Assert.assertEquals(driver.getCurrentUrl(), address);
        driver.close();
        driver.switchTo().window(winHandleBefore);

    }

    /* Help function to get Web Element and time to wait, click on it and wait ms second(s) */

    private void clickOnIt(WebElement we, int ms) throws InterruptedException {

        we.click();
        Thread.sleep(ms*1000);

    }

}
