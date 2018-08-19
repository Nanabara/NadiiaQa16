package com.telran.qa16.tests;

import com.telran.qa16.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreationWithEmptyFields() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        List<GroupData>groupsListBefore=app.getGroupHelper().getGroupsList();

        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData()
                .withId(groupsListBefore.get(0).getId())
                .withName("GroupName")
                .withHeader("GroupHeader")
                .withFooter("GroupFooter");
        app.getGroupHelper().fillGroupsForm(new GroupData());
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();

        List<GroupData>groupsListAfter=app.getGroupHelper().getGroupsList();
        Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size()+1);

groupsListBefore.add(group);
int max = 0;
for(GroupData g:groupsListAfter){
 if(g.getId()> max){
     max=g.getId();
 }
 group.withId(max);
}
 //  Assert.assertEquals(new HashSet<Object>(groupsListAfter), new HashSet<Object>(groupsListBefore));
    }

}
