package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {

    public BuildYourOwnComputerPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]")
    WebElement buildComputer;

    @FindBy(xpath = "//h2[@class='product-title']/a[contains(text(),'Build your own computer')]")
    WebElement buildComputerText;

    @FindBy(id = "product_attribute_1")
    WebElement processorDropDown;

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ramDropDown;

    @FindBy(xpath = "//input[@id='product_attribute_3_7']")
    WebElement hddRadios;

    @FindBy(xpath = "//input[@id='product_attribute_4_9']")
    WebElement osRadio;

    @FindBy(id = "product_attribute_5_12")
    WebElement totalSoftwareCheck;

    @FindBy(id = "product_attribute_5_11")
    WebElement acrobatSoftwareCheck;

    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement addToCartButton;

    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCart;

    @FindBy(xpath = "//p[@class='content']")
    By verifyTopBar;


    public void clickOnBuildCop(){
        Reporter.log("click on ram " + buildComputer.toString() + "<br>");
        clickOnElement(buildComputer);
    }

    public String getBuildYourComputer(){
        Reporter.log("Verify build your own computer" + buildComputerText.toString() + buildComputerText);
        return getTextFromElement(buildComputerText);
    }
    public void ramDropDown(){
        Reporter.log("click on ram " + ramDropDown.toString() + "<br>");
        clickOnElement(ramDropDown);
    }
    public void processorDropDown(){
        Reporter.log("click on processor" + processorDropDown.toString() + "<br>");
        clickOnElement(ramDropDown);
    }
    public void osRadioButton(){
        Reporter.log("click on processor" + osRadio.toString() + "<br>");
        clickOnElement(osRadio);
    }
    public void clickHddRadio(){
        Reporter.log("click on hdd radio button" + hddRadios.toString() + "<br>");
        clickOnElement(hddRadios);
    }
    public void acrobatSoftWareBox(){
        Reporter.log("click on soft ware box" + acrobatSoftwareCheck.toString() + "<br>");
        clickOnElement(acrobatSoftwareCheck);
    }
    public void totalSoftWareBox(){
        Reporter.log("click on soft ware box" + totalSoftwareCheck.toString() + "<br>");
        clickOnElement(totalSoftwareCheck);
    }
    public void addToCard(){
        Reporter.log("click on add to card" + addToCart.toString() + "<br>");
        clickOnElement(addToCart);
    }
    public String verifyAddToCartBarMessage (){
        Reporter.log("Verify to add to cart message" + verifyTopBar.toString() + "<br>");
        return getTextFromElement(verifyTopBar);
    }


}
