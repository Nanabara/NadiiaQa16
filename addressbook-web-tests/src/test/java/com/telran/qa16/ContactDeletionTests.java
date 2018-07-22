package com.telran.qa16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{
     @Test
    public void testContactDeletion(){
        int before = wd.findElements(By.name("selected[]")).size();
        goToSelectContact();
        goToDeleteContact();
        confirmAlert();
        int after = wd.findElements(By.name("selected[]")).size();
        Assert.assertEquals(after, before-1);
     }

    private void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void goToSelectContact() {

        wd.findElement(By.name("selected[]")).click();
    }

    public void goToDeleteContact() {

        wd.findElement(By.xpath("//*[@value ='Delete']")).click();
    }

    }