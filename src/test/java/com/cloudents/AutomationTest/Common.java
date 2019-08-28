package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Drivers.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;




public class Common extends CloudentsAutoTests {

    @Test
    public void header() throws InterruptedException {

        // Buttons Text
        Drivers.driver.navigate().to(HOMEWORK_PAGE);
        for(int i = 0 ; i < 2 ; i++) {
            Assert.assertTrue(mainPage.signButtons.get(i).getText().equalsIgnoreCase(SIGN_BUTTONS[i]));
        }
        Assert.assertEquals(mainPage.signButtons.get(0).getAttribute("href"), SIGNUP_ASK);
        Assert.assertEquals(mainPage.signButtons.get(1).getAttribute("href"), LOGIN_ASK);


        // Open the user menu
        mainPage.userMenuIcon.click();

        // Testing user menu
        for(int i = 0 ; i < 6 ; i++) {
            Assert.assertTrue(mainPage.userMenuItems.get(i).getAttribute("innerText").trim().equalsIgnoreCase(USERMENU_ITEMS[i]));
            if (i > 1) {
                mainPage.userMenuItems.get(i).click();
                Thread.sleep(2000);
                Assert.assertEquals(driver.getCurrentUrl(), USERMENU_LINKS[i]);
                driver.navigate().back();
                Thread.sleep(2000);
                mainPage.userMenuIcon.click();
            }
        }


        // Action Box
        for(int i = 0 ; i < 3 ; i++) {
            mainPage.actionButtons.get(0).click();
            Assert.assertNotNull(mainPage.loginPopup);
            mainPage.closePopup.click();
            Thread.sleep(1000);
        }


        mainPage.userMenuIcon.click();
        Thread.sleep(1000);
        mainPage.userMenuItems.get(1).click();
        Thread.sleep(1000);
        mainPage.userMenuIcon.click();
        Thread.sleep(1000);
        mainPage.userMenuItems.get(0).click();
        Thread.sleep(1000);

    }

    @Test
    public void mainTabs() throws InterruptedException {

        Drivers.driver.navigate().to(HOMEWORK_PAGE);

        for(int i = 1 ; i < 3 ; i++) {
            Assert.assertEquals(mainPage.tabsContainer.get(i).getAttribute("class"), "v-tabs__item");
        }

        for(int i = 0 ; i < 3 ; i++) {
            mainPage.tabsContainer.get(i).click();
            Thread.sleep(500);
            Assert.assertEquals(mainPage.tabsContainer.get(i).getText(), TABS_TITLE[i]);
            Assert.assertEquals(mainPage.tabsContainer.get(i).getAttribute("class"), "v-tabs__item v-tabs__item--active header-tab-active");
            Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"), SEARCHBAR_PLACEHOLDERS[i]);
        }

        for(int i = 0 ; i < 2 ; i++) {
            Assert.assertEquals(mainPage.tabsContainer.get(i).getAttribute("class"), "v-tabs__item");
        }

    }

}
