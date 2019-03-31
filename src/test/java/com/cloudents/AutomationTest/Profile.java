package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.Pages.HOME_PAGE;
import static com.cloudents.AutomationTest.Resources.Strings.PROFILE_MENU;

public class Profile extends CloudentsAutoTests {

    @Test
    public void profile() throws InterruptedException {

        Drivers.driver.navigate().to(HOME_PAGE + "/profile/159039");
        Thread.sleep(1000);
        for(int i = 0 ; i < 4 ; i++) {
            profilePage.profileMenu.get(i).click();
            Thread.sleep(1000);
            Assert.assertEquals(profilePage.profileMenu.get(i).getText(), PROFILE_MENU[i]);
            Assert.assertEquals(profilePage.profileMenu.get(i).getAttribute("class"),"active");
            if (i != 0) {
                Assert.assertNotEquals(profilePage.profileMenu.get(i-1).getAttribute("class"), "active");
            }
        }

    }

}
