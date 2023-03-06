package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleateGroup extends TestBase {

    @Test

    public void testDeleateGroup () {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleateGroup();
        app.getGroupHelper().returnToGroupPage();
    }

}
