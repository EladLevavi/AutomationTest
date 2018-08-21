package com.cloudents.AutomationTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TokenPage {

    @FindBy(xpath = "//*[@id=\"mainnav\"]/nav/a[1]/img[1]")
    public WebElement headerLink;

    @FindBy(xpath = "//*[@id=\"whitepaper-nav\"]/a")
    public WebElement downloadWhitepaper;

    @FindBy(xpath = "//*[@id=\"telegram-nav\"]/a")
    public WebElement joinTelegram;

    @FindBy(xpath = "//*[@id=\"telegram-nav\"]/a")
    public WebElement joinUsOnTelegram;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[3]/ul/li[5]/a")
    public WebElement whitepaperLink;

    @FindBy(xpath = "//*[@id=\"contact-form\"]/div[2]/input")
    public WebElement yourName;

    @FindBy(xpath = "//*[@id=\"contact-form\"]/div[3]/input")
    public WebElement yourEmail;

    @FindBy(xpath = "//*[@id=\"contact-form\"]/div[4]/textarea")
    public WebElement yourMessage;

    @FindBy(xpath = "//*[@id=\"contact-form\"]/div[5]/button")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[1]/a/img")
    public WebElement homePage;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[3]/ul/li[6]/a")
    public WebElement oldSpitball;

    @FindBy(xpath = "//*[@id=\"footer\"]/ul/li[1]/a")
    public WebElement privacy;

    @FindBy(xpath = "//*[@id=\"footer\"]/ul/li[2]/a")
    public WebElement terms;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[3]/ul/li[1]/a")
    public WebElement roadmapLink;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[3]/ul/li[2]/a")
    public WebElement usecasesLink;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[3]/ul/li[3]/a")
    public WebElement teamLink;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[3]/ul/li[4]/a")
    public WebElement contactLink;

    @FindBy(xpath = "//*[@id=\"subscribe-form\"]/input")
    public WebElement emailText;

    @FindBy(xpath = "//*[@id=\"subscribe-form\"]/button")
    public WebElement subscribeButton;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[1]/ul/li[1]")
    public WebElement telegramIcon;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[1]/ul/li[2]")
    public WebElement facebookIcon;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[1]/ul/li[3]/a/em")
    public WebElement twitterIcon;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[1]/ul/li[4]/a/em")
    public WebElement youtubeIcon;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[1]/ul/li[5]/a/em")
    public WebElement githubIcon;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[1]/ul/li[6]/a/em")
    public WebElement linkedinIcon;

    @FindBy(xpath = "//*[@id=\"partners\"]/div[5]/div[5]/div[1]/ul/li[7]/a/em")
    public WebElement mediumIcon;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[2]/div/div/img")
    public WebElement image1;

    @FindBy(xpath = "//*[@id=\"tokenSale\"]/div/div/div[1]/img")
    public WebElement image2;

    @FindBy(xpath = "//*[@id=\"apps\"]/div[2]/div/div[2]/div/img")
    public WebElement image3;

    @FindBy(xpath = "/html/body/div[6]/div[2]/div[2]/div/img")
    public WebElement image4;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div[2]/div[1]/div/h1/span[1]")
    public WebElement header1;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div/h2")
    public WebElement header2;

    @FindBy(xpath = "//*[@id=\"tokenSale\"]/div/div/div[2]/h2[1]")
    public WebElement header3a;

    @FindBy(xpath = "//*[@id=\"tokenSale\"]/div/div/div[2]/h2[2]")
    public WebElement header3b;

    @FindBy(xpath = "//*[@id=\"apps\"]/div[2]/div/div[1]/div/h2[1]")
    public WebElement header4a;

    @FindBy(xpath = "//*[@id=\"apps\"]/div[2]/div/div[1]/div/h2[2]/b")
    public WebElement header4b;

    @FindBy(xpath = "//*[@id=\"roadmap\"]/div/div[1]/div/div/h2")
    public WebElement header5;

    @FindBy(xpath = "//*[@id=\"team\"]/div/div[1]/div/div/h2")
    public WebElement header6;

    @FindBy(xpath = "/html/body/div[6]/div[2]/div[2]/div/h2")
    public WebElement header7;

    @FindBy(xpath = "//*[@id=\"contact\"]/div[2]/div[1]/div/div/h2")
    public WebElement header8;

}
