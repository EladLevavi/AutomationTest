package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.Methods.loginUser;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;

public class Walkthrough extends CloudentsAutoTests {

    @Test
    public void walkthrough() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.finishButton.click();
        Thread.sleep(3000);

        Assert.assertEquals(mainPage.header.getText(), WALKTHROUGH_HEADER[3]);
        Assert.assertEquals(mainPage.content.getText(), WALKTHROGH_CONTENT[3]);
        Assert.assertEquals(mainPage.navButtons.get(0).getText(), WALKTHROUGH_NAV[2]);
        Assert.assertEquals(mainPage.navButtons.get(1).getText(), WALKTHROUGH_NAV[1]);
        mainPage.navButtons.get(1).click();
        Assert.assertEquals(mainPage.header.getText(), WALKTHROUGH_HEADER[4]);
        Assert.assertEquals(mainPage.content.getText(), WALKTHROGH_CONTENT[4]);
        Assert.assertEquals(mainPage.navButtons.get(0).getText(), WALKTHROUGH_NAV[0]);
        Assert.assertEquals(mainPage.navButtons.get(1).getText(), WALKTHROUGH_NAV[3]);
        mainPage.navButtons.get(0).click();
        Assert.assertEquals(mainPage.header.getText(), WALKTHROUGH_HEADER[3]);
        Assert.assertEquals(mainPage.content.getText(), WALKTHROGH_CONTENT[3]);
        Thread.sleep(3000);


        mainPage.tabsContainer.get(0).click();
        Thread.sleep(3000);

        Assert.assertEquals(mainPage.header.getText(), WALKTHROUGH_HEADER[0]);
        Assert.assertEquals(mainPage.content.getText(), WALKTHROGH_CONTENT[0]);
        Assert.assertEquals(mainPage.navButtons.get(0).getText(), WALKTHROUGH_NAV[2]);
        Assert.assertEquals(mainPage.navButtons.get(1).getText(), WALKTHROUGH_NAV[1]);
        mainPage.navButtons.get(1).click();
        Assert.assertEquals(mainPage.header.getText(), WALKTHROUGH_HEADER[1]);
        Assert.assertEquals(mainPage.content.getText(), WALKTHROGH_CONTENT[1]);
        Assert.assertEquals(mainPage.navButtons.get(0).getText(), WALKTHROUGH_NAV[2]);
        Assert.assertEquals(mainPage.navButtons.get(1).getText(), WALKTHROUGH_NAV[0]);
        Assert.assertEquals(mainPage.navButtons.get(2).getText(), WALKTHROUGH_NAV[1]);
        mainPage.navButtons.get(1).click();
        Assert.assertEquals(mainPage.header.getText(), WALKTHROUGH_HEADER[0]);
        mainPage.navButtons.get(1).click();
        mainPage.navButtons.get(2).click();
        Assert.assertEquals(mainPage.header.getText(), WALKTHROUGH_HEADER[2]);
        Assert.assertEquals(mainPage.content.getText(), WALKTHROGH_CONTENT[2]);
        Assert.assertEquals(mainPage.navButtons.get(0).getText(), WALKTHROUGH_NAV[0]);
        Assert.assertEquals(mainPage.navButtons.get(1).getText(), WALKTHROUGH_NAV[3]);

    }

}
