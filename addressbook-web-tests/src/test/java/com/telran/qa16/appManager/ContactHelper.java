package com.telran.qa16.appManager;

import com.telran.qa16.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

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
                .withFirstName("Vasya")
                .withLastName("Ivanov")
                .withEmail("w@gmail.com")
                .withAddress("terner"));
        submitContactCreationForm();

    }

    private void goToHomePage() {
        click(By.xpath("//a[contains(text(),'home')]"));
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void goToDeleteContact() {
        click(By.xpath("//*[@value = 'Delete']"));
    }

        public int getContactCount() {
            return wd.findElements(By.name("selected[]")).size();
    }

    public void confirmAlert(){
        wd.switchTo().alert().accept();
    }

    public void isOnTheContactPage() {
        if(!isElementPresent(By.id("maintable"))){
            goToHomePage();
        }
    }
}

