package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;



public class AboutPage {


    // ******   Header   *******

    @FindBy(className = "v-tabs__div")
    public List<WebElement> tabsHeader;






    // ******* FAQs   *********

    @FindBy(className = "v-expansion-panel__container")
    public List<WebElement> faqHeaders;

    @FindBy(xpath = "//*[@class='v-expansion-panel__body']//p")
    public List<WebElement> faqText;






    // *******   Partners   ********

    @FindBy(xpath = "//*[@class='partner text-xs-center text-sm-left']//span")
    public WebElement partnersText;

    @FindBy(linkText = "partner@spitball.co")
    public WebElement partnerEmail;






    // ******* Reps   ********

    @FindBy(xpath = "//*[@class='reps text-xs-center text-sm-left']//span")
    public WebElement repsText;

    @FindBy(linkText = "work@spitball.co")
    public WebElement workEmail;






    // ****** Privacy   ********

    @FindBy(linkText = "support@spitball.co")
    public List<WebElement> support;

    @FindBy(linkText = "here")
    public WebElement link2;

    @FindBy(linkText = "www.spitball.co")
    public WebElement link1;








    // *******   Terms   *******

    @FindBy(className = "term")
    public WebElement termsText;

    @FindBy(linkText = "http://www.copyright.gov/legislation/dmca.pdf")
    public WebElement copyrights;






    // *******   Contact   ********

    @FindBy(xpath = "//*[@class='wrapper']//span")
    public WebElement contactText;

    @FindBy(className = "gm-style-pbc")
    public WebElement map;











    @FindBy(xpath = "//*[@class='flex social-btns mr-4 align-start justify-start']//a")
    public List<WebElement> links;

    @FindBy(xpath = "//*[@class='flex text']//p")
    public List<WebElement> paragraphs;

}
