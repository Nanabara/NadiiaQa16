package com.telran.qa16.tests;

import com.telran.qa16.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

@Test
public void testGroupModification() {
app.getGroupHelper().goToGroupsPage();
    if(!app.getGroupHelper().isGroupPresent()){
        app.getGroupHelper().createGroup();
    }
    int before = app.getGroupHelper().getGroupsCount();
    app.getGroupHelper().goToSelectedGroups();
    app.getGroupHelper().goToModificationGroup();
    app.getGroupHelper().fillGroupsForm(new GroupData()
                .withName("modifiedTestGroupName")
                .withHeader("modifiedTestGroupHeader")
                .withFooter("modifiedTestGroupFooter"));
    app.getGroupHelper().goToSubmitGroup();
    app.getGroupHelper().returnToTheGroupsPage();
    int after = app.getGroupHelper().getGroupsCount();
    Assert.assertEquals(after, before);
  }
}