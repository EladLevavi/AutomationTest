package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.Methods.loginUser;
import static com.cloudents.AutomationTest.Resources.Pages.*;

public class Upload extends CloudentsAutoTests {

    @Test
    public void upload() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.finishButton.click();
        Thread.sleep(1000);
        Drivers.driver.navigate().to(HOME_PAGE + "/note");
        Thread.sleep(2000);


        studyDocumentsPage.uploadButton.click();
        Thread.sleep(1000);
        studyDocumentsPage.closeUpload.click();
        Thread.sleep(1000);
        studyDocumentsPage.uploadButton.click();
        Assert.assertEquals(studyDocumentsPage.subTitle.getText(), "Upload");
        Assert.assertEquals(studyDocumentsPage.stepTitle.getText(), "Upload Files");
        studyDocumentsPage.courseDropdown.get(0).click();
        Thread.sleep(1000);
        String course = studyDocumentsPage.coursesList.get(0).getText();
        studyDocumentsPage.coursesList.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(studyDocumentsPage.courseDropdown.get(0).getText(), course);
        studyDocumentsPage.browse.click();
        Thread.sleep(10000);

    }

}
