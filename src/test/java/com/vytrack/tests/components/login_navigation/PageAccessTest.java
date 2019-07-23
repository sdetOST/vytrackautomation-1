package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.ApplicationConstants;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageAccessTest extends TestBase {

    @Test (groups = "regression")
    public void vehicleContractsPageStoreManagerAccess(){

        extentLogger=report.createTest("Vehicle Contracts Page Store Manager Access Test");

        extentLogger.info("Open the Login Page");
        pages.login().open();

        extentLogger.info("Login by Store Manager credentials");
        pages.login().login(ConfigurationReader.getProperty("usernameStoreManager"),
                        ConfigurationReader.getProperty("password"));



        extentLogger.info("Hover over Fleet Drop Down Menu");

        actions.moveToElement(pages.homePage().fleetDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().vehicleContracts));
        extentLogger.info("Click on Vehicle Contracts");
        pages.homePage().vehicleContracts.click();

        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify if Vehicle Contracts Page Title is correct");
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.VEHICLE_CONTRACTS_PAGE_TITLE);


        extentLogger.pass("Vehicle Contracts Page Store Manager Access");

    }
    @Test
    public void vehicleContractsPageSalesManagerAccess(){

        extentLogger=report.createTest("Vehicle Contracts Page Sales Manager Access Test");

        extentLogger.info("Open Login Page");
        pages.login().open();

        extentLogger.info("Login by Sales Manager credentials");
        pages.login().login(ConfigurationReader.getProperty("usernameSalesManager"),
                ConfigurationReader.getProperty("password"));

        extentLogger.info("Hover over Fleet Drop Down Menu");
        actions.moveToElement(pages.homePage().fleetDropDownMenu).perform();
        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().vehicleContracts));


        extentLogger.info("Click on Vehicle Contracts");
        pages.homePage().vehicleContracts.click();
        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify if Vehicle Contracts Page Title is correct");
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.VEHICLE_CONTRACTS_PAGE_TITLE);

        extentLogger.pass("Vehicle Contracts Page Sales Manager Access");


    }
    @Test
    public void vehicleContractsPageTruckDriverAccess(){

        extentLogger=report.createTest("Vehicle Contracts Page Truck Driver Access Test");

        extentLogger.info("Open Login Page");
        pages.login().open();

        extentLogger.info("Login by Truck Driver credentials");
        pages.login().login(ConfigurationReader.getProperty("usernameTruckDriver"),
                ConfigurationReader.getProperty("password"));

        extentLogger.info("Hover over Fleet Drop Down Menu");
        actions.moveToElement(pages.homePage().fleetDropDownMenuTruckDriver).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().vehicleContracts));

        extentLogger.info("Click on Vehicle Contracts");
        pages.homePage().vehicleContracts.click();

        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify if warning message displayed and Truck Driver cannot access Vehicle Contracts");
        Assert.assertTrue(pages.homePage().warningMessage.isDisplayed());

        extentLogger.pass("Vehicle Contracts Page Truck Driver Access");


    }


}
