package com.telran.qa16.tests;

import com.telran.qa16.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

@Test
public void testGroupModification() throws InterruptedException {
app.getGroupHelper().goToGroupsPage();
    if(!app.getGroupHelper().isGroupPresent()){
        app.getGroupHelper().createGroup();
    }

    List<GroupData> groupsListBefore
            =app.getGroupHelper().getGroupsList();

   app.getGroupHelper().goToSelectedGroups();
    app.getGroupHelper().goToModificationGroup();

    GroupData group = new GroupData()
            .withId(groupsListBefore.get(0).getId())
            .withName("modifiedTestGroupName")
            .withHeader("modifiedTestGroupHeader")
            .withFooter("modifiedTestGroupFooter");

    app.getGroupHelper().fillGroupsForm(group);
    app.getGroupHelper().goToSubmitGroup();
    app.getGroupHelper().returnToTheGroupsPage();


    List<GroupData>groupsListAfter
            =app.getGroupHelper().getGroupsList();
    Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size());
    groupsListBefore.remove(0);
    groupsListBefore.add(group);

  //  Assert.assertEquals(new HashSet<Object>(groupsListAfter), new HashSet<Object>(groupsListBefore));


  }
}