package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyWalletPage {

    // ******* Header   **********
    @FindBy(xpath = "//*[@class='header-title']")
    public WebElement headerTitle;

    @FindBy(xpath = "//*[@class='v-tabs__div']/a")
    public List<WebElement> tabs;





    // ******   Balances   ********

    @FindBy(xpath = "//*[@class='column sortable text-xs-left']//span")
    public List<WebElement> headers;

    @FindBy(xpath = "//*[@class='text-xs-left']")
    public List<WebElement> sblTypes;






    // *********   Transaction   *********

    @FindBy(xpath = "//*[@class='transaction-table wallet-table']//span")
    public List<WebElement> tableHeaders;

    @FindBy(className = "Date-header table-header")
    public WebElement dateHeader;

    @FindBy(className = "Action-header table-header")
    public WebElement actionHeader;

    @FindBy(className = "Type-header table-header")
    public WebElement typeHeader;

    @FindBy(className = "Amount-header table-header")
    public WebElement amountHeader;

    @FindBy(className = "Balance-header table-header")
    public WebElement balanceHeader;





    // *******   Cash Out   ********

    @FindBy(className = "text-wrap")
    public WebElement cashoutText;

    @FindBy(className = "redeem-btn")
    public WebElement redeemButton;

    @FindBy(xpath = "//*[@class='cash-out-wrapper']//img")
    public WebElement images;

    @FindBy(className = "num")
    public WebElement redeemableSBL;





    // *******   Footer   ***********

    @FindBy(className = "back-button wallet")
    public WebElement closeWindow;

}
