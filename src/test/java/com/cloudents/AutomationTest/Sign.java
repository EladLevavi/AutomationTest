package com.cloudents.AutomationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;
import static com.cloudents.AutomationTest.Resources.Drivers.*;
import static com.cloudents.AutomationTest.Resources.Pages.*;
import static com.cloudents.AutomationTest.Resources.Strings.*;
import static com.cloudents.AutomationTest.Resources.Images.*;
import static com.cloudents.AutomationTest.Resources.Methods.*;
import static org.testng.Assert.assertTrue;

public class Sign extends CloudentsAutoTests {

    @Test
    public void signupWithGoogle() throws InterruptedException {

        landingPage.signupButton.click();
        Thread.sleep(1000);
        assertTrue(driver.getCurrentUrl().contains(SIGNUP_PAGE));
        Assert.assertTrue(signPage.stepTitle.getText().equalsIgnoreCase(SIGNUP_TITLES[0]));
        Assert.assertTrue(signPage.signupWithGoogle.getText().equalsIgnoreCase(SIGN_BUTTONS_TEXT[0]));
        Assert.assertTrue(signPage.signupWithEmail.getText().equalsIgnoreCase(SIGN_BUTTONS_TEXT[1]));
        Assert.assertTrue(signPage.agreeCheckbox.getText().equalsIgnoreCase(AGREEMENT_TEXT));
        Assert.assertTrue(signPage.signinStrip.getText().equalsIgnoreCase(SIGNIN_LINK));
        Assert.assertEquals(signPage.image.getAttribute("src"),SIGNUP_IMAGE);
        Assert.assertTrue(signPage.textSeperator.getText().equalsIgnoreCase(SEPERATOR_TEXT));
        signPage.checkBox.click();
        Thread.sleep(1000);
        signPage.signupWithGoogle.click();
        Thread.sleep(1000);
        Set<String> winHandles = driver.getWindowHandles();
        winHandles.forEach(winHandle -> driver.switchTo().window(winHandle));
        Assert.assertTrue(driver.getCurrentUrl().contains(GOOGLE_SIGNIN_PAGE));
        signPage.gmailInput.sendKeys(USERNAME);
        signPage.gmailNext.click();
        Thread.sleep(1000);
        signPage.gmailPassword.sendKeys("3l@d*1805");
        signPage.passwordNext.click();
        Thread.sleep(8000);
        driver.switchTo().window(winHandleBefore);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE);

    }

    @Test
    public void signupWithEmail() throws InterruptedException {

        landingPage.signupButton.click();
        Thread.sleep(1000);
        assertTrue(driver.getCurrentUrl().contains(SIGNUP_PAGE));
        Assert.assertTrue(signPage.stepTitle.getText().equalsIgnoreCase(SIGNUP_TITLES[0]));
        Assert.assertTrue(signPage.signupWithGoogle.getText().equalsIgnoreCase(SIGN_BUTTONS_TEXT[0]));
        Assert.assertTrue(signPage.signupWithEmail.getText().equalsIgnoreCase(SIGN_BUTTONS_TEXT[1]));
        Assert.assertTrue(signPage.agreeCheckbox.getText().equalsIgnoreCase(AGREEMENT_TEXT));
        Assert.assertTrue(signPage.signinStrip.getText().equalsIgnoreCase(SIGNIN_LINK));
        Assert.assertEquals(signPage.image.getAttribute("src"),SIGNUP_IMAGE);
        Assert.assertTrue(signPage.textSeperator.getText().equalsIgnoreCase(SEPERATOR_TEXT));
        signPage.checkBox.click();
        Thread.sleep(1000);
        signPage.signupWithEmail.click();
        Thread.sleep(1000);
        signPage.emailInput.sendKeys("elad+2@cloudents.com");
        signPage.passwordField.sendKeys(PASSWORD);
        signPage.passwordConfirm.sendKeys(PASSWORD);
        signPage.recaptcha.click();
        signPage.continueSignup.click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE);

    }

    @Test
    public void resetPassword() throws InterruptedException {

        landingPage.loginButton.click();
        Thread.sleep(1000);
        signPage.signWithEmail.click();
        Thread.sleep(1000);
        signPage.enterEmail.sendKeys(USERNAME);
        signPage.continueButton.click();
        Thread.sleep(1000);
        signPage.forgotPassword.click();
        Thread.sleep(1000);
        Assert.assertEquals(signPage.image.getAttribute("src"), LOGIN_IMAGE);
        Assert.assertEquals(signPage.stepTitle.getText(), RESET_PASSWORD_LINK);
        Assert.assertEquals(signPage.subTitle.getText(), RESET_PASSWORD_TITLE);
        Assert.assertEquals(signPage.enterEmail.getAttribute("placeholder"), EMAIL_PLACEHOLDER);
        signPage.enterEmail.sendKeys(USERNAME);
        signPage.enterEmail.clear();
        signPage.enterEmail.sendKeys(" ");
        Assert.assertEquals(signPage.loginLink.get(0).getText(), LOGIN_LINK);
        signPage.loginLink.get(0).click();
        Assert.assertEquals(signPage.image.getAttribute("src"), LOGIN_IMAGE);
        Assert.assertEquals(signPage.stepTitle.getText(), LOGIN_TITLES[0]);
        driver.navigate().back();

    }

    @Test
    public void loginWithEmail() throws InterruptedException {

        landingPage.loginButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(signPage.signWithGoogle.getText().equalsIgnoreCase(SIGN_BUTTONS_TEXT[2]));
        Assert.assertTrue(signPage.signWithEmail.getText().equalsIgnoreCase(SIGN_BUTTONS_TEXT[3]));
        Assert.assertEquals(signPage.signinStrip.getText(), SIGNUP_LINK);
        signPage.signWithEmail.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE);
        Assert.assertEquals(signPage.stepTitle.getText(), LOGIN_TITLES[0]);
        //Assert.assertEquals(signPage.image.getAttribute("src"),SIGNUP_IMAGE);
        signPage.emailInput.sendKeys(USERNAME);
        signPage.continueButton.click();
        signPage.password.sendKeys(PASSWORD);
        signPage.loginButton.click();
        Thread.sleep(5000);

    }

    @Test
    public void loginWithGoogle() throws InterruptedException {

        driver.navigate().to(HOME_PAGE);
        landingPage.loginButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(signPage.signWithGoogle.getText().equalsIgnoreCase(SIGN_BUTTONS_TEXT[2]));
        Assert.assertTrue(signPage.signWithEmail.getText().equalsIgnoreCase(SIGN_BUTTONS_TEXT[3]));
        Assert.assertEquals(signPage.signinStrip.getText(), SIGNUP_LINK);
        signPage.signWithGoogle.click();
        Thread.sleep(2000);
        Set<String> winHandles = driver.getWindowHandles();
        winHandles.forEach(winHandle -> driver.switchTo().window(winHandle));
        Assert.assertTrue(driver.getCurrentUrl().contains(GOOGLE_SIGNIN_PAGE));
        signPage.gmailInput.sendKeys(USERNAME);
        signPage.gmailNext.click();
        Thread.sleep(1000);
        signPage.gmailPassword.sendKeys("3l@d*1805");
        signPage.passwordNext.click();
        Thread.sleep(8000);
        driver.switchTo().window(winHandleBefore);
        Assert.assertEquals(driver.getCurrentUrl(), STUDY_PAGE);

    }


}
