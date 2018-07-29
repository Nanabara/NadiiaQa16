package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
    @Test
    public void testGroupDeletion() {
        goToGroupsPage();
        if(!isGroupPresent()){
            createGroup();
        }
        int before = getGroupsCount();
        selectGroupByIndex(before-1); //last group
        groupDeletion();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after, before-1);
    }

}