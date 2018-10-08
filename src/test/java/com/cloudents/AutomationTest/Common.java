package com.cloudents.AutomationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.*;
import static com.cloudents.AutomationTest.Resources.TABS_TITLE;
import static com.cloudents.AutomationTest.Resources.mainPage;
import static org.testng.Assert.assertTrue;

public class Common extends CloudentsAutoTests {


    @Test
    public void common() throws InterruptedException {

        mainPage.homeLink.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);
        mainPage.moreButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), FAQ_PAGE);
        driver.navigate().back();

        for (int i = 0 ; i < 5 ; i++) {
            Thread.sleep(5000);
            Assert.assertEquals(mainPage.FAQlist.get(i).getAttribute("href"), FAQ_PAGE + "?id=" + i);
        }

        mainPage.signButtons.get(0).click();
        Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        assertTrue(actualURL.contains(SIGNUP_PAGE));
        driver.navigate().back();
        mainPage.signButtons.get(1).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE);

    }

    @Test
    public void mainTabs() throws InterruptedException {

        driver.get(HOME_PAGE);
        for(int i = 0; i < 6 ; i++) {
            mainPage.tabsContainer.get(i).click();
            Thread.sleep(1000);
        }
        for(int i = 0 ; i < 6 ; i++) {
            Assert.assertEquals(mainPage.tabsContainer.get(i).getText().trim(), TABS_TITLE[i]);
        }

    }


}
