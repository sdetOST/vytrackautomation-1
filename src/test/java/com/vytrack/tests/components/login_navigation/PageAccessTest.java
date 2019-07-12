package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageAccessTest extends TestBase {

    @Test
    public void vehicleContractsPageStoreManagerAccess(){
//        TEST	CASE:	Vehicle	contracts	test	store	manager


//        1. Login	to	Vytrack	as	a	store	manager

        driver.get("http://qa2.vytrack.com/user/login");
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager98");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(7);


//        2. Verify	that	you	can	access	Vehicle	contracts	page

        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//span[contains(text(),'Vehicle Contracts')]")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle="All - Vehicle Contract - Entities - System - Car - Entities - System";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void vehicleContractsPageSalesManagerAccess(){
//        TEST	CASE:	Vehicle	contracts	test	sales	manager


//        1. Login	to	Vytrack	as	a	sales	manager

        driver.get("http://qa2.vytrack.com/user/login");
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager261");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(7);


//        2. Verify	that	you	can	access	Vehicle	contracts	page

        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//span[contains(text(),'Vehicle Contracts')]")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle="All - Vehicle Contract - Entities - System - Car - Entities - System";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void vehicleContractsPageTruckDriverAccess(){
//        TEST	CASE:	Vehicle	contracts	test	sales	manager


//        1. Login	to	Vytrack	as	a	truck driver

        driver.get("http://qa2.vytrack.com/user/login");
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.id("prependedInput")).sendKeys("user165");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(7);


//        2. Verify	that	you	cannot	access	Vehicle	contracts	page
//        3. Message	You do not have permission to perform this action. should	be	displayed

        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//span[contains(text(),'Vehicle Contracts')]")).click();
        SeleniumUtils.waitPlease(5);

        WebElement expectedMessage=driver.findElement(By.xpath("//div[contains(text(),'You do not have permission to perform this action.')]"));
        Assert.assertTrue(expectedMessage.isDisplayed());
    }


}
