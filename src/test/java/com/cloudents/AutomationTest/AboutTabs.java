package com.cloudents.AutomationTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.*;
import static com.cloudents.AutomationTest.Resources.aboutPage;
import static com.cloudents.AutomationTest.Resources.contactPage;

public class AboutTabs extends CloudentsAutoTests {


    @Test
    public void mainTabs() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        for(int i = 0 ; i < 8 ; i++) {
            Thread.sleep(1000);
            Assert.assertEquals(aboutPage.tabsHeader.get(i).getText(), ABOUT_TABS_TITLE[i]);
            aboutPage.tabsHeader.get(i).click();
            if (i == 2) {
                Thread.sleep(1000);
                driver.switchTo().window(winHandleBefore);
            }
        }

    }

    @Test
    public void about() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(1000);
        aboutPage.tabsHeader.get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), ABOUT_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(0).getText().trim(), ABOUT_TABS_TITLE[0]);
        /*for(int i = 0 ; i < 3 ; i++) {
            Assert.assertTrue(aboutPage.images.get(i).getAttribute("src").contains(ABOUT_IMAGES[i]));
        }*/

    }

    @Test
    public void FAQ() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(1000);
        Assert.assertEquals(aboutPage.tabsHeader.get(1).getText(), ABOUT_TABS_TITLE[1]);
        aboutPage.tabsHeader.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FAQ_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(1).getText().trim(), "FAQ");
        for(int i = 0 ; i < 11 ; i++) {
            faqPage.FaqHeaders.get(i).click();
            faqPage.FaqHeaders.get(i).click();
            Thread.sleep(2000);
        }
        faqPage.FaqHeaders.get(11).sendKeys(Keys.END);
        for(int i = 11 ; i < 16 ; i++) {
            faqPage.FaqHeaders.get(i).click();
            faqPage.FaqHeaders.get(i).click();
            Thread.sleep(2000);
        }
        Thread.sleep(1000);
        faqPage.FaqHeaders.get(8).click();
        Assert.assertEquals(mainPage.termsLink.getAttribute("href"), TERMS_PAGE_PROD);
        Thread.sleep(3000);
        for(int i=0 ; i < 2 ; i++) {
            faqPage.FaqHeaders.get(i + 9).click();
            Assert.assertEquals(faqPage.support.getAttribute("href"), SPITBALL_MAIL);
        }
        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), AMAZON_IMAGE);
        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), AMAZON_IMAGE);

    }

    @Test
    public void blog() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(1000);
        Assert.assertEquals(aboutPage.tabsHeader.get(2).getText(), ABOUT_TABS_TITLE[2]);
        aboutPage.tabsHeader.get(2).click();
        Thread.sleep(2000);
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        Assert.assertEquals(driver.getCurrentUrl(), MEDIUM_PAGE);

    }

    @Test
    public void partners() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(1000);
        Assert.assertEquals(aboutPage.tabsHeader.get(3).getText(), ABOUT_TABS_TITLE[3]);
        aboutPage.tabsHeader.get(3).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), PARTNERS_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(3).getText().trim(), "Partners");
        //Assert.assertEquals(partnersPage.image.getAttribute("src"), PARTNERS_IMAGE);
        partnersPage.partnerEmail.click();

    }

    @Test
    public void reps() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(1000);
        aboutPage.tabsHeader.get(4).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), REPS_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(4).getText().trim(), "Reps");
        //Assert.assertEquals(repsPage.image.getAttribute("src"), REPS_IMAGE);
        repsPage.workEmail.click();

    }

    @Test
    public void privacy() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(1000);
        aboutPage.tabsHeader.get(5).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), PRIVACY_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(5).getText().trim(), ABOUT_TABS_TITLE[5]);
        Assert.assertTrue(privacyPage.links.get(0).getAttribute("href").contains(HOME_PAGE_PROD));
        Thread.sleep(500);
        Assert.assertEquals(privacyPage.links.get(1).getAttribute("href"), GOOGLE_MARKETING);

    }

    @Test
    public void terms() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(1000);
        aboutPage.tabsHeader.get(6).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(6).getText().trim(), ABOUT_TABS_TITLE[6]);
        Thread.sleep(1000);
        Assert.assertEquals(termsPage.links.get(0).getAttribute("href"), COPYRIGHTS_DOC);
        Assert.assertEquals(termsPage.links.get(1).getAttribute("href"), SPITBALL_MAIL);

    }

    @Test
    public void contact() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(1000);
        aboutPage.tabsHeader.get(7).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), CONTACT_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(7).getText().trim(), ABOUT_TABS_TITLE[7]);
        Assert.assertNotNull(contactPage.map);
        for(int i = 0 ; i < 8 ; i++) {
            Assert.assertTrue(contactPage.links.get(i).getAttribute("href").contains(CONTACT_LINKS[i]));
        }

    }

}
