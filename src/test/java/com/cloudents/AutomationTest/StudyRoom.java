package com.cloudents.AutomationTest;


import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Methods.loginUser;



public class StudyRoom extends CloudentsAutoTests {

    @Test
    public void testPage() throws InterruptedException {

        loginUser();
        Thread.sleep(1000);
        studyRoomPage.studyRoomItem.click();
        Thread.sleep(1000);
        studyRoomPage.enterStudyRoom.click();
        Thread.sleep(1000);

        for(int i = 0 ; i < 14 ; i ++) {
            studyRoomPage.navActions.get(i).click();
            Thread.sleep(500);
        }

    }

}
