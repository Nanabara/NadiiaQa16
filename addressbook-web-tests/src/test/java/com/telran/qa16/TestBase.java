package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;


    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        openSite();
        login("admin", "secret");
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    public void login(String userName, String password) {
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).sendKeys(userName);

        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys(password);

        wd.findElement(By.xpath("//*[@value ='Login']")).click();
    }

    public void openSite() {

        wd.navigate().to("http://localhost/addressbook");
    }

    public void returnToTheGroupsPage() {

        wd.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupsForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {

        wd.findElement(By.name("new")).click();
    }

    public void goToGroupsPage() {

        wd.findElement(By.linkText("groups")).click();
    }

    public void groupDeletion() {

        wd.findElement(By.name("delete")).click();
    }

    public void goToSelectedGroups() {

        wd.findElement(By.name("selected[]")).click();
    }

    @Test

    public void testGroupModification() {
        goToGroupsPage();
        goToSelectedGroups();
        goToModificationGroup();
        fillGroupsForm(new GroupData()
                .withName("")
                .withHeader("")
                .withFooter(""));
        goToSubmitGroup();
        returnToTheGroupsPage();
    }

    public void goToModificationGroup() {
        wd.findElement(By.name("edit")).click();
    }

    public void goToSubmitGroup() {
        wd.findElement(By.name("update")).click();
    }

    public void goToAddNew() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillContactCreationForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        wd.findElement(By.name("firstname")).click();

        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        wd.findElement(By.name("lastname")).click();

        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
        wd.findElement(By.name("address")).click();

        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
        wd.findElement(By.name("email")).click();

    }

    public void submitContactCreationForm() {
        wd.findElement(By.name("submit")).click();
    }
}
