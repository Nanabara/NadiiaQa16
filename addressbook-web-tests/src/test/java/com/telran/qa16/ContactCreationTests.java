package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ContactCreationTests {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        openSite();
        login();
    }

    @Test
    public void TestContactCreation() {
        goToAddNew();
        fillContactCreationForm("Masha", "Mashkova", "Terner,7", "masha@gmail.com");
        submitContactCreationForm();
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

    public void goToAddNew() {
        wd.findElement(By.linkText("add new")).click();
    }

    private void fillContactCreationForm(String firstName, String lastName, String address, String email) {
        wd.findElement(By.name("firstname")).sendKeys(firstName);
        wd.findElement(By.name("firstname")).click();

        wd.findElement(By.name("lastname")).sendKeys(lastName);
        wd.findElement(By.name("lastname")).click();

        wd.findElement(By.name("address")).sendKeys(address);
        wd.findElement(By.name("address")).click();

        wd.findElement(By.name("email")).sendKeys(email);
        wd.findElement(By.name("email")).click();

    }

    public void submitContactCreationForm() {
        wd.findElement(By.name("submit")).click();
    }
 /* @AfterMethod
    public void tearDown() {
        wd.quit();
    }*/
}