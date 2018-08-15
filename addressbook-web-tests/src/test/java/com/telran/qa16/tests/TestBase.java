package com.telran.qa16.tests;

import com.telran.qa16.appManager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  public static ApplicationManager app
          = new ApplicationManager(System.getProperty("browser",BrowserType.FIREFOX));

    @BeforeSuite // поставили вместо BeforeClass
    public void setUp() {
        app.start();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public void confirmAlert() {
        app.wd.switchTo().alert().accept();
    }

    public void goToDeleteContact() {
        app.wd.findElement(By.xpath("//*[@value ='Delete']")).click();
    }
}
