package com.cloudents.AutomationTest;


import com.cloudents.AutomationTest.Pages.*;
import javafx.stage.Screen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


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

    private String winHandleBefore;

    /*private Pattern baseImagePattern = new Pattern(imagePath1);
    private Pattern capturedImagePattern = new Pattern(imagePath2);
    Screen screen = new Screen();
    Match pass = screen.exists(capturedImagePattern);*/


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

    }

    /*@Parameters("browser")
    @BeforeClass
    public void setup(@Optional String browser) {

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
        winHandleBefore = driver.getWindowHandle();

    }*/

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loadPageElements();

        // Store the current window handle
        winHandleBefore = driver.getWindowHandle();
    }

    @Test
    public void DefaultHomePage() {
        driver.get("http://dev.spitball.co");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask");
    }

    @Test
    public void MainTabsNavigation() throws InterruptedException {

        driver.get("https://dev.spitball.co");

        mainPage.HWhelpTab.click();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.HWhelpTab.getAttribute("className"),"v-tabs__item v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/ask?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Search questions");

        mainPage.StudyDocsTab.click();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.StudyDocsTab.getAttribute("className"),"v-tabs__item v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/note?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Find study documents in...");

        mainPage.FlashcardTab.click();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.FlashcardTab.getAttribute("className"),"v-tabs__item v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/flashcard?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Look for flashcards...");

        mainPage.TutorsTab.click();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.TutorsTab.getAttribute("className"),"v-tabs__item v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/tutor?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Find a tutor...");

        mainPage.BooksTab.click();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.BooksTab.getAttribute("className"),"v-tabs__item v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/book?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Textbook title or ISBN...");

        mainPage.JobsTab.click();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.JobsTab.getAttribute("className"),"v-tabs__item v-tabs__item--active");
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/job?q=");
        Assert.assertEquals(mainPage.SearchBar.getAttribute("placeholder"),"Your field of expertise...");

    }

    @Test
    public void HWPageContent() throws InterruptedException {

        driver.get("https://dev.spitball.co");

        HwPage.artsItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Arts");
        HwPage.artsItem.click();
        Thread.sleep(1000);

        HwPage.biologyItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Biology");
        HwPage.biologyItem.click();
        Thread.sleep(1000);

        HwPage.blockchainItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Blockchain");
        HwPage.blockchainItem.click();
        Thread.sleep(1000);

        HwPage.businessItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Business");
        HwPage.businessItem.click();
        Thread.sleep(1000);

        HwPage.chemistryItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Chemistry");
        HwPage.chemistryItem.click();
        Thread.sleep(1000);

        HwPage.computerScienceItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Computer%20Science");
        HwPage.computerScienceItem.click();
        Thread.sleep(1000);

        HwPage.economicsItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Economics");
        HwPage.economicsItem.click();
        Thread.sleep(1000);

        HwPage.educationItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Education");
        HwPage.educationItem.click();
        Thread.sleep(1000);

        HwPage.geographyItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Geography");
        HwPage.geographyItem.click();
        Thread.sleep(1000);

        HwPage.healthItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Health%20%26%20Medicine");
        HwPage.healthItem.click();
        Thread.sleep(1000);

        HwPage.historyItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=History");
        HwPage.historyItem.click();
        Thread.sleep(1000);

        HwPage.languagesItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Languages");
        HwPage.languagesItem.click();
        Thread.sleep(1000);

        HwPage.lawItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Law%20%26%20Politics");
        HwPage.lawItem.click();
        Thread.sleep(1000);

        HwPage.literatureItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Literature");
        HwPage.literatureItem.click();
        Thread.sleep(1000);

        HwPage.mathItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Mathematics");
        HwPage.mathItem.click();
        Thread.sleep(1000);

        HwPage.physicsItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Physics");
        HwPage.physicsItem.click();
        Thread.sleep(1000);

        HwPage.psychologyItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Psychology");
        HwPage.psychologyItem.click();
        Thread.sleep(1000);

        HwPage.religionItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Religion%2FPhilosophy");
        HwPage.religionItem.click();
        Thread.sleep(1000);

        HwPage.socialItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Social%20Studies");
        HwPage.socialItem.click();
        Thread.sleep(1000);

        HwPage.technologyItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Technology");
        HwPage.technologyItem.click();
        Thread.sleep(1000);

        HwPage.miscItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/ask?source=Miscellaneous");
        HwPage.miscItem.click();

    }

    @Test
    public void FAQPageContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/faq");

        faqPage.FAQ1.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ1Content.getText(),"Spitball is the first decentralized global marketplace for students. From class notes & study guides, to textbooks, tutors, jobs and more, Spitball brings the best that the internet has to offer students, all together in one place. Spitball allows students to ask and answer questions, share notes, buy & sell textbooks and more - making it the ideal one-stop shop for students.");

        faqPage.FAQ2.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ2Content.getText(),"Spitball acts as an aggregator of academic content and a marketplace for students to come together and exchange information, goods and services. Because it's a decentralized marketplace, third-party transaction fees are greatly reduced, providing cheaper goods for consumers and more money in the pockets of sellers!");

        faqPage.FAQ3.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ3Content.getText(),"Unlike other student websites, Spitball brings a new level of personalization and variety of content to students. Not only do we provide our users with the ability to customize their results to their school and classes, Spitball also aggregates content from over 25 leading student sites and services.\n\nIn addition to these unique features, Spitball is the only decentralized marketplace for students - allowing students from all over the world to ask and answer questions, share notes, buy & sell textbooks and more - all while cutting out costly transaction fees.");

        faqPage.FAQ4.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ4Content.getText(),"SBL are the internal points of the Spitball system. Certain goods and services can only be purchased using SBL. Similarly, you can receive SBL for contributing to the Spitball community.");

        faqPage.FAQ5.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ5Content.getText(),"SBL are redeemable for Amazon gift cards with real CASH value! See below for more details on how to redeem your SBL.");

        faqPage.FAQ6.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ6Content.getText(),"That's right! There's no catch. Earned SBL can be redeemed for Amazon gift cards with real cash value! To see the Cash-Out Ratios, see the image below.");

        faqPage.FAQ7.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ7Content.getText(),"Awarded SBL are points given by Spitball for actions such as registration, promoting Spitball on social media, etc. These SBL can only be used within the system and are not redeemable for cash rewards. Earned SBL are points received by answering questions or providing services on the Spitball platform. These can be used for all of the actions that Awarded SBL can be used for and also are redeemable for cash rewards.");

        faqPage.FAQ8.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ8Content.getText(),"\"You may cash out anytime you reach the minimum SBL balance (1000), but there is a significant advantage to hold onto your SBL. As your balance of SBL increases, so does their value. For example, if you have 1000 SBL and want to cash out, you will only make $1 per 100 SBL, whereas if you wait until your balance is 4000 SBL before cashing out, you will earn $1 per 40 SBL. \"");

        faqPage.FAQ9.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ9Content.getText(),"Spitball's rules can be found in our Terms of Service.");

        faqPage.FAQ10.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ10Content.getText(),"If you don’t see your school on Spitball and think we should add it, email us at support@spitball.co");

        faqPage.FAQ11.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ11Content.getText(),"Your class could be new, or none of your classmates have posted documents online. Don’t fret - we have flashcards, tutors and textbooks to help you ace your exams. If you still can’t find what you need, shoot us an email at support@spitball.co or contact us on social media and we’ll try to help you out!");

        faqPage.FAQ12.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ12Content.getText(),"Don’t forget to personalize your results to your university and specific courses. You can do this on the search results page by clicking “Personalize” on the left hand side.");

        faqPage.FAQ13.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ13Content.getText(),"You can contact us through the chat on our homepage, or email us at support@spitball.co");

        faqPage.FAQ14.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ14Content.getText(),"Spitball was created as a community for collaborative learning. Students benefit from sharing knowledge, and our objective is to make students' lives easier by creating one unified platform to meet all of their academic needs. We are founded on the principles of transparency and collaboration and are firmly opposed to plagiarism, cheating, and any form of academic misconduct.");

        faqPage.FAQ15.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ15Content.getText(),"Yes, Spitball is a free service. Some of our partner sites, however, may require you to pay to unlock certain content, meet with a tutor, find homework help or buy a textbook.");

        faqPage.FAQ16.click();
        Thread.sleep(1000);
        Assert.assertEquals(faqPage.FAQ16Content.getText(),"From the search results page, click “Personalize” on the left hand side to update your university and courses. You can also click the three dots in the top right corner of your screen.");

        faqPage.FAQ9.click();
        faqPage.link.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.spitball.co/terms");

    }

    @Test
    public void signUpNavigation() throws InterruptedException {

        driver.get("https://dev.spitball.co");
        Thread.sleep(1000);
        mainPage.SignUpButton.click();
        /*File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File originImage = new File("src/test/resources/SignUp.png");

        Assert.assertEquals(FileUtils.contentEquals(screenShot, originImage),true);*/

        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/register");
    }

    @Test
    public void loginNavigation() {

        driver.get("https://dev.spitball.co");

        mainPage.LoginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.spitball.co/signin");

    }

    @Test
    public void AboutPageContent() throws InterruptedException {

        driver.get("https://dev.spitball.co/about");

        aboutPage.HowWorks.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/about");
        Assert.assertEquals(aboutPage.HowWorks.getAttribute("className"),"v-tabs__item--active v-tabs__item");
        Assert.assertEquals(aboutPage.AboutHeader1.getText(),"What is Spitball?");
        Assert.assertEquals(aboutPage.WhatIsSpitball.getText(),"Simply put, Spitball is the global marketplace for students. Spitball allows students to ask and answer questions, share notes, find tutors, buy & sell textbooks and more - making it the ideal one-stop-shop for students. We bring the best that the internet has to offer students, all together in one place.");
        Assert.assertEquals(aboutPage.AboutHeader2.getText(),"Our Technology");
        Assert.assertEquals(aboutPage.OurTechnology.getText(),"Our platform combines artificial intelligence & machine learning with blockchain technology, bringing students the most relevant content and enabling them to exchange peer-to-peer (P2P) safely & securely. We source directly from students and leading educational websites, so you can forget about the time-consuming and frustrating search process through the tsunami of online content.");
        Assert.assertEquals(aboutPage.AboutHeader3.getText(),"Personalization");
        Assert.assertEquals(aboutPage.Personalization.getText(), "Spitball offers personalized results based on your school, classes, and preferences. Our AI engine combined with your specific user preferences provides curated, relevant results for you. Missed class and need some notes? Spitball it. Need a tutor? Spitball it. Buying textbooks? You get the idea...");

        aboutPage.FAQ.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/faq");
        Assert.assertEquals(aboutPage.FAQ.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        aboutPage.Blog.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/blog");
        Assert.assertEquals(aboutPage.Blog.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        aboutPage.Partners.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/partners");
        Assert.assertEquals(aboutPage.Partners.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        aboutPage.Reps.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/reps");
        Assert.assertEquals(aboutPage.Reps.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        aboutPage.Privacy.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/privacy");
        Assert.assertEquals(aboutPage.Privacy.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        aboutPage.Terms.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dev.spitball.co/terms");
        Assert.assertEquals(aboutPage.Terms.getAttribute("className"),"v-tabs__item--active v-tabs__item");

        aboutPage.Contact.click();
        Thread.sleep(1000);
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

        termsPage.link.click();
        Thread.sleep(3000);
        checkNewWindowAddress("https://www.copyright.gov/legislation/dmca.pdf");

    }

    @Test
    public void PrivacyPageContent() {

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

        privacyPage.link1.click();
        checkNewWindowAddress("https://www.spitball.co/ask");

        privacyPage.link2.click();
        checkNewWindowAddress("https://marketingplatform.google.com/about/");
    }

    @Test
    public void PartnersPageContent() {

        driver.get("https://www.spitball.co/partners");
        Assert.assertEquals(partnersPage.partnerText.getText(), "Does your company make students’ lives easier? Are you interested in joining the community or accepting SBL on your website? Reach out to us at partner@spitball.co");

    }

    @Test
    public void RepsPageContent() {

        driver.get("https://www.spitball.co/reps");
        Assert.assertEquals(repsPage.repsText.getText(), "Want to help grow the Spitball community at your school or university? Reach out to us at work@spitball.co");

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

        Assert.assertEquals(driver.getCurrentUrl(), address);
        driver.close();
        driver.switchTo().window(winHandleBefore);

    }

}
