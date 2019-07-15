package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageAccessTest extends TestBase {

    @Test
    public void vehicleContractsPageStoreManagerAccess(){
//        TEST	CASE:	Vehicle	contracts	test	store	manager


//        1. Login	to	Vytrack	as	a	store	manager


        loginPage.open();
        loginPage.login(ConfigurationReader.getProperty("usernameStoreManager"),
                        ConfigurationReader.getProperty("password"));


//        2. Verify	that	you	can	access	Vehicle	contracts	page

        actions.moveToElement(homePage.fleetDropDownMenu).perform();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.vehicleContracts));

        homePage.vehicleContracts.click();
        SeleniumUtils.waitPlease(3);

        String expectedTitle="All - Vehicle Contract - Entities - System - Car - Entities - System";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void vehicleContractsPageSalesManagerAccess(){
//        TEST	CASE:	Vehicle	contracts	test	sales	manager


//        1. Login	to	Vytrack	as	a	sales	manager

        loginPage.open();
        loginPage.login(ConfigurationReader.getProperty("usernameSalesManager"),
                ConfigurationReader.getProperty("password"));



//        2. Verify	that	you	can	access	Vehicle	contracts	page

        actions.moveToElement(homePage.fleetDropDownMenu).perform();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.vehicleContracts));

        homePage.vehicleContracts.click();
        SeleniumUtils.waitPlease(3);


        String expectedTitle="All - Vehicle Contract - Entities - System - Car - Entities - System";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void vehicleContractsPageTruckDriverAccess(){
//        TEST	CASE:	Vehicle	contracts	test	sales	manager


//        1. Login	to	Vytrack	as	a	truck driver

        loginPage.open();
        loginPage.login(ConfigurationReader.getProperty("usernameTruckDriver"),
                ConfigurationReader.getProperty("password"));



//        2. Verify	that	you	cannot	access	Vehicle	contracts	page

        actions.moveToElement(homePage.fleetDropDownMenuTruckDriver).perform();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.vehicleContracts));

        homePage.vehicleContracts.click();

        SeleniumUtils.waitPlease(3);

        //3. Message	You do not have permission to perform this action. should	be	displayed

        Assert.assertTrue(homePage.warningMessage.isDisplayed());
    }


}
