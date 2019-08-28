package com.cloudents.AutomationTest.Obsolete;

import com.cloudents.AutomationTest.CloudentsAutoTests;
import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.Methods.loginUser;
import static com.cloudents.AutomationTest.Resources.Strings.*;

public class OnBoarding extends CloudentsAutoTests {

    @Test
    public void onboarding() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(3000);

        for(int i = 0 ; i < 2 ; i++) {
            Assert.assertEquals(mainPage.stepTitle.get(i).getText(), ONBOARDING_TITLES[i]);
            Assert.assertEquals(mainPage.bottomText.get(i).getText(), ONBOARDING_BOTTOM_TEXT[i]);
            Assert.assertEquals(mainPage.nextWindow.getText(), "Continue");
            Assert.assertEquals(mainPage.skipButton.getText(), "Skip");
            mainPage.nextWindow.click();
            Thread.sleep(500);
        }

        Assert.assertEquals(mainPage.finalStep.getText(), ONBOARDING_TITLES[2]);
        Assert.assertEquals(mainPage.finalText.getText(), ONBOARDING_FINAL_TEXT);
        Assert.assertEquals(mainPage.finishButton.getText(), "Finish");

        Drivers.driver.navigate().refresh();
        mainPage.skipButton.click();
        Thread.sleep(500);
        Assert.assertEquals(mainPage.finalStep.getText(), ONBOARDING_TITLES[2]);
        Assert.assertEquals(mainPage.finalText.getText(), ONBOARDING_FINAL_TEXT);
        Assert.assertEquals(mainPage.finishButton.getText(), "Finish");

        Drivers.driver.navigate().refresh();
        mainPage.nextWindow.click();
        Thread.sleep(500);
        mainPage.skipButton.click();
        Thread.sleep(500);
        Assert.assertEquals(mainPage.finalStep.getText(), ONBOARDING_TITLES[2]);
        Assert.assertEquals(mainPage.finalText.getText(), ONBOARDING_FINAL_TEXT);
        Assert.assertEquals(mainPage.finishButton.getText(), "Finish");
        mainPage.finishButton.click();

    }

}
