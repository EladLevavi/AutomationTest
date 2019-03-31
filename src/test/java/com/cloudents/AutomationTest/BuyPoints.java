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
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.finishButton.click();
        Thread.sleep(1000);
        mainPage.getPoints.click();
        Thread.sleep(500);
        mainPage.closeBuyPoints.click();
        Thread.sleep(500);
        mainPage.getPoints.click();
        Thread.sleep(500);
        Assert.assertEquals(mainPage.headers.get(0).getText(), "Get Points");
        Assert.assertEquals(mainPage.headers.get(1).getText(), "Need more points?");
        Assert.assertEquals(mainPage.mostPopular.getText(), "MOST POPULAR");
        for(int i = 0 ; i < 3 ; i++) {
            Assert.assertEquals(mainPage.titles.get(i).getText(), BUY_TITLES[i]);
            Assert.assertEquals(mainPage.subTitles.get(i).getText(), BUY_SUBTITLES[i]);
        }
        Assert.assertTrue(mainPage.buyOptions.get(1).getAttribute("class").contains("selected"));
        mainPage.buyOptions.get(0).click();
        Thread.sleep(500);
        Assert.assertTrue(mainPage.buyOptions.get(0).getAttribute("class").contains("selected"));
        Assert.assertTrue(!mainPage.buyOptions.get(1).getAttribute("class").contains("selected"));
        Assert.assertTrue(!mainPage.buyOptions.get(2).getAttribute("class").contains("selected"));
        mainPage.buyOptions.get(1).click();
        Thread.sleep(500);
        Assert.assertTrue(!mainPage.buyOptions.get(0).getAttribute("class").contains("selected"));
        Assert.assertTrue(mainPage.buyOptions.get(1).getAttribute("class").contains("selected"));
        Assert.assertTrue(!mainPage.buyOptions.get(2).getAttribute("class").contains("selected"));
        mainPage.buyOptions.get(2).click();
        Thread.sleep(500);
        Assert.assertTrue(!mainPage.buyOptions.get(0).getAttribute("class").contains("selected"));
        Assert.assertTrue(!mainPage.buyOptions.get(1).getAttribute("class").contains("selected"));
        Assert.assertTrue(mainPage.buyOptions.get(2).getAttribute("class").contains("selected"));
        for(int i = 0 ; i < 3 ; i++) {
            Assert.assertEquals(mainPage.pointsOption.get(i).getText(), POINTS_OPTION[i]);
            Assert.assertEquals(mainPage.pointsConvertion.get(i).getText(), POINTS_CONVERTION[i]);
            Assert.assertEquals(mainPage.chooseButtons.get(i).getText(), "Choose");
        }

        //Assert.assertEquals(mainPage.checkoutButton.getText(), "Checkout");
        mainPage.checkoutButton.click();
        Thread.sleep(12000);
        Set<String> winHandles = driver.getWindowHandles();
        winHandles.forEach(winHandle -> driver.switchTo().window(winHandle));
        mainPage.paypalEmail.sendKeys("gaby@cloudents.com");
        mainPage.paypalNext.click();
        Thread.sleep(1000);
        mainPage.paypalPassword.sendKeys("12345678");
        mainPage.paypalLogin.click();
        Thread.sleep(10000);
        mainPage.confirmButton.click();
        Thread.sleep(8000);

    }

}
