package com.cloudents.AutomationTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.*;



public class AboutTabs extends CloudentsAutoTests {


    @Test
    public void mainTabs() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        for(int i=0 ; i < 8 ; i++) {
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
        aboutPage.tabsHeader.get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), ABOUT_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(0).getText(), ABOUT_TABS_TITLE[0]);
        for(int i = 0 ; i < 3 ; i++)
            Assert.assertEquals(aboutPage.paragraphs.get(i).getText(), ABOUT_TEXT[i]);
        /*for(int i = 0 ; i < 3 ; i++) {
            System.out.println(ABOUT_IMAGES[i]);
            System.out.println(aboutPage.images.get(i).getAttribute("src"));
            Assert.assertTrue(aboutPage.images.get(i).getAttribute("src").contains(ABOUT_IMAGES[i]));
        }*/

    }

    @Test
    public void faq() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), FAQ_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(1).getText(), "FAQ");
        for(int i = 0; i < 12 ; i++) {
            aboutPage.faqHeaders.get(i).click();
            Assert.assertEquals(aboutPage.faqHeaders.get(i).getText(),FAQ_HEADERS[i]);
            Thread.sleep(1000);
            Assert.assertEquals(aboutPage.faqText.get(i).getText().trim(),FAQ_TEXT[i]);
            aboutPage.faqHeaders.get(i).click();
            Thread.sleep(1000);
        }
        aboutPage.faqHeaders.get(11).sendKeys(Keys.END);
        Thread.sleep(1000);
        for(int i = 12 ; i < 16 ; i++) {
            aboutPage.faqHeaders.get(i).click();
            Assert.assertEquals(aboutPage.faqHeaders.get(i).getText(),FAQ_HEADERS[i]);
            Thread.sleep(1000);
            Assert.assertEquals(aboutPage.faqText.get(i).getText().trim(),FAQ_TEXT[i]);
            aboutPage.faqHeaders.get(i).click();
            Thread.sleep(1000);
        }
        aboutPage.faqHeaders.get(8).click();
        Assert.assertEquals(mainPage.termsLink.getAttribute("href"), TERMS_PAGE_PROD);
        Thread.sleep(500);
        for(int i=0 ; i < 2 ; i++) {
            aboutPage.faqHeaders.get(i + 9).click();
            Assert.assertEquals(aboutPage.support.get(0).getAttribute("href"), SPITBALL_MAIL);
        }
        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), AMAZON_IMAGE);
        Assert.assertEquals(mainPage.images.get(1).getAttribute("src"), AMAZON_IMAGE);

    }

    @Test
    public void blog() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        Thread.sleep(500);
        Assert.assertEquals(aboutPage.tabsHeader.get(2).getText(), ABOUT_TABS_TITLE[2]);
        aboutPage.tabsHeader.get(2).click();
        for(String winHandle : driver.getWindowHandles())
            driver.switchTo().window(winHandle);
        Assert.assertEquals(driver.getCurrentUrl(), MEDIUM_PAGE);

    }

    @Test
    public void partners() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(3).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), PARTNERS_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(3).getText(), ABOUT_TABS_TITLE[3]);
        Assert.assertEquals(aboutPage.partnersText.getText(), PARTNERS_TEXT);
        //Assert.assertEquals(partnersPage.image.getAttribute("src"), PARTNERS_IMAGE);
        Assert.assertEquals(aboutPage.partnerEmail.getAttribute("href"), PARTNER_MAIL);

    }

    @Test
    public void reps() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(4).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), REPS_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(4).getText(), ABOUT_TABS_TITLE[4]);
        Assert.assertEquals(aboutPage.repsText.getText(), REPS_TEXT);
        //Assert.assertEquals(repsPage.image.getAttribute("src"), REPS_IMAGE);
        Assert.assertEquals(aboutPage.workEmail.getAttribute("href"), WORK_MAIL);

    }

    @Test
    public void privacy() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(5).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), PRIVACY_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(5).getText(), ABOUT_TABS_TITLE[5]);
        Thread.sleep(1000);
        Assert.assertTrue(aboutPage.link1.getAttribute("href").contains(HOME_PAGE_PROD));
        Thread.sleep(2000);
        Assert.assertEquals(aboutPage.link2.getAttribute("href"), GOOGLE_MARKETING);
        Assert.assertEquals(aboutPage.termsText.getText().trim(), PRIVACY_TEXT.trim());
        for (int i = 0 ; i < 2 ; i++)
            Assert.assertEquals(aboutPage.support.get(i).getAttribute("href"), SPITBALL_MAIL);

    }

    @Test
    public void terms() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(6).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(6).getText(), ABOUT_TABS_TITLE[6]);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
        Thread.sleep(1000);
        Assert.assertEquals(aboutPage.copyrights.getAttribute("href"), COPYRIGHTS_DOC);
        Assert.assertEquals(aboutPage.termsText.getText().trim(), TERMS_TEXT.trim());
        Thread.sleep(3000);
        Assert.assertEquals(aboutPage.support.get(0).getAttribute("href"), SPITBALL_MAIL);

    }

    @Test
    public void contact() throws InterruptedException {

        driver.get(ABOUT_PAGE);
        aboutPage.tabsHeader.get(7).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), CONTACT_PAGE);
        Assert.assertEquals(aboutPage.tabsHeader.get(7).getText(), ABOUT_TABS_TITLE[7]);
        Assert.assertEquals(aboutPage.contactText.getText(), CONTACT_TEXT);
        Assert.assertNotNull(aboutPage.map);
        for(int i = 0 ; i < 8 ; i++)
            Assert.assertTrue(aboutPage.links.get(i).getAttribute("href").contains(CONTACT_LINKS[i]));

    }


}
