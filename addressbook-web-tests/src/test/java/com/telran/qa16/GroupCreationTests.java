package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        openSite();
        login("admin", "secret");
    }

    @Test
    public void testGroupCreation() {
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm("testGroupName1", "testGroupHeader1", "testGroupFooter1");
        submitGroupCreation();
        returnToTheGroupsPage();
    }

    @Test
    public void testGroupCreationWithEmptyFields() {
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm("", "", "");
        submitGroupCreation();
        returnToTheGroupsPage();
    }

    @Test
    public void testGroupCreationWithLongName() {
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm("naaaaaammmmmeeeeeeeeeeeeeeeee", "", "");
        submitGroupCreation();
        returnToTheGroupsPage();
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    public void login(String userName, String password) {
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).sendKeys(userName);

        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys(password);

        wd.findElement(By.xpath("//*[@value ='Login']")).click();
    }

    public void openSite() {

        wd.navigate().to("http://localhost/addressbook");
    }

    public void returnToTheGroupsPage() {

        wd.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupsForm(String name, String header, String footer) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(name);

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(header);

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(footer);
    }

    public void initGroupCreation() {

        wd.findElement(By.name("new")).click();
    }

    public void goToGroupsPage() {

        wd.findElement(By.linkText("groups")).click();
    }


}
