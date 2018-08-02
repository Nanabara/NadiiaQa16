package com.telran.qa16.tests;

import com.telran.qa16.model.ContactData;
import com.telran.qa16.tests.TestBase;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if(!app.getContactHelper().isContactPresent()){
           app.getContactHelper().createContact();
        }
        app.getContactHelper().goToSelectContact();
        app.getContactHelper().goToEditContact();
        app.getContactHelper().fillContactCreationForm(new ContactData()
                .withAddress("Rishon")
                .withEmail("r@gmail.com")
                .withLastName("Esenin")
                .withFirstName("Sergey"));
        app.getContactHelper().submitContactModificationForm();
    }


}