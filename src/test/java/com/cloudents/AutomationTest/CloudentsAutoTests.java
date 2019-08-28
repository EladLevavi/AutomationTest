package com.cloudents.AutomationTest;



import com.cloudents.AutomationTest.Pages.*;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Drivers.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;





public class CloudentsAutoTests {

    // All pages instances
    public static MainPage mainPage;
    public static LandingPage landingPage;
    public static HomeworkHelpPage homeworkHelpPage;
    public static StudyDocumentsPage studyDocumentsPage;
    public static FlashcardsPage flashcardsPage;
    public static SignPage signPage;
    public static AboutPage aboutPage;
    public static TokenPage tokenPage;
    public static MyWalletPage myWalletPage;
    public static AskPopup askPopup;
    public static UniversityPage universityPage;
    public static ProfilePage profilePage;
    public static StudyRoomPage studyRoomPage;
    public static TutorListPage tutorListPage;
    public static CoursesPage coursesPage;





    // Handle for the main window
    public static String winHandleBefore;




    /*@Parameters("browser")
    @BeforeClass
    public void setup(@Optional String browser) {

        if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile myProfile = profile.getProfile("Automation");
            options.setProfile(myProfile);
            //options.addArguments("--headless");
            System.setProperty(GECKO_DRIVER, DRIVERS_LOCATION + GECKO_FILE);
            driver = new FirefoxDriver(options);
        }
        else if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless");
            System.setProperty(CHROME_DRIVER, DRIVERS_LOCATION + CHROME_FILE);
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty(EDGE_DRIVER, DRIVERS_LOCATION + EDGE_FILE);
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("Safari")) {
            DesiredCapabilities caps = DesiredCapabilities.safari();
            caps.setCapability("platform", "macOS 10.12");
            caps.setCapability("version", "11.0");
            driver = new SafariDriver();
        }


        Resources.initElements();
        Resources.winHandleBefore = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }*/

    @BeforeTest
    public void driverSetup() {

        //loadEdgeDriver();

        //loadFFDriver();

        loadChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        initElements();
        winHandleBefore = driver.getWindowHandle();

    }

    @BeforeTest
    public void homePage() {

        driver.get(HOME_PAGE);
        //mainPage.cookieApprove.click();

    }


    @AfterClass
    public void cleanupTestSeries() {

        driver.quit();

    }

}
