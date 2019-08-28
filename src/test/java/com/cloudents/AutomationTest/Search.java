package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;

public class Search extends CloudentsAutoTests {

    @Test
    public void search() throws InterruptedException {

        Drivers.driver.navigate().to(HOMEWORK_PAGE);
        Thread.sleep(1000);
        mainPage.searchBar.sendKeys(SEARCH_TEST);
        Thread.sleep(500);
        mainPage.searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Assert.assertTrue(mainPage.questionBody.get(0).getText().equalsIgnoreCase(SEARCH_TEST));
        Thread.sleep(1000);
        mainPage.studyDocumentsTab.click();
        Thread.sleep(1000);
        //Assert.assertTrue(studyDocumentsPage.docTitle.get(0).getText().equalsIgnoreCase(SEARCH_TEST));
        Thread.sleep(1000);
        mainPage.homeworkHelpTab.click();
        Thread.sleep(2000);
        mainPage.clearSearch.click();
        Thread.sleep(1000);
        mainPage.searchBar.sendKeys(ECONOMICS_COURSE);
        Thread.sleep(500);
        mainPage.searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Assert.assertTrue(mainPage.questionBody.get(0).getText().contains(ECONOMICS_COURSE));

    }

}
