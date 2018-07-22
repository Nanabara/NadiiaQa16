package com.telran.qa16;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        goToSelectContact();
        goToEditContact();
        editContactModification();
        submitContactModificationForm();

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

    public void submitContactModificationForm() {
        wd.findElement(By.name("update")).click();
    }

    public void goToSelectContact() {
        wd.findElement(By.name("selected[]")).click();
    }


    /*@AfterMethod
    public void tearDown() {
        wd.quit();
    }*/
}