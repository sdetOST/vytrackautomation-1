package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void LoginPositiveTest(){
//        1. Login	to	Vytrack	as	a	store	manager

        driver.get("http://qa2.vytrack.com/user/login");
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager98");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(10);
//        2. Verify	name	of	the	store	manager is	displayed	on	top	right
        String nameExpected="Crawford Graham";
        String nameActual=driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
        Assert.assertEquals(nameActual,nameExpected);

//        3. Verify	Dashboad	page	is	open

        String pageExpected="Dashboard";
        String pageActual=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(pageActual,pageExpected);

//        4. Log	out

        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement dropdown;

        dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.className("dropdown-toggle")));
        dropdown.click();

        dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='no-hash']")));
        dropdown.click();



//        5. Login	to	Vytrack	as	a	sales manager
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager261");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);

//        6. Verify	Dashboad	page	is	open
        pageExpected="Dashboard";
        pageActual=driver.findElement(By.cssSelector(".oro-subtitle")).getText();

        Assert.assertEquals(pageActual,pageExpected);

//        7. A	different	name	should	be	displayed	on	top	right
        nameExpected="Kian Stehr";
        nameActual=driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
        Assert.assertEquals(nameActual,nameExpected);

//        8. Log	out

        dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.className("dropdown-toggle")));
        dropdown.click();

        dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='no-hash']")));
        dropdown.click();


//        9. Login	to	Vytrack	as	a	driver
        driver.findElement(By.id("prependedInput")).sendKeys("user165");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);

//        10. Verify	Dashboad/Quick	Launchpad page	is	open

        pageExpected="Quick Launchpad";
        pageActual=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        Assert.assertEquals(pageActual,pageExpected);



//        11. A	different	name	should	be	displayed	on	top	right
        nameExpected="Grace Walsh";
        nameActual=driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
        Assert.assertEquals(nameActual,nameExpected);

    }

    @Test
    public void LoginNegativeTest(){
//        TEST	CASE:	Login	test	(negative)

//        1. Open	Vytrack	login	page
        driver.get("http://qa2.vytrack.com/user/login");
        SeleniumUtils.waitPlease(2);


//        2. Enter	valid	username	and	invalid	password	information

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager98");
        driver.findElement(By.id("prependedInput2")).sendKeys("password");

//        3. Click	login
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);

//        4. Message	Invalid user name or password. should	be	displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Invalid user name or password.')]")).isDisplayed());

//        5. Page	title	and	url	should	be	same

        String pageExpected="Login";
        String pageActual=driver.getTitle();

        Assert.assertEquals(pageActual,pageExpected);

        String expectedURL="http://qa2.vytrack.com/user/login";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);


    }




}
