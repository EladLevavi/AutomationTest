package com.cloudents.AutomationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.*;
import static org.testng.Assert.assertTrue;



public class Common extends CloudentsAutoTests {

    @Test
    public void common() throws InterruptedException {

        for(int i = 0 ; i < 5 ; i++) {
            mainPage.userMenuIcon.click();
            Thread.sleep(1000);
            mainPage.userMenuItems.get(i).click();
            Thread.sleep(1000);
        }
        mainPage.userMenuIcon.click();
        Thread.sleep(1000);
        mainPage.userMenuItems.get(0).click();
        mainPage.homeLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);
        mainPage.moreButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FAQ_PAGE);
        driver.navigate().back();

        for (int i = 0 ; i < 5 ; i++) {
            Thread.sleep(500);
            Assert.assertEquals(mainPage.faqList.get(i).getAttribute("href"), FAQ_PAGE + "?id=" + i);
        }

        mainPage.signButtons.get(0).click();
        Thread.sleep(1000);
        String actualURL = driver.getCurrentUrl();
        assertTrue(actualURL.contains(SIGNUP_PAGE));
        driver.navigate().back();
        mainPage.signButtons.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE);
        driver.navigate().back();

    }

    @Test
    public void mainTabs() throws InterruptedException {

        for(int i = 0 ; i < 6 ; i++) {
            mainPage.tabsContainer.get(i).click();
            Thread.sleep(500);
        }
        for(int i = 0 ; i < 6 ; i++) {
            Assert.assertEquals(mainPage.tabsContainer.get(i).getText(), TABS_TITLE[i]);
        }

    }


}
