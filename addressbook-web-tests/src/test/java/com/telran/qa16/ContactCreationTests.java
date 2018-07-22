package com.telran.qa16;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        goToAddNew();
        fillContactCreationForm(new ContactData("Masha", "Mashkova", "Terner,7", "masha@gmail.com"));
        submitContactCreationForm();

    }

}