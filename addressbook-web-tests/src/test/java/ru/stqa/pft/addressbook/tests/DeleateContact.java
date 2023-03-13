package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleateContact extends TestBase {

    @Test
    public void testDeleateContact () {
        app.getContactHelper().goToHomePage();
        app.getContactHelper().choiceContact();
        app.getContactHelper().deleateContact();
    }

}