package com.cloudents.AutomationTest;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static com.cloudents.AutomationTest.Resources.*;



public class Token extends CloudentsAutoTests {


    @Test
    public void token() throws InterruptedException {

        driver.get(TOKEN_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(tokenPage.logoHeaderLink.getAttribute("href"), HOME_PAGE_PROD);
        Assert.assertNotNull(tokenPage.youtube);
        tokenPage.logo.get(0).click();
        newWindow(HOME_PAGE_PROD);
        for(int i = 0 ; i < 3 ; i++) {
            tokenPage.headerLinks.get(i).click();
            newWindow(TOKEN_HEADER_LINKS[i]);
        }
        Assert.assertEquals(tokenPage.emailText.getAttribute("placeholder"), "Enter your email");
        tokenPage.emailText.sendKeys(USERNAME);
        //tokenPage.subscribeButton.click();
        //Assert.assertNull(tokenPage.emailText.getText());
        //scroll(tokenPage.innerLinks.get(0), 22);
        Assert.assertEquals(tokenPage.images.get(3).getAttribute("src"), HEVRA_IMAGE);
        //scroll(tokenPage.innerLinks.get(0) , 22);
        Assert.assertEquals(tokenPage.images.get(4).getAttribute("src"), SPITBALL_APP_IMAGE);
        //scroll(tokenPage.innerLinks.get(0), 22);
        Assert.assertEquals(tokenPage.images.get(5).getAttribute("src"), ECONOMY_IMAGE);
        //scroll(tokenPage.innerLinks.get(0), 44);
        for(int i=6, j=0 ; i < 22 ; i+=2, j++) {
            Assert.assertEquals(tokenPage.images.get(i).getAttribute("src"), PERSONAL_IMAGES[j]);
        }
        Thread.sleep(1000);
        //scroll(tokenPage.innerLinks.get(0), 22);
        Assert.assertEquals(tokenPage.images.get(22).getAttribute("src"), TOKEN_PARTNERS_IMAGE);
        Thread.sleep(1000);
        //scroll(tokenPage.innerLinks.get(0), 17);
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(tokenPage.contactFields.get(0)).perform();
        Assert.assertEquals(tokenPage.contactFields.get(0).getText(), "Your Name");
        Assert.assertEquals(tokenPage.contactFields.get(1).getText(), "Your Email");
        Assert.assertEquals(tokenPage.contactFields.get(2).getText(), "Your Message");
        tokenPage.contactForm.get(0).sendKeys(FIRST_NAME);
        tokenPage.contactForm.get(1).sendKeys(USERNAME);
        tokenPage.textArea.sendKeys(MESSAGE);
            /*tokenPage.submitButton.click();
            Assert.assertEquals(tokenPage.contactForm.get(1).getText(), "");
            Assert.assertEquals(tokenPage.contactForm.get(2).getText(), "");
            Assert.assertEquals(tokenPage.contactForm.get(3).getText(), "");*/
        tokenPage.support.click();
        tokenPage.joinTelegram.get(1).click();
        Thread.sleep(1000);
        //checkNewWindowAddress(TELEGRAM_PAGE);
        //scroll(tokenPage.innerLinks.get(0), 15);
        Thread.sleep(1000);
        for(int i = 0 ; i < 7 ; i++) {
            tokenPage.socialLinks.get(i).click();
            Thread.sleep(1000);
            //checkNewWindowAddress(TOKEN_SOCIAL[i]);
        }
        /*tokenPage.innerLinks.get(6).click();
        Thread.sleep(5000);
        //checkNewWindowAddress(WHITEPAPER_DOC);
        tokenPage.innerLinks.get(7).click();
        Thread.sleep(1000);
        //checkNewWindowAddress(HOME_PAGE_PROD);
        tokenPage.footerLinks.get(0).click();
        Thread.sleep(1000);
        //checkNewWindowAddress(PRIVACY_PAGE_PROD);
        tokenPage.footerLinks.get(1).click();
        Thread.sleep(1000);
        //checkNewWindowAddress(TERMS_PAGE_PROD);
        for(int i = 0 ; i < 4 ; i++) {
            tokenPage.innerLinks.get(i).click();
            Thread.sleep(1000);
            //scroll(tokenPage.innerLinks.get(i),50);
            Thread.sleep(1000);
        }
        tokenPage.footerBrand.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TOKEN_PAGE + "/");*/
    }


}
