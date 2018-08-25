package com.telran.qa16.appManager;

import com.telran.qa16.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void goToAddNew() {
        click(By.linkText("add new"));
    }

    public void fillContactCreationForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getEmail());
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

    public void confirmAlert() throws InterruptedException {
        wd.switchTo().alert().accept();
        Thread.sleep(2000);
    }

    public void isOnTheContactPage() {
        if (!isElementPresent(By.id("maintable"))) {
            goToHomePage();
        }
    }

    public List<ContactData> getContactList() {
     List<ContactData> contacts = new ArrayList<>();

     List<WebElement> rows = wd.findElements(By.name("entry"));
     for(WebElement row: rows){
         List<WebElement> cells = row.findElements(By.tagName("td"));
             int id = Integer.parseInt(cells.get(0).findElement(By.name("selected[]")).getAttribute("value"));
             String lastName = cells.get(1).getText();
             String firstName = cells.get(2).getText();
             contacts.add(new ContactData().withId(id).withLastName(lastName).withFirstName(firstName));
         }

     System.out.println(contacts);
        return contacts;
    }
}

