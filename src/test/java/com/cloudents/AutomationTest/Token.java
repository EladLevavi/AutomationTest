package com.cloudents.AutomationTest;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.cloudents.AutomationTest.Resources.*;
import static com.cloudents.AutomationTest.Resources.scroll;
import static com.cloudents.AutomationTest.Resources.tokenPage;

public class Token extends CloudentsAutoTests {


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
        tokenPage.emailText.sendKeys(USERNAME);
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
        tokenPage.contactForm.get(1).sendKeys(FIRST_NAME);
        tokenPage.contactForm.get(2).sendKeys(USER_NAME);
        tokenPage.contactForm.get(3).sendKeys(MESSAGE);
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
        //checkNewWindowAddress(TOKEN_PAGE);

    }


}
