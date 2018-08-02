package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
       super(wd);
    }
    
    public void goToAddNew() {
        click(By.linkText("add new"));
    }

    public void fillContactCreationForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstName());
        type(By.name("lastname"),contactData.getLastName());
        type(By.name("address"),contactData.getAddress());
        type(By.name("email"),contactData.getEmail());
     }

  public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitContactCreationForm() {
        click(By.name("submit"));
    }

    public void goToEditContact() {
        click(By.xpath("//*[@title ='Edit']"));
    }

    public void submitContactModificationForm() {
        click(By.name("update"));
    }

    public void goToSelectContact() {
        click(By.name("selected[]"));
    }

    public void createContact() {
        goToAddNew();
        fillContactCreationForm(
                new ContactData()
                .withFirstName("GJHG")
                .withLastName("kjbkj")
                .withEmail(".kbkjb")
                .withAddress("dfdfh"));
        submitContactCreationForm();

    }
}
