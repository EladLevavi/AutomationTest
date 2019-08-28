package com.cloudents.AutomationTest;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


import static com.cloudents.AutomationTest.Resources.Methods.loginUser;


public class Upload extends CloudentsAutoTests {

    @Test
    public void upload() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);


        mainPage.actionButtons.get(1).click();
        Thread.sleep(1000);
        studyDocumentsPage.closeUpload.click();
        Thread.sleep(1000);
        mainPage.actionButtons.get(1).click();
        Assert.assertEquals(studyDocumentsPage.windowTitle.getText(), "Upload Files");
        Assert.assertEquals(studyDocumentsPage.stepTitle.getText(), "Upload");
        studyDocumentsPage.courseDropdown.get(0).click();
        Thread.sleep(1000);
        String course = studyDocumentsPage.coursesList.get(0).getText();
        studyDocumentsPage.coursesList.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(studyDocumentsPage.courseDropdown.get(0).getText(), course);
        //studyDocumentsPage.browse.click();
        studyDocumentsPage.dropbox.get(0).click();

        Thread.sleep(10000);

    }

}
