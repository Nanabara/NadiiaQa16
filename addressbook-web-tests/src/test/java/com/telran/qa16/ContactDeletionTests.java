package com.telran.qa16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{
     @Test
    public void testContactDeletion(){
          if(!app.getContactHelper().isContactPresent()){
            app.getContactHelper().createContact();
         }
        int before = app.getGroupHelper().getGroupsCount();
        app.getContactHelper().goToSelectContact();
        goToDeleteContact();
        confirmAlert();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before-1);
     }

}