package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreationWithEmptyFields() {
        goToGroupsPage();
        int before = getGroupsCount();
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("xfgnxfgjh")
                .withHeader("")
                .withFooter(""));
        submitGroupCreation();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after, before+1);
    }


}
