package com.cloudents.AutomationTest;


import com.cloudents.AutomationTest.Resources.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Drivers.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;
import static com.cloudents.AutomationTest.Resources.Methods.*;



public class MainTabs extends CloudentsAutoTests {


    @Test
    public void homeworkHelp() throws InterruptedException {

        Drivers.driver.navigate().to(HOMEWORK_PAGE);
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);

        // Texts validation
        /*textValidation(0);
        mainPage.filters.get(0).click();
        Thread.sleep(1000);
        Assert.assertTrue(homeworkHelpPage.questionPrice.get(0).getAttribute("innerText").contains("SBL"));
        Assert.assertTrue(homeworkHelpPage.questionPrice.get(0).getAttribute("innerText").contains("Earn"));
        mainPage.filters.get(0).click();
        Thread.sleep(1000);
        mainPage.filters.get(2).click();
        Assert.assertTrue(homeworkHelpPage.questionPrice.get(0).getAttribute("innerText").contains("SOLD"));

        // Clicking on filters
        for(int i = 0 ; i < 27 ; i++) {
            mainPage.filters.get(i).click();
            Thread.sleep(1000);
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title"), mainPage.filters.get(i).getText());
        }
        for(int i = 0 ; i < 2 ; i++) {
            mainPage.filterSections.get(i).click();
        }*/

        // Clicking on ask button
        homeworkHelpPage.askButton.click();
        personalizePopup(0);

        // Number of results bigger than 50 (paging is working)
        resultsCount(0);

    }

    @Test
    public void studyDocuments() throws InterruptedException {

        driver.navigate().to(STUDY_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE);
        textValidation(1);
        //mainPage.searchBars.get(1).click();
        //personalizePopup(1);
        Thread.sleep(500);
        //mainPage.sort.get(1).click();
        Thread.sleep(1000);
        //Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Relevance");
        //mainPage.sort.get(0).click();
        Thread.sleep(1000);
        //Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE + "?sort=Date");
        //Assert.assertEquals(mainPage.filterSections.size(), 0);
        /*Assert.assertEquals(mainPage.filters.size(), 5);
        for(int i = 0 ; i < 5 ; i++) {
            mainPage.filters.get(i).click();
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title"), mainPage.filters.get(i).getText());
            Thread.sleep(2000);
        }
        mainPage.filterSections.get(0).click();*/
        resultsCount(1);

    }

    /*@Test
    public void flashcards() throws InterruptedException {

        driver.navigate().to(FLASHCARD_PAGE);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE);
        textValidation(2);
        //mainPage.searchBars.get(1).click();
        //personalizePopup(2);
        Thread.sleep(5000);
        //mainPage.sort.get(1).click();
        Thread.sleep(2000);
        //Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=Relevance");
        //mainPage.sort.get(0).click();
        Thread.sleep(2000);
        //Assert.assertEquals(driver.getCurrentUrl(), FLASHCARD_PAGE + "?sort=Date");
        Assert.assertEquals(mainPage.filterSections.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 8);
        for(int i = 0 ; i < 8 ; i++) {
            mainPage.filters.get(i).click();
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title").toLowerCase(), mainPage.filters.get(i).getText().toLowerCase());
            Thread.sleep(1000);
        }
        mainPage.filterSections.get(0).click();
        resultsCount(2);
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
        Assert.assertEquals(mainPage.filterSections.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 2);
        for(int i = 0 ; i < 2 ; i++) {
            mainPage.filters.get(i).click();
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title"), mainPage.filters.get(i).getText());
            Thread.sleep(2000);
        }
        mainPage.filterSections.get(0).click();
        resultsCount(3);

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
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.filterSections.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 3);
        Thread.sleep(2000);
        for(int i = 0 ; i < 3 ; i++) {
            mainPage.filters.get(i).click();
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title"), mainPage.filters.get(i).getText().toLowerCase());
            Thread.sleep(2000);
        }
        mainPage.filterSections.get(0).click();
        mainPage.sort.get(1).click();
        mainPage.sort.get(0).click();
        mainPage.filterSections.get(0).click();
        resultsCount(4);

    }

    @Test
    public void jobs() throws InterruptedException {

        mainPage.tabsContainer.get(5).click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), JOB_PAGE);
        textValidation(5);
        Thread.sleep(3000);
        Assert.assertEquals(mainPage.filterSections.size(), 1);
        Assert.assertEquals(mainPage.filters.size(), 4);
        for(int i = 0 ; i < 4 ; i++) {
            mainPage.filters.get(i).click();
            Assert.assertEquals(mainPage.filters.get(i).getAttribute("title"), mainPage.filters.get(i).getText());
            Thread.sleep(2000);
        }
        mainPage.filterSections.get(0).click();


    }*/


}
