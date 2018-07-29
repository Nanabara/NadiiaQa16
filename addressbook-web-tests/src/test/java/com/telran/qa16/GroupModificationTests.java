package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

@Test
public void testGroupModification() {
goToGroupsPage();
    if(!isGroupPresent()){
        createGroup();
    }
    int before = getGroupsCount();
    goToSelectedGroups();
    goToModificationGroup();
    fillGroupsForm(new GroupData()
                .withName("modifiedTestGroupName")
                .withHeader("modifiedTestGroupHeader")
                .withFooter("modifiedTestGroupFooter"));
    goToSubmitGroup();
    returnToTheGroupsPage();
    int after = getGroupsCount();
    Assert.assertEquals(after, before);
  }
}