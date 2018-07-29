package com.telran.qa16;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if(!isContactPresent()){
            createContact();
        }
        goToSelectContact();
        goToEditContact();
        fillContactCreationForm(new ContactData()
                .withAddress("Rishon")
                .withEmail("r@gmail.com")
                .withLastName("Esenin")
                .withFirstName("Sergey"));
        submitContactModificationForm();

    }


}