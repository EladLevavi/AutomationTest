package com.cloudents.AutomationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cloudents.AutomationTest.Resources.*;
import static org.testng.Assert.assertTrue;

public class Sign extends CloudentsAutoTests {

    @Test
    public void signUp() throws InterruptedException {

        mainPage.signButtons.get(0).click();
        Thread.sleep(1000);
        assertTrue(driver.getCurrentUrl().contains(SIGNUP_PAGE));
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Ask Questions & receive instant help or Answer Questions & make money");
        Assert.assertEquals(signUpPage.googleButton.getText(),"Sign Up with Google");
        Assert.assertEquals(signUpPage.signWithEmail.getText(),"Sign Up with Email");
        Assert.assertEquals(signUpPage.checkboxTerms.getText(), "I agree to Spitball's Terms of Services and Privacy Policy");
        Assert.assertEquals(signUpPage.signinStrip.getText(), "Do you already have an account?   Sign in");
        Assert.assertEquals(signUpPage.image.getAttribute("src"),SIGNUP_IMAGE);
        signUpPage.termsLinks.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), TERMS_PAGE);
        driver.navigate().back();
        signUpPage.termsLinks.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), PRIVACY_PAGE);
        driver.navigate().back();
        signUpPage.googleButton.click();
        Assert.assertEquals(signUpPage.errorMessage.getText(), "Please agree to Terms And Services in order to proceed");
        driver.navigate().refresh();
        signUpPage.signWithEmail.click();
        Assert.assertEquals(signUpPage.errorMessage.getText(), "Please agree to Terms And Services in order to proceed");
        signUpPage.agreeCheckbox.click();
        Thread.sleep(500);
        signUpPage.googleButton.click();
        //checkNewWindowAddress(GOOGLE_SIGNIN_PAGE);
        signUpPage.signWithEmail.click();
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Start with your email. We need to know how to contact you.");
        Assert.assertEquals(signUpPage.emailInput.getAttribute("placeholder"), "Enter your email");
        Assert.assertEquals(signUpPage.passwordField.getAttribute("placeholder"), "Choose password");
        Assert.assertEquals(signUpPage.passwordConfirm.getAttribute("placeholder"), "Confirm password");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getText(), "Continue");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.enterEmail.sendKeys(USERNAME);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.passwordField.sendKeys(PASSWORD);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.passwordConfirm.sendKeys(PASSWORD);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        Assert.assertEquals(signUpPage.passwordHelp.getText(), "Weak");
        driver.navigate().back();
        signUpPage.loginLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE);
        signUpPage.signWithEmail.click();
        Thread.sleep(500);
        signUpPage.continueButtons.get(1).click();
        Thread.sleep(500);
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Welcome back\nplease login");
        driver.navigate().back();
        mainPage.backButton.click();
        Thread.sleep(500);
        Assert.assertNotNull(mainPage.exitDialog);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getText(), "Exit");
        Assert.assertEquals(mainPage.exitWindowText.getText(), "Are you sure you want to exit?");
        Thread.sleep(2000);
        signUpPage.continueButtons.get(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);

    }

    @Test
    public void resetPassword() throws InterruptedException {

        mainPage.signButtons.get(1).click();
        signUpPage.signWithEmail.click();
        signUpPage.continueButtons.get(1).click();
        Thread.sleep(1000);
        signUpPage.signinStrip.click();
        Assert.assertEquals(loginPage.image.getAttribute("src"), LOGIN_IMAGE);
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Reset your password");
        Assert.assertEquals(signUpPage.subTitle.getText(), "Don’t be ashamed. It happens to the best.");
        Assert.assertEquals(signUpPage.enterEmail.getAttribute("placeholder"), "Enter your email");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.enterEmail.sendKeys(USERNAME);
        Assert.assertNull(signUpPage.continueButtons.get(1).getAttribute("disabled"));
        signUpPage.enterEmail.clear();
        signUpPage.enterEmail.sendKeys(" ");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        Assert.assertEquals(signUpPage.loginLink.getText(), "I remember now!");
        signUpPage.loginLink.click();
        Assert.assertEquals(loginPage.image.getAttribute("src"), LOGIN_IMAGE);
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Welcome back\nplease login");
        driver.navigate().back();

    }

    @Test
    public void login() throws InterruptedException {

        mainPage.signButtons.get(1).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE);
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Ask Questions & receive instant help or Answer Questions & make money");
        Assert.assertEquals(signUpPage.googleButton.getText(),"Sign In with Google");
        Assert.assertEquals(signUpPage.signWithEmail.getText(),"Sign In with Email");
        Assert.assertEquals(signUpPage.signinStrip.getText(), "Need an account?  Sign up");
        Assert.assertEquals(loginPage.image.getAttribute("src"),SIGNUP_IMAGE);
        signUpPage.googleButton.click();
        //checkNewWindowAddress(GOOGLE_SIGNIN_PAGE);
        signUpPage.signWithEmail.click();
        signUpPage.createPassword.click();
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Create your password");
        Assert.assertEquals(signUpPage.enterEmail.getAttribute("placeholder"), "Enter your email");
        Assert.assertEquals(signUpPage.loginLink.getText(), "I already have a password!");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getText(), "Create password");
        Assert.assertEquals(loginPage.image.getAttribute("src"), LOGIN_IMAGE);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.enterEmail.sendKeys(USERNAME);
        Assert.assertNull(signUpPage.continueButtons.get(1).getAttribute("disabled"));
        signUpPage.enterEmail.clear();
        signUpPage.enterEmail.sendKeys(" ");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.signinStrip.click();
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Welcome back\nplease login");
        Assert.assertEquals(loginPage.emailInput.getAttribute("placeholder"), "Enter your email");
        Assert.assertEquals(loginPage.password.getAttribute("placeholder"), "Enter password");
        Assert.assertEquals(signUpPage.signinStrip.getText(), "Forgot password?");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("value"), "Login");
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        loginPage.emailInput.sendKeys(USERNAME);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        loginPage.password.sendKeys(PASSWORD);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getAttribute("disabled"), "true");
        signUpPage.signinStrip.click();
        Assert.assertEquals(signUpPage.stepTitle.getText(), "Reset your password");
        driver.navigate().back();
        mainPage.backButton.click();
        Thread.sleep(500);
        Assert.assertNotNull(mainPage.exitDialog);
        Assert.assertEquals(signUpPage.continueButtons.get(1).getText(), "Exit");
        Assert.assertEquals(mainPage.exitWindowText.getText(), "Are you sure you want to exit?");
        Thread.sleep(2000);
        signUpPage.continueButtons.get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), HOMEWORK_PAGE);
        driver.navigate().back();
        loginPage.signUpLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), SIGNUP_PAGE);
        driver.get(HOME_PAGE);

    }

}
