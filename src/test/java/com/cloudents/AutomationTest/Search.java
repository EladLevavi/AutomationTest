package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.CloudentsAutoTests.mainPage;
import static com.cloudents.AutomationTest.Resources.Methods.loginUser;
import static com.cloudents.AutomationTest.Resources.Pages.HOME_PAGE;

public class Search extends CloudentsAutoTests {

    @Test
    public void search() throws InterruptedException {

        Drivers.driver.navigate().to(HOME_PAGE + "/ask");
        Thread.sleep(1000);
        mainPage.searchBar.sendKeys("test");
        Thread.sleep(500);
        mainPage.searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Assert.assertTrue(mainPage.questionBody.get(0).getText().toLowerCase().contains("test"));
        Thread.sleep(1000);
        mainPage.studyDocumentsTab.click();
        Thread.sleep(1000);
        Assert.assertTrue(studyDocumentsPage.docTitle.get(0).getText().toLowerCase().contains("test"));
        Thread.sleep(1000);
        mainPage.homeworkHelpTab.click();
        Thread.sleep(2000);
        mainPage.clearSearch.click();
        Thread.sleep(1000);
        mainPage.searchBar.sendKeys("economics");
        Thread.sleep(500);
        mainPage.searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Assert.assertTrue(mainPage.questionBody.get(0).getText().toLowerCase().contains("economics"));

    }

}
