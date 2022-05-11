package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import org.testng.annotations.DataProvider;

import java.security.PublicKey;

public class ComputerPageTest extends TestBase {

    HomePage homePage;
    DesktopPage desktopPage;
    ComputerPage computerPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {

        homePage = new HomePage();
        desktopPage = new DesktopPage();
        computerPage = new ComputerPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
        PageFactory.initElements(driver, this);

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {

        homePage.clickOnComputers();
        String expectedText = "Computers";
        String actualText = computerPage.getComputerText();
        Assert.assertEquals(actualText, expectedText, "Error");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.clickOnComputers();
        computerPage.clickOnDesktopLink();
        String expectedText = "Desktops";
        String actualText = desktopPage.getDesktopsText();
        Assert.assertEquals(actualText, expectedText, "Error");
    }

    @Test(dataProvider = "buildYouOwnComputer", dataProviderClass = TestData.class, groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String
         processor, String ram, String hdd, String os, String software){

        homePage.clickOnComputers();
        computerPage.clickOnDesktopLink();
        buildYourOwnComputerPage.clickOnBuildCop();
        buildYourOwnComputerPage.getBuildYourComputer();
        buildYourOwnComputerPage.processorDropDown();
        buildYourOwnComputerPage.ramDropDown();
        buildYourOwnComputerPage.clickHddRadio();
        buildYourOwnComputerPage.osRadioButton();
        buildYourOwnComputerPage.acrobatSoftWareBox();


    }


}
