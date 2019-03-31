package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;

public class Filters extends CloudentsAutoTests {

    @Test
    public void filters() throws InterruptedException {

        Drivers.driver.navigate().to(HOME_PAGE + "/ask");
        mainPage.filter.click();
        Thread.sleep(2000);
        mainPage.closeFilter.click();
        Thread.sleep(2000);
        mainPage.filter.click();
        Thread.sleep(2000);
        mainPage.applyFilter.click();
        Thread.sleep(2000);
        mainPage.filter.click();

        Assert.assertEquals(mainPage.filterTitle.get(0).getText(), FILTER_TYPES[0]);
        Assert.assertEquals(mainPage.filterTitle.get(1).getText(), FILTER_TYPES[1]);
        Assert.assertEquals(mainPage.applyFilter.getText(), "Apply");

        for(int i = 0 ; i < 27 ; i++) {
            Assert.assertEquals(mainPage.filterItems.get(i).getText(), FILTER_ITEMS[i]);
            mainPage.filterItems.get(i).click();
            Thread.sleep(250);
        }

        Drivers.driver.navigate().to(HOME_PAGE + "/note");
        mainPage.filter.click();
        Thread.sleep(2000);
        mainPage.closeFilter.click();
        Thread.sleep(2000);
        mainPage.filter.click();
        Thread.sleep(2000);
        mainPage.applyFilter.click();
        Thread.sleep(2000);
        mainPage.filter.click();
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.filterTitle.get(0).getText(), FILTER_TYPES[0]);
        Assert.assertEquals(mainPage.applyFilter.getText(), "Apply");

        for(int i = 0 ; i < 10 ; i++) {
            Assert.assertEquals(mainPage.filterItems.get(i).getText(), FILTER_ITEMS[i+27]);
            mainPage.filterItems.get(i).click();
            Thread.sleep(250);
        }

    }

}
