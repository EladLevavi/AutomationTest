package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class Profile extends CloudentsAutoTests {

    @Test
    public void tutorProfile() throws InterruptedException {

        Drivers.driver.navigate().to(PROFILE_USER_PAGE);
        Thread.sleep(1000);
        for(int i = 0 ; i < 5 ; i++) {
            profilePage.profileTabs.get(i).click();
            Thread.sleep(1000);
            Assert.assertEquals(profilePage.profileTabs.get(i).getText(), PROFILE_TABS[i]);
            Assert.assertTrue(profilePage.profileTabs.get(i).getAttribute("class").contains(PROFILE_ACTIVE));
            for(int j = 4 ; j > i ; j--)
                Assert.assertFalse(profilePage.profileTabs.get(j).getAttribute("class").contains(PROFILE_ACTIVE));
        }

        profilePage.profileTabs.get(0).click();
        Assert.assertEquals(profilePage.introText.getText(), PROFILE_INTRO);
        Assert.assertFalse(profilePage.userName.getText().contains(PROFILE_UNDEFINED));
        Assert.assertTrue(profilePage.priceHour.get(0).getText().equalsIgnoreCase(PROFILE_PRICE));
        //Assert.assertTrue(profilePage.priceHour.get(1).getText().equalsIgnoreCase(PROFILE_PRICE));
        Assert.assertEquals(profilePage.bioTitle.getText(), PROFILE_BIO);
        Assert.assertEquals(profilePage.coursesTitle.get(0).getText(), PROFILE_COURSES);
        Assert.assertEquals(profilePage.reviewsTitle.getText(), PROFILE_REVIEWS);

    }

    @Test
    public void studentProfile() throws InterruptedException {

        Drivers.driver.navigate().to(PROFILE_OTHER_USER_PAGE);
        Thread.sleep(1000);
        for(int i = 0 ; i < 5 ; i++) {
            profilePage.profileTabs.get(i).click();
            Thread.sleep(1000);
            Assert.assertEquals(profilePage.profileTabs.get(i).getText(), PROFILE_TABS[i]);
            Assert.assertTrue(profilePage.profileTabs.get(i).getAttribute("class").contains(PROFILE_ACTIVE));
            for(int j = 4 ; j > i ; j--)
                Assert.assertFalse(profilePage.profileTabs.get(j).getAttribute("class").contains(PROFILE_ACTIVE));
        }

        profilePage.profileTabs.get(0).click();
        Assert.assertEquals(profilePage.introText.getText(), PROFILE_INTRO);
        Assert.assertFalse(profilePage.userName.getText().contains(PROFILE_UNDEFINED));
        Assert.assertEquals(profilePage.coursesTitle.get(1).getText(), PROFILE_MY_COURSES);

    }

}
