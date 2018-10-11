package com.cloudents.AutomationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;
import static com.cloudents.AutomationTest.Resources.*;
import static org.testng.Assert.assertTrue;

public class Sign extends CloudentsAutoTests {

    @Test
    public void signUp() throws InterruptedException {

        mainPage.signButtons.get(0).click();
        Thread.sleep(5000);
        assertTrue(driver.getCurrentUrl().contains(SIGNUP_PAGE));
        Assert.assertEquals(signUpPage.stepTitle.getText(), SIGNUP_TITLES[0]);
        Assert.assertEquals(signUpPage.googleButtons.get(1).getText(),SIGN_BUTTONS_TEXT[0]);
        Assert.assertEquals(signUpPage.signWithEmailButtons.get(1).getText(),SIGN_BUTTONS_TEXT[1]);
        Assert.assertEquals(signUpPage.checkboxTerms.getText(), AGREEMENT_TEXT);
        Assert.assertEquals(signUpPage.signinStrip.getText(), SIGNIN_LINK);
        Assert.assertEquals(signUpPage.image.getAttribute("src"),SIGNUP_IMAGE);
        Assert.assertEquals(signUpPage.textSeperator.getText(), SEPERATOR_TEXT);
        signUpPage.termsLinks.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
        driver.navigate().back();
        signUpPage.termsLinks.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), PRIVACY_PAGE);
        driver.navigate().back();
        signUpPage.googleButtons.get(1).click();
        Assert.assertEquals(signUpPage.errorMessage.getText(), AGREEMENT_NOT_CHECKED);
        driver.navigate().refresh();
        signUpPage.signWithEmailButtons.get(1).click();
        Assert.assertEquals(signUpPage.errorMessage.getText(), AGREEMENT_NOT_CHECKED);
        signUpPage.agreeCheckbox.click();
        Thread.sleep(500);
        signUpPage.googleButtons.get(1).click();
        Set<String> winHandles = driver.getWindowHandles();
        winHandles.forEach(winHandle -> driver.switchTo().window(winHandle));
        Assert.assertTrue(driver.getCurrentUrl().contains(GOOGLE_SIGNIN_PAGE));
        driver.close();
        driver.switchTo().window(winHandleBefore);
        signUpPage.signWithEmailButtons.get(1).click();
        //Assert.assertEquals(signUpPage.stepTitle.getText(), SIGNUP_TITLES[1]);
        Assert.assertEquals(signUpPage.emailInput.getAttribute("placeholder"), EMAIL_PLACEHOLDER);
        Assert.assertEquals(signUpPage.passwordField.getAttribute("placeholder"), PASSWORD_PLACEHOLDER[0]);
        Assert.assertEquals(signUpPage.passwordConfirm.getAttribute("placeholder"), CONFIRM_PASSWORD_PLACEHOLDER);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getText(), CONTINUE_BUTTON_TEXT);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.enterEmail.sendKeys(USERNAME);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.passwordField.sendKeys(PASSWORD);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.passwordConfirm.sendKeys(PASSWORD);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        Assert.assertEquals(signUpPage.passwordHelp.getText(), PASSWORD_TIP);
        driver.navigate().back();
        Thread.sleep(2000);
        signUpPage.loginLink.get(1).click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE);
        signUpPage.signWithEmailButtons.get(0).click();
        Thread.sleep(500);
        signUpPage.continueButtons.get(0).click();
        Thread.sleep(500);
        Assert.assertEquals(signUpPage.stepTitle.getText(), LOGIN_TITLES[0]);
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        exitDialog();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);

    }

    @Test
    public void resetPassword() throws InterruptedException {

        mainPage.signButtons.get(1).click();
        signUpPage.signWithEmailButtons.get(0).click();
        signUpPage.continueButtons.get(1).click();
        Thread.sleep(1000);
        signUpPage.signinStrip.click();
        Assert.assertEquals(signPage.image.getAttribute("src"), LOGIN_IMAGE);
        Assert.assertEquals(signUpPage.stepTitle.getText(), RESET_PASSWORD_LINK);
        Assert.assertEquals(signUpPage.subTitle.getText(), RESET_PASSWORD_TITLE);
        Assert.assertEquals(signUpPage.enterEmail.getAttribute("placeholder"), EMAIL_PLACEHOLDER);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.enterEmail.sendKeys(USERNAME);
        Assert.assertNull(signUpPage.continueButtons.get(1).getAttribute("disabled"));
        signUpPage.enterEmail.clear();
        signUpPage.enterEmail.sendKeys(" ");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        Assert.assertEquals(signUpPage.loginLink.get(0).getText(), LOGIN_LINK);
        signUpPage.loginLink.get(0).click();
        Assert.assertEquals(signPage.image.getAttribute("src"), LOGIN_IMAGE);
        Assert.assertEquals(signUpPage.stepTitle.getText(), LOGIN_TITLES[0]);
        driver.navigate().back();

    }

    @Test
    public void login() throws InterruptedException {

        mainPage.signButtons.get(1).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE);
        Assert.assertEquals(signPage.stepTitle.getText(), LOGIN_TITLES[1]);
        Assert.assertEquals(signPage.googleButtons.get(0).getText(),SIGN_BUTTONS_TEXT[2]);
        Assert.assertEquals(signPage.signWithEmailButtons.get(0).getText(),SIGN_BUTTONS_TEXT[3]);
        Assert.assertEquals(signPage.signinStrip.getText(), SIGNUP_LINK);
        Assert.assertEquals(signPage.image.getAttribute("src"),SIGNUP_IMAGE);
        signUpPage.googleButtons.get(0).click();
        Thread.sleep(2000);
        Set<String> winHandles = driver.getWindowHandles();
        winHandles.forEach(winHandle -> driver.switchTo().window(winHandle));
        Assert.assertTrue(driver.getCurrentUrl().contains(GOOGLE_SIGNIN_PAGE));
        driver.close();
        driver.switchTo().window(winHandleBefore);
        Thread.sleep(1000);
        signUpPage.signWithEmailButtons.get(0).click();
        Thread.sleep(1000);
        signUpPage.createPassword.click();
        Thread.sleep(2000);
        Assert.assertEquals(signUpPage.stepTitle.getText(), CREATE_PASSWORD_TITLE);
        Assert.assertEquals(signUpPage.enterEmail.getAttribute("placeholder"), EMAIL_PLACEHOLDER);
        Assert.assertEquals(signUpPage.loginLink.get(0).getText(), NEW_PRIVACY_BUTTONS[1]);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getText(), NEW_PRIVACY_BUTTONS[0]);
        Assert.assertEquals(signPage.image.getAttribute("src"), LOGIN_IMAGE);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.enterEmail.sendKeys(USERNAME);
        Assert.assertNull(signUpPage.continueButtons.get(1).getAttribute("disabled"));
        signUpPage.enterEmail.clear();
        signUpPage.enterEmail.sendKeys(" ");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.signinStrip.click();
        Assert.assertEquals(signUpPage.stepTitle.getText(), LOGIN_TITLES[0]);
        Assert.assertEquals(signPage.emailInput.getAttribute("placeholder"), EMAIL_PLACEHOLDER);
        Assert.assertEquals(signPage.password.getAttribute("placeholder"), PASSWORD_PLACEHOLDER[1]);
        Assert.assertEquals(signUpPage.signinStrip.getText(), FORGOT_PASSWORD_LINK);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("value"), LOGIN_BUTTON_TEXT);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signPage.emailInput.sendKeys(USERNAME);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signPage.password.sendKeys(PASSWORD);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.signinStrip.click();
        Assert.assertEquals(signUpPage.stepTitle.getText(), RESET_PASSWORD_LINK);
        Assert.assertEquals(signUpPage.signinStrip.getText(), LOGIN_LINK);
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        exitDialog();
        Thread.sleep(2000);
        signUpPage.continueButtons.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);
        driver.navigate().back();
        signPage.signinStrip.click();
        Assert.assertEquals(driver.getCurrentUrl(), SIGNUP_PAGE);
        driver.get(HOME_PAGE);

    }

}
