package com.cloudents.AutomationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.*;



public class MainTabs extends CloudentsAutoTests {


    @Test
    public void homeworkHelp() throws InterruptedException {

        mainPage.tabsContainer.get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);
        textValidation(0);
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
        resultsCount();

    }

    @Test
    public void studyDocuments() throws InterruptedException {

        mainPage.tabsContainer.get(1).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE);
        textValidation(0);
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
        resultsCount();

    }

    @Test
    public void flashcards() throws InterruptedException {

        mainPage.tabsContainer.get(2).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE);
        textValidation(2);
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
        resultsCount();
    }

    @Test
    public void tutors() throws InterruptedException {

        mainPage.tabsContainer.get(3).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), TUTOR_PAGE);
        textValidation(3);
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
        resultsCount();

    }

    @Test
    public void textbooks() throws InterruptedException {

        mainPage.tabsContainer.get(4).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), BOOK_PAGE);
        textValidation(4);
        mainPage.searchBars.get(1).click();
        Thread.sleep(1000);
        personalizePopup(4);
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.searchBar.getAttribute("placeholder"),SEARCHBAR_PLACEHOLDER[4]);
        mainPage.results.get(0).click();
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
        resultsCount();

    }

    @Test
    public void jobs() throws InterruptedException {

        mainPage.tabsContainer.get(5).click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), JOB_PAGE);
        textValidation(5);
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
