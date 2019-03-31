package com.cloudents.AutomationTest;



import com.cloudents.AutomationTest.Resources.Drivers;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static com.cloudents.AutomationTest.Resources.Drivers.driver;
import static com.cloudents.AutomationTest.Resources.Images.STUDENT_ICON;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;



public class AskQuestion extends CloudentsAutoTests {

    @Test
    public void askQuestion() throws InterruptedException {

        // Initialize
        loginUser();
        mainPage.nextWindow.click();
        Thread.sleep(500);
        mainPage.nextWindow.click();
        Thread.sleep(500);
        mainPage.finishButton.click();
        Thread.sleep(500);


        homeworkHelpPage.askButton.click();
        Thread.sleep(1000);
        homeworkHelpPage.addQuestion.click();
        Thread.sleep(1000);
        Assert.assertEquals(homeworkHelpPage.textareaError.getText(), "There is a minimum of 15 characters for a question");
        Assert.assertEquals(homeworkHelpPage.selectError.getText(), "Don’t forget to select the class for your question");
        Assert.assertEquals(homeworkHelpPage.priceError.getText(), "Invalid value");
        Assert.assertEquals(homeworkHelpPage.questionTitle.getText(), "Add a question");
        Assert.assertEquals(homeworkHelpPage.offerText.getText(), "Offer a Reward");
        Assert.assertEquals(homeworkHelpPage.priceButtons.get(0).getText(), "10 Pts");
        Assert.assertEquals(homeworkHelpPage.priceButtons.get(1).getText(), "40 Pts");
        Assert.assertEquals(homeworkHelpPage.priceButtons.get(2).getText(), "60 Pts");
        Assert.assertEquals(homeworkHelpPage.priceInput.getAttribute("placeholder"), "Other");
        Assert.assertEquals(homeworkHelpPage.addQuestion.getText(), "Add Question");
        //Assert.assertEquals(homeworkHelpPage.classSelection.getText(), "For what class?");
        Assert.assertEquals(homeworkHelpPage.subjectSelection.getText(), "Select the subject");
        Assert.assertEquals(homeworkHelpPage.textAreaLabel.getText(), "Ask your question here…");

        homeworkHelpPage.questionTextarea.sendKeys("aaaaaaaaaaaaaa");
        homeworkHelpPage.addQuestion.click();
        Assert.assertEquals(homeworkHelpPage.textareaError.getText(), "There is a minimum of 15 characters for a question");


        homeworkHelpPage.closePopup.click();
        Thread.sleep(1000);
        homeworkHelpPage.askButton.click();
        Thread.sleep(500);
        homeworkHelpPage.questionTextarea.sendKeys("bbbbbbbbbbbbbbb");
        Assert.assertEquals(homeworkHelpPage.textareaError.getText(), "");
        //homeworkHelpPage.classSelection.click();
        //homeworkHelpPage.classesList.get(0).click();
        //homeworkHelpPage.addQuestion.click();
        //Assert.assertEquals(homeworkHelpPage.selectError.getText(), "");
        //Thread.sleep(500);
        for(int i = 0 ; i < 3 ; i++) {
            homeworkHelpPage.priceButtons.get(i).click();
            Thread.sleep(500);
        }
        Thread.sleep(1000);
        homeworkHelpPage.addQuestion.click();
        Assert.assertEquals(homeworkHelpPage.priceError.getText(), "");
        Thread.sleep(1000);
        homeworkHelpPage.priceInput.click();
        homeworkHelpPage.priceInput.sendKeys("101");
        Thread.sleep(1000);
        homeworkHelpPage.addQuestion.click();
        Assert.assertEquals(homeworkHelpPage.priceError.getText(), "Maximum offer limit is 100 points");
        homeworkHelpPage.browse.click();
        //Set<String> winHandles = driver.getWindowHandles();
        //winHandles.forEach(winHandle -> driver.switchTo().window(winHandle));
        Thread.sleep(10000);

    }

    @Test
    public void deleteQuestion() throws InterruptedException {

        // Initialize
        loginUser();
        mainPage.nextWindow.click();
        Thread.sleep(500);
        mainPage.nextWindow.click();
        Thread.sleep(500);
        mainPage.finishButton.click();
        Thread.sleep(500);

        homeworkHelpPage.askButton.click();
        Thread.sleep(1000);
        homeworkHelpPage.questionTextarea.sendKeys("jfsdkljgklfdjklghg");
        Thread.sleep(1000);
        homeworkHelpPage.classSelection.click();
        Thread.sleep(1000);
        homeworkHelpPage.classesList.get(0).click();
        Thread.sleep(1000);
        homeworkHelpPage.priceButtons.get(0).click();
        Thread.sleep(1000);
        homeworkHelpPage.addQuestion.click();
        Thread.sleep(10000);


        mainPage.userMenuIcon.click();
        mainPage.userMenuItems.get(2).click();
        Thread.sleep(5000);
        homeworkHelpPage.questionsBox.get(0).click();
        homeworkHelpPage.deleteButton.click();

    }
}
