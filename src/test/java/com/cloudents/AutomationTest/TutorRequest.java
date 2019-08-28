package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.CloudentsAutoTests;
import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class TutorRequest extends CloudentsAutoTests {

    @Test
    public void registered() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);
        mainPage.actionButtons.get(2).click();
        Thread.sleep(2000);

        Assert.assertEquals(mainPage.requestTitle.getText(), REQUEST_TITLE);
        Assert.assertEquals(mainPage.requestText.getAttribute("aria-label"), REQUEST_PLACEHOLDERS[3]);
        Assert.assertEquals(mainPage.course.getAttribute("placeholder"), REQUEST_PLACEHOLDERS[4]);
        Assert.assertEquals(mainPage.submitRequest.getText(), REQUEST_BUTTONS[0]);
        Assert.assertEquals(mainPage.closeRequest.getText(), REQUEST_BUTTONS[1]);
        mainPage.closeRequest.click();
        Thread.sleep(1000);
        mainPage.actionButtons.get(2).click();
        Thread.sleep(1000);
        mainPage.submitRequest.click();
        Thread.sleep(500);
        Assert.assertEquals(mainPage.requiredMessage.get(0).getText(), REUQEST_REQUIRED);
        Assert.assertEquals(mainPage.requiredMessage.get(1).getText(), REUQEST_REQUIRED);
        mainPage.requestText.sendKeys("a");
        mainPage.submitRequest.click();
        Thread.sleep(500);
        mainPage.course.sendKeys(REQUEST_COURSE_SEARCH);
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.coursesList.size(), 23);
        mainPage.coursesList.get(0).click();
        Thread.sleep(1000);
        mainPage.submitRequest.click();

    }

    @Test
    public void anonymous() throws InterruptedException {

        // Initialize
        Drivers.driver.navigate().to(HOMEWORK_PAGE);
        Thread.sleep(1000);
        mainPage.actionButtons.get(2).click();
        Thread.sleep(1000);

        Assert.assertEquals(mainPage.requestTitle.getText(), REQUEST_TITLE);
        for(int i = 0 ; i < 3 ; i ++) {
            Assert.assertEquals(mainPage.requestFields.get(i).getAttribute("placeholder"), REQUEST_PLACEHOLDERS[i]);
        }

        Assert.assertEquals(mainPage.requestText.getAttribute("aria-label"), REQUEST_PLACEHOLDERS[3]);
        Assert.assertEquals(mainPage.course.getAttribute("placeholder"), REQUEST_PLACEHOLDERS[4]);
        Assert.assertEquals(mainPage.requestUniversity.get(1).getAttribute("placeholder"), REQUEST_PLACEHOLDERS[5]);

        Assert.assertEquals(mainPage.submitRequest.getText(), REQUEST_BUTTONS[0]);
        Assert.assertEquals(mainPage.closeRequest.getText(), REQUEST_BUTTONS[1]);

    }

}
