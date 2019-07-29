package com.vytrack.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BrowserUtils {



    public static String getScreenshot(String name){

        String time= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot=(TakesScreenshot) Driver.getDriver();

        File source= takesScreenshot.getScreenshotAs(OutputType.FILE);

        String target=System.getProperty("user.dir")+"/test-output/Screenshots"+name+time+".png";
        File finalDestination=new File(target);

        try{
            FileUtils.copyFile(source,finalDestination);

        }catch (IOException io){



        }




        return target;
    }


    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }


    public static void waitUntilLoaderScreenDisappear(){
        String loaderMaskLocator = "div[class='loader-mask shown']";
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(10));
            wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.cssSelector(loaderMaskLocator))));
        } catch(Exception e){
            System.out.println(e + " : : Loader Mask doesn't present");
        }
    }

}
