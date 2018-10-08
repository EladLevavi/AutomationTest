package com.cloudents.AutomationTest;


import org.junit.rules.Timeout;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOError;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.cloudents.AutomationTest.Resources.*;
import static org.testng.Assert.assertTrue;




public class CloudentsAutoTests {



    @BeforeTest
    public void driverSetup() {

        loadSafariDriver();

        //loadChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Resources.initElements();
        Resources.winHandleBefore = driver.getWindowHandle();

    }

    @BeforeTest
    public void homePage() throws InterruptedException {

        driver.get(HOME_PAGE);
        Thread.sleep(3000);
        mainPage.cookieApprove.click();

    }




    @AfterClass
    public void cleanupTestSeries() {

        driver.quit();

    }

}
