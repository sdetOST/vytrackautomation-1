package com.vytrack.tests.components.activities;

import com.vytrack.utilities.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarEventsFunctionality extends TestBase {


    @Test

    public void createCalendarEventFormTest() {

        extentLogger = report.createTest("Create Calendar Event Form Test");

        extentLogger.info("Open Login Page");
        pages.login().open();

        extentLogger.info("Login by Store Manager credentials");
        pages.login().login(ConfigurationReader.getProperty("usernameStoreManager"),
                            ConfigurationReader.getProperty("password"));

        extentLogger.info("Hover over Activities Drop Down Menu");
        actions.moveToElement(pages.homePage().activitiesDropDownMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().activitiesDropDownMenuCalendarEventsSelection));

        extentLogger.info("Click on Calendar Events");
        pages.homePage().activitiesDropDownMenuCalendarEventsSelection.click();

        SeleniumUtils.waitPlease(3);

        extentLogger.info("Click on create new calendar event");
        pages.activitiesPage().createCalendarEventButton.click();
        SeleniumUtils.waitPlease(2);

        extentLogger.info("Click on Repeat checkbox");
        pages.activitiesPage().createFormRepeatCheckbox.click();

        SeleniumUtils.waitPlease(2);
        extentLogger.info("Verify that Daily is selected by default");

        Select select=new Select(pages.activitiesPage().createFormRepeatsSelectbox);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Daily");

        extentLogger.info("Verify day(s) checkbox is selected and default value is 1");
        Assert.assertTrue(pages.activitiesPage().createFormRepeatEveryDaysRadioButton.isSelected());
        Assert.assertTrue(pages.activitiesPage().createFormRepeatEveryDaysInputBox.getAttribute("value").equals("1"));

        extentLogger.info("Verify summary says Daily every 1 day");
        Assert.assertEquals(pages.activitiesPage().createFormSummary.getText(),"Daily every 1 day");


        extentLogger.info("Check the weekday checkbox");
        pages.activitiesPage().createFormRepeatEveryWeekDayRadioButton.click();

        extentLogger.info("Verify that days input now disabled");
        Assert.assertFalse(pages.activitiesPage().createFormRepeatEveryDaysInputBox.isEnabled());

        extentLogger.info("Verify summary says Daily every weekday");
        Assert.assertEquals(pages.activitiesPage().createFormSummary.getText(),"Daily, every weekday");


        extentLogger.pass("Pass- Create Calendar Event Form Test");

    }
}
