package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class DocumentPreview extends CloudentsAutoTests {

    @Test
    public void anonymous() throws InterruptedException {

        // Initialize
        Drivers.driver.navigate().to(STUDY_PAGE);
        Thread.sleep(1000);
        studyDocumentsPage.documentCards.get(0).click();
        Thread.sleep(1000);

        Assert.assertEquals(studyDocumentsPage.previewTitle.getText(), DOC_PREVIEW_TITLE);
        Assert.assertEquals(studyDocumentsPage.previewSubTitle.getText(), DOC_PREVIEW_SUBTITLE);
        Assert.assertEquals(studyDocumentsPage.unlockTitle.getText(), DOC_UNLOCK);
        Assert.assertEquals(studyDocumentsPage.unlockButton.getText(), DOC_UNLOCK_BUTTON);

        for(int i = 0 ; i < 3 ; i ++) {
            Assert.assertEquals(studyDocumentsPage.tutorTitle.get(i).getText(), DOC_TUTOR_TITLES[i]);
        }
        Assert.assertEquals(studyDocumentsPage.moreTutors.getText(), DOC_MORE_TUTORS);
        Assert.assertEquals(studyDocumentsPage.moreDocuments.getText(), DOC_MORE);
        studyDocumentsPage.moreDocuments.click();
        Thread.sleep(1000);
        Assert.assertTrue(Drivers.driver.getCurrentUrl().contains(PROFILE_PAGE));
        Drivers.driver.navigate().back();
        Thread.sleep(1000);
        Assert.assertTrue(studyDocumentsPage.sendButtons.get(0).getText().contains(TUTOR_SEND));
        Assert.assertTrue(studyDocumentsPage.sendButtons.get(0).getText().contains(TUTOR_MESSAGE));
        studyDocumentsPage.sendButtons.get(0).click();
        Thread.sleep(1000);
        mainPage.closeRequest.click();
        Thread.sleep(1000);
        studyDocumentsPage.backButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), STUDY_PAGE);

    }

    @Test
    public void registered() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);
        mainPage.userMenuIcon.click();
        Thread.sleep(1000);
        mainPage.userMenuItems.get(1).click();
        Thread.sleep(1000);
        profilePage.profileTabs.get(3).click();
        Thread.sleep(1000);
        profilePage.documentCard.get(0).click();
        Thread.sleep(1000);

        Assert.assertEquals(studyDocumentsPage.previewTitle.getText(), DOC_PREVIEW_TITLE);
        Assert.assertEquals(studyDocumentsPage.previewSubTitle.getText(), DOC_PREVIEW_SUBTITLE);
        Assert.assertEquals(studyDocumentsPage.downloadButton.getText(), DOC_DOWNLOAD);

        for(int i = 0 ; i < 3 ; i ++) {
            Assert.assertEquals(studyDocumentsPage.tutorTitle.get(i).getText(), DOC_TUTOR_TITLES[i]);
        }
        Assert.assertEquals(studyDocumentsPage.moreTutors.getText(), DOC_MORE_TUTORS);
        Assert.assertEquals(studyDocumentsPage.moreDocuments.getText(), DOC_MORE);
        studyDocumentsPage.moreDocuments.click();
        Thread.sleep(1000);
        Assert.assertTrue(Drivers.driver.getCurrentUrl().contains(PROFILE_PAGE));
        Drivers.driver.navigate().back();
        Thread.sleep(1000);
        Assert.assertTrue(studyDocumentsPage.sendButtons.get(0).getText().contains(TUTOR_SEND));
        Assert.assertTrue(studyDocumentsPage.sendButtons.get(0).getText().contains(TUTOR_MESSAGE));
        studyDocumentsPage.sendButtons.get(0).click();
        studyDocumentsPage.downloadButton.click();
        Thread.sleep(1000);
        studyDocumentsPage.backButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(Drivers.driver.getCurrentUrl().contains(PROFILE_PAGE));

    }

}
