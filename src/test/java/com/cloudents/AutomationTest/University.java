package com.cloudents.AutomationTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Methods.loginUser;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class University extends CloudentsAutoTests {

    @Test
    public void university() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.nextWindow.click();
        Thread.sleep(1000);
        mainPage.finishButton.click();
        Thread.sleep(1000);
        mainPage.userMenuIcon.click();
        Thread.sleep(500);
        mainPage.userMenuItems.get(3).click();
        Thread.sleep(1000);


        Assert.assertEquals(universityPage.uniTitles.get(1).getText(), SET_SCHOOL);
        Assert.assertEquals(universityPage.schoolInput.get(1).getAttribute("placeholder"), "Type your school name");
        universityPage.clear.get(2).click();
        universityPage.schoolInput.get(1).sendKeys("Boston University");
        String university = universityPage.schoolInput.get(1).getText();
        //universityPage.next.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(universityPage.classTitle.get(1).getText(), SET_CLASS);
        Assert.assertEquals(universityPage.fromTitle.getText(), "From Boston University");
        universityPage.schoolInput.get(1).sendKeys("psyc");
        Thread.sleep(1000);
        universityPage.classResults.click();
        Thread.sleep(500);
        universityPage.doneButton.click();

    }

}
