package com.telran.qa16.appManager;

import com.telran.qa16.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToTheGroupsPage() throws InterruptedException {
        click(By.linkText("group page"));
        Thread.sleep(2000);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupsForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.xpath("//*[@value = 'New group'][2]"));
    }

    public void goToGroupsPage() {
        if (!isElementPresent(By.xpath("//h1[contains(text(),'Groups')]"))
                && !isElementPresent(By.name("new"))) {
            click(By.cssSelector("[href='group.php']"));
        }
    }

    public void groupDeletion() {
        click(By.name("delete"));
    }

    public void goToModificationGroup() {
        click(By.xpath("//*[@name='edit'][1]"));
    }

    public void goToSubmitGroup() {
        click(By.name("update"));
    }

    public void goToSelectedGroups() {
        click(By.name("selected[]"));
    }

    public void selectGroupByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean isElementPresent(By locator) {  //находим элемент если есть
        return isContactElementPresent(locator);
    }

    public boolean isGroupPresent() {

        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup() throws InterruptedException {  // создаем новую группу
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("testgroupname")
                .withHeader("testgroupheader")
                .withFooter("testgroupfooter"));
        submitGroupCreation();
        returnToTheGroupsPage();
    }

    public List<GroupData> getGroupsList() {
        List<GroupData> groups = new ArrayList<>(); // создаем новый список
        List<WebElement> elements =
                wd.findElements(By.cssSelector("span.group"));
    for(WebElement element: elements){
    String name = element.getText();
    int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
    GroupData group = new GroupData().withId(id).withName(name);
    groups.add(group);
}
        System.out.println(groups);
        return groups;
    }
}
