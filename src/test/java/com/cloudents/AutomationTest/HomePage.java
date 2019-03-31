package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Drivers.driver;
import static com.cloudents.AutomationTest.Resources.Methods.newWindow;




public class HomePage extends CloudentsAutoTests {

    @Test
    public void fullTest() throws InterruptedException {

        Actions action = new Actions(Drivers.driver);
        final String statHeaders[] = {"Total Answers", "Points Traded", "Money Earned", "Happy Students", "סך כל התשובות", "נקודות שנפדו לכסף", "סך הרווחים של חברי הקהילה", "סטודנטים מרוצים"};
        final String menuItems[] = {"עברית", "About Spitball", "Help", "Terms Of Service", "Privacy Policy", "English", "אודות Spitball", "עזרה", "תנאי השירות", "מדיניות פרטיות"};
        final String pages[]  ={"spitball.co/about", "spitball.co/faq", "spitball.co/terms", "spitball.co/privacy"};
        final String faqTitles[] = {"What is Spitball?", "How does Spitball differ from other websites?", "How does Spitball work?", "Wait, Points are worth real money?", "How do I get points?", "Wait, what’s the catch?","מה זה בעצם ספיטבול?", "במה ספיטבול שונה מאתרים אחרים?", "איך זה עובד?", "רגע - נקודות שוות כסף אמיתי?", "איך אפשר לצבור נקודות?", "אוקי אוקי - אז מה האותיות הקטנות?"};
        final String faqTexts[] = {"Spitball is The First Online Marketplace where students acquire knowledge while earning from helping each other succeed in school. Our platform allows students to ask and answer homework questions, share study documents, buy books and so much more. On Spitball, students learn and earn while helping each other.",
                "Spitball brings power back to the students, no subscription fees, no ads, no catch. With Spitball you get the tools to learn smarter and earn points so you can enjoy life.",
                "Students that need help with their studies, choose their campus and class browse study documents or ask homework questions. Students that know the answer will help solve these problems, and the most helpful answer or document gets rewarded with points.",
                "Pts is the reward system used on the Spitball platform. Points can be converted into real money through Amazon Gift cards.",
                "You get points when you register and earn more points by helping others or referring friends.",
                "There is no catch. Earned points are redeemable for Amazon gift cards. So there is no reason not to sign up today."};
        final String reviewNames[] = {"Donna Floyd", "Sarah Friedman", "Daniel Kaplan","ורד סלקמן", "חן נעים", "טובי כהן"};
        final String reviewTitles[] = {"Sophomore at UC Davis", "Junior at UC Berkeley", "Senior at UCLA", "האוניברסיטה הפתוחה", "המכללה האקדמית אשקלון", "האוניברסיטה הפתוחה"};
        final String reviewTexts[] = {"As a sophomore, I found myself looking for a new way to communicate and study with my classmates. After searching online, I was shocked that there was no real solution that fit my lifestyle (nothing I could easily access on my phone or computer). Then someone invited me to Spitball... it saved me.",
                "There have been many times when I would try to share files or a document with classmates over the school’s portal or other online studying tools, but it was a huge hassle! Then I started using Spitball and everything changed - I was easily able to upload all of my files, even video and audio files!",
                "It’s so nice to have all my notes, questions, answers, lectures, etc. in one place and always available online and in the palm of my hand! Spitball comes in handy when I need to compare class notes. Thank you Spitball for making my life a whole lot easier! I already know whom I have to thank first on graduation day :)",
                "כל הכבוד על היוזמה. אתר טוב מאוד ויעיל. תודה רבה", "אוהבים את הכל!!! אין על האתר הזה, הכי עוזר שיש", "אתר מדהים! ממשק פשוט ונוח מאגר חומרי לימוד יעיל ועדכני"};
        final String subjectsList[] = {"Accounting", "Anthropology", "Arts", "Biology", "Blockchain", "Business", "Chemistry", "Computer Science", "Economics", "Education", "Geography",
                "Health & Medicine", "History", "Languages", "Law & Politics", "Literature", "Mathematics", "Physics", "Psychology", "Religion/Philosophy", "Social Studies", "Sports", "Technology", "Miscellaneous",
                "אומנות", "אנתרופולוגיה", "ביולוגיה", "בלוקצ'יין", "בריאות ורפואה", "גיאוגרפיה", "דת ופילוסופיה", "היסטוריה", "חינוך", "חשבונאות", "טכנולוגיה", "כימיה", "כלכלה", "מדעי החברה", "מדעי המחשב", "משפטים ופוליטיקה",
                "מתמטיקה", "ספורט", "ספרות", "עסקים", "פיזיקה", "פסיכולוגיה", "שפות", "שונות"};
        final String socialLinks[] = {"medium.com/@spitballstudy", "www.linkedin.com", "https://www.facebook.com/spitballstudy/", "https://www.youtube.com/channel/UC9qGHTJixreP2bbwugmSi2Q?view_as=subscriber",
                "https://t.me/Spitball", "https://twitter.com/SpitballStudy"};
        final String footerLinks[] = {"about", "reps", "", "partners", "terms", "faq", "privacy", "", "contact", "blog", "אודות ספיטבול", "שגרירים", "פידבק", "שותפויות", "תנאי שימוש", "שאלות נפוצות", "מדיניות פרטיות", "יחסי ציבור", "צור קשר", "בלוג"};
        final String cookieText[] = {"This website uses cookies to ensure you get the best experience", "Got it", "אתר אינטרנט זה נעזר בקובצי \"עוגיות\" כדי להבטיח לך חוויה מיטבית", "הבנתי"};
        final String pagesRedirect[] = {"/signin", "/register", "/note", "mailto"};
        final String buttonCaptions[] = {"Login", "Sign Up", "כניסה", "הרשמה"};
        final String headerTitles[] = {"Study Faster, Enjoy College", "Turn Your Study Docs into Cash", "חולמים על שיעורי בית מושלמים?", "מסמכי הלימוד שלך שווים כסף"};
        final String headerSubTitles[] = {"Quickly boost your GPA with instant help and thousands of study docs", "Upload class-specific study documents and start earning!", "שפרו ציונים וקבלו גם סיוע בשיעורי הבית וגם גישה לאלפי מסמכי לימוד", "פשוט להעלות מסמכי לימוד מהקורס שלך ולהתחיל להרוויח כסף"};
        final String titles1[] = {"Get Solutions to Homework Questions", "Answer Homework Questions, Get Gift Cards", "עבודה להגשה שתקועה בשאלה קשה?", "עונים על שאלות - צוברים נקודות!"};
        final String subTitles1[] = {"80% of questions get answered in under 1 minute", "Earn Points And Exchange Them To Gift Cards", "80% מהשאלות שעולות בקהילת ספיטבול, זוכות למענה תוך פחות מדקה!", "צברו נקודות ופדו אותן ב- BuyMe"};
        final String titles2[] = {"Find study resources", "Your study documents have real value", "קבלו גישה לאלפי חומרי לימוד רלוונטיים אליכם", "תחלקו ותרוויחו מהידע האקדמי שלכם"};
        final String subTitles2[] = {"Download Class Notes, Study Guides And Exam Preparations", "Upload Class Notes, Study Guides and Exams Preparations now!", "מצאו את הקובץ המתאים לכיתתכם עכשיו", "העלו עכשיו מסמכי לימוד שיצרתם וסייעו לסטודנטים אחרים"};
        final String ctaButtons[] = {"Join Spitball it's 100% Free", "Upload and Earn", "Get Your Points", "SIGN UP", "נסו, זה בחינם","להרוויח עכשיו", "להרשמה וקבלת נקודות", "הרשמה"};
        final String learnEarn[] = {"Learn Faster", "Earn money", "ללמוד מהר", "להרוויח יותר"};
        final String placeholders[] = {"Choose subject", "What is your school?", "Show all schools", "בחר נושא", "בחר מוסד אקדמי", "הצג את כל מוסדות הלימודים"};
        final String sectionTitles[] = {"Students Talk about Spitball", "Find Homework Help By Subject", "Just pick a subject, and find relevant questions for you", "Join Spitball it's Free!", "הסטודנטים של קהילת ספיטבול מדברים עלינו", "מצא שיעורי בית לפי נושא", "פשוט בחר נושא, ומצא שאלות רלוונטיות עבורך", "הצטרפו, זה בחינם!"};
        final String videoText[] = {"See how it works", "איך זה עובד"};
        final String selectedSection = "lp-header-link mr-4 yellow-text";






        // Bottom Cookie Banner test
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.cookieText.getText(), cookieText[0]);
        Assert.assertEquals(landingPage.cookieButton.getText(), cookieText[1]);
        landingPage.cookieButton.click();


        // Signup & Login buttons test
        Assert.assertEquals(landingPage.loginButton.getText() , buttonCaptions[0]);
        Assert.assertTrue(landingPage.loginButton.getAttribute("href").contains(pagesRedirect[0]));
        Assert.assertEquals(landingPage.signupButton.getText() , buttonCaptions[1]);
        Assert.assertTrue(landingPage.signupButton.getAttribute("href").contains(pagesRedirect[1]));



        // User menu test
        for(int i = 1 ; i < 5 ; i++) {
            landingPage.userMenu.click();
            Thread.sleep(1500);
            Assert.assertEquals(landingPage.userItems.get(i).getText(), menuItems[i]);
            landingPage.userItems.get(i).click();
            Thread.sleep(1500);
            Assert.assertTrue(Drivers.driver.getCurrentUrl().contains(pages[i - 1]));
            Drivers.driver.navigate().back();
            Thread.sleep(1500);
        }


        // Texts & Links + CTA Button test both learn & earn
        Assert.assertEquals(landingPage.learnLink.getText(), learnEarn[0]);
        Assert.assertEquals(landingPage.earnLink.getText(), learnEarn[1]);
        landingPage.learnLink.click();
        Thread.sleep(1500);
        Assert.assertEquals(landingPage.learnLink.getAttribute("class"), selectedSection);
        Assert.assertEquals(landingPage.headerTitle.getText(), headerTitles[0]);
        Assert.assertEquals(landingPage.headerSubTitle.getText(), headerSubTitles[0]);
        Assert.assertEquals(landingPage.ctaButton.getText(), ctaButtons[0]);
        Assert.assertEquals(landingPage.title1.getText(), titles1[0]);
        Assert.assertEquals(landingPage.subTitle1.getText(), subTitles1[0]);
        Assert.assertEquals(landingPage.title2.getText(), titles2[0]);
        Assert.assertEquals(landingPage.subTitle2.getText(), subTitles2[0]);
        Assert.assertEquals(landingPage.ctaButton.getText(), ctaButtons[0]);
        Assert.assertTrue(landingPage.ctaButton.getAttribute("href").contains(pagesRedirect[1]));
        Assert.assertEquals(landingPage.earnLink.getText(), learnEarn[1]);
        landingPage.earnLink.click();
        Thread.sleep(1500);
        Assert.assertEquals(landingPage.earnLink.getAttribute("class"), selectedSection);
        Assert.assertEquals(landingPage.headerTitle.getText(), headerTitles[1]);
        Assert.assertEquals(landingPage.headerSubTitle.getText(), headerSubTitles[1]);
        Assert.assertEquals(landingPage.title1.getText(), titles1[1]);
        Assert.assertEquals(landingPage.subTitle1.getText(), subTitles1[1]);
        Assert.assertEquals(landingPage.title2.getText(), titles2[1]);
        Assert.assertEquals(landingPage.subTitle2.getText(), subTitles2[1]);
        Assert.assertEquals(landingPage.ctaButton.getText(), ctaButtons[1]);
        Assert.assertTrue(landingPage.ctaButton.getAttribute("href").contains(pagesRedirect[2]));
        for(int i = 0 ; i < 3 ; i++) {
            Assert.assertTrue(landingPage.statHeaders.get(i).getText().contains(statHeaders[i]));
        }


        // Dropdown Lists & animated gifs test
        action.sendKeys(Keys.SPACE).perform();
        Thread.sleep(1000);
        Assert.assertEquals(landingPage.dropdownLists.get(0).getAttribute("placeholder"), placeholders[0]);
        Assert.assertNotNull(landingPage.gifImage1);
        landingPage.dropdownLists.get(0).click();
        Thread.sleep(1000);
        for(int i = 0 ; i < 20 ; i++) {
            Assert.assertEquals(landingPage.dropdownItems.get(i).getText(), subjectsList[i]);
            Thread.sleep(500);
        }
        landingPage.dropdownLists.get(0).click();
        Thread.sleep(1000);
        action.sendKeys(Keys.SPACE).perform();
        action.moveToElement(landingPage.title2);
        Assert.assertEquals(landingPage.dropdownLists.get(1).getAttribute("placeholder"), placeholders[1]);
        Assert.assertNotNull(landingPage.gifImage2);
        landingPage.dropdownLists.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.schoolItem.getText(), placeholders[2]);
        landingPage.dropdownLists.get(1).click();


        // FAQ Text Section test
        action.moveToElement(landingPage.faqTitle.get(0));
        Thread.sleep(1000);
        for(int i = 0 ; i< 6 ; i++) {
            Assert.assertEquals(landingPage.faqTitle.get(i).getText(), faqTitles[i]);
            Assert.assertEquals(landingPage.faqText.get(i).getText(), faqTexts[i]);
        }


        // Student Reviews Text & CTA Button Test
        action.moveToElement(landingPage.reviewsTitle);
        Thread.sleep(1000);
        Assert.assertEquals(landingPage.faqCta.getText(), ctaButtons[2]);
        Assert.assertTrue(landingPage.faqCta.getAttribute("href").contains(pagesRedirect[1]));
        Assert.assertEquals(landingPage.reviewsTitle.getText(), sectionTitles[0]);
        for(int i = 0 ; i < 3 ; i++) {
            Assert.assertEquals(landingPage.reviewNames.get(i).getText(), reviewNames[i]);
            Assert.assertEquals(landingPage.reviewTitles.get(i).getText(), reviewTitles[i]);
            Assert.assertEquals(landingPage.reviewTexts.get(i).getText(), reviewTexts[i]);
        }


        // Subjects Section Texts & Links Test
        action.moveToElement(landingPage.footerCta);
        Thread.sleep(1000);
        Assert.assertEquals(landingPage.subjectTitle.getText(), sectionTitles[1]);
        Assert.assertEquals(landingPage.subjectSubTitle.getText(), sectionTitles[2]);
        for(int i = 0 ; i < 24 ; i++) {
            Assert.assertEquals(landingPage.subjectsList.get(i).getText().toLowerCase(), subjectsList[i].toLowerCase());
        }


        // Join Section CTA Button & Social Links Test
        action.moveToElement(landingPage.footerTitle);
        Thread.sleep(1000);
        Assert.assertEquals(landingPage.footerTitle.getText(), sectionTitles[3]);
        Assert.assertEquals(landingPage.footerCta.getText(), ctaButtons[3]);
        Assert.assertTrue(landingPage.footerCta.getAttribute("href").contains(pagesRedirect[1]));
        for(int i = 0 ; i < 6 ; i++) {
            Assert.assertTrue(landingPage.socialLinks.get(i).getAttribute("href").contains(socialLinks[i]));
            Thread.sleep(2000);
        }
        for(int i = 0 ; i < 10 ; i++) {
            if (i == 2 || i == 7) {
                Thread.sleep(1000);
                Assert.assertTrue(landingPage.footerLinks.get(i).getAttribute("href").contains(pagesRedirect[3]));
            }
            else {
                Assert.assertTrue(landingPage.footerLinks.get(i).getAttribute("href").contains(footerLinks[i]));
                Thread.sleep(1000);
            }
        }


        // Header fixed Test
        landingPage.userMenu.click();
        Thread.sleep(1000);
        landingPage.footerTitle.click();
        Thread.sleep(1000);




        // Embedded Video Link Test
        if (Drivers.driver instanceof FirefoxDriver)
            landingPage.headerTitle.click();
        else
            action.sendKeys(Keys.HOME).perform();


        Assert.assertEquals(landingPage.videoLink.getText(), videoText[0]);
        landingPage.videoLink.click();
        Thread.sleep(2000);

    }

}
