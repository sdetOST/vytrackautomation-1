package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @Test
    public void LoginPositiveTest(){

        extentLogger=report.createTest("Login Positive Test");

        extentLogger.info("Open the Login Page");
        pages.login().open();

        extentLogger.info("Login to Vytrack as a store manager");
        pages.login().login(ConfigurationReader.getProperty("usernameStoreManager"),
                        ConfigurationReader.getProperty("password")             );

        //SeleniumUtils.waitPlease(3);

        //BrowserUtils.waitUntilLoaderScreenDisappear();
        extentLogger.info("Verify name of the store manager is displayed on top right");
        Assert.assertEquals(pages.homePage().nameOfTheEmployee.getText(),ApplicationConstants.STORE_MANAGER_NAME);

        extentLogger.info("Verify Dashboard page is open");
        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.DASHBOARD_PAGE_NAME);

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().logOutDropDownMenu));
        extentLogger.info("Click on Log out DropDown Menu ");
        pages.homePage().logOutDropDownMenu.click();


        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().logOutDropDownMenuLogOutSelection));
        extentLogger.info("Click on Log out");
        pages.homePage().logOutDropDownMenuLogOutSelection.click();


        extentLogger.info("Login as a Sales Manager ");
        pages.login().login(ConfigurationReader.getProperty("usernameSalesManager"),
                        ConfigurationReader.getProperty("password")             );
        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify Dashboard page is open");
        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.DASHBOARD_PAGE_NAME);

        extentLogger.info("Verify Sales Manager is displayed on top right");
        Assert.assertEquals(pages.homePage().nameOfTheEmployee.getText(),ApplicationConstants.SALES_MANAGER_NAME);


        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().logOutDropDownMenu));
        extentLogger.info("Click on Log out DropDown Menu ");
        pages.homePage().logOutDropDownMenu.click();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().logOutDropDownMenuLogOutSelection));
        extentLogger.info("Click on Log out");
        pages.homePage().logOutDropDownMenuLogOutSelection.click();


        extentLogger.info("Login as a Truck Driver");
        pages.login().login(ConfigurationReader.getProperty("usernameTruckDriver"),
                ConfigurationReader.getProperty("password")             );


        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify DashBoard/Quick Launchpad page is open");
        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.DASHBOARD_QUICK_LAUNCHPAD_PAGE_NAME);

        extentLogger.info("Verify Truck Driver name is displayed on top right");
        Assert.assertEquals(pages.homePage().nameOfTheEmployee.getText(),ApplicationConstants.TRUCK_DRIVER_NAME);

        extentLogger.pass("Login Positive Test");
    }

    @Test
    public void LoginNegativeTest(){

        extentLogger=report.createTest("Login Negative Test");

        extentLogger.info("Open the Login Page");
        pages.login().open();

        extentLogger.info("Login to Vytrack with an invalid password");
        pages.login().login(ConfigurationReader.getProperty("usernameStoreManager"),"password");

        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify invalid username or password message displayed");
        Assert.assertTrue(pages.login().errorMessage.isDisplayed());

        extentLogger.info("Verify page title is still login page");
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.LOGIN_PAGE_TITLE);

        extentLogger.info("Verify url is still login page url");
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.getProperty("url"));
        extentLogger.pass("Login Negative Test");

    }




}
