package com.cloudents.AutomationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class ReferralDialog extends CloudentsAutoTests {

    @Test
    public void referral() throws InterruptedException {

        loginUser();
        Thread.sleep(1000);
        mainPage.userMenuIcon.click();
        Thread.sleep(1000);
        mainPage.userMenuItems.get(8).click();
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.spreadText.getText(), REFERRAL_TITLE);
        Assert.assertEquals(mainPage.earnText.getText(), REFERRAL_SEC_TITLE);
        Assert.assertEquals(mainPage.subTitle.getText(), REFERRAL_SUB_TITLE);
        Assert.assertEquals(mainPage.smallLetters.getText(), REFERRAL_SMALL_LETTERS);
        Assert.assertTrue(mainPage.invitedText.getText().contains("Limited to "));
        //Assert.assertEquals(mainPage.referralLink.getText(), REFERRAL_LINK);
        Assert.assertEquals(mainPage.copyButton.getText(), REFERRAL_COPY_BUTTON[0]);
        mainPage.copyButton.click();
        Thread.sleep(500);
        Assert.assertEquals(mainPage.copiedButton.getText(), REFERRAL_COPY_BUTTON[1]);

        for(int i = 0 ; i < 4 ; i++) {
            Assert.assertEquals(mainPage.shareIcons.get(i).getText(), REFERRAL_SHARING_ICONS[i]);
            Assert.assertEquals(mainPage.shareText.get(i).getText(), REFERRAL_SHARE_TEXT[i]);
        }

        mainPage.closeReferral.click();
        Thread.sleep(1000);

    }

}
