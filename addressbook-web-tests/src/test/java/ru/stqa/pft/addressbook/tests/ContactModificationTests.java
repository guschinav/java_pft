package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test

    public void testContactModification () {

        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToNewAddPage();
            app.getContactHelper().createContact(new ContactData("John", "Silver", "Yellow", "+791115648594", "test@mail.ru", "New Orenburg", "test1"));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillNewContact(new ContactData("Tom", "Gold", "Yellow", "+111111111111", "test@mail.ru", "New Orenburg", null), false);
        app.getContactHelper().updateContactModification();



    }

}
