package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class DeleateContact extends TestBase {

    @Test
    public void testDeleateContact () {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToNewAddPage();
            app.getContactHelper().createContact(new ContactData("John", "Silver", "Yellow", "+791115648594", "test@mail.ru", "New Orenburg", "test1"), true);
        }
        app.getContactHelper().choiceContact();
        app.getContactHelper().deleateContact();
    }

}