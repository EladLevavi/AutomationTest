package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TokenPage {

    // ********   Header   ********

    @FindBy(xpath = "//*[@id='mainnav']//a")
    public WebElement spitballLink;

    @FindBy(xpath = "//*[@class='navbar-nav animated remove-animation fadeInDown']//li//a")
    public List<WebElement> headerLinks;






    // *******   Paragraph 1   ***********

    @FindBy(xpath = "//*[@class='countdown-box countdown-transparent text-center']//iframe")
    public WebElement youtube;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(className = "btn btn-plane")
    public WebElement subscribeButton;

    @FindBy(xpath = "//*[@class='header-txt']")
    public WebElement paragraph1;

    @FindBy(xpath = "//*[@class='header-subscription']//h6")
    public WebElement subscribtion;





    // ********   Paragraph 2   ************

    @FindBy(xpath = "//*[@class='section-bg-angle section-muscari']//img")
    public WebElement hevreImage;

    @FindBy(xpath = "//*[@class='section section-pad-md section-bg-muscari section-angle']//h2")
    public WebElement paragraph2Header;

    @FindBy(xpath = "//*[@class='section-head-s4']")
    public WebElement para2part1;

    @FindBy(xpath = "//*[@class='lead animated blue undefined']")
    public WebElement para2part2;











    // ********   Paragraph 3   ***********

    @FindBy(xpath = "//*[@class='col-lg-7 res-m-bttm']//img")
    public WebElement laptopImage;

    @FindBy(className = "row align-items-start")
    public WebElement paragraph3;







    // *********   Paragraph 4   ***********

    @FindBy(xpath = "//*[@class='section section-pad-md section-bg-muscari section-muscari']//img")
    public WebElement graphImage;







    // *********   Paragraph 5   ***********








    // *********   Paragraph 6   ***********

    @FindBy(xpath = "//*[@id='team']//img")
    public List<WebElement> employeeImages;

    @FindBy(className = "team-info")
    public WebElement teamInfo;







    // *********   Paragraph 7   ***********

    @FindBy(xpath = "//*[@class='section section-pad-md section-bg-light']//img")
    public WebElement logosImage;








    // ********   Get in touch   ********

    @FindBy(xpath = "//*[@class='col-lg-4 offset-lg-1']//h2")
    public WebElement titleText;

    @FindBy(xpath = "//*[@class='col-lg-4 offset-lg-1']//p")
    public WebElement contactText;

    @FindBy(xpath = "//*[@class='contact-info-alt']//span")
    public List<WebElement> contactTypes;

    @FindBy(className = "input-field animated fadeInUp")
    public List<WebElement> nameAndEmail;

    @FindBy(className = "txtarea input-line required")
    public WebElement messageArea;

    @FindBy(className = "btn")
    public WebElement submitButton;







    // ********   Footer   **********

    @FindBy(xpath = "//*[@class='container']//img")
    public List<WebElement> logo;

    @FindBy(xpath = "//*[@class='social']//a")
    public List<WebElement> socialLinks;

    @FindBy(className = "copyright-text")
    public WebElement copyrightText;

    @FindBy(xpath = "//*[@class='link-widget animated fadeInUp']//a")
    public List<WebElement> innerLinks;

    @FindBy(xpath = "//*[@class='footer-links']//a")
    public List<WebElement> footerLinks;

}
