package com.telran.qa16.tests;

import com.telran.qa16.appManager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    public static ApplicationManager app
          = new ApplicationManager(System
            .getProperty("browser",BrowserType.CHROME));

    @BeforeMethod
    public void logTestStart(Method m){
        logger.info("Start the " +m.getName());
    }

    @AfterMethod(alwaysRun = true)  //chtobi test vsegda zapuskalsya
    public void logTestEnd(Method m){
        logger.info("End of the " +m.getName());
    }

    @BeforeSuite // поставили вместо BeforeClass
    public void setUp() {
        app.start();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() { app.stop();
    }

    public void confirmAlert() {
        app.wd.switchTo().alert().accept();
    }

    public void goToDeleteContact() {
        app.wd.findElement(By.xpath("//*[@value ='Delete']")).click();
    }
}
