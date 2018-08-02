package com.telran.qa16;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  public static ApplicationManager app = new ApplicationManager();

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

    public void goToDeleteContact() { app.wd.findElement(By.xpath("//*[@value ='Delete']")).click();
    }
}
