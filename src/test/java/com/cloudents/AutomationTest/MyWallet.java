package com.cloudents.AutomationTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static com.cloudents.AutomationTest.Resources.Images.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;



public class MyWallet extends CloudentsAutoTests {

    @Test
    public void wallet() throws InterruptedException {

        // Initialize
        loginUser();
        Thread.sleep(2000);
        mainPage.userMenuIcon.click();
        Thread.sleep(500);
        mainPage.userMenuItems.get(0).click();
        Thread.sleep(1000);

        Assert.assertEquals(myWalletPage.headerTitle.getText(), WALLET_TITLE);

        for(int i = 0 ; i < 3 ; i++)
            Assert.assertEquals(myWalletPage.tabs.get(i).getText(), WALLET_TABS[i]);

        for(int i = 0 ; i < 2 ; i++) {
            Assert.assertEquals(myWalletPage.sblTypes.get(i+1).getAttribute("innerText"), BALANCES_HEADER[i]);
        }
        for(int i = 0 , j = 3 ; i < 4 ; i++ , j = j + 3)
            Assert.assertEquals(myWalletPage.sblTypes.get(j).getAttribute("innerText"), TRANSACTION_TYPES[i]);

        myWalletPage.tabs.get(1).click();
        Thread.sleep(1000);
        for(int i = 0 ; i < 5 ; i++) {
            Assert.assertEquals(myWalletPage.tableHeaders.get(i).getAttribute("innerText"), TRANSACTION_TABLE[i]);
        }

        myWalletPage.tabs.get(2).click();
        Thread.sleep(1000);
        //Assert.assertTrue(myWalletPage.cashoutText.getText().contains(CASH_OUT_TITLE));
        for(int i = 0 ; i < 4 ; i++)
            Assert.assertTrue(myWalletPage.redeemButton.getAttribute("innerText").equalsIgnoreCase(REDEEM_BUTTON));
        Thread.sleep(500);
        for(int i = 0 ; i < 4 ; i++ )
            Assert.assertEquals(myWalletPage.redeemableSBL.getAttribute("innerText"), REDEEM_VALUES);
        //for(int i = 0 ; i < 4 ; i++)
            //Assert.assertEquals(myWalletPage.images.getAttribute("src"), CASHOUT_IMAGES);

    }

}
