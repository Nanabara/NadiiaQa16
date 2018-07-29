package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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


    //HW procedures with groups

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
        wd.findElement(By.xpath("//*[@value = 'New group'][2]")).click();
    }

    public void goToGroupsPage() {
        wd.findElement(By.cssSelector("[href='group.php']")).click();
    }

    public void groupDeletion() {
        wd.findElement(By.name("delete")).click();
    }

    public void goToModificationGroup() {
        wd.findElement(By.xpath("//*[@name='edit'][1]")).click();
    }

    public void goToSubmitGroup() {
        wd.findElement(By.name("update")).click(); //нажимаем кнопку "update"
    }

    public void goToSelectedGroups() {
        wd.findElement(By.name("selected[]")).click();//удаляет первую группу
    }

    public void selectGroupByIndex(int ind){
        wd.findElements(By.name("selected[]")).get(ind).click(); //удаляет последнюю группу
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean isElementPresent(By locator) {  //находим элемент если есть
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isGroupPresent(){
        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup(){  // создаем новую группу
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("testgroupname")
                .withHeader("testgroupheader")
                .withFooter("testgroupfooter"));
        submitGroupCreation();
        returnToTheGroupsPage();

    }
    public boolean isElementsPresent(By locator){  //тоже самое что и метод выше
        return wd.findElements(locator).size()>0;
    }


    //HW Procedures with contacts

    public void goToAddNew() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillContactCreationForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());

        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());

        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void submitContactCreationForm() {
        wd.findElement(By.name("submit")).click();
    }


    public void goToEditContact() {
        wd.findElement(By.xpath("//*[@title ='Edit']")).click();
    }

    public void submitContactModificationForm() {
        wd.findElement(By.name("update")).click();
    }

    public void goToSelectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public boolean isContactElementPresent(By locator) {  //находим элемент если есть
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isContactPresent(){
        return isContactElementPresent(By.name("selected[]"));
    }

    public void createContact(){
        goToAddNew();
        fillContactCreationForm(new ContactData()
                        .withAddress("ashdod")
                        .withEmail("a@gmail.com")
                        .withLastName("Pushkin")
                        .withFirstName("Sasha"));
        submitContactCreationForm();


    }

}
