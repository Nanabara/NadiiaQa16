package com.telran.qa16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{
     @Test
    public void testContactDeletion(){
         if(!isContactPresent()){
             createContact();
         }
        int before = getGroupsCount();
        goToSelectContact();
        goToDeleteContact();
        confirmAlert();
        int after = getGroupsCount();
        Assert.assertEquals(after, before-1);
     }

    private void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void goToDeleteContact() {
        wd.findElement(By.xpath("//*[@value ='Delete']")).click();
    }
}