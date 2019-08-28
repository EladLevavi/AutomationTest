package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class Courses extends CloudentsAutoTests {

    @Test
    public void edit() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);
        mainPage.userMenuIcon.click();
        Thread.sleep(500);
        mainPage.userMenuItems.get(3).click();
        Thread.sleep(1000);

        Assert.assertEquals(Drivers.driver.getCurrentUrl(), COURSES_EDIT);
        Assert.assertEquals(coursesPage.myCourses.get(0).getText().substring(0, 10), COURSES_MY);
        String courseCounter = coursesPage.myCourses.get(1).getText().substring(2,coursesPage.myCourses.get(1).getText().length()-1);
        Thread.sleep(500);
        Assert.assertEquals(courseCounter, String.valueOf(coursesPage.coursesList.size()));
        addTestCourse();
        coursesPage.teachButton.get(0).click();
        Assert.assertEquals(coursesPage.teachButton.get(0).getText(), "Teach");
        Thread.sleep(1000);
        coursesPage.teachButton.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(coursesPage.teachingButton.get(0).getText(), "Teaching");
        coursesPage.finishButton.click();
        coursesPage.editCourses.click();
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), COURSES_EDIT);
        coursesPage.addCourse.click();
        Thread.sleep(500);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), COURSES_ADD);

    }

    @Test
    public void add() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);
        mainPage.userMenuIcon.click();
        Thread.sleep(500);
        mainPage.userMenuItems.get(3).click();
        Thread.sleep(1000);

        coursesPage.addCourse.click();
        Thread.sleep(500);
        Assert.assertEquals(coursesPage.joinCourses.getText(), COURSES_JOIN);
        //Assert.assertEquals(coursesPage.doneButton, null);
        Assert.assertEquals(coursesPage.input.getAttribute("placeholder"), COURSES_INPUT_PLACEHOLDER);
        coursesPage.input.sendKeys("Statistics");
        Thread.sleep(1000);
        Assert.assertEquals(coursesPage.coursesResult.size(), 9);
        coursesPage.coursesResult.get(0).click();
        Thread.sleep(1000);
        coursesPage.removeCourse.click();
        Thread.sleep(500);
        coursesPage.coursesResult.get(0).click();
        coursesPage.doneButton.click();
        coursesPage.addCourse.click();
        coursesPage.navigateBack.click();
        Thread.sleep(500);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), COURSES_EDIT);

    }

    @Test
    public void delete() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(1000);
        mainPage.userMenuIcon.click();
        Thread.sleep(500);
        mainPage.userMenuItems.get(3).click();
        Thread.sleep(1000);

        coursesPage.addCourse.click();
        Thread.sleep(500);
        coursesPage.input.sendKeys("Statistics");
        Thread.sleep(1000);
        coursesPage.coursesResult.get(0).click();
        Thread.sleep(1000);

    }

}
