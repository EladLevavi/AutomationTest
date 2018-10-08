package com.cloudents.AutomationTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.*;
import static com.cloudents.AutomationTest.Resources.clickOnWebElements;
import static com.cloudents.AutomationTest.Resources.mainPage;

public class MainTabs extends CloudentsAutoTests {


    @Test
    public void homeworkHelp() throws InterruptedException {

        //mainPage.tabsContainer.get(0).click();
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(0).getText().trim(), "Homework Help");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Search questions");
        Assert.assertEquals(mainPage.banner.getText(), "Make money while helping others with their homework.");
        Thread.sleep(3000);
        scroll(mainPage.moreButton, 15);
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.filterHeaders.size(),2 );
        Assert.assertEquals(mainPage.filters.size(), 26);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.filterHeaders);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        System.out.println(homeworkHelpPage.questionBox.size());
        if (homeworkHelpPage.questionBox.size() <= 50)
            Assert.fail();
        homeworkHelpPage.askButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(mainPage.signPopup.isDisplayed());

    }

    @Test
    public void studyDocuments() throws InterruptedException {

        mainPage.tabsContainer.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(1).getText().trim(), "Study Documents");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find study documents in...");
        Assert.assertEquals(mainPage.banner.getText(), "Notes, study guides, exams and more from the best sites.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        mainPage.sort.get(1).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Relevance");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Date");
        Assert.assertEquals(mainPage.filterHeaders.size(),1 );
        Assert.assertEquals(mainPage.filters.size(), 5);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void flashcards() throws InterruptedException {

        mainPage.tabsContainer.get(2).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(2).getText().trim(), "Flashcards");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Look for flashcards...");
        Assert.assertEquals(mainPage.banner.getText(), "Study from millions of flashcard sets to improve your grades.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        mainPage.sort.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=Relevance");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=Date");
        Assert.assertEquals(mainPage.filterHeaders.size(),1 );
        Assert.assertEquals(mainPage.filters.size(), 8);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void tutors() throws InterruptedException {

        mainPage.tabsContainer.get(3).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(3).getText().trim(), "Tutors");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find a tutor...");
        Assert.assertEquals(mainPage.banner.getText(), "Find an expert to help you ace your classes in-person or online.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        mainPage.sort.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE + "?sort=Price");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE + "?sort=Relevance");
        Assert.assertEquals(mainPage.filterHeaders.size(),1 );
        Assert.assertEquals(mainPage.filters.size(), 2);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void textbooks() throws InterruptedException {

        mainPage.tabsContainer.get(4).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), BOOK_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(4).getText().trim(), "Textbooks");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Textbook title or ISBN...");
        Assert.assertEquals(mainPage.banner.getText(), "Compare the best prices to buy, rent or sell your textbooks.");
        Assert.assertEquals(mainPage.searchSchool.getAttribute("placeholder"), "Where do you go to school?");
        driver.get(BOOK_PAGE + "/9781400201655");
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.filterHeaders.size(),1 );
        Assert.assertEquals(mainPage.filters.size(), 3);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sortSection);

    }

    @Test
    public void jobs() throws InterruptedException {

        mainPage.tabsContainer.get(5).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), JOB_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(5).getText().trim(), "Jobs");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Your field of expertise...");
        Assert.assertEquals(mainPage.banner.getText().trim(), "Find jobs and internships catered specifically to students.");
        Thread.sleep(2000);
        Assert.assertEquals(mainPage.filterHeaders.size(),1 );
        Assert.assertEquals(mainPage.filters.size(), 4);
        clickOnWebElements(mainPage.filters);
        clickOnWebElements(mainPage.sort);

    }


}
