package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        int before = getGroupsCount();
        goToAddNew();
        fillContactCreationForm(new ContactData()
                .withFirstName("Masha")
                .withLastName("Mashkova")
                .withAddress("Terner,7")
                .withEmail("masha@gmail.com"));
        submitContactCreationForm();
        int after = getGroupsCount();
        Assert.assertEquals(after, before+1);
    }
}