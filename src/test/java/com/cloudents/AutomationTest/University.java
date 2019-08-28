package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class University extends CloudentsAutoTests {

    @Test
    public void university() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);
        mainPage.userMenuIcon.click();
        Thread.sleep(500);
        mainPage.userMenuItems.get(2).click();
        Thread.sleep(1000);


        Assert.assertEquals(universityPage.title.getText(), UNIVERSITY_TITLE);
        Assert.assertEquals(universityPage.doneButton.getText(), UNIVERSITY_DONE);
        Assert.assertEquals(universityPage.universityInput.getAttribute("placeholder"), UNIVERSITY_INPUT_PLACEHOLDER);
        Assert.assertEquals(universityPage.universityResults.size(),30);
        universityPage.universityResults.get(3).click();
        mainPage.userMenuIcon.click();
        Thread.sleep(500);
        mainPage.userMenuItems.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(profilePage.university.getText(), UNIVERSITY_BAR_ILAN);
        mainPage.userMenuIcon.click();
        Thread.sleep(500);
        mainPage.userMenuItems.get(2).click();
        Thread.sleep(1000);
        universityPage.doneButton.click();
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), STUDY_PAGE);
        Thread.sleep(2000);

    }

}
