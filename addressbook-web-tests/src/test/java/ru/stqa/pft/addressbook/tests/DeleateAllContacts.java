package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleateAllContacts extends TestBase {

    @Test
    public void testDeleateContact () {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().choiceAllContacts();
        app.getContactHelper().deleateContact();
    }

}
