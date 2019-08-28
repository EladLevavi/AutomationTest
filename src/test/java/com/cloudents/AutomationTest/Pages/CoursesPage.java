package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CoursesPage {

    @FindBy(xpath = "//*[@class='flex text-xs-center hidden-xs-only xs2 shrink']")
    public WebElement finishButton;

    @FindBy(xpath = "//*[@class='v-list__tile__action edit-course px-3']")
    public WebElement editCourses;

    @FindBy(xpath = "//*[@class='add-btn py-1 my-0 elevation-0 v-btn v-btn--round theme--light']")
    public WebElement addCourse;

    @FindBy(xpath = "//*[@class='d-inline-flex justify-center shrink']/span")
    public List<WebElement> myCourses;

    @FindBy(xpath = "//*[@class='list-item search-class-item py-2 mx-2 justify-space-between align-center font-weight-regular']")
    public List<WebElement> coursesList;

    @FindBy(xpath = "//*[@class='layout pl-3 limit-width column']")
    public List<WebElement> coursesResult;

    @FindBy(xpath = "//*[@class='subheading font-weight-bold']")
    public WebElement joinCourses;

    @FindBy(xpath = "//*[@class='v-text-field__slot']//input")
    public WebElement input;

    @FindBy(xpath = "//*[@class='v-icon course-back-btn mr-3 v-icon--link sbf sbf-arrow-back theme--light']")
    public WebElement navigateBack;

    @FindBy(xpath = "//*[@class='elevation-0 done-btn py-1 font-weight-bold my-0 text-capitalize v-btn v-btn--round theme--light']")
    public WebElement doneButton;

    @FindBy(xpath = "//*[@class='v-icon sbf sbf-close theme--light white--text']")
    public WebElement removeCourse;

    @FindBy(xpath = "//*[@class='solid-btn elevation-0 text-none align-center justify-center rounded-btn v-btn v-btn--round theme--light']")
    public List<WebElement> teachingButton;

    @FindBy(xpath = "//*[@class='outline-btn elevation-0 text-none align-center justify-center rounded-btn v-btn v-btn--round theme--light']")
    public List<WebElement> teachButton;

}
