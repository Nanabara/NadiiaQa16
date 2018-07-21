package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactDeletionTests {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        openSite();
        login();

    }

    @Test
    public void testContactDeletion(){
        goToHomePage();
        goToSelectContact();
        goToDeleteContact();
        goToGroupPage();
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

    public void goToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void goToSelectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void goToDeleteContact() {
        wd.findElement(By.xpath("//*[@value ='Delete']")).click();
    }

     public void goToHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

 /*@AfterClass
    public void tearDown() {
        wd.quit();
    }*/

}