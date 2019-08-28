package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class TutorCard extends CloudentsAutoTests {

    @Test
    public void anonymous() throws InterruptedException {

        // Initialize
        Drivers.driver.navigate().to(HOMEWORK_PAGE);
        Thread.sleep(1000);

        Assert.assertEquals(homeworkHelpPage.courseTutors.getText(), TUTOR_CARD_HEADER);
        Assert.assertEquals(homeworkHelpPage.tutorCards.size(), 20);
        Assert.assertTrue(homeworkHelpPage.tutorCardsTitle.get(0).getText().contains(TUTOR_CARD_TITLE));
        Assert.assertTrue(homeworkHelpPage.tutorCardsButton.get(0).getText().contains(TUTOR_SEND));
        Assert.assertTrue(homeworkHelpPage.tutorCardsButton.get(0).getText().contains(TUTOR_MESSAGE));
        homeworkHelpPage.tutorCardsButton.get(0).click();
        Drivers.driver.navigate().to(STUDY_PAGE);
        Thread.sleep(1000);
        Assert.assertEquals(studyDocumentsPage.courseTutors.getText(), TUTOR_CARD_HEADER);
        Assert.assertEquals(studyDocumentsPage.tutorCards.size(), 20);
        Assert.assertTrue(studyDocumentsPage.tutorCardsTitle.get(0).getText().contains(TUTOR_CARD_TITLE));
        Assert.assertTrue(studyDocumentsPage.tutorCardsButton.get(0).getText().contains(TUTOR_SEND));
        Assert.assertTrue(studyDocumentsPage.tutorCardsButton.get(0).getText().contains(TUTOR_MESSAGE));

    }

    @Test
    public void registered() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);

        Assert.assertEquals(studyDocumentsPage.courseTutors.getText(), TUTOR_CARD_HEADER);
        Assert.assertEquals(studyDocumentsPage.tutorCards.size(), 20);
        Assert.assertTrue(studyDocumentsPage.tutorCardsTitle.get(0).getText().contains(TUTOR_CARD_TITLE));
        Assert.assertTrue(studyDocumentsPage.tutorCardsButton.get(0).getText().contains(TUTOR_SEND));
        Assert.assertTrue(studyDocumentsPage.tutorCardsButton.get(0).getText().contains(TUTOR_MESSAGE));
        homeworkHelpPage.tutorCardsButton.get(0).click();
        Drivers.driver.navigate().to(HOMEWORK_PAGE);
        Assert.assertEquals(homeworkHelpPage.courseTutors.getText(), TUTOR_CARD_HEADER);
        Assert.assertEquals(homeworkHelpPage.tutorCards.size(), 20);
        Assert.assertTrue(homeworkHelpPage.tutorCardsTitle.get(0).getText().contains(TUTOR_CARD_TITLE));
        Assert.assertTrue(homeworkHelpPage.tutorCardsButton.get(0).getText().contains(TUTOR_SEND));
        Assert.assertTrue(homeworkHelpPage.tutorCardsButton.get(0).getText().contains(TUTOR_MESSAGE));

    }

}
