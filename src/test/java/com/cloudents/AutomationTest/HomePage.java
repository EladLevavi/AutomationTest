package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class HomePage extends CloudentsAutoTests {

    @Test
    public void English() throws InterruptedException {

        Drivers.driver.navigate().to(HOME_PAGE);
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.hebrewButton.getText(), TUTOR_HEBREW);
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.signButtons.get(0).getText(), TUTOR_LOGIN);
        landingPage.signButtons.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), LOGIN_PAGE);
        Drivers.driver.navigate().back();
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.signButtons.get(1).getText(), TUTOR_SIGNUP);
        landingPage.signButtons.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), SIGNUP_PAGE);
        Drivers.driver.navigate().back();
        Thread.sleep(2000);


        // Texts & Links + CTA Button test
        Assert.assertEquals(landingPage.title.getText(), LANDING_TITLE[0]);
        Assert.assertEquals(landingPage.subTitle.getText(), LANDING_SUB_TITLE[0]);
        Assert.assertEquals(landingPage.upperCta.getText(), LANDING_UPPER_CTA);
        landingPage.upperCta.click();
        Thread.sleep(1000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), TUTOR_LIST_PAGE);
        Drivers.driver.navigate().back();
        Thread.sleep(1000);


        for(int i = 0 ; i < 3 ; i++) {
            Assert.assertEquals(landingPage.counters.get(i).getText(), LANDING_COUNTERS[i]);
        }

        Assert.assertEquals(landingPage.secondTitle.getText(), LANDING_SECOND_TITLE);
        Assert.assertEquals(landingPage.secondSubTitle.getText(), LANDING_SECOND_SUBTITLE);
        Assert.assertEquals(landingPage.thirdTitle.getText(), LANDING_THIRD_TITLE);
        Assert.assertEquals(landingPage.thirdSubTitle.getText(), LANDING_THIRD_SUBTITLE);
        Assert.assertEquals(landingPage.rdTitle.getText(), LANDING_FORTH_TITLE);
        Assert.assertEquals(landingPage.rdSubTitle.getText(), LANDING_FORTH_SUBTITLE);
        Assert.assertEquals(landingPage.fifthTitle.getText(), LANDING_FIFTH_TITLE);
        Assert.assertEquals(landingPage.fifthSubTitle.getText(), LANDING_FIFTH_SUBTITLE);
        Assert.assertEquals(landingPage.sixthTitle.getText(), LANDING_SIXTH_TITLE);
        Assert.assertEquals(landingPage.sixthSubTitle.getText(), LANDING_SIXTH_SUBTITLE);
        Assert.assertEquals(landingPage.seventhTitle.getText(), LANDING_SEVENTH_TITLE);
        Assert.assertEquals(landingPage.seventhSubTitle.getText(), LANDING_SEVENTH_SUBTITLE);
        Assert.assertEquals(landingPage.footerTitle.getText(), LANDING_FOOTER_TITLE);
        Assert.assertEquals(landingPage.footerCta.getText(), LANDING_FOOTER_CTA);
        landingPage.signButtons.get(0).sendKeys(Keys.END);
        Thread.sleep(1000);
        landingPage.footerCta.click();
        Thread.sleep(1000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), TUTOR_PAGE);
        Thread.sleep(1000);
        Drivers.driver.navigate().back();
        Thread.sleep(1000);

        footerLinksTest();
        for(int i = 0 ; i < 10 ; i++) {
            landingPage.footerCta.sendKeys(Keys.ARROW_UP);
            Thread.sleep(100);
        }
        landingCarouselTest();

    }

    @Test
    public void Hebrew() throws InterruptedException {

        Drivers.driver.navigate().to(HOME_PAGE);
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.hebrewButton.getText(), TUTOR_HEBREW);
        landingPage.hebrewButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.signButtons.get(0).getText(), TUTOR_LOGIN_H);
        landingPage.signButtons.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), LOGIN_PAGE);
        Drivers.driver.navigate().back();
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.signButtons.get(1).getText(), TUTOR_SIGNUP_H);
        landingPage.signButtons.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), SIGNUP_PAGE);
        Drivers.driver.navigate().back();
        Thread.sleep(2000);



        // Texts & Links + CTA Button test
        Assert.assertEquals(landingPage.title.getText(), LANDING_TITLE_H[0]);
        Assert.assertEquals(landingPage.subTitle.getText(), LANDING_SUB_TITLE_H[0]);
        Assert.assertEquals(landingPage.upperCta.getText(), LANDING_UPPER_CTA_H);
        landingPage.upperCta.click();
        Thread.sleep(1000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), TUTOR_LIST_PAGE);
        Drivers.driver.navigate().back();
        Thread.sleep(1000);


        for(int i = 0 ; i < 3 ; i++) {
            Assert.assertEquals(landingPage.counters.get(i).getText(), LANDING_COUNTERS_H[i]);
        }

        Assert.assertEquals(landingPage.secondTitle.getText(), LANDING_SECOND_TITLE_H);
        Assert.assertEquals(landingPage.secondSubTitle.getText(), LANDING_SECOND_SUBTITLE_H);
        Assert.assertEquals(landingPage.thirdTitle.getText(), LANDING_THIRD_TITLE_H);
        Assert.assertEquals(landingPage.thirdSubTitle.getText(), LANDING_THIRD_SUBTITLE_H);
        Assert.assertEquals(landingPage.rdTitle.getText(), LANDING_FORTH_TITLE_H);
        Assert.assertEquals(landingPage.rdSubTitle.getText(), LANDING_FORTH_SUBTITLE_H);
        Assert.assertEquals(landingPage.fifthTitle.getText(), LANDING_FIFTH_TITLE_H);
        Assert.assertEquals(landingPage.fifthSubTitle.getText(), LANDING_FIFTH_SUBTITLE_H);
        Assert.assertEquals(landingPage.sixthTitle.getText(), LANDING_SIXTH_TITLE_H);
        Assert.assertEquals(landingPage.sixthSubTitle.getText(), LANDING_SIXTH_SUBTITLE_H);
        Assert.assertEquals(landingPage.seventhTitle.getText(), LANDING_SEVENTH_TITLE_H);
        Assert.assertEquals(landingPage.seventhSubTitle.getText(), LANDING_SEVENTH_SUBTITLE_H);
        Assert.assertEquals(landingPage.footerTitle.getText(), LANDING_FOOTER_TITLE_H);
        Assert.assertEquals(landingPage.footerCta.getText(), LANDING_FOOTER_CTA_H);
        landingPage.signButtons.get(0).sendKeys(Keys.END);
        Thread.sleep(1000);
        landingPage.footerCta.click();
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), TUTOR_PAGE);
        Thread.sleep(1000);
        Drivers.driver.navigate().back();
        Thread.sleep(1000);

        footerLinksHebTest();
        landingCarouselHebTest();


    }

}
