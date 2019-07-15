package com.vytrack.tests.components.login_navigation;

import com.vytrack.pages.HomePage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @Test
    public void LoginPositiveTest(){

        //1. Login	to	Vytrack	as	a	store	manager

        loginPage.open();

        loginPage.login(ConfigurationReader.getProperty("usernameStoreManager"),
                        ConfigurationReader.getProperty("password")             );

        SeleniumUtils.waitPlease(3);

        //2. Verify	name	of	the	store	manager is	displayed	on	top	right


        String nameExpected="Crawford Graham";
        String nameActual=homePage.nameOfTheEmployee.getText();

        Assert.assertEquals(nameActual,nameExpected);

        //3. Verify	Dashboard	page	is	open

        String pageExpected="Dashboard";
        String pageActual=homePage.pageName.getText();

        Assert.assertEquals(pageActual,pageExpected);

        //4. Log	out

        wait.until(ExpectedConditions.elementToBeClickable(homePage.logOutDropDownMenu));

        homePage.logOutDropDownMenu.click();


        wait.until(ExpectedConditions.elementToBeClickable(homePage.logOutDropDownMenuLogOutSelection));
        homePage.logOutDropDownMenuLogOutSelection.click();

        //5. Login	to	Vytrack	as	a	sales manager

        loginPage.login(ConfigurationReader.getProperty("usernameSalesManager"),
                        ConfigurationReader.getProperty("password")             );
        SeleniumUtils.waitPlease(3);

        //6. Verify	Dashboard	page	is	open
        pageExpected="Dashboard";
        pageActual=homePage.pageName.getText();
        Assert.assertEquals(pageActual,pageExpected);

        //7. A	different	name	should	be	displayed	on	top	right
        nameExpected="Kian Stehr";
        nameActual=homePage.nameOfTheEmployee.getText();
        Assert.assertEquals(nameActual,nameExpected);

        //8. Log	out

        wait.until(ExpectedConditions.elementToBeClickable(homePage.logOutDropDownMenu));

        homePage.logOutDropDownMenu.click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.logOutDropDownMenuLogOutSelection));
        homePage.logOutDropDownMenuLogOutSelection.click();

        //9. Login	to	Vytrack	as	a	driver

        loginPage.login(ConfigurationReader.getProperty("usernameTruckDriver"),
                ConfigurationReader.getProperty("password")             );


        SeleniumUtils.waitPlease(3);

        //10. Verify	Dashboard/Quick	Launchpad page	is	open

        pageExpected="Quick Launchpad";
        pageActual=homePage.pageName.getText();

        Assert.assertEquals(pageActual,pageExpected);



        //11. A	different	name	should	be	displayed	on	top	right
        nameExpected="Grace Walsh";
        nameActual=homePage.nameOfTheEmployee.getText();
        Assert.assertEquals(nameActual,nameExpected);

    }

    @Test
    public void LoginNegativeTest(){
        //TEST	CASE:	Login	test	(negative)

        //1. Open	Vytrack	login	page
        loginPage.open();
        SeleniumUtils.waitPlease(2);


        //2. Enter	valid	username	and	invalid	password	information
        loginPage.login(ConfigurationReader.getProperty("usernameStoreManager"),"password");

        //3. Click	login
        SeleniumUtils.waitPlease(3);

        //4. Message	Invalid user name or password. should	be	displayed
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        //5. Page	title	and	url	should	be	same

        String pageExpected="Login";
        String pageActual=driver.getTitle();

        Assert.assertEquals(pageActual,pageExpected);

        String expectedURL= ConfigurationReader.getProperty("url");
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);


    }




}
