package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class ContactModificationTests {
    WebDriver wd;

    @BeforeClass

    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        openSite();
        login();
    }

    @Test
    public void testContactModification() {
        goToHomePage();
        goToSelectContact();
        goToEditContact();
        editContactModification();
        submitContactModificationForm();
        goToGroupPage();
    }

        public void editContactModification () {
            wd.findElement(By.name("firstname")).click();
            wd.findElement(By.name("firstname")).clear();
            wd.findElement(By.name("firstname")).sendKeys("modifiedTestContactFirstName");

            wd.findElement(By.name("lastname")).click();
            wd.findElement(By.name("lastname")).clear();
            wd.findElement(By.name("lastname")).sendKeys("modifiedTestContactFirstName");

            wd.findElement(By.name("address")).click();
            wd.findElement(By.name("address")).clear();
            wd.findElement(By.name("address")).sendKeys("modifiedTestContactAddress");

            wd.findElement(By.name("email")).click();
            wd.findElement(By.name("email")).clear();
            wd.findElement(By.name("email")).sendKeys("modifiedTestContactEmail");
        }

    public void goToEditContact() {
        wd.findElement(By.xpath("//*[@title ='Edit']")).click();
    }

    public void goToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void submitContactModificationForm() {
        wd.findElement(By.name("update")).click();
    }

    public void goToSelectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void goToHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void openSite() {
        wd.navigate().to("http://localhost/addressbook");
    }

    public void login() {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");

        wd.findElement(By.xpath("//*[@value ='Login']")).click();
    }

    /*@AfterMethod
    public void tearDown() {
        wd.quit();
    }*/
}