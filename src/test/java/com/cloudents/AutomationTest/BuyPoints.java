package com.cloudents.AutomationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;
import static com.cloudents.AutomationTest.Resources.Drivers.driver;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class BuyPoints extends CloudentsAutoTests {

    @Test
    public void getPoints() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);

        mainPage.getPoints.click();
        Thread.sleep(500);
        Assert.assertEquals(mainPage.headers.get(0).getText(), GET_POINTS_HEADER);
        Assert.assertEquals(mainPage.headers.get(1).getText(), GET_POINTS_SUBTITLE);
        Assert.assertEquals(mainPage.mostPopular.getText(), GET_POINTS_MOST);
        for(int i = 0 ; i < 3 ; i++) {
            Assert.assertEquals(mainPage.titles.get(i).getText(), BUY_TITLES[i]);
            Assert.assertEquals(mainPage.subTitles.get(i).getText(), BUY_SUBTITLES[i]);
        }
        Assert.assertTrue(mainPage.buyOptions.get(1).getAttribute("class").contains("selected"));
        mainPage.buyOptions.get(0).click();
        Thread.sleep(500);
        Assert.assertTrue(mainPage.buyOptions.get(0).getAttribute("class").contains("selected"));
        Assert.assertFalse(mainPage.buyOptions.get(1).getAttribute("class").contains("selected"));
        Assert.assertFalse(mainPage.buyOptions.get(2).getAttribute("class").contains("selected"));
        mainPage.buyOptions.get(1).click();
        Thread.sleep(500);
        Assert.assertFalse(mainPage.buyOptions.get(0).getAttribute("class").contains("selected"));
        Assert.assertTrue(mainPage.buyOptions.get(1).getAttribute("class").contains("selected"));
        Assert.assertFalse(mainPage.buyOptions.get(2).getAttribute("class").contains("selected"));
        mainPage.buyOptions.get(2).click();
        Thread.sleep(500);
        Assert.assertFalse(mainPage.buyOptions.get(0).getAttribute("class").contains("selected"));
        Assert.assertFalse(mainPage.buyOptions.get(1).getAttribute("class").contains("selected"));
        Assert.assertTrue(mainPage.buyOptions.get(2).getAttribute("class").contains("selected"));

        for(int i = 0 ; i < 3 ; i++) {
            Assert.assertEquals(mainPage.pointsOption.get(i).getText(), POINTS_OPTION[i]);
            Assert.assertEquals(mainPage.pointsConvertion.get(i).getText(), POINTS_CONVERTION[i]);
            Assert.assertEquals(mainPage.chooseButtons.get(i).getText(), "Choose");
        }

        Assert.assertEquals(mainPage.pointsMessages.get(0).getText(), POINTS_WARNING);
        Assert.assertEquals(mainPage.pointsMessages.get(0).getAttribute("style"), POINTS_RED);
        Assert.assertEquals(mainPage.pointsMessages.get(1).getText(), POINTS_NOTE);

        //Assert.assertEquals(mainPage.checkoutButton.getText(), "Checkout");
        mainPage.checkoutButton.click();
        Thread.sleep(12000);
        Set<String> winHandles = driver.getWindowHandles();
        winHandles.forEach(winHandle -> driver.switchTo().window(winHandle));
        mainPage.paypalEmail.sendKeys(PAYPAL_USERNAME);
        mainPage.paypalNext.click();
        Thread.sleep(1000);
        mainPage.paypalPassword.sendKeys(PAYPAL_PASSWORD);
        mainPage.paypalLogin.click();
        Thread.sleep(10000);
        mainPage.confirmButton.click();
        Thread.sleep(8000);
        winHandles.forEach(winHandle -> driver.switchTo().window(winHandleBefore));
        mainPage.userMenuIcon.click();
        Thread.sleep(1000);
        mainPage.userMenuItems.get(0).click();
        Thread.sleep(1000);
        myWalletPage.tabs.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(myWalletPage.sblTypes.get(1).getText(), POINTS_ACTION);
        Assert.assertEquals(myWalletPage.sblTypes.get(2).getText(), POINTS_TYPE);
        Assert.assertEquals(myWalletPage.sblTypes.get(3).getText(), POINTS_AMOUNT);

    }

}
