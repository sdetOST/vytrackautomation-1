package com.vytrack.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {  //abstract because we dont want instance from this class
    protected WebDriver driver;
    protected Actions actions;
    protected SoftAssert softAssert;
    protected WebDriverWait wait;
    protected Pages pages;

    protected static ExtentReports report;
    private static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;



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
        driver=Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert=new SoftAssert();
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,10);
        pages=new Pages();

    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {

        if(result.getStatus()==ITestResult.FAILURE){
            String screenshotLocation=BrowserUtils.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());
        }
       else if (result.getStatus()==ITestResult.SKIP){
           extentLogger.skip("Test Case Skipped: "+result.getName());

        }

        Driver.closeDriver();

        softAssert.assertAll();

    }


    @BeforeTest
    public void setUpTest(){
        report =new ExtentReports();

        String filePath=System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(filePath);

        report.attachReporter(htmlReporter);

        report.setSystemInfo("Browser",ConfigurationReader.getProperty("browser"));
        report.setSystemInfo("QA Engineer","Mehmet Durkan");


        htmlReporter.config().setDocumentTitle("VyTrack Reports");


    }
    @AfterTest
    public void endReport() {
        report.flush();
    }


}
