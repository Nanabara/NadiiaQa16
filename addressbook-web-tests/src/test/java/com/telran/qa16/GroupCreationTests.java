package com.telran.qa16;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm("testGroupName1", "testGroupHeader1", "testGroupFooter1");
        submitGroupCreation();
        returnToTheGroupsPage();
    }

    @Test
    public void testGroupCreationWithEmptyFields() {
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm("", "", "");
        submitGroupCreation();
        returnToTheGroupsPage();
    }

    @Test
    public void testGroupCreationWithLongName() {
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm("naaaaaammmmmeeeeeeeeeeeeeeeee", "", "");
        submitGroupCreation();
        returnToTheGroupsPage();
    }


}
