package com.vytrack.tests.components.activities;

import com.vytrack.utilities.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

    @Test

    public void dailyRepeatOptionBoundaryTest() {

        //1. Log in as Valid user
        //2. Go to Activities -> Calendar Events
        //3. Click on create new calendar event
        //4. Click on Repeat checkbox
        //5. Test the day(s) input entering different values (boundary value analysis)
        //6. Verify error messages The value have not to be less than 1. and The value have not to be
        //more than 99. occur when values are too big or small
        //7. Verify that error messages disappear when valid values are entered

        extentLogger = report.createTest("Daily repeat option, Repeat every day(s), error messages");

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
        wait.until(ExpectedConditions.elementToBeClickable(pages.activitiesPage().createFormRepeatCheckbox));
        pages.activitiesPage().createFormRepeatCheckbox.click();

        extentLogger.info("Verify day(s) value cannot be less than 1, error message displayed");
        pages.activitiesPage().createFormRepeatEveryDaysInputBox.clear();
        pages.activitiesPage().createFormRepeatEveryDaysInputBox.sendKeys("0"+ Keys.TAB);
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberErrorMessage.isDisplayed());

        extentLogger.info("Verify error message is not displayed with value <1> ");
        pages.activitiesPage().createFormRepeatEveryDaysInputBox.clear();
        pages.activitiesPage().createFormRepeatEveryDaysInputBox.sendKeys("1");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberErrorMessages.isEmpty());

        extentLogger.info("Verify day(s) value cannot be more than 99, error message displayed");
        pages.activitiesPage().createFormRepeatEveryDaysInputBox.clear();
        pages.activitiesPage().createFormRepeatEveryDaysInputBox.sendKeys("100");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberErrorMessage.isDisplayed());

        extentLogger.info("Verify error message is not displayed with value <99> ");
        pages.activitiesPage().createFormRepeatEveryDaysInputBox.clear();
        pages.activitiesPage().createFormRepeatEveryDaysInputBox.sendKeys("99");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberErrorMessages.isEmpty());

        extentLogger.pass("Pass- Daily repeat option, Repeat every day(s), error messages Test");

    }
    @Test

    public void dailyRepeatOptionSummaryFuncTest() {

        extentLogger = report.createTest("Daily repeat option, Repeat every day(s), functionality");

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
        SeleniumUtils.waitPlease(3);

        extentLogger.info("Click on Repeat checkbox");
        wait.until(ExpectedConditions.elementToBeClickable(pages.activitiesPage().createFormRepeatCheckbox));
        pages.activitiesPage().createFormRepeatCheckbox.click();

        SeleniumUtils.waitPlease(2);



        pages.activitiesPage().createFormRepeatEveryDaysInputBox.clear();
        String randomDay=""+((int) (Math.random()* 99) + 1);

        pages.activitiesPage().createFormRepeatEveryDaysInputBox.sendKeys(randomDay+ Keys.TAB);
        extentLogger.info("Verify summary says Daily every (random number: ) "+randomDay+" days");
        Assert.assertEquals(pages.activitiesPage().createFormSummary.getText(),"Daily every "+randomDay+" days");


        randomDay=""+((int) (Math.random()* 99) + 1);

        pages.activitiesPage().createFormRepeatEveryDaysInputBox.clear();
        pages.activitiesPage().createFormRepeatEveryDaysInputBox.sendKeys(randomDay+ Keys.TAB);
        extentLogger.info("Verify summary says Daily every (random number: ) "+randomDay+" days");
        Assert.assertEquals(pages.activitiesPage().createFormSummary.getText(),"Daily every "+randomDay+" days");


        extentLogger.pass("Pass- Daily repeat option, Repeat every day(s), summary functionality");

    }

    @Test

    public void dailyRepeatBlankErrorMessageTest() {

        extentLogger = report.createTest("Daily repeat option, blank fields, blank error message");

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
        SeleniumUtils.waitPlease(3);

        extentLogger.info("Click on Repeat checkbox");
        wait.until(ExpectedConditions.elementToBeClickable(pages.activitiesPage().createFormRepeatCheckbox));
        pages.activitiesPage().createFormRepeatCheckbox.click();

        SeleniumUtils.waitPlease(2);


        pages.activitiesPage().createFormRepeatEveryDaysInputBox.clear();
        pages.activitiesPage().createFormRepeatEveryDaysInputBox.sendKeys(Keys.TAB);
        extentLogger.info("Repeat Every Days Input box is blank. Verify <This value should not be blank.>message displayed");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberBlankErrorMessage.isDisplayed());

        pages.activitiesPage().createFormRepeatEveryDaysInputBox.sendKeys("1");
        extentLogger.info("Repeat Every Days Input box has a valid value.Verify <This value should not be blank.>message not displayed");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberBlankErrorMessages.isEmpty());

        pages.activitiesPage().createFormAfterOccurencesInputBox.click();
        pages.activitiesPage().createFormAfterOccurencesInputBox.sendKeys(Keys.TAB);
        extentLogger.info("Ends After Occurences Input box is blank. Verify <This value should not be blank.>message displayed");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberBlankErrorMessage.isDisplayed());

        pages.activitiesPage().createFormAfterOccurencesInputBox.sendKeys("1");
        extentLogger.info("Ends After Occurences Input box is blank. Verify <This value should not be blank.>message not displayed");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberBlankErrorMessages.isEmpty());



        extentLogger.pass("Pass- Daily repeat option, blank fields, blank error message");

    }

    @Test

    public void dailyRepeatEndOccurenceBoundaryErrorMessageTest() {

        extentLogger = report.createTest("Daily repeat option, Ends Occurence Boundary, error messages");

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
        SeleniumUtils.waitPlease(3);

        extentLogger.info("Click on Repeat checkbox");
        wait.until(ExpectedConditions.elementToBeClickable(pages.activitiesPage().createFormRepeatCheckbox));
        pages.activitiesPage().createFormRepeatCheckbox.click();

        SeleniumUtils.waitPlease(2);



        pages.activitiesPage().createFormAfterOccurencesInputBox.click();
        pages.activitiesPage().createFormAfterOccurencesInputBox.sendKeys("0"+Keys.TAB);
        extentLogger.info("Ends After Occurences Input box has invalid value(0). Verify error message displayed");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberErrorMessage.isDisplayed());

        pages.activitiesPage().createFormAfterOccurencesInputBox.clear();
        pages.activitiesPage().createFormAfterOccurencesInputBox.sendKeys("1"+Keys.TAB);
        extentLogger.info("Ends After Occurences Input box has valid value. Verify error message not displayed");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberErrorMessages.isEmpty());

        pages.activitiesPage().createFormAfterOccurencesInputBox.clear();
        pages.activitiesPage().createFormAfterOccurencesInputBox.sendKeys("100"+Keys.TAB);
        extentLogger.info("Ends After Occurences Input box has invalid value(100). Verify error message displayed");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberErrorMessage.isDisplayed());

        pages.activitiesPage().createFormAfterOccurencesInputBox.clear();
        pages.activitiesPage().createFormAfterOccurencesInputBox.sendKeys("1"+Keys.TAB);
        extentLogger.info("Ends After Occurences Input box has valid value. Verify error message not displayed");
        Assert.assertTrue(pages.activitiesPage().repeatDayNumberErrorMessages.isEmpty());
        extentLogger.pass("Pass- Daily repeat option, Ends Occurence Boundary, error messages");

    }

    @Test

    public void dailyRepeatEndOccurenceSummaryFuncTest() {

        extentLogger = report.createTest("Daily repeat option, Ends Occurence Summary functionality");

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
        SeleniumUtils.waitPlease(3);

        extentLogger.info("Click on Repeat checkbox");
        wait.until(ExpectedConditions.elementToBeClickable(pages.activitiesPage().createFormRepeatCheckbox));
        pages.activitiesPage().createFormRepeatCheckbox.click();

        SeleniumUtils.waitPlease(2);



        pages.activitiesPage().createFormAfterOccurencesInputBox.click();
        String randomDay=""+((int) (Math.random()* 99) + 1);


        pages.activitiesPage().createFormAfterOccurencesInputBox.sendKeys(randomDay+Keys.TAB);

        extentLogger.info("Verify summary says Daily every (random number: ) "+randomDay+" days");
        Assert.assertEquals(pages.activitiesPage().createFormSummary.getText(),"Daily every "+randomDay+" days");


        randomDay=""+((int) (Math.random()* 99) + 1);

        pages.activitiesPage().createFormAfterOccurencesInputBox.clear();
        pages.activitiesPage().createFormAfterOccurencesInputBox.sendKeys(randomDay+ Keys.TAB);
        extentLogger.info("Verify summary says Daily every (random number: ) "+randomDay+" days");
        Assert.assertEquals(pages.activitiesPage().createFormSummary.getText(),"Daily every "+randomDay+" days");

        extentLogger.pass("Pass- Daily repeat option, Ends Occurence Summary Functionality, error messages");

    }
///////////////////////////////////Date and Time Tests///////////////////////////////
    @Test

    public void dateTimeEndDateAutoAdjustTest() {

        //Date Time, End date auto adjust
        //1. Log in as Valid user
        //2. Go to Activities -> Calendar Events
        //3. Click on create new calendar event
        //4. Change the start date to future date
        //5. Verify that end date changes to the same date
        //6. Change back the start date to today’s date
        //7. Verify that end date changes back to today’s date

        extentLogger = report.createTest("Date Time, End date auto adjust");

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
        wait.until(ExpectedConditions.elementToBeClickable(pages.activitiesPage().createCalendarEventButton));
        pages.activitiesPage().createCalendarEventButton.click();
        SeleniumUtils.waitPlease(3);

        String today=pages.activitiesPage().getStartDateInputBox.getAttribute("value");

        extentLogger.info("Click on Start Date Input Box");
        pages.activitiesPage().getStartDateInputBox.click();

        extentLogger.info("Click on Start Date Next Month Button");
        pages.activitiesPage().startDateNextMonthSelection.click();
        extentLogger.info("Click on first day of nex month- Testing selection of future date");
        pages.activitiesPage().startDateEachDaySelection.click();

        extentLogger.info("Verify End Date changes according to the change on Start Date");
        Assert.assertEquals(pages.activitiesPage().getEndDateInputBox.getAttribute("value"),
                            pages.activitiesPage().getStartDateInputBox.getAttribute("value")    );


        extentLogger.info("Click on Start Date Input box to open ");
        pages.activitiesPage().getStartDateInputBox.click();

        extentLogger.info("Click on Start Date Today button");
        wait.until(ExpectedConditions.elementToBeClickable(pages.activitiesPage().startDateTodaySelection));
        pages.activitiesPage().startDateTodaySelection.click();

        extentLogger.info("Verify Today date is correct");
        Assert.assertEquals(pages.activitiesPage().getStartDateInputBox.getAttribute("value"),today);
        extentLogger.info("Verify End Date is also changed as Today date");
        Assert.assertEquals(pages.activitiesPage().getEndDateInputBox.getAttribute("value"),today);
        extentLogger.pass("Pass- Date Time, End date auto adjust");

    }
    @Test

    public void dateTimeEndTimeAutoAdjustTest() {

        // Date Time, End time auto adjust
        //1. Log in as Valid user
        //2. Go to Activities -> Calendar Events
        //3. Click on create new calendar event
        //4. Change the start time to any other time
        //5. Verify that end time changes exactly 1 hours later

        extentLogger = report.createTest("Date Time, End time auto adjust (one hour later than start date)");

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
        wait.until(ExpectedConditions.elementToBeClickable(pages.activitiesPage().createCalendarEventButton));
        pages.activitiesPage().createCalendarEventButton.click();
        SeleniumUtils.waitPlease(3);


        extentLogger.info("Click on Start Time Input Box");
        pages.activitiesPage().getStartTimeInputBox.click();
        extentLogger.info("Select a future time by Arrow DOWN key and ENTER key");
        pages.activitiesPage().getStartTimeInputBox.sendKeys(Keys.ARROW_DOWN);
        pages.activitiesPage().getStartTimeInputBox.sendKeys(Keys.ENTER);



        String startTime=pages.activitiesPage().getStartTimeInputBox.getAttribute("value");
        String endTime=pages.activitiesPage().getEndTimeInputBox.getAttribute("value");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.US);
        LocalTime startTimeParsed = LocalTime.parse(startTime, inputFormatter);
        LocalTime endTimeParsed=LocalTime.parse(endTime, inputFormatter);
        LocalTime startTimeParsedPlusOne=startTimeParsed.plusHours(1);


        extentLogger.info("Verify End Time is one hour later than New Start Date");
        Assert.assertEquals(endTimeParsed,startTimeParsedPlusOne);


        extentLogger.pass("Pass- Date Time, End time auto adjust (one hour later than start date)");

    }

    @Test

    public void dateTimeEndTimeAutoAdjustDayChangeTest() {

        // Date Time, End date/time auto adjust
        //1. Log in as Valid user
        //2. Go to Activities -> Calendar Events
        //3. Click on create new calendar event
        //4. Change the start time to 11.30 PM
        //5. Verify that end date shows tomorrows date
        //6. Verify that end time is 12:30 AM

        extentLogger = report.createTest("Date Time, End time auto adjust change day(one hour later than start date)");

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
        wait.until(ExpectedConditions.elementToBeClickable(pages.activitiesPage().createCalendarEventButton));
        pages.activitiesPage().createCalendarEventButton.click();
        SeleniumUtils.waitPlease(3);


        extentLogger.info("Clear Start Time Input Box");
        pages.activitiesPage().getStartTimeInputBox.clear();
        extentLogger.info("Edit Start Time Input Box as <11:30 PM>");
        pages.activitiesPage().getStartTimeInputBox.sendKeys("11:30 PM"+Keys.ENTER);
        SeleniumUtils.waitPlease(2);

        ////////// start date parsing and adding one day to compare with end date///////////////////////
        String startDate=pages.activitiesPage().getStartDateInputBox.getAttribute("value");
        String endDate=pages.activitiesPage().getEndDateInputBox.getAttribute("value");

        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat inputFormatter = new SimpleDateFormat("MMM dd, yyyy");
        try {
            calendar.setTime(inputFormatter.parse(startDate));
        }catch(Exception e){}

        calendar.add(Calendar.DATE,1);

        String endDateExpected=inputFormatter.format(calendar.getTime());


        extentLogger.info("Verify End Time is one hour later than New Start Time");
        softAssert.assertEquals(pages.activitiesPage().getEndTimeInputBox.getAttribute("value"),"12:30 AM");
        extentLogger.info("Verify End date is one day later than New Start Date");
        softAssert.assertEquals(endDate,endDateExpected);

        extentLogger.pass("Pass- Date Time, End time auto adjust change day(one hour later than start date)");

    }




}











