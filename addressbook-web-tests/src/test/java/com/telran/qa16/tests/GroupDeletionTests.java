package com.telran.qa16.tests;

import com.telran.qa16.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class GroupDeletionTests extends TestBase {
    @Test
    public void testGroupDeletion() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
        List<GroupData> groupsListBefore
                =app.getGroupHelper().getGroupsList();

        app.getGroupHelper().selectGroupByIndex(groupsListBefore.size()-1);
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();

        List<GroupData>groupsListAfter
                =app.getGroupHelper().getGroupsList();

        Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size()-1);

        groupsListBefore.remove(groupsListBefore.size()-1);
        System.out.println(groupsListAfter);
        System.out.println(groupsListBefore);
        Assert.assertEquals(groupsListAfter, groupsListBefore);
    }

}