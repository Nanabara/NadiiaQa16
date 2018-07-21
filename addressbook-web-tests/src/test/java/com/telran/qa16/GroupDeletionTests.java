package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupDeletionTests {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        openSite();
        login();
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

    public void openSite() {

        wd.navigate().to("http://localhost/addressbook");
    }

    @Test
    public void testGroupDeletion() {
        goToGroupsPage();
        selectGroup();
        groupDeletion();
        returnToGroupPage();
    }

    public void returnToGroupPage() {

        wd.findElement(By.linkText("group page")).click();
    }

    public void groupDeletion() {

        wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {

        wd.findElement(By.name("selected[]")).click();
    }

    public void goToGroupsPage() {

        wd.findElement(By.linkText("groups")).click();
    }

    @AfterClass
    public void tearDown() {

        wd.quit();
    }
}
