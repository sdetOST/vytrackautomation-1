package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {  //abstract because we dont want instance from this class
    protected WebDriver driver;
    protected Actions actions;
    protected SoftAssert softAssert;


    public boolean elementDisplayed (By by) {
        try{
            return driver.findElement(by).isDisplayed();

        }catch (NoSuchElementException e){
            return false;
        }



    }


    @BeforeClass
    public void setUpClass(){
        WebDriverManager.chromedriver().setup();


    }

    @BeforeMethod
    public void setUpMethod(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert=new SoftAssert();
        actions=new Actions(driver);
    }
    @AfterMethod
    public void tearDownMethod(){

        softAssert.assertAll();

    }
    @AfterClass
    public void tearDownClass(){
        driver.quit();

    }


}
