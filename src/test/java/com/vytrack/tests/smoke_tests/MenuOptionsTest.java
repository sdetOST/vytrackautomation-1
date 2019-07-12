package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuOptionsTest extends TestBase {

    @Test
    public void menuOptionsDriverTest(){
//        TEST	CASE:	Menu	options,	driver

//        1. Login	to	Vytrack	as	a	driver

        driver.get("http://qa2.vytrack.com/user/login");
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.id("prependedInput")).sendKeys("user165");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
       SeleniumUtils.waitPlease(3);





//        2. Navigate	to	Fleet	à Vehicles,	verify	page	title	Car	- Entities	- System	- Car	- Entities	–
//        System,	page	name	Cars

        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/div/div/ul/li[3]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle="Car - Entities - System - Car - Entities - System";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        String expectedPageName="Cars";
        String actualPageName=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);



//        3. Navigate	to	Customers	à Accounts,	verify	page	title	Accounts	- Customers,	verify	page
//        name	Accounts
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle2="Accounts - Customers";
        String actualTitle2=driver.getTitle();
        Assert.assertEquals(actualTitle2,expectedTitle2);

        String expectedPageName2="Accounts";
        String actualPageName2=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName2,expectedPageName2);



//        4. Navigate	to	Customers	à Contacts,	verify	page	title	Accounts	- Customers,	verify	page
//        name	Contacts

        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/div/div/ul/li[4]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle3="Contacts - Customers";
        String actualTitle3=driver.getTitle();
        Assert.assertEquals(actualTitle3,expectedTitle3);

        String expectedPageName3="Contacts";
        String actualPageName3=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName3,expectedPageName3);


//        5. Navigate	to	Activities	à Calendar	Events,	verify	page	title	Calendar	Events	- Activities,	page
//        name	Calendar	Events
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/div/div/ul/li[3]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle4="Calendar Events - Activities";
        String actualTitle4=driver.getTitle();
        Assert.assertEquals(actualTitle4,expectedTitle4);

        String expectedPageName4="Calendar Events";
        String actualPageName4=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName4,expectedPageName4);
    }

//
//    TEST	CASE:	Menu	options,	store	manager
    @Test
    public void menuOptionsStoreManagerTest() {


//1. Login	to	Vytrack	as	a	store	manager


        driver.get("http://qa2.vytrack.com/user/login");
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager98");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);
//2. Navigate	to	Dashboards	à Dashboard,	verify	page	title	Dashboard	- Dashboards,	verify
//    page	name	Dashboard
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/div/div/ul/li[3]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle5="Dashboard - Dashboards";
        String actualTitle5=driver.getTitle();
        Assert.assertEquals(actualTitle5,expectedTitle5);

        String expectedPageName5="Dashboard";
        String actualPageName5=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName5,expectedPageName5);




//3. Navigate	to	Fleet	à Vehicles,	verify	page	title	Car	- Entities	- System	- Car	- Entities	–
//    System,	page	name	Cars
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle="All - Car - Entities - System - Car - Entities - System";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        String expectedPageName="All Cars";
        String actualPageName=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);


//4. Navigate	to	Customers	à Accounts,	verify	page	title	Accounts	- Customers,	verify	page
//    name	Accounts

        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/div/div/ul/li[3]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle2="All - Accounts - Customers";
        String actualTitle2=driver.getTitle();
        Assert.assertEquals(actualTitle2,expectedTitle2);

        String expectedPageName2="All Accounts";
        String actualPageName2=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName2,expectedPageName2);

//5. Navigate	to	Customers	à Contacts,	verify	page	title	Accounts	- Customers,	verify	page
//    name	Contacts
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/div/div/ul/li[4]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle3="All - Contacts - Customers";
        String actualTitle3=driver.getTitle();
        Assert.assertEquals(actualTitle3,expectedTitle3);

        String expectedPageName3="All Contacts";
        String actualPageName3=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName3,expectedPageName3);


//6. Navigate	to	Sales	à Opportunities,	verify	page	title	Open	Opportunities	- Opportunities	-
//    Sales,	verify	page	name	Open	Opportunities
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[4]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[4]/div/div/ul/li[3]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle4="Open Opportunities - Opportunities - Sales";
        String actualTitle4=driver.getTitle();
        Assert.assertEquals(actualTitle4,expectedTitle4);

        String expectedPageName4="Open Opportunities";
        String actualPageName4=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName4,expectedPageName4);



//7. Navigate	to	Activities	à Calls	verify	page	title	Calendar	Events	- Activities,	page	name	All
//            Calls

        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/div/div/ul/li[3]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle6="All - Calls - Activities";
        String actualTitle6=driver.getTitle();
        Assert.assertEquals(actualTitle6,expectedTitle6);

        String expectedPageName6="All Calls";
        String actualPageName6=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName6,expectedPageName6);

//8. Navigate	to	Activities	à Calendar	Events,	verify	page	title	Calendar	Events	- Activities,	page
//    name	Calendar	Events

        actions.moveToElement(driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/a/span"))).perform();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[5]/div/div/ul/li[4]/a/span")).click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle7="All - Calendar Events - Activities";
        String actualTitle7=driver.getTitle();
        Assert.assertEquals(actualTitle7,expectedTitle7);

        String expectedPageName7="All Calendar Events";
        String actualPageName7=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(actualPageName7,expectedPageName7);


    }
}
