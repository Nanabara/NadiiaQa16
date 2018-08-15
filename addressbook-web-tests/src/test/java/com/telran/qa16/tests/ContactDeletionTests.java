package com.telran.qa16.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
     @Test
    public void testContactDeletion() throws InterruptedException {
          if(!app.getContactHelper().isContactPresent()){
            app.getContactHelper().createContact();
         }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().goToSelectContact();
        app.getContactHelper().goToDeleteContact();
        app.getContactHelper().confirmAlert();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before-1);
     }

}