package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.Methods.loginUser;
import static com.cloudents.AutomationTest.Resources.Pages.*;

public class TopEarners extends CloudentsAutoTests {

    @Test
    public void topEarners() throws InterruptedException {

        loginUser();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.finishButton.click();
        Thread.sleep(3000);

        Assert.assertEquals(mainPage.topEarner.getText(), "Top Earners");
        Assert.assertEquals(mainPage.total.getText(), "Total Earnings");
        for(int i = 0 ; i < 5 ; i++) {
            Assert.assertTrue(mainPage.leaders.get(i).getText().contains("$"));
        }


        Drivers.driver.navigate().to(HOME_PAGE + "/logout");
        Thread.sleep(1000);
        Drivers.driver.navigate().to(HOME_PAGE + "/ask");
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.topEarner.getText(), "Top Earners");
        Assert.assertEquals(mainPage.total.getText(), "Total Earnings");
        for(int i = 0 ; i < 5 ; i++) {
            Assert.assertTrue(mainPage.leaders.get(i).getText().contains("$"));
        }

    }

}
