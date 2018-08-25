package com.telran.qa16.tests;

import com.telran.qa16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().isOnTheContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().goToAddNew();

        app.getContactHelper().fillContactCreationForm(new ContactData()
                .withFirstName("Masha")
                .withLastName("Mashkova")
                .withAddress("Terner,7")
                .withEmail("masha@gmail.com"));
        app.getContactHelper().submitContactCreationForm();

        List<ContactData> after = app.getContactHelper().getContactList();

       Assert.assertEquals(after.size(), before.size()+1);
    }
}