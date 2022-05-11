package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */

public class LoginPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPage() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    @Test(groups = { "sanity", "smoke", "regression"})
    public void verifyErrorMessageWithInvalidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("gits123@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String expectedText = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualText = loginPage.getLoginErrorText();
        Assert.assertEquals(expectedText, actualText, "Error occur");
    }
    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("abc12345@gmail.com");
        loginPage.enterPassword("gh123456");
        loginPage.clickOnLoginButton();
        String expectedText = "My account";
        String actualText = homePage.getMyAccountText();
        Assert.assertEquals(expectedText, actualText, "Error occur");
    }
    @Test(groups = {"Regression"})
    public void VerifyThatUserShouldLogOutSuccessFully() throws InterruptedException {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("gits123@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        homePage.clickOnLogOutLink();

    }



}

