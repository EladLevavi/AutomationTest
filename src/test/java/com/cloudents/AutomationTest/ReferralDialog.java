package com.cloudents.AutomationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.CountDownLatch;

import static com.cloudents.AutomationTest.Resources.Methods.loginUser;
import static com.cloudents.AutomationTest.Resources.Strings.REFERRAL_SHARING_ICONS;

public class ReferralDialog extends CloudentsAutoTests {

    @Test
    public void referral() throws InterruptedException {

        loginUser();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.finishButton.click();
        Thread.sleep(1000);
        mainPage.userMenuIcon.click();
        Thread.sleep(1000);
        mainPage.userMenuItems.get(7).click();
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.spreadText.getText(), "Spread the word at");
        Assert.assertEquals(mainPage.earnText.getText(), "Earn 10 points for each one that joins");
        Assert.assertEquals(mainPage.subTitle.get(0).getText(), "The more classmates you get on Spitball, the better everyone’s grades will be!");
        Assert.assertEquals(mainPage.subTitle.get(1).getText(), "Limited to 5 referrals");
        Assert.assertTrue(Integer.parseInt(mainPage.invitedText.get(0).getText()) >= 0);
        Assert.assertEquals(mainPage.invitedText.get(1).getText(), "invited friends have joined");
        Assert.assertEquals(mainPage.copyButton.getText(), "COPY");
        mainPage.copyButton.click();
        Thread.sleep(500);
        //Assert.assertEquals(mainPage.copiedButton.getText(), "COPIED");


        for(int i = 0 ; i < 4 ; i++) {
            Assert.assertEquals(mainPage.shareIcons.get(i).getText(), REFERRAL_SHARING_ICONS[i]);
        }

        mainPage.closeReferral.click();
        Thread.sleep(1000);

    }

}
