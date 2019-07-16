package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.ApplicationConstants;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuOptionsTest extends TestBase {

    @Test
    public void menuOptionsDriverTest(){

        extentLogger=report.createTest("Menu Options Truck Driver Test");

        extentLogger.info("Open the Login Page");
        pages.login().open();

        extentLogger.info("Login by truck Driver credentials");
        pages.login().login(ConfigurationReader.getProperty("usernameTruckDriver"),
                        ConfigurationReader.getProperty("password"));

        extentLogger.info("Hover over Fleet Drop Down Menu");

        actions.moveToElement(pages.homePage().fleetDropDownMenuTruckDriver).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().fleetDropDownMenuVehiclesSelection));
        extentLogger.info("Click on Vehicles");

        pages.homePage().fleetDropDownMenuVehiclesSelection.click();
        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify Vehicles Page Title");

        Assert.assertEquals(driver.getTitle(), ApplicationConstants.VEHICLES_PAGE_TITLE);
        extentLogger.info("Verify Vehicles Page Name");

        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.VEHICLES_PAGE_NAME);



        extentLogger.info("Hover over Customers Drop Down Menu");

        actions.moveToElement(pages.homePage().customersDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().customersDropDownMenuAccountsSelection));
        extentLogger.info("Click on Accounts");

        pages.homePage().customersDropDownMenuAccountsSelection.click();
        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify Accounts Page Title");

        Assert.assertEquals(driver.getTitle(),ApplicationConstants.CUSTOMERS_ACCOUNTS_PAGE_TITLE);
        extentLogger.info("Verify Accounts Page Name");

        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.CUSTOMERS_ACCOUNTS_PAGE_NAME);




        extentLogger.info("Hover over Customers Drop Down Menu");

        actions.moveToElement(pages.homePage().customersDropDownMenu).perform();
        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().customersDropDownMenuContactsSelection));
        extentLogger.info("Click on Contacts");

        pages.homePage().customersDropDownMenuContactsSelection.click();
        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify Contacts Page Title");

        Assert.assertEquals(driver.getTitle(),ApplicationConstants.CUSTOMERS_CONTACTS_PAGE_TITLE);
        extentLogger.info("Verify Contacts Page Name");

        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.CUSTOMERS_CONTACTS_PAGE_NAME);


        extentLogger.info("Hover over Activities Drop Down Menu");


        actions.moveToElement(pages.homePage().activitiesDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().activitiesDropDownMenuCalendarEventsSelection));
        extentLogger.info("Click on Calendar Events");

        pages.homePage().activitiesDropDownMenuCalendarEventsSelection.click();
        SeleniumUtils.waitPlease(3);
        extentLogger.info("Verify Calendar Events Page Title");

        Assert.assertEquals(driver.getTitle(),ApplicationConstants.ACTIVITIES_CALENDAR_EVENT_PAGE_TITLE);
        extentLogger.info("Verify Calendar Events Page Name");

        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.ACTIVITIES_CALENDAR_EVENT_PAGE_NAME);


        extentLogger.pass("Menu Options Truck Driver");

    }

    @Test
    public void menuOptionsStoreManagerTest() {

        extentLogger=report.createTest("Menu Options Store Manager Test");

        extentLogger.info("Open Login Page");
        pages.login().open();

        extentLogger.info("Login by Store Manager credentials");
        pages.login().login(ConfigurationReader.getProperty("usernameStoreManager"),
                ConfigurationReader.getProperty("password"));
        extentLogger.info("Hover over Dashboards Drop Down Menu");

        actions.moveToElement(pages.homePage().dashboardsDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().dashboardsDropDownMenuDashboardSelection));

        extentLogger.info("Click on Dashboard");
        pages.homePage().dashboardsDropDownMenuDashboardSelection.click();

        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify Dashboard Page Title");
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.DASHBOARDS_DASHBOARD_PAGE_TITLE);

        extentLogger.info("Verify Dashboard Page Name");
        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.DASHBOARDS_DASHBOARD_PAGE_NAME);


        extentLogger.info("Hover over Fleet Drop Down Menu");
        actions.moveToElement(pages.homePage().fleetDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().fleetDropDownMenuVehiclesSelection));

        extentLogger.info("Click on Vehicles");
        pages.homePage().fleetDropDownMenuVehiclesSelection.click();

        SeleniumUtils.waitPlease(7);
        extentLogger.info("Verify Vehicles Page Title");
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.VEHICLES_PAGE_TITLE);

        extentLogger.info("Verify Vehicles Page Name");
        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.VEHICLES_PAGE_NAME);


        extentLogger.info("Hover over Customers Drop Down Menu");
        actions.moveToElement(pages.homePage().customersDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().customersDropDownMenuAccountsSelection));

        extentLogger.info("Click on Accounts");
        pages.homePage().customersDropDownMenuAccountsSelection.click();

        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify Accounts Page Title");
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.CUSTOMERS_ACCOUNTS_PAGE_TITLE);

        extentLogger.info("Verify Accounts Page Name");
        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.CUSTOMERS_ACCOUNTS_PAGE_NAME);

        extentLogger.info("Hover over Customers Drop Down Menu");
        actions.moveToElement(pages.homePage().customersDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().customersDropDownMenuContactsSelection));

        extentLogger.info("Click on Contacts");
        pages.homePage().customersDropDownMenuContactsSelection.click();

        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify Contacts Page Title");
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.CUSTOMERS_CONTACTS_PAGE_TITLE);

        extentLogger.info("Verify Contacts Page Name");
        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.CUSTOMERS_CONTACTS_PAGE_NAME);

        extentLogger.info("Hover over Sales Drop Down Menu");
        actions.moveToElement(pages.homePage().salesDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().salesDropDownMenuOpportunities));

        extentLogger.info("Click on Opportunities");
        pages.homePage().salesDropDownMenuOpportunities.click();

        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify Opportunities Page Title");
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.SALES_OPPORTUNITIES_PAGE_TITLE);

        extentLogger.info("Verify Opportunities Page Name");
        Assert.assertEquals(pages.homePage().pageName.getText(),ApplicationConstants.SALES_OPPORTUNITIES_PAGE_NAME);


        extentLogger.info("Hover over Activities Drop Down Menu");
        actions.moveToElement(pages.homePage().activitiesDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().activitiesDropDownMenuCallsSelection));

        extentLogger.info("Click on Calls");
        pages.homePage().activitiesDropDownMenuCallsSelection.click();

        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify Opportunities Calls Page Title");
        Assert.assertEquals(driver.getTitle(),ApplicationConstants.ACTIVITIES_CALLS_PAGE_TITLE);

        extentLogger.info("Verify Opportunities Calls Page Name");
        Assert.assertEquals(pages.homePage().pageName.getText(), ApplicationConstants.ACTIVITIES_CALLS_PAGE_NAME);

        extentLogger.info("Hover over Activities Drop Down Menu");
        actions.moveToElement(pages.homePage().activitiesDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().activitiesDropDownMenuCalendarEventsSelection));

        extentLogger.info("Click on Calendar Events");
        pages.homePage().activitiesDropDownMenuCalendarEventsSelection.click();

        SeleniumUtils.waitPlease(3);

        extentLogger.info("Verify Calendar Events Page Title");
        Assert.assertEquals(driver.getTitle(), ApplicationConstants.ACTIVITIES_CALENDAR_EVENT_PAGE_TITLE);

        extentLogger.info("Verify Calendar Events Page Name");
        Assert.assertEquals(pages.homePage().pageName.getText(), ApplicationConstants.ACTIVITIES_CALENDAR_EVENT_PAGE_NAME);

        extentLogger.pass("Menu Options Store Manager");

    }
}
