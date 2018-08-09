package com.telran.qa16.tests;

import com.telran.qa16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().isOnTheContactPage();
        int before = app.getGroupHelper().getGroupsCount();
        app.getContactHelper().goToAddNew();
        app.getContactHelper().fillContactCreationForm(new ContactData()
                .withFirstName("Masha")
                .withLastName("Mashkova")
                .withAddress("Terner,7")
                .withEmail("masha@gmail.com"));
        app.getContactHelper().submitContactCreationForm();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before + 1);
    }
}