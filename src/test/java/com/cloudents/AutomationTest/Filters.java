package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;

public class Filters extends CloudentsAutoTests {

    @Test
    public void homework() throws InterruptedException {

        Drivers.driver.navigate().to(HOMEWORK_PAGE);
        mainPage.filter.click();
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.filterTitle.getText(), FILTER_TYPE);
        Assert.assertEquals(mainPage.applyFilter.getText(), FILTER_APPLY);
        Thread.sleep(1000);
        mainPage.closeFilter.click();
        Thread.sleep(1000);
        mainPage.filter.click();
        Thread.sleep(2000);
        mainPage.filterItems.get(0).click();
        Thread.sleep(1000);
        mainPage.applyFilter.click();
        Thread.sleep(1000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), FILTER_QUERY);
        mainPage.filter.click();
        Thread.sleep(1000);
        mainPage.filterItems.get(0).click();
        Thread.sleep(1000);
        mainPage.applyFilter.click();
        Thread.sleep(1000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), HOMEWORK_PAGE);
        mainPage.filter.click();
        Thread.sleep(1000);


        for(int i = 0 ; i < 3 ; i++) {
            Assert.assertEquals(mainPage.filterItems.get(i).getText(), FILTER_ITEMS[i]);
            mainPage.filterItems.get(i).click();
            Thread.sleep(250);
        }

    }

    @Test
    public void study() throws InterruptedException {

        Drivers.driver.navigate().to(STUDY_PAGE);
        mainPage.filter.click();
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.filterTitle.getText(), FILTER_TYPE);
        Assert.assertEquals(mainPage.applyFilter.getText(), FILTER_APPLY);
        Assert.assertEquals(studyDocumentsPage.noneFilter.getText(), FILTER_NONE);
        Thread.sleep(1000);
        mainPage.closeFilter.click();
        Thread.sleep(1000);
        mainPage.filter.click();
        Thread.sleep(1000);
        studyDocumentsPage.noneFilter.click();
        Thread.sleep(1000);
        mainPage.applyFilter.click();
        Thread.sleep(1000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), FILTER_QUERY2);
        mainPage.filter.click();
        Thread.sleep(1000);
        studyDocumentsPage.noneFilter.click();
        Thread.sleep(1000);
        mainPage.applyFilter.click();
        Thread.sleep(1000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), STUDY_PAGE);
        Thread.sleep(1000);

    }

}
