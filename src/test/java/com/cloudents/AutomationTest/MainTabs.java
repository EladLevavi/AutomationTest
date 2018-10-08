package com.cloudents.AutomationTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.*;
import static org.testng.Assert.assertTrue;

public class MainTabs extends CloudentsAutoTests {


    @Test
    public void homeworkHelp() throws InterruptedException {

        //mainPage.tabsContainer.get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(0).getText(), "Homework Help");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Search questions");
        Assert.assertEquals(mainPage.banner.getText(), "Make money while helping others with their homework.");
        homeworkHelpPage.askButton.click();
        Thread.sleep(1000);
        personalizePopup(0);
        Assert.assertEquals(mainPage.filterHeaders.size(), 2);
        Assert.assertEquals(mainPage.filters.size(), 26);
        for(int i = 0 ; i < 26 ; i++) {
            mainPage.filters.get(i).click();
            //Assert.assertEquals(mainPage.filters.get(i).getAttribute("title"), mainPage.filters.get(i).getText());
            Thread.sleep(2000);
        }
        for(int i = 0 ; i < 2 ; i++) {
            mainPage.filterHeaders.get(i).click();
        }
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        System.out.println(homeworkHelpPage.questionBox.size());
        if (homeworkHelpPage.questionBox.size() <= 50)
            Assert.fail();

    }

    @Test
    public void studyDocuments() throws InterruptedException {

        mainPage.tabsContainer.get(1).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(1).getText(), "Study Documents");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find study documents in...");
        Assert.assertEquals(mainPage.banner.getText(), "Notes, study guides, exams and more from the best sites.");
        Assert.assertEquals(mainPage.searchBars.get(1).getAttribute("placeholder"), "Where do you go to school?");
        mainPage.searchBars.get(1).click();
        personalizePopup(1);
        Thread.sleep(500);
        mainPage.sort.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Relevance");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Date");
        Assert.assertEquals(mainPage.filterHeaders.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 5);
        for(int i = 0 ; i < 5 ; i++) {
            mainPage.filters.get(i).click();
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title"), mainPage.filters.get(i).getText());
            Thread.sleep(2000);
        }
        mainPage.filterHeaders.get(0).click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        System.out.println(studyDocPage.studyBlocks.size());
        if (studyDocPage.studyBlocks.size() <= 50)
            Assert.fail();

    }

    @Test
    public void flashcards() throws InterruptedException {

        mainPage.tabsContainer.get(2).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(2).getText(), "Flashcards");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"), "Look for flashcards...");
        Assert.assertEquals(mainPage.banner.getText(), "Study from millions of flashcard sets to improve your grades.");
        Assert.assertEquals(mainPage.searchBars.get(1).getAttribute("placeholder"), "Where do you go to school?");
        mainPage.searchBars.get(1).click();
        Thread.sleep(500);
        personalizePopup(2);
        mainPage.sort.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=Relevance");
        mainPage.sort.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=Date");
        Assert.assertEquals(mainPage.filterHeaders.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 8);
        for(int i = 0 ; i < 8 ; i++) {
            mainPage.filters.get(i).click();
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title").toLowerCase(), mainPage.filters.get(i).getText().toLowerCase());
            Thread.sleep(2000);
        }
        mainPage.sortSection.get(0).click();
    }

    @Test
    public void tutors() throws InterruptedException {

        mainPage.tabsContainer.get(3).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(3).getText(), "Tutors");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Find a tutor...");
        Assert.assertEquals(mainPage.banner.getText(), "Find an expert to help you ace your classes in-person or online.");
        Assert.assertEquals(mainPage.searchBars.get(1).getAttribute("placeholder"), "Where do you go to school?");
        mainPage.searchBars.get(1).click();
        personalizePopup(3);
        mainPage.sort.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE + "?sort=Price");
        mainPage.sort.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE + "?sort=Relevance");
        Assert.assertEquals(mainPage.filterHeaders.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 2);
        for(int i = 0 ; i < 2 ; i++) {
            mainPage.filters.get(i).click();
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title"), mainPage.filters.get(i).getText());
            Thread.sleep(2000);
        }
        mainPage.sortSection.get(0).click();

    }

    @Test
    public void textbooks() throws InterruptedException {

        mainPage.tabsContainer.get(4).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), BOOK_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(4).getText(), "Textbooks");
        Assert.assertEquals(mainPage.banner.getText(), "Compare the best prices to buy, rent or sell your textbooks.");
        Assert.assertEquals(mainPage.searchBars.get(1).getAttribute("placeholder"), "Where do you go to school?");
        mainPage.searchBars.get(1).click();
        personalizePopup(4);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Textbook title or ISBN...");
        driver.get(BOOK_PAGE + "/9781400201655");
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.filterHeaders.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 3);
        Thread.sleep(2000);
        for(int i = 0 ; i < 3 ; i++) {
            mainPage.filters.get(i).click();
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title"), mainPage.filters.get(i).getText().toLowerCase());
            Thread.sleep(2000);
        }
        mainPage.filterHeaders.get(0).click();
        mainPage.sort.get(1).click();
        mainPage.sort.get(0).click();
        mainPage.sortSection.get(0).click();

    }

    @Test
    public void jobs() throws InterruptedException {

        mainPage.tabsContainer.get(5).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), JOB_PAGE);
        Assert.assertEquals(mainPage.tabsContainer.get(5).getText(), "Jobs");
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),"Your field of expertise...");
        Assert.assertEquals(mainPage.banner.getText().trim(), "Find jobs and internships catered specifically to students.");
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.filterHeaders.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 4);
        for(int i = 0 ; i < 4 ; i++) {
            mainPage.filters.get(i).click();
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title"), mainPage.filters.get(i).getText());
            Thread.sleep(2000);
        }
        mainPage.sortSection.get(0).click();

    }


}
