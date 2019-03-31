package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Drivers.*;
import static com.cloudents.AutomationTest.Resources.Methods.loginUser;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;




public class Common extends CloudentsAutoTests {

    @Test
    public void header() throws InterruptedException {

        // Buttons Text
        Drivers.driver.navigate().to(HOME_PAGE + "/ask");
        Assert.assertEquals(mainPage.signButtons.get(0).getText(), "Sign Up");
        Assert.assertEquals(mainPage.signButtons.get(0).getAttribute("href"), HOME_PAGE + "/register?returnUrl=%2Fask");
        Assert.assertEquals(mainPage.signButtons.get(1).getText(), "Login");
        Assert.assertEquals(mainPage.signButtons.get(1).getAttribute("href"), HOME_PAGE + "/signin?returnUrl=%2Fask");

        // Search bar
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"), "Search");

        // User menu
        for(int i = 0 ; i < 5 ; i++) {
            mainPage.userMenuIcon.click();
            Thread.sleep(1000);
            Assert.assertEquals(mainPage.userMenuItems.get(i).getAttribute("innerText").trim(), USERMENU_ITEMS[i]);
            if (i != 0) {
                mainPage.userMenuItems.get(i).click();
                Thread.sleep(2000);
            }

            switch(i) {
                case 0: {
                    mainPage.userMenuIcon.click();
                    break;
                }
                case 1: {
                    Assert.assertEquals(driver.getCurrentUrl(), ABOUT_PAGE);
                    break;
                }
                case 2: {
                    Assert.assertEquals(driver.getCurrentUrl(), FAQ_PAGE);
                    break;
                }
                case 3: {
                    Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
                    break;
                }
                case 4: {
                    Assert.assertEquals(driver.getCurrentUrl(), PRIVACY_PAGE);
                    break;
                }
            }
        }

    }

    @Test
    public void mainTabs() throws InterruptedException {

        Drivers.driver.navigate().to(HOME_PAGE + "/ask");
        for(int i = 0 ; i < 5 ; i++) {
            mainPage.tabsContainer.get(i).click();
            Thread.sleep(500);
            Assert.assertEquals(mainPage.tabsContainer.get(i).getText(), TABS_TITLE[i]);
            //Assert.assertEquals(mainPage.tabsContainer.get(i).getAttribute("class"), "v-tabs__item v-tabs__item--active");
        }

    }

}
