package com.cloudents.AutomationTest;

import com.cloudents.AutomationTest.Resources.Drivers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;


public class TutorList extends CloudentsAutoTests {

    @Test
    public void English() throws InterruptedException {

        Actions builder = new Actions(Drivers.driver);

        Drivers.driver.navigate().to(TUTOR_LIST_PAGE);

        for(int i = 1 ; i < 3 ; i ++) {
            System.out.println(tutorListPage.tutorCards.size());
            Assert.assertEquals(tutorListPage.tutorCards.size(), 20*i);
            builder.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
            Thread.sleep(1000);
        }


        landingPage.logoIcon.click();
        Thread.sleep(2000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), HOME_PAGE + "/");
        Drivers.driver.navigate().back();
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.hebrewButton.getText(), TUTOR_HEBREW);
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.signButtons.get(0).getText(), TUTOR_LOGIN);
        landingPage.signButtons.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), LOGIN_PAGE);
        Drivers.driver.navigate().back();
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.signButtons.get(1).getText(), TUTOR_SIGNUP);
        landingPage.signButtons.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), SIGNUP_PAGE);
        Drivers.driver.navigate().back();
        Thread.sleep(2000);
        Assert.assertEquals(tutorListPage.title.getText(), TUTOR_LIST_TITLE);
        Assert.assertEquals(tutorListPage.subTitles.get(0).getText(), TUTOR_SUB_TITLES[0]);
        Assert.assertEquals(tutorListPage.subTitles.get(1).getText(), TUTOR_SUB_TITLES[1]);
        Assert.assertEquals(tutorListPage.searchBar.getAttribute("placeholder"), TUTOR_SEARCH_PLACEHOLDER);
        Assert.assertTrue(tutorListPage.tutorCards.size()>10);
        Assert.assertTrue(tutorListPage.contactButton.getText().contains("Send "));

        builder.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Assert.assertEquals(tutorListPage.footerTitles.get(0).getText(), TUTOR_SUB_TITLES[1]);
        Assert.assertEquals(tutorListPage.footerTitles.get(1).getText(), TUTOR_COURSES_COUNTER);
        Assert.assertEquals(tutorListPage.footerTitles.get(2).getText(), TUTOR_TUTORS_COUNTER);
        Assert.assertEquals(tutorListPage.searchBar.getAttribute("placeholder"), TUTOR_SEARCH_PLACEHOLDER);

        footerLinksTest();
        tutorCarouselTest();

    }

    @Test
    public void Hebrew() throws InterruptedException {

        Actions builder = new Actions(Drivers.driver);

        Drivers.driver.navigate().to(TUTOR_LIST_PAGE);

        for(int i = 1 ; i < 3 ; i ++) {
            System.out.println(tutorListPage.tutorCards.size());
            Assert.assertEquals(tutorListPage.tutorCards.size(), 20*i);
            builder.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
            Thread.sleep(1000);
        }

        landingPage.logoIcon.click();
        Thread.sleep(2000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), HOME_PAGE + "/");
        Drivers.driver.navigate().back();
        Thread.sleep(2000);
        Drivers.driver.navigate().to(TUTOR_LIST_PAGE);
        landingPage.hebrewButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.hebrewButton.getText(), TUTOR_ENGLISH);
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.signButtons.get(0).getText(), TUTOR_LOGIN_H);
        landingPage.signButtons.get(0).click();
        Thread.sleep(2000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), LOGIN_PAGE);
        Drivers.driver.navigate().back();
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.signButtons.get(1).getText(), TUTOR_SIGNUP_H);
        landingPage.signButtons.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(Drivers.driver.getCurrentUrl(), SIGNUP_PAGE);
        Drivers.driver.navigate().back();
        Thread.sleep(2000);
        Assert.assertEquals(tutorListPage.title.getText(), TUTOR_LIST_TITLE_H);
        Assert.assertEquals(tutorListPage.subTitles.get(0).getText(), TUTOR_SUB_TITLES_H[0]);
        Assert.assertEquals(tutorListPage.subTitles.get(1).getText(), TUTOR_SUB_TITLES_H[1]);
        Assert.assertEquals(tutorListPage.searchBar.getAttribute("placeholder"), TUTOR_SEARCH_PLACEHOLDER_H);
        Assert.assertTrue(tutorListPage.tutorCards.size()>10);
        Assert.assertTrue(tutorListPage.contactButton.getText().contains("שלחו ל"));


        builder.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Assert.assertEquals(tutorListPage.footerTitles.get(0).getText(), TUTOR_SUB_TITLES_H[1]);
        Assert.assertEquals(tutorListPage.footerTitles.get(1).getText(), TUTOR_COURSES_COUNTER_H);
        Assert.assertEquals(tutorListPage.footerTitles.get(2).getText(), TUTOR_TUTORS_COUNTER_H);
        Assert.assertEquals(tutorListPage.searchBar.getAttribute("placeholder"), TUTOR_SEARCH_PLACEHOLDER_H);
        Assert.assertEquals(tutorListPage.tutorCarousel.size(), 3);

        footerLinksHebTest();
        tutorCarouselHebTest();

    }

}
